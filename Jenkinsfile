pipeline {
    agent any

    tools {
        jdk 'jdk 17'
        maven 'mvn'
    }

    stages {
        stage('Checkout and Build with Maven') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/master']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/varun21807/Jenkins.git']]
                )
                bat 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t varun2615/docker_example:latest .'
            }
        }

        stage('Login and Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'Docker-hub',  // Make sure this matches your Jenkins credential ID
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    bat """
                        echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
                        docker push varun2615/docker_example:latest
                    """
                }
            }
        }
    }
}
