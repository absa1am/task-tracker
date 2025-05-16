pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                echo 'Building branch: main'
                sh '''
                    chmod +x ./mvnw
                    ./mvnw clean package
                '''
            }
        }

        stage('deploy') {
            steps {
                echo 'Deploying branch: main'
                sh '''
                    chmod +x $CATALINA_HOME/bin/startup.sh
                    cp target/*.war $CATALINA_HOME/webapps/
                    cd $CATALINA_HOME/bin/
                    ./startup.sh
                '''
            }
        }
    }
}