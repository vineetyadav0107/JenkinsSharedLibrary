def call(){
    withCredentials([usernameColonPassword(credentialsId: 'sonar-access', variable: 'USERPASS')]) {
      sh '''
          set x
          sleep 15s
          status="OK"
          qg_status=$(curl -u $USERPASS https://ci-builds.compunnel.com/sonar/api/qualitygates/project_status?projectKey=$projectKey  | jq -r '.projectStatus.status')
       '''
      return qg_status
}
