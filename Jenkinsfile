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

        stage('Deploy to Server') {
            steps {
                script {
                    // Copy the built JAR file to the server
                    sh 'scp target/your-spring-boot-app.jar user@http://192.168.33.10:8080/:/path/to/deployment/'

              
                }
            }
        }
    }

}
