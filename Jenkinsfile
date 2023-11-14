pipeline {
    agent any
    stages {
        stage('Building') {
            steps {
                sh 'mvn clean'
                sh 'mvn compile'
            }
        }
       
    }
}