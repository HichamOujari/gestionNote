pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'java 17.0.1'
    }
    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage ('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
}