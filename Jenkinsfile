pipeline {
    agent any
    environment { 
        registry = "yasineromdhane/projetdevops" 
        registryCredential = 'yasineromdhane'
        docker_variable =  'mUE_t)s2JSBqQgt'
        dockerImage = '' 
    }git
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

        stage('Push Docker Image') {
            steps {
                script {
                withCredentials([string(credentialsId: 'docker_pat', variable:'docker_variable')]) { 
                sh "docker login -u yasineromdhane -p ${docker_variable}"
                sh "docker push ${registry}:${BUILD_NUMBER}"
                }

                }
            }
        }

        post {
            success {
                emailext body: 'Pipeline succeeded!',
                         subject: 'Jenkins Pipeline Success',
                         to: 'yasine.romdhane@esprit.tn'
            }
            failure {
                emailext body: 'Pipeline failed!',
                         subject: 'Jenkins Pipeline Failure',
                         to: 'yasine.romdhane@esprit.tn'
            }
    }

    }

}
