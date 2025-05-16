pipeline {
    agent any

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