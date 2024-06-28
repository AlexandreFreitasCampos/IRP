pipeline {
    agent any
    options {
        disableConcurrentBuilds() // Garante que apenas um estágio é executado por vez
    }
    stages {
        stage('Setup') {
            steps {
                script {
                    // Inicializa o WebDriver e o armazena em uma variável de ambiente 'driver'
                    def driver = new org.openqa.selenium.chrome.ChromeDriver()
                    env.WEBDRIVER = driver
                }
            }
        }
        stage('Checar URL') {
            steps {
                def driver = env.WEBDRIVER
                git 'https://github.com/AlexandreFreitasCampos/IRP.git'
            }
        }
        stage('Realizar login com o perfil Editor and Recorder') {
            steps {
                def driver = env.WEBDRIVER
                bat 'mvn test -Dcucumber.filter.tags="@recEditor"'
            }
        }
        stage('Gerar relatorios personalizados todos os filtros com o perfil Editor and Recorder') {
            steps {
                def driver = env.WEBDRIVER
                bat 'mvn test -Dcucumber.filter.tags="@faixas"'
            }
        }
        stage('Realizar login com o perfil Recorder') {
            steps {
                def driver = env.WEBDRIVER
                bat 'mvn test -Dcucumber.filter.tags="@recEditor"'
            }
        }
        stage('Gerar relatorios personalizados todos os filtros com o perfil Recorder') {
            steps {
                def driver = env.WEBDRIVER
                bat 'mvn test -Dcucumber.filter.tags="@faixasRec"'
            }
        }
   
    }
}    