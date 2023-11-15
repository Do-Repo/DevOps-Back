pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Check out your source code
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    sh 'mvn clean install jacoco:prepare-agent test jacoco:report'
                }
            }
        }

        stage('Code Coverage Analysis') {
            steps {
                script {
                    // Add steps to publish JaCoCo reports
                    // For example, using the Publish HTML Jenkins plugin
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site/jacoco',
                        reportFiles: 'index.html',
                        reportName: 'JaCoCo Code Coverage'
                    ])
                }
            }
        }
    }

    post {
        always {
        }
    }
}
