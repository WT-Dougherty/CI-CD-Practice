pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                cd scripts && source run-unit-tests.sh
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}