pipeline {
    agent any
    tools {
        jdk 'jdk 17'
        maven 'mvn'
    }
    stages {
        stage('Build Maven') {
            steps {
                script {
                    try {
                        checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/varun21807/Jenkins.git']])
                        bat 'mvn clean install'
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }
    }
    post {
        failure {
            mail to: '2k21csbs22@kiot.ac.in,2k21csbs20@kiot.ac.in,2k21csbs15@kiot.ac.in,2k21csbs27@kiot.ac.in',
                 subject: "Jenkins Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build for ${env.JOB_NAME} #${env.BUILD_NUMBER} has failed.\nCheck the logs for more details.\n\nBuild URL: ${env.BUILD_URL}",
                 from: 'your-email@example.com'
        }
    }
}
