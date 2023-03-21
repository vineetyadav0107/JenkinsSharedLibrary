def (projectKey,projectName,loginKey,coveragePath,sonarHost){
    def scannerHome = tool 'SonarScanner';
                  withSonarQubeEnv("SonarQube-Localhost") {
                  sh "${tool("SonarScanner")}/bin/sonar-scanner \
                  -Dsonar.projectKey=${projectKey} \
                  -Dsonar.projectName=${projectName} \
                  -Dsonar.projectVersion=1.0 \
                  -Dsonar.sources=. \
                  -Dsonar.sonar.nodejs.executable=. \
                  -Dsonar.language=. \
                  -Dsonar.tests=src \
                  -Dsonar.test.inclusions=. \
                  -Dsonar.host.url=${sonarHost} \
				  -Dsonar.javascript.lcov.reportPaths=${coveragePath} \
                  -Dsonar.login=${loginKey}"
}