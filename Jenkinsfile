pipeline {
    agent {
        node {
            //label 'VM_TST_QA_1_DEV'
            label 'VM_TST_QA_7_HML'
        }
    }
    stages {
        stage('Clean & Build') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Tests') {
            steps {
                script {
                    try {
                        sh 'mvn test'
                    } catch (err) {
                        echo err.message
                        currentBuild.result ='FAILURE'
                    }
                }
                echo currentBuild.result
            }
        }
        stage('Publish Report') {
            steps {
                publishHTML (target: [
                  allowMissing: false,
                  alwaysLinkToLastBuild: false,
                  keepAll: true,
                  reportDir: 'target/report',
                  reportFiles: 'cucumber.html',
                  reportName: "Cucumber Report"
                  ])
            }
        }
    }
}