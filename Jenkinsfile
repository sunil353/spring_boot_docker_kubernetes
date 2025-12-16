pipeline{
	agent any
			
	environment {
        DOCKER_IMAGE = "skumarmeher/springboot-docker-kubernetes"
    }
    
	tools{
		maven 'maven_3_9_11'
	}
	
	stages{
		
		stage('check out code from git'){
			steps{
				git 'https://github.com/sunil353/spring_boot_docker_kubernetes.git'
			}
		}
		
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