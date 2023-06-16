pipeline {
    agent any
    
    environment{
        registryUrl = "viracrrepo1.azurecr.io"
        registryCredential = "ACR"
        registryName = "viracrrepo1"
        dockerImage = ""
        
    }

    stages {
        stage('check out') {
            steps {
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Vireshgit/docker-spring-boot.git']]) 
            }
        }
        stage('build jar') {
            steps {
               sh "mvn clean install"
            }
        }
        stage('build docker image') {
            steps {
               script{
                   dockerImage = docker.build registryName
               }
            }
        }
        stage('upload image to ACR') {
            steps {
               script{
                    docker.withRegistry( "http://${registryUrl}", registryCredential ) {
                    dockerImage.push("$BUILD_NUMBER")
                    }
               }
            }
        }
        stage('helm deploy') {
            steps {
               script{
                    sh "helm upgrade ver-$BUILD_NUMBER --install my-aks-chart --namespace helm-deployment --set image.tag=$BUILD_NUMBER"
               }
            }
        }
    }
}
