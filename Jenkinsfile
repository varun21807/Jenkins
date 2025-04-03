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
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t varun2615/docker_example .'
                }
            }
        }
        stage('Push Image to DockerHub') {
            steps {
                script {
                    bat "docker login"
                    bat 'docker push varun2615/docker_example'
                }
            }
        }
    }
    post {
        success {
            mail to: '2k21csbs22@kiot.ac.in,2k21csbs20@kiot.ac.in,2k21csbs15@kiot.ac.in,2k21csbs27@kiot.ac.in',
                 subject: "Jenkins Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Hey Team,\n\nThe build for ${env.JOB_NAME} #${env.BUILD_NUMBER} was successful! 🚀\n\nCheck the details here: ${env.BUILD_URL}\n\nKeep up the great work!"
        }
        failure {
            mail to: '2k21csbs22@kiot.ac.in,2k21csbs20@kiot.ac.in,2k21csbs15@kiot.ac.in,2k21csbs27@kiot.ac.in',
                 subject: "Jenkins Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Hello Team,\n\nOops! The build for ${env.JOB_NAME} #${env.BUILD_NUMBER} has failed. 😞\n\nPlease check the logs and fix the issue.\n\nBuild URL: ${env.BUILD_URL}"
        }
    }
}
