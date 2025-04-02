pipeline{
    agent any
        tools{
            jdk 'jdk 17'
            maven 'mvn'
        }
        stages{
            stage('Build Maven'){
                steps{
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/varun21807/Jenkins.git']])
                    bat 'mvn clean install'
                }
            }
           
        }
}