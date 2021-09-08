pipeline {
    agent any
       stages {
        stage("SCM checkout") {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/ashwanidhawan007/webserverproject.git'
                 }
        }
        stage("archive artifacts") {
            steps {
               archiveArtifacts '**/*.html' 
                 }
        }
      stage("transfrer artifacts") {
            steps {
                // Get some code from a GitHub repository
        sshPublisher( continueOnError: false, failOnError: true,   publishers: [     sshPublisherDesc(     configName: 'webserver',     verbose: true,     transfers: [      sshTransfer(        sourceFiles: '**/*.html',       removePrefix: '',       remoteDirectory: '',       execCommand: "run commands after copy?"      )     ])   ])

     }
  }
        
  }
}
