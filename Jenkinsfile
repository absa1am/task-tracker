pipeline {
    agent {
        docker { image 'maven:3.9.9-eclipse-temurin-21-alpine' }
    }

    stages {
        stage('build') {
            steps {
                echo 'Building branch: main'
                sh 'mvn clean package'
            }
        }

        stage('deploy') {
            steps {
                echo 'Deploying branch: main'
                sh '''
                    cp target/*.war $CATALINA_HOME/webapps/
                    $CATALINA_HOME/bin/startup.sh
                '''
            }
        }
    }
}