pipeline {
  agent {
    label "jenkins-maven"
  }
  environment {
    ORG = 'cb-kubecd'
    APP_NAME = 'needs-tests'
    CHARTMUSEUM_CREDS = credentials('jenkins-x-chartmuseum')
  }
  stages {
    stage('CI Build and push snapshot') {
      when {
        branch 'PR-*'
      }
      environment {
        PREVIEW_VERSION = "0.0.0-SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER"
        PREVIEW_NAMESPACE = "$APP_NAME-$BRANCH_NAME".toLowerCase()
        HELM_RELEASE = "$PREVIEW_NAMESPACE".toLowerCase()
      }
      steps {
        container('maven') {
          sh "mvn versions:set -DnewVersion=$PREVIEW_VERSION"
          sh "mvn install"
        }
      }
    }
    stage('Build Release') {
      when {
        branch 'master'
      }
      steps {
        container('maven') {
          git 'https://github.com/cb-kubecd/needs-tests.git'

          // so we can retrieve the version in later steps
          sh "echo \$(jx-release-version) > VERSION"
          sh "mvn versions:set -DnewVersion=\$(cat VERSION)"
          sh "jx step tag --version \$(cat VERSION)"
          sh "mvn clean deploy"
        }
      }
    }
  }
}
