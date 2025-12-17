pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "skumarmeher/springboot-docker-kubernetes"
        IMAGE_TAG    = "${BUILD_NUMBER}"
    }

    tools {
        maven 'maven_3_9_11'
    }

    stages {

        stage('Build App') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${IMAGE_TAG} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-pwdd', variable: 'dockerhubpwd')]) {
                    sh '''
                        echo $dockerhubpwd | docker login -u skumarmeher --password-stdin
                        docker push ${DOCKER_IMAGE}:${IMAGE_TAG}
                    '''
                }
            }
        }

        stage('Deploy to Kubernetes') {
		    steps {
		        withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG')]) {
		            sh '''
		              echo "Deploying to Kubernetes..."
		
		              # Replace image version
		
		              kubectl apply -f deployment.yaml
		              kubectl apply -f service.yaml
		
		              # WAIT until app is really running
		              kubectl rollout status deployment/springboot-deployment
		            '''
		        }
    		}
		}

    }
}
