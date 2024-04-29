pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Test') {
            steps {
                // Comando para executar testes Cucumber, ajustando conforme necessário
                sh 'mvn test -Dcucumber.options="--plugin pretty --plugin junit:target/cucumber.xml src/test/resources"'
            }
        }
        stage('Publish Reports') {
            steps {
                // Publicar relatórios de teste para Jenkins
                junit 'target/*.xml'
            }
        }
    }
}
