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
                    CATALINA_HOME=$(printenv CATALINA_HOME)
                    echo "CATALINA_HOME = $CATALINA_HOME"
                    cp target/*.war $CATALINA_HOME/webapps/
                    $CATALINA_HOME/bin/startup.sh
                '''
            }
        }
    }
}