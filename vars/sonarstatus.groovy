def call(projectKey){
    def qg_status = null
    echo "${projectKey}"
    withCredentials([usernameColonPassword(credentialsId: 'sonar-access', variable: 'USERPASS')]) {
      sh """
           sleep 15s
       """
       def res = sh(script: "curl --user ${USERPASS} https://ci-builds.compunnel.com/sonar/api/qualitygates/project_status?projectKey=${projectKey} | jq -r '.projectStatus.status'", returnStdout: true)
       return res
}
}
