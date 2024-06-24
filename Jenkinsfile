pipeline {
    agent any

    stages {
        stage('Checar URL') {
            steps {
                git 'https://github.com/AlexandreFreitasCampos/IRP.git'
            }
        }
        stage('Efetuar login com perfil Gravadora/Editora') {
            steps {
                bat 'mvn clean test -Dcucumber.filter.name="Efetuar login com perfil Editora"'
            }
        }
        stage('Gerar rel person rec edit selos') {
            steps {
                bat 'mvn clean test -Dcucumber.filter.name="rel_person_editor_selos"'
            }
        }
        stage('Gerar rel person rec edit artistas') {
            steps {
                bat 'mvn clean test -Dcucumber.filter.name="rel_person_editor_artistas"'
            }
        }
        stage('Gerar rel person rec edit albuns') {
            steps {
                bat 'mvn clean test -Dcucumber.filter.name="rel_person_editor_albuns"'
            }
        }
        stage('Gerar rel person rec edit faixas') {
            steps {
                bat 'mvn clean test -Dcucumber.filter.name="rel_person_editor_faixas"'
            }
        }
    }
}
