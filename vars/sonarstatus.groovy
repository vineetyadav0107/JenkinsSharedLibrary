def call(projectKey){
    def qg_status = null
    echo "${projectKey}"
    withCredentials([usernameColonPassword(credentialsId: 'sonar-access', variable: 'USERPASS')]) {
      sh """
           echo "${projectKey}"
           echo "${USERPASS}"
           set x
           sleep 15s
           status="OK"
           qg_status=curl --user ${USERPASS} https://ci-builds.compunnel.com/sonar/api/qualitygates/project_status?projectKey=${projectKey}  | jq -r '.projectStatus.status'
           echo "${qg_status}"
       """
}
}
