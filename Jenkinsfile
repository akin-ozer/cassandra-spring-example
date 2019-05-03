pipeline {
  agent any
  stages {
    stage('wait') {
      steps {
        input 'enter'
        sleep 1
      }
    }
    stage('print') {
      steps {
        echo 'haha'
        sh 'mvn -v'
      }
    }
  }
}