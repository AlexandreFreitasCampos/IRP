pipeline {
    agent any

    stages {
        stage('Checar URL') {
            steps {
                git 'https://github.com/AlexandreFreitasCampos/IRP.git'
            }
        }
        stage('Gerar relatórios personalizados todos os filtos com o perfil Editor') {
            steps {
                bat 'mvn test -Dfeature=src/test/resources/features/editor.feature'
            }
        }
        stage('Gerar relatórios personalizados todos os filtos com o perfil Editor and Recorder') {
            steps {
                bat 'mvn test -Dfeature=src/test/resources/features/editorAndRecorder.feature'
            }
        }
        stage('Gerar relatórios personalizados todos os filtos com o perfil Recorder') {
            steps {
                bat 'mvn test -Dfeature=src/test/resources/features/recorder.feature'
            }
        }
       
    }
}
