pipeline {
    agent any
    tools {
        jdk 'jdk 17'
        maven 'mvn'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/varun21807/Jenkins.git']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t varun2615/docker_example:latest .'
                }
            }
        }
        stage('Push Image to DockerHub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'Docker-hub', usernameVariable: 'Docker_user', passwordVariable: 'Docker_password')]) {
                        sh 'echo $Docker_password | docker login -u $Docker_user --password-stdin'
                        sh 'docker push varun2615/docker_example:latest'
                    }
                }
            }
        }
        stage('Clean Up Dangling Images') {
            steps {
                sh 'docker rmi $(docker images -f "dangling=true" -q) || true'
            }
        }
    }
}
