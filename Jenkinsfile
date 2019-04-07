pipeline {
  agent any
  stages {
    stage('error') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }
    stage('kube') {
      steps {
        sh 'kubectl create --help'
      }
    }
  }
}