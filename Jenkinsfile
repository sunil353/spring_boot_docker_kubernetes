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
                sh "docker build -t ${DOCKER_IMAGE}:latest ."
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-pwdd', variable: 'dockerhubpwd')]) {
                    sh '''
                        echo $dockerhubpwd | docker login -u skumarmeher --password-stdin
                        docker push ${DOCKER_IMAGE}:latest
                    '''
                }
            }
        }

        stage('Deploy to Kubernetes') {
	    steps {
	        withCredentials([file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG')]) {
	            sh '''
	            	echo "Using kubeconfig: $KUBECONFIG"
	            	kubectl get nodes
	                kubectl apply -f deployment_service.yaml
	            '''
	           }  
		    }
	    }

    }
}
