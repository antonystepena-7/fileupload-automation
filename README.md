# File Upload Automation

<p align="center">
  A Selenium-based web automation project for testing single-file and multiple-file uploads on GoFile.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-11%2B-orange" alt="Java 11+">
  <img src="https://img.shields.io/badge/Selenium-4-green" alt="Selenium 4">
  <img src="https://img.shields.io/badge/TestNG-Testing-red" alt="TestNG">
  <img src="https://img.shields.io/badge/Maven-Build-blue" alt="Maven">
</p>

---

## Overview

This project automates file upload testing on [GoFile](https://gofile.io) using Java and Selenium WebDriver.

It includes two test cases to practise browser-based file upload automation: uploading multiple files together and uploading a single file.

## Technologies

| Technology | Purpose |
|---|---|
| Java 11+ | Programming language |
| Selenium WebDriver 4 | Browser automation |
| TestNG | Test execution |
| Maven | Dependency management |
| Eclipse IDE | Development environment |

## Test Cases

| Test Case | Description |
|---|---|
| Multiple File Upload | Selects and submits multiple files together from the `testdata` folder. |
| Single File Upload | Selects and submits one file from the `testdata` folder. |

**Execution order:**
1. Multiple-file upload
2. Single-file upload

## Project Structure

```text
fileupload-automation/
│
├── src/test/java/fileupload/
│   ├── base/
│   │   └── BaseTest.java
│   ├── pages/
│   │   └── UploadPage.java
│   └── tests/
│       └── UploadTests.java
│
├── testdata/
│   ├── sample_data.csv
│   ├── sample_image.png
│   ├── sample_notes.txt
│   ├── sample_report_1.pdf
│   └── sample_report_2.pdf
│
├── screenshots/
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

## How It Works

1. Selenium launches a browser and opens GoFile.
2. The multiple-file test selects all sample files from the `testdata` folder and submits them together.
3. The single-file test selects and submits one sample file.
4. A screenshot is captured after each test.
5. The browser remains open for 15 seconds after each test so the result can be viewed.

## Key Features

- Single-file and multiple-file upload automation.
- Reusable browser setup and cleanup.
- File selection using Selenium WebDriver's `sendKeys()` method.
- Test execution using TestNG.
- Screenshot capture after each test.
- Support for Chrome, Edge and Firefox.

## Requirements

- Java JDK 11 or later.
- Eclipse IDE with Maven support.
- Google Chrome, Microsoft Edge or Mozilla Firefox.
- Internet connection.

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Antonystepena-7/fileupload-automation.git
```

### 2. Import into Eclipse

1. Open Eclipse IDE.
2. Go to **File → Import**.
3. Select **Maven → Existing Maven Projects**.
4. Click **Next**.
5. Browse and select the cloned project folder.
6. Eclipse will detect the `pom.xml` file.
7. Select the project and click **Finish**.
8. Wait for Maven dependencies to load.

### 3. Run the Tests

1. Right-click the imported project.
2. Select **Run As → Maven test**.
3. The multiple-file upload test runs first, followed by the single-file upload test.
4. View the execution results in the Eclipse console.

## Test Results

TestNG displays the number of tests passed, failed and skipped in the Eclipse console.

Screenshots are saved in:

```text
target/screenshots/
```

## Notes

- The project uses the live GoFile website for testing.
- Sample files are included in the `testdata` folder.
- Do not use confidential or personal files during testing.
- The tests automate file selection and upload submission. Server-side upload completion should also be checked through the browser.

---

<p align="center">
  Created as a practice project to learn Java-based web test automation using Selenium WebDriver and TestNG.
</p>
