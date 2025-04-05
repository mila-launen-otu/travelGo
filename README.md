[//]: # (This is a branch of travel go that uses JavaFX for a GUI.)

[//]: # ()
[//]: # (It uses the maven build system and this branch can be accessed by using "git clone https://github.com/mila-launen-otu/travelGo.git" to clone the repository and checking out the branch "GUI".)

[//]: # ()
[//]: # (to run this branch with the build scripts type into the terminal "mvn javafx:run")

[//]: # ()
[//]: # (to create an executable based on this branch with the build scripts type into the terminal "mvn javafx:jlink" the executable will be in the app.zip file in the target directory.)

[//]: # ()

# ✈️ travelGo By Rubicon Systems

## Overview

**travelGo** is a Java-based travel management application for travel agencies that allows admins to add, remove, 
update, save, view, filter and sort travel packages. This application helps travel agencies shift from manually 
organizing travel packages with pen and paper, to a more efficient, technological and organized solution.

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/mila-launen-otu/travelGo.git
cd travelGo
git checkout GUI
```

### Build & Run (Maven)
This application uses a Maven build system that includes build scripts.

#### To **run** the application:
```bash
mvn javafx:run
```

#### To **build** an executable:
```bash
mvn javafx:jlink
```
- The executable zip will be available at: `target/app.zip`

---

## Features

### 1. Add/Remove/Update/Save Packages
* Travel packages can easily be added/removed/updated/saved with the touch of a button. With easy-to-find buttons and 
input fields properly labeled, users can use the database in ease.
* Adding information to a travel package is heavily checked before submitting to the database to ensure users showing 
travel packages to customers receive the accurate information.
### 2. Filter & Sorting Packages
* Travel packages can be filtered by continent or travel type.
* Travel packages can be sorted by price and stock in ascending or descending order.
### 3. Detailed View
* Double clicking a travel package can let users find more details on travel packages which also includes 
pictures to let users explore more detail in travel packages.

---

## Project Structure

```
travelGo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/exp/travelgogui/
│   │   │       ├── main/
│   │   │       │   ├── MainApplication.java        ← JavaFX App Launcher
│   │   │       │   ├── MainController.java         ← Screen flow logic
│   │   │       │   ├── MainModel.java              ← App-wide state
│   │   │       │   └── MainViewBuilder.java        ← Root layout (Login ↔ DB)
│   │   │       │
│   │   │       ├── login_screen/
│   │   │       │   ├── functionalInterface.java    ← Callback for login
│   │   │       │   ├── LoginController.java        ← Binds view + logic
│   │   │       │   ├── LoginInteractor.java        ← Runs login task
│   │   │       │   ├── LoginModel.java             ← Stores login state
│   │   │       │   └── LoginViewBuilder.java       ← Login screen GUI
│   │   │       │
│   │   │       ├── travel_database_screen/
│   │   │       │   ├── components/
│   │   │       │   │   ├── TravelDatabaseController.java  ← Handles actions
│   │   │       │   │   ├── TravelDatabaseInteractor.java  ← Runs save/load tasks
│   │   │       │   │   ├── TravelDatabaseModel.java       ← Travel DB state
│   │   │       │   │   ├── TravelDatabaseViewBuilder.java ← GUI: filters, lists, buttons
│   │   │       │   │   └── TravelPackageDetailView.java   ← Popup window for package info
│   │   │       │   └── backend/
│   │   │       │       ├── TravelDatabase.java      ← XML I/O logic
│   │   │       │       ├── TravelPackage.java       ← Travel package model
│   │   │       │       └── TravelPackageList.java   ← Wrapper for XML serialization
│   │   │       └── TravelPackageDialogs.java        ← Add/Edit Dialog window
│   │   └── resources/
│   │       └── images/                              ← Travel images, default.jpg, icons
│   │
│   └── test/
│       └── java/
│           ├── unit/
│           │   ├── AddTravelPackageTest.java
│           │   ├── FilterContinentTest.java
│           │   ├── FilterPriceTest.java
│           │   ├── FilterStockSizeTest.java
│           │   ├── LoginInteractorTest.java        
│           │   └── TravelPackageTest.java
│           │
│           ├── integration/
│           │   ├── DatabaseQueryTest.java
│           │   ├── FrontendAPITest.java
│           │   ├── FrontendListDisplayTest.java
│           │   └── TravelDatabaseIntegrationTest.java
│           │
│           ├── system/
│           │   ├── AdminAddEditPackageTest.java
│           │   ├── AdminDeletePackageTest.java
│           │   ├── AdminFilterAndSelectTest.java
│           │   └── TravelAppSystemTest.java
│           │
│           └── translucent/
│               ├── DuplicatePackageTest.java
│               ├── FileCleanupTest.java
│               └── MemoryManagementTest.java
│
├── pom.xml                    ← Maven configuration (JavaFX + Jackson + TestFX)
├── README.md                  ← Full documentation, setup, structure, contact
└── travel_packages.xml        ← Saved travel package data (if created at runtime)
```

---

## Key Dependencies (pom.xml)

- **JavaFX 22**: UI framework
- **Jackson XML**: XML serialization/deserialization
- **JUnit 5** + **TestFX**: For unit and UI testing
- **Maven Compiler Plugin**: Compiles Java 23

All dependencies and plugins are defined in the provided `pom.xml`.

---

## Testing Instructions

### Unit & System Test Execution

```bash
mvn test
```

Make sure you run it with:

```bash
--add-opens javafx.graphics/com.sun.javafx.application=ALL-UNNAMED
```

This is already configured in the `<argLine>` of the `maven-surefire-plugin`.

---

## Developer Notes

- Admin username + passwords are stored in `login_credentials.xml`, which must follow:
  ```bash
  <LoginCredentials>
    <username>AdminUser</username>
    <password>AdminUser123</password>
  </LoginCredentials>
  ```
- Travel packages are stored in `travel_packages.xml`
- Images are stored in the `src/main/resources/images/` directory
- Travel packages are represented using `TravelPackage` and grouped in `TravelPackageList`
- Filters & sorts are applied dynamically via dropdowns in the UI
- Double-clicking a package opens a detailed popup view
- Any missing image paths fallback to the default image `default.jpg`

---

## Contribution Tips

- Make sure to write **unit tests** for model/database logic
- Use **TestFX** for GUI behavior tests
- Always run `mvn clean javafx:run` after changes to see the full effect
- Add your test classes in `src/test/java/...` in the appropriate test package:
    - `unit` for pure logic classes (e.g., `TravelPackageTest`)
    - `integration` for interactions between database + model
    - `system` for full app UI behavior using `ApplicationTest`

---

## Contact
For questions or suggestions, feel free to reach out to us:

* **Project Team**:
  * **Project Manager:** Mila Launen mila.launen@ontariotechu.net
  * **Technical Manager:** Kendra Peace kendra.peace@ontariotechu.net
  * **Front-End Lead:** Keifer Young keifer.young@ontariotechu.net
  * **Back-End Lead:** Klein Cafa kleinlester.cafa@ontariotechu.net
  * **Software Quality lead:** Gina Suliman gina.suliman@ontariotechu.net
  * **Developers:** All
