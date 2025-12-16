pipeline{
	agent any
			
	environment {
        DOCKER_IMAGE = "skumarmeher/springboot-docker-kubernetes"
    }
    
	tools{
		maven 'maven_3_9_11'
	}
	
	stages{
		
		stage('build spring boot docker kubernetes app'){
			steps{
				sh 'mvn clean install'
			}
		}
		
		stage('buil docker images'){
			steps{
				sh 'docker build -t $DOCKER_IMAGE:latest .'
			}
		}
	}
}