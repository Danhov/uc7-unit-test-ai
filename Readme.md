## Running Tests Locally

To run the tests locally, follow these steps:

1. **Clone the Repository**: Start by cloning the project repository to your local machine. Use the following command:

`git clone <repository_url>`


2. **Navigate to Project Directory**: Change your working directory to the root of the project:

`cd <project_directory>`

3. **Ensure Java 17**: Make sure you have Java 17 installed on your machine. You can check your Java version by running:

`java -version`

If you don't have Java 17 installed, you can download and install it from the official Oracle website or your preferred package manager.

4. **Build the Project**: Build the Gradle project by running the following command:

`./gradlew build`

This command will download dependencies and compile the project.

5. **Run Tests**: Execute the tests by running the following command:

`./gradlew test`

This command will run all the tests for both the StudentConverter and PlayerAnalyzer components. You'll see the test results in the terminal.

6. **Review Test Reports**: Optionally, you can generate and review detailed test reports, including coverage reports, by running:

`./gradlew test jacocoTestReport`

The test report will be available in the `build/reports` directory.

By following these steps, you can locally run and verify the tests for the StudentConverter and PlayerAnalyzer components. These tests help ensure the correctness and reliability of these essential project functionalities.