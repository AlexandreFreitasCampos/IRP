pipeline {
    agent any
    options {
        disableConcurrentBuilds() // Garante que apenas um estágio é executado por vez
    }
    
    stages {
        stage('Checar URL') {
            steps {
                git 'https://github.com/AlexandreFreitasCampos/IRP.git'
            }
        }
        
        stage('Gerar relatorios personalizados todos os filtros com o perfil Editor') {
            steps {
                bat 'mvn test -Dcucumber.options="src/test/resources/features/editor.feature"'
            }
        }

        stage('Gerar relatorios personalizados todos os filtros com o perfil Editor and Recorder') {
            steps {
                bat 'mvn test -Dcucumber.options="src/test/resources/features/editorAndRecorder.feature"'
            }
        }

        stage('Gerar relatorios personalizados todos os filtros com o perfil Recorder') {
            steps {
                bat 'mvn test -Dcucumber.options="src/test/resources/features/recorder.feature"'
            }
        }
    }    
}