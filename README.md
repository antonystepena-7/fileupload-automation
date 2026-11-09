# \# File Upload Automation

# 

# A Java-based web automation project that tests single-file and multiple-file uploads on \[GoFile](https://gofile.io) using Selenium WebDriver, TestNG and Maven.

# 

# This project was developed to practise web test automation and browser-based file upload functionality.

# 

# \## Technologies Used

# 

# \- Java 11+

# \- Selenium WebDriver 4

# \- TestNG

# \- Maven

# \- Eclipse IDE

# 

# \## Test Cases

# 

# The project contains two automated test cases:

# 

# | Test Case | Description |

# |---|---|

# | Multiple File Upload | Uploads multiple files together from the `testdata` folder. |

# | Single File Upload | Uploads one file from the `testdata` folder. |

# 

# \*\*Execution Order:\*\*

# 1\. Multiple-file upload test

# 2\. Single-file upload test

# 

# \## Project Structure

# 

# ```text

# fileupload-automation/

# │

# ├── src/

# │   └── test/

# │       └── java/

# │           └── fileupload/

# │               ├── base/

# │               │   └── BaseTest.java

# │               ├── pages/

# │               │   └── UploadPage.java

# │               └── tests/

# │                   └── UploadTests.java

# │

# ├── testdata/

# │   ├── sample\_data.csv

# │   ├── sample\_image.png

# │   ├── sample\_notes.txt

# │   ├── sample\_report\_1.pdf

# │   └── sample\_report\_2.pdf

# │

# ├── screenshots/

# │   └── .gitkeep

# │

# ├── .gitignore

# ├── pom.xml

# ├── testng.xml

# └── README.md

# ```

# 

# \## How It Works

# 

# 1\. Selenium opens the GoFile website in a browser.

# 2\. The multiple-file upload test selects all sample files from the `testdata` folder and submits them together.

# 3\. The single-file upload test selects one sample file and submits it.

# 4\. A screenshot is captured after each test.

# 5\. The browser remains open for 15 seconds after each test so the result can be viewed.

# 

# \## Key Features

# 

# \- Automated single-file upload testing.

# \- Automated multiple-file upload testing.

# \- Reusable browser setup and cleanup.

# \- File selection using Selenium WebDriver's `sendKeys()` method.

# \- Test execution using TestNG.

# \- Screenshot capture after each test.

# \- Support for Chrome, Edge and Firefox.

# 

# \## Requirements

# 

# \- Java JDK 11 or later

# \- Eclipse IDE with Maven support

# \- Google Chrome, Microsoft Edge or Mozilla Firefox

# \- Internet connection

# 

# \## Running the Tests

# 

# \### 1. Import the Project into Eclipse

# 

# 1\. Open Eclipse IDE.

# 2\. Go to \*\*File → Import\*\*.

# 3\. Select \*\*Maven → Existing Maven Projects\*\*.

# 4\. Click \*\*Next\*\*.

# 5\. Browse and select the downloaded or cloned project folder.

# 6\. Eclipse will detect the `pom.xml` file.

# 7\. Select the project and click \*\*Finish\*\*.

# 8\. Wait for Maven dependencies to load.

# 

# \### 2. Execute the Tests

# 

# 1\. Right-click the imported project.

# 2\. Select \*\*Run As → Maven test\*\*.

# 3\. The multiple-file upload test runs first.

# 4\. The single-file upload test runs next.

# 5\. Check the execution results in the Eclipse console.

# 

# \### 3. View Screenshots

# 

# Screenshots captured after each test are saved in:

# 

# ```text

# target/screenshots/

# ```

# 

# \## Notes

# 

# \- The project uses the live GoFile website for testing.

# \- Sample files are provided in the `testdata` folder.

# \- Do not use confidential or personal files during testing.

# \- The tests automate file selection and upload submission. Server-side upload completion should also be checked through the browser.

# 

# \## Author

# 

# Created as a practice project to learn Java-based web test automation using Selenium WebDriver and TestNG.

