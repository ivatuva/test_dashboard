# Step-by-Step Guide: Configuring and Running a REST Assured Test

## Step 1: Set Up Your Development Environment

1. **Install Java Development Kit (JDK)**
   - REST Assured requires Java to be installed on your machine.
   - Download and install the latest version of the JDK from the [Oracle JDK website](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://jdk.java.net/).
   - Verify the installation by running `java -version` in your command prompt or terminal.

2. **Install an Integrated Development Environment (IDE)**
   - You need an IDE to write and run your tests. Common choices include [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) and [Eclipse](https://www.eclipse.org/downloads/).
   - Download and install your preferred IDE.

3. **Set Up a Build Tool (Maven or Gradle)**
   - REST Assured can be added as a dependency in your project using a build tool like Maven or Gradle.
   - If you're using Maven, download and install it from the [Maven website](https://maven.apache.org/download.cgi).
   - If you're using Gradle, download and install it from the [Gradle website](https://gradle.org/install/).
   - Ensure Maven or Gradle is correctly installed by running `mvn -v` or `gradle -v` in your command prompt or terminal.

## Step 2: Create a New Project

1. **Open Your IDE**
   - Launch your installed IDE (IntelliJ IDEA or Eclipse).

2. **Create a New Maven or Gradle Project**
   - **Maven Project:**
     - In IntelliJ IDEA: Go to `File > New > Project`, select `Maven`, and click `Next`.
     - In Eclipse: Go to `File > New > Project`, choose `Maven > Maven Project`, and click `Next`.
   - **Gradle Project:**
     - In IntelliJ IDEA: Go to `File > New > Project`, select `Gradle`, and click `Next`.
     - In Eclipse: Go to `File > New > Project`, choose `Gradle > Gradle Project`, and click `Next`.

3. **Configure Project Settings**
   - Enter your `GroupId` (e.g., `com.example`) and `ArtifactId` (e.g., `restassured-demo`).
   - Click `Finish` to create the project.

## Step 3: Add REST Assured Dependency

1. **Open the `pom.xml` file (for Maven) or `build.gradle` file (for Gradle)**

2. **Add REST Assured Dependency**
   - **For Maven:** Add the following dependency inside the `<dependencies>` section of your `pom.xml` file:
     ```xml
     <dependency>
       <groupId>io.rest-assured</groupId>
       <artifactId>rest-assured</artifactId>
       <version>5.3.0</version>
       <scope>test</scope>
     </dependency>
     ```
   - **For Gradle:** Add the following dependency to the `dependencies` block in your `build.gradle` file:
     ```groovy
     testImplementation 'io.rest-assured:rest-assured:5.3.0'
     ```

3. **Refresh Your Project**
   - In IntelliJ IDEA: Right-click on the project in the Project Explorer and select `Maven > Reload Project` or `Gradle > Refresh Gradle Project`.
   - In Eclipse: Right-click on the project and select `Maven > Update Project` or `Gradle > Refresh Gradle Project`.

## Step 4: Write Your First REST Assured Test

1. **Create a Test Class**
   - In your project’s `src/test/java` directory, create a new Java class (e.g., `RestAssuredTest`).

2. **Write a Basic REST Assured Test**
   - Below is a simple example of a REST Assured test that sends a GET request to a public API and verifies the status code:
   ```java
   import io.restassured.RestAssured;
   import io.restassured.response.Response;
   import org.junit.jupiter.api.Test;

   import static io.restassured.RestAssured.*;
   import static org.hamcrest.Matchers.*;

   public class RestAssuredTest {

       @Test
       public void testGetRequest() {
           // Base URI of the REST API
           RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

           // Send a GET request to /posts/1
           given()
               .when()
                   .get("/posts/1")
               .then()
                   .statusCode(200)  // Verify that the status code is 200
                   .body("userId", equalTo(1))  // Verify that userId is 1
                   .body("id", equalTo(1));  // Verify that id is 1
       }
   }

This test uses JUnit 5 for assertions. If you're using a different testing framework, adjust the import statements accordingly.

This test uses JUnit 5 for assertions. If you're using a different testing framework, adjust the import statements accordingly.
## Step 5: Run Your Test
Run the Test in Your IDE

Right-click on the test class (e.g., RestAssuredTest) and select Run 'RestAssuredTest'.
Alternatively, you can run it from the command line using Maven (mvn test) or Gradle (gradle test).
Check Test Results

After running the test, you should see the results in your IDE’s console or in the terminal.
If the test passes, you’ll see a success message. If it fails, check the output for error details.
## Step 6: Advanced REST Assured Usage
Once you've mastered the basics, you can explore more advanced REST Assured features:

Authentication and Authorization

REST Assured supports various authentication methods, including Basic, OAuth, and more. Refer to the REST Assured documentation on Authentication for details.
Request Specifications

You can define common request parameters, headers, and more using RequestSpecification. This helps avoid redundancy in tests.
Response Validations

REST Assured provides a rich set of matchers and assertions for validating response bodies, headers, cookies, etc.
Logging and Debugging

Use REST Assured’s logging capabilities (log().all(), log().body(), etc.) to debug requests and responses.
Data-Driven Testing

You can parameterize your tests using external data sources like CSV files, databases, or Excel sheets.
## Step 7: References and Further Reading
REST Assured Official Documentation
JUnit 5 User Guide
Maven Getting Started Guide
Gradle User Manual
JSONPlaceholder - A free online REST API for testing and prototyping.
