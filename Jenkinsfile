pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AlexandreFreitasCampos/IRP.git'
            }
        }
        stage('Test') {
            steps {
                // Comando para executar testes Cucumber, ajustando conforme necessário
                bat 'mvn clean package install test -Dtest=Runner'
            }
        }
    }
}
