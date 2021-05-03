pipeline {
  agent any

  stages {
    stage('Checkout Scm') {
      steps {
        git(credentialsId: '8d667107-de9a-4977-9f3e-9ebee6f9c8dc', url: 'https://git.epam.com/Viktor_Zherdev/advanced-taf.git')
        git branch: 'create-framework', credentialsId: '8d667107-de9a-4977-9f3e-9ebee6f9c8dc', url: 'https://git.epam.com/Viktor_Zherdev/advanced-taf.git'
      }
    }

    stage('SonarQube analysis') {
            steps {

                bat """ gradle --info sonarqube -Dsonar.projectKey=advanced-taf -Dsonar.host.url=http://localhost:9000 -Dsonar.login=7670ad8a9c82b765186fd7c4253d97797fba37d5
                """
        }
    }

    stage('Test') {
      steps {
        withCredentials([usernamePassword(usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD', credentialsId: '8d667107-de9a-4977-9f3e-9ebee6f9c8dc')]) {
             bat """
              gradle clean test -Duser=$USERNAME  -Dpassword=$PASSWORD
              """
        }
      }
    }
  }
  post {
    always {
      publishHTML(reportFiles: 'index.html', allowMissing: false, keepAll: false, alwaysLinkToLastBuild: false, reportTitles: '', reportName: 'HTML Report', reportDir: 'build/reports/tests/test')
      step($class: 'JUnitResultArchiver', checksName: '', testResults: 'build/test-results/test/*.xml')
      script {
              allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'build/allure-results']]
              ])
            }
    }

  }
  triggers {
    cron('@daily, @midnight')
    pollSCM('H/2 * * * *')
  }
}