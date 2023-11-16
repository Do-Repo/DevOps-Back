pipeline {
    agent any
    environment { 
        registry = "yasineromdhane/projetdevops" 
        registryCredential = 'yasineromdhane' 
        dockerImage = '' 
    }
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
                    sh 'mvn test'
                    sh 'mvn clean'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerimage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 

    }

}
