# 🎓 Master Java Project - Maven Edition

Complete Java learning project organized by difficulty level.

## 🚀 Quick Start

### Open in IntelliJ IDEA:
1. File → Open
2. Select this folder
3. Wait for Maven indexing
4. Right-click any .java file
5. Click green ▶️ Run button

### Run from Terminal:
```bash
# Compile
mvn clean compile

# Run main
mvn exec:java -Dexec.mainClass="com.masterjava.Main"

# Run specific class
mvn exec:java -Dexec.mainClass="com.masterjava.core.fundamentals.HelloWorld"
```

## 📁 Project Structure

```
src/main/java/com/masterjava/
├── Main.java                 ← Start here!
├── core/                     ← Fundamentals
│   ├── HelloWorld.java
│   ├── VariablesAndDataTypes.java
│   ├── OOP.java
│   └── ...
├── advanced/                 ← Advanced concepts
│   ├── Generics.java
│   └── ...
└── springboot/               ← Framework
    ├── SpringBasics.java
    └── ...
```

## 📚 Learning Modules

### Core Java (Fundamentals)
- HelloWorld
- Variables & Data Types
- Operators
- Control Flow
- OOP Concepts
- Collections
- Exception Handling
- Threading

### Advanced Java
- Generics
- Design Patterns
- Streams & Lambdas
- Reflection
- Serialization

### Spring Boot
- Spring Basics
- Dependency Injection
- REST Controllers
- Exception Handling

## 🎯 Learning Path

1. Start with **Core Java**
2. Progress to **Advanced**
3. Learn **Spring Boot**

## 💡 Tips

- Run examples frequently
- Modify and experiment
- Check other modules for reference
- Each file has comprehensive examples

## 🔧 Maven Commands

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Build JAR
mvn clean package

# Run with Maven
mvn exec:java -Dexec.mainClass="com.masterjava.Main"
```

Happy Learning! 🎉
