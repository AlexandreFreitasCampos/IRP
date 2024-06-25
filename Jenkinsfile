pipeline {
    agent any

    stages {
        stage('Checar URL') {
            steps {
                git 'https://github.com/AlexandreFreitasCampos/IRP.git'
            }
        }
        stage('Gerar relatorios personalizados com perfil Editora') {
            steps {
                bat 'mvn clean test -Dtest="Runner"'
            }
        }
    }
}
