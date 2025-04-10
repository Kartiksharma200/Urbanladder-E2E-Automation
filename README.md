# 🧪 UrbanLadder E2E Automation Framework

This repository contains an end-to-end automation testing framework for the UrbanLadder website, built using **Cucumber**, **TestNG**, **Java**, and **Maven**. The project follows best practices for BDD-style testing with feature files and step definitions, and generates structured test reports.

---

## 🔧 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Cucumber (BDD)
- Maven
- Gherkin Syntax (for Feature Files)

---

## 📁 Project Structure

```plaintext
kartiksharma200-urbanladder-e2e-automation/
├── README.md                   # Project documentation
├── pom.xml                     # Maven configuration and dependencies
├── testng.xml                  # TestNG suite configuration file
├── src/
│   └── test/
│       ├── java/
│       │   ├── e2e.java                 # TestNG runner class
│       │   └── Stepdefination.java     # Step definitions for feature steps
│       └── resources/
│           └── Features/
│               └── main.feature        # Gherkin-based feature file
├── test-output/                         # TestNG generated reports
│   ├── emailable-report.html
│   ├── index.html
│   ├── testng-results.xml
│   ├── Default suite/
│   └── junitreports/
│       └── TEST-e2e.xml
```
## 📜 How It Works

- Feature File: Written in Gherkin syntax (main.feature) to define high-level test scenarios in human-readable language.
- Step Definitions: Java code (Stepdefination.java) implementing steps described in the feature file.
- TestNG Runner: e2e.java is configured to run Cucumber features via TestNG.
- Reports: Test results are generated using TestNG's default reporters.

## 🚀 Getting Started
# 1. Clone the repository
~~~
git clone https://github.com/kartiksharma200/kartiksharma200-urbanladder-e2e-automation.git
cd kartiksharma200-urbanladder-e2e-automation
~~~
# 2. Install dependencies
Ensure you have Maven and JDK set up, then:
~~~
mvn clean install
~~~
# 3. Run the tests
You can execute the tests using:
~~~
mvn test
~~~
Or specifically with TestNG:
~~~
mvn test -DsuiteXmlFile=testng.xml
~~~

## 📌 Notes
- Ensure all required drivers and browser setups are configured correctly before running.
- This is a scalable base for any BDD-style Selenium TestNG project.

## 👨‍💻 Author
- Kartik Sharma
- SDET Trainee | Automation Engineer
- LinkedIn

## 📄 License
This project is licensed for educational and learning purposes.
~~~
Let me know if you'd like to add a section for browser config, GitHub Actions CI, or integrate with Allure/
~~~
