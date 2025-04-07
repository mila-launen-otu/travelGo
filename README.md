# 🏛️ Rubicon Systems – Travel Package Management

> *“Alea iacta est.”* – *The die is cast.*  
Just like Caesar crossing the Rubicon, this project marks a point of no return in efficient travel management.

---

## 📜 **Project Overview**
Rubicon Systems is a **Travel Package Management System** designed to help administrators **organize, track, and modify travel packages efficiently**. The platform ensures seamless management of travel offerings, including inventory and pricing adjustments.

---

### ⚔️ **Key Features**
- **Add, Edit, or Delete Travel Packages**: Manage package details such as title, description, price, and stock availability.
- **Real-Time Stock Tracking**: Monitor available stock for each package.
- **Detailed View**: Click on any travel package and get a full view, including a photo.
- **Advanced Sorting & Filtering**: Quickly find packages based on criteria like price, destination, and availability.
- **Admin Login System**: Secure access to system functionalities.

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

## 🧭 **How to Use**
1. **Add Travel Packages**: Input essential details like title, description, price, and stock.
2. **Modify Stock**: Adjust stock quantities as needed for each package.
3. **Edit Packages**: Update existing package information when required.
4. **Delete Packages**: Remove discontinued or outdated packages.
5. **Sort & Filter**: Utilize sorting and filtering options to easily navigate available packages.
6. **Admin Login** – Authenticate to unlock the full suite of management features.

---

## 🛠️ Installation & Running the Program

Rubicon Systems provides a pre-built executable for easy setup, no compiling required!

1. Go to the [Releases](https://github.com/mila-launen-otu/travelGo/releases/tag/v1.0.0) section of this repository.
   
2. Download the zip files under **Assets**

3. Once unzipped, open the app folder and click on the Travel Go shortcut to simply run the program!
   
---

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

## ⚙️ **Project Requirements**
- **Primary Language**: Java
- **Data Storage**: CSV Files
- **Version Control**: Git + GitHub
- **Project Management**: GitHub Project Board

---

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

## 🗓️ **Development Timeline**
### **Week 1:**
- [x] Add Travel Packages
- [x] View Travel Packages
- [x] Modify Stock

### **Week 2:**
- [x] Delete Travel Packages
- [x] Edit Travel Packages
- [X] Sorting & Filtering

### **Week 3:**
- [X] UI Enhancements
- [X] System Testing
- [X] Admin Login

---

## 📜 **Project Taskboard**  
(https://github.com/users/KendraP5/projects/2)

---

## 🛡️ Contact
For questions or suggestions, feel free to reach out to us:

* **Project Team**:
  * **Project Manager:** Mila Launen mila.launen@ontariotechu.net
  * **Technical Manager:** Kendra Peace kendra.peace@ontariotechu.net
  * **Front-End Lead:** Keifer Young keifer.young@ontariotechu.net
  * **Back-End Lead:** Klein Cafa kleinlester.cafa@ontariotechu.net
  * **Software Quality lead:** Gina Suliman gina.suliman@ontariotechu.net
  * **Developers:** All

---

## ⚠️ **Known Risks & Challenges**
- **Data Accuracy**: Implementing efficient stock updates.
- **Security Concerns**: Ensuring safe admin access and data protection.
- **Performance Optimization**: Enhancing sorting and filtering speed.

---

## 🏛️ Final Product: **TravelGo**
A decisive step forward in travel management by **Rubicon Systems**, where bold ideas become reality.

---
