# Step-by-Step Guide: Configuring and Running a RestSharp Test

## Step 1: Set Up Your Development Environment

1. **Install .NET SDK**
   - RestSharp requires .NET to be installed on your machine.
   - Download and install the latest version of the .NET SDK from the [.NET SDK Download Page](https://dotnet.microsoft.com/download).
   - Verify the installation by running `dotnet --version` in your command prompt or terminal.

2. **Install an Integrated Development Environment (IDE)**
   - You need an IDE to write and run your tests. A common choice is [Visual Studio](https://visualstudio.microsoft.com/downloads/) or [Visual Studio Code](https://code.visualstudio.com/).
   - Download and install your preferred IDE.

## Step 2: Create a New Project

1. **Open Your IDE**
   - Launch your installed IDE (Visual Studio or Visual Studio Code).

2. **Create a New .NET Project**
   - **Using Visual Studio:**
     - Go to `File > New > Project`.
     - Select `Console App` (.NET Core or .NET 5+), and click `Next`.
   - **Using Visual Studio Code:**
     - Open a terminal and run the following command:
     ```bash
     dotnet new console -n RestSharpDemo
     ```
   - This command creates a new console application named `RestSharpDemo`.

3. **Configure Project Settings**
   - In Visual Studio, enter your project name (e.g., `RestSharpDemo`) and location, then click `Create`.

## Step 3: Add RestSharp Dependency

1. **Add RestSharp NuGet Package**
   - **Using Visual Studio:**
     - Right-click on your project in the Solution Explorer and select `Manage NuGet Packages`.
     - Search for `RestSharp`, select it, and click `Install`.
   - **Using .NET CLI:**
     - Open the terminal in Visual Studio Code or the command prompt, navigate to your project directory, and run:
     ```bash
     dotnet add package RestSharp --version 110.2.0
     ```

## Step 4: Write Your First RestSharp Test

1. **Create a Test Class**
   - In the `Program.cs` file or create a new class file (e.g., `RestSharpTest.cs`).

2. **Write a Basic RestSharp Test**
   - Below is a simple example of a RestSharp test that sends a GET request to a public API and verifies the response status code:
   ```csharp
   using System;
   using RestSharp;

   class RestSharpTest
   {
       static void Main(string[] args)
       {
           // Base URI of the REST API
           var client = new RestClient("https://jsonplaceholder.typicode.com");

           // Create a GET request to /posts/1
           var request = new RestRequest("/posts/1", Method.Get);

           // Execute the request
           var response = client.Execute(request);

           // Verify the status code
           if (response.StatusCode == System.Net.HttpStatusCode.OK)
           {
               Console.WriteLine("Test Passed: Status Code is 200");
           }
           else
           {
               Console.WriteLine("Test Failed: Status Code is " + response.StatusCode);
           }

           // Verify the content
           if (response.Content.Contains("\"userId\": 1"))
           {
               Console.WriteLine("Test Passed: userId is 1");
           }
           else
           {
               Console.WriteLine("Test Failed: userId is not 1");
           }
       }
   }

This code sends a GET request to the JSONPlaceholder API and checks if the status code is 200 and userId is 1.

## Step 5: Run Your Test
Run the Test in Your IDE

Using Visual Studio:
Press Ctrl + F5 or click Debug > Start Without Debugging to run the test.
- Using Visual Studio Code:
- Open the terminal, navigate to your project directory, and run:
`dotnet run

## Step 6: References and Further Reading
- RestSharp Official Documentation
- .NET SDK Documentation
- Visual Studio Documentation
- Visual Studio Code Documentation
- JSONPlaceholder - A free online REST API for testing and prototyping.

