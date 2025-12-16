pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "skumarmeher/springboot-docker-kubernetes"
    }

    tools {
        maven 'maven_3_9_11'
    }

    stages {

        stage('Build Spring Boot App') {
            steps {
                sh 'mvn clean package'
                sh 'ls -lh target'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE}:latest .'
            }
        }
        
        stage('push docker image to docker hub'){
			steps{
				script {
                    withCredentials([string(credentialsId: 'dockerhub-pwdd', variable: 'dockerhubpwd')]) {
                        sh '''
                            echo $dockerhubpwd | docker login -u skumarmeher --password-stdin
                            docker push skumarmeher/springboot-docker-kubernetes
                        '''
                        }
                        sh 'docker push skumarmeher/springboot-docker-kubernetes'
                }
			}
		}
    }
}
