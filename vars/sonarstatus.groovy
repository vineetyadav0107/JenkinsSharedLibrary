def call(projectKey){
    def qg_status = null
    echo "${projectKey}"
    withCredentials([usernameColonPassword(credentialsId: 'sonar-access', variable: 'USERPASS')]) {
      sh """
           echo "${projectKey}"
       """
}
}
