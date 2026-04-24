pipeline {
	agent any

	tools {
		maven 'Maven'
		jdk 'JDK17'
	}

	stages {

		stage('Checkout Code') {
			steps {
				git branch: 'main',
				url: 'https://github.com/raziqpasha/swiggy_ui_automation.git'
			}
		}

		stage('Build & Test') {
			steps {
				bat 'mvn clean test'
			}
		}

		// ✅ CREATE FIRST
		stage('Create Executor File') {
			steps {
				script {
					writeFile file: 'allure-results/executor.json', text: """
{
  "name": "Jenkins",
  "type": "jenkins",
  "url": "${env.BUILD_URL}",
  "buildOrder": ${env.BUILD_NUMBER},
  "buildName": "Build-${env.BUILD_NUMBER}",
  "buildUrl": "${env.BUILD_URL}",
  "reportUrl": "${env.BUILD_URL}allure"
}
"""
				}
			}
		}

		// ✅ THEN GENERATE
		stage('Generate Allure Report') {
			steps {
				script {
					def allureHome = tool 'Allure'
					bat "${allureHome}\\bin\\allure generate allure-results --clean -o allure-report"
				}
			}
		}

		// ✅ THEN PUBLISH
		stage('Publish Allure Report') {
			steps {
				allure includeProperties: false,
				results: [[path: 'allure-results']]
			}
		}
	}

	post {
		always {
			archiveArtifacts artifacts: 'allure-report/**'
			script {
				currentBuild.result = 'SUCCESS'
			}
		}

		failure {
			echo 'Test Failed ❌'
		}
	}
}