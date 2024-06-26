pipeline {
    agent any

    stages {
        stage('Checar URL') {
            steps {
                git 'https://github.com/AlexandreFreitasCampos/IRP.git'
            }
        }
        stage('Efetuar login com perfil Recorder and Editor') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="Efetuar login com perfil Gravadora/Editora"'
            }
        }
        stage('Gerar relatorios personalizados com filtos Faixas') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="rel_person_rec_edit_faixas"'
            }
        }
        stage('Efetuar login com perfil Editor') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="Efetuar login com perfil Editora"'
            }
        }
        stage('Gerar relatorios personalizados com filtos Faixas') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="rel_person_editor_faixas"'
            }
        }
        stage('Efetuar login com perfil Recorder') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="Efetuar login com perfil Gravadora"'
            }
        }
        stage('Gerar relatorios personalizados com filtos Faixas') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="rel_person_recorder_faixas"'
            }
        }
       
    }
}
