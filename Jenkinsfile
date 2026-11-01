pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                echo 'Source code checked out successfully'
            }
        }

        stage('Build') {
            steps {
                bat 'if not exist build mkdir build'
                bat 'javac -d build src\\Main.java src\\MainTest.java'
                echo 'Java compilation successful'
            }
        }

        stage('Test') {
            steps {
                bat 'java -cp build MainTest'
                echo 'Testing completed successfully'
            }
        }

        stage('Package') {
            steps {
                bat 'jar --create --file build\\student-task-manager.jar --main-class Main -C build Main.class'
                echo 'JAR package created'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'build/*.jar'
                echo 'Artifact archived successfully'
            }
        }

        stage('Smoke Test') {
            steps {
                bat 'java -jar build\\student-task-manager.jar'
                echo 'Application verification successful'
            }
        }
    }
}
