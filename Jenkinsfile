pipeline {
    agent any

    stages {
        stage('Checar URL') {
            steps {
                git 'https://github.com/AlexandreFreitasCampos/IRP.git'
            }
        }
        stage('Gerar relatórios personalizados') {
            steps {
                bat 'mvn clean test'
            }
        }       
    }
}
