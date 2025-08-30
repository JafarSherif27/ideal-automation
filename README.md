# IDEAL Automation Framework

## Overview
This is a **Java + Gradle automation framework** for testing the [IDEAL](https://website.idealonline.app/) web application.  
It supports **UI testing** using Selenium WebDriver, **API testing** using RestAssured, and **reporting** with ExtentReports.  

The framework follows **Page Object Model (POM)** design, **TestNG** as the test runner, and **data-driven testing** using JSON files.

---

## Folder Structure

```
ideal-automation/
├── build.gradle                  # Gradle build file
├── settings.gradle               # Gradle settings
├── src/
│   ├── main/
│   │   ├── java/com/ideal/automation/
│   │   │   ├── config/          # ConfigReader, EnvironmentManager
│   │   │   ├── core/            # BaseTest, BasePage
│   │   │   ├── driver/          # DriverManager, WebDriver setup
│   │   │   ├── reporting/       # ExtentReports setup
│   │   │   └── utils/           # FileUtils, WaitUtils, JsonUtils
│   │   └── resources/
│   │       ├── config.properties
│   └── test/
│       ├── java/com/ideal/automation/
│       │   ├── pages/           # Page Objects (LoginPage, DashboardPage, etc.)
│       │   ├── tests/
│       │   │   ├── ui/          # UI test classes
│       │   │   ├── api/         # API test classes
│       │   │   └── mobile/      # Mobile test classes (future)
│       │   ├── dataprovider/    # TestNG DataProviders
│       └── resources/
│           ├── locators/        # External locator files (optional)
│           ├── testdata/        # JSON/CSV/Excel test data
│           └── testng.xml       # TestNG suite configuration
└── .gitignore
```

---

## Prerequisites

- **Java 21** (or compatible version)  
- **Gradle** (wrapped or installed)  
- IDE: **IntelliJ IDEA** or **VS Code**  
- ChromeDriver (or driver for your browser) in PATH

---

## Setup

1. Clone the repository:

```bash
git clone https://github.com/your-repo/ideal-automation.git
cd ideal-automation
```

2. Build the project:

```bash
./gradlew build
```

3. Ensure `config.properties` contains your environment info:

```properties
baseUrl=https://website.idealonline.app/
browser=chrome
timeout=10
```

---

## Running Tests

### Run all tests via Gradle

```bash
./gradlew test
```

### Run specific TestNG XML suite

```bash
./gradlew test --tests "com.ideal.automation.tests.ui.LoginTest"
```

## Adding Test Data

- Place JSON, CSV, or Excel files in:
```
src/test/resources/testdata/
```
- Use `DataProvider` classes to read and feed tests dynamically.
---

## Reporting

- ExtentReports generates **HTML reports** in `target/reports/extent/`  
- Configure report path in `reporting/ExtentManager.java`

---

## Code Conventions

- **Packages/folders** are lowercase  
- **Page classes** under `pages/`  
- **Test classes** under `tests/ui` or `tests/api`  
- **Data providers** under `dataprovider/`  
- **Reusable utilities** under `utils/`  



