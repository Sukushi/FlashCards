pipeline {
	agent any

	tools {
		maven "Maven 3.9.6"
	}

	stages {
		stage('Maven Build') {
			steps {
				bat 'mvn clean package'
			}
			post {
				success {
					archiveArtifacts 'target/*.jar'
				}
			}
		}

		stage('Build Docker Image') {
			steps {
				script {
					dockerImage = docker.build('flashcards:latest')
					bat "docker image prune -f"
				}
			}
		}

		stage('Start Docker Container') {
			steps {
				script {
					try {
						bat "docker stop flashcards"
						bat "docker rm flashcards"
					} catch (e) {
						echo '404 Not Found : flashcards'
					}
					bat "docker run --name flashcards -d -p 9090:8080 flashcards:latest FlashCards.jar"
				}
			}
		}
	}
}