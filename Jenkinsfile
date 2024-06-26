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
                bat 'mvn test -Dfeature=src/test/resources/features/editor.feature'
            }
        }
        stage('Gerar relatorios personalizados com filtos Selos') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="rel_person_editor_selos"'
            }
        }
        stage('Gerar relatorios personalizados com filtos Artistas') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="rel_person_editor_artistas"'
            }
        }
        stage('Gerar relatorios personalizados com filtos Álbuns') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="rel_person_editor_albuns"'
            }
        }
        stage('Gerar relatorios personalizados com filtos Faixas') {
            steps {
                bat 'mvn test -Dcucumber.filter.name="rel_person_editor_faixas"'
            }
        }
       
    }
}
