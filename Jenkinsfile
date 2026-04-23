pipeline {
	agent any

	tools {
		maven 'Maven'
		jdk 'Java17'
	}

	stages {

		stage('Checkout Code') {
			steps {
				git 'https://github.com/raziqpasha/swiggy_ui_automation.git'
			}
		}

		stage('Build & Test') {
			steps {
				bat 'mvn clean test'
			}
		}

		stage('Generate Allure Report') {
			steps {
				bat 'allure generate allure-results --clean -o allure-report'
			}
		}

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
		}

		failure {
			echo 'Test Failed ❌'
		}
	}
}