package com.masterjava.core.oop;

/**
 * LESSON 8: ABSTRACTION & ABSTRACT CLASSES
 * =========================================
 *
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand abstraction concept
 * 2. Master abstract classes and methods
 * 3. Learn when to use abstraction
 * 4. Understand abstract vs concrete classes
 * 5. Learn abstract class vs interface
 * 6. Master constructor in abstract classes
 * 7. Understand partial implementation
 * 8. Learn real-world abstraction patterns
 *
 * UNDER THE HOOD (JVM):
 * --------------------
 * ABSTRACT CLASS BEHAVIOR:
 * - Abstract classes cannot be instantiated
 * - But can have constructors (called by child)
 * - Abstract methods have no body (only signature)
 * - Stored in Method Area like regular classes
 * - Child classes must implement all abstract methods
 *
 * MEMORY LAYOUT:
 * -------------
 * Abstract class metadata in Method Area
 * Concrete child objects in Heap
 * Abstract class reference can point to child object
 *
 * vtable (Virtual Method Table):
 * - Abstract methods: placeholder in parent's vtable
 * - Concrete methods: actual implementation
 * - Child's vtable: all methods have implementations
 *
 * @author Master Java Project
 * @version 1.0
 * @since 2024
 */
public class AbstractionDemo {

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   LESSON 8: ABSTRACTION              ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: BASIC ABSTRACTION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. BASIC ABSTRACT CLASSES ━━━");

        // Cannot instantiate abstract class
        // Creature creature = new Creature(); // Compile error!

        // Can create reference and point to child
        Creature lion = new Lion();
        Creature eagle = new Eagle();

        lion.eat();        // Inherited concrete method
        lion.makeSound();  // Overridden abstract method
        lion.sleep();      // Inherited concrete method

        System.out.println();

        eagle.eat();
        eagle.makeSound();
        eagle.sleep();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: ABSTRACT CLASS WITH CONSTRUCTOR
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. ABSTRACT CLASS WITH CONSTRUCTOR ━━━");

        BankAccount savings = new SavingsAccount("SA001", 5000, 2.5);
        BankAccount current = new CurrentAccount("CA001", 10000, 5000);

        savings.deposit(1000);
        savings.withdraw(500);
        savings.displayBalance();

        System.out.println();

        current.deposit(2000);
        current.withdraw(500);
        current.displayBalance();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: PARTIAL IMPLEMENTATION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. PARTIAL IMPLEMENTATION ━━━");

        GameCharacter warrior = new Warrior("Conan");
        GameCharacter mage = new Mage("Gandalf");

        warrior.displayInfo();
        warrior.attack();
        warrior.defend();
        warrior.specialAbility();

        System.out.println();

        mage.displayInfo();
        mage.attack();
        mage.defend();
        mage.specialAbility();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: ABSTRACT CLASS HIERARCHY
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. ABSTRACT CLASS HIERARCHY ━━━");

        TwoDShape circle = new CircleShape(5.0);
        TwoDShape rectangle = new RectangleShape(4.0, 6.0);
        ThreeDShape sphere = new SphereShape(3.0);
        ThreeDShape cube = new CubeShape(4.0);

        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println("Sphere volume: " + sphere.calculateVolume());
        System.out.println("Cube volume: " + cube.calculateVolume());

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: REAL-WORLD EXAMPLE - DATABASE CONNECTION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. REAL-WORLD: DATABASE CONNECTION ━━━");

        DatabaseConnection mysql = new MySQLConnection();
        DatabaseConnection postgres = new PostgreSQLConnection();

        mysql.connect();
        mysql.executeQuery("SELECT * FROM users");
        mysql.disconnect();

        System.out.println();

        postgres.connect();
        postgres.executeQuery("SELECT * FROM products");
        postgres.disconnect();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: TEMPLATE METHOD PATTERN
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. TEMPLATE METHOD PATTERN ━━━");

        DataProcessor csvProcessor = new CSVDataProcessor();
        DataProcessor jsonProcessor = new JSONDataProcessor();

        System.out.println("Processing CSV:");
        csvProcessor.process();

        System.out.println("\nProcessing JSON:");
        jsonProcessor.process();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: ABSTRACT CLASS WITH STATIC METHODS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. ABSTRACT CLASS WITH STATIC METHODS ━━━");

        MathOperation addition = new Addition();
        MathOperation multiplication = new Multiplication();

        System.out.println("Addition: " + addition.calculate(10, 5));
        System.out.println("Multiplication: " + multiplication.calculate(10, 5));
        System.out.println("Using static utility: " + MathOperation.validateInputs(10, 5));

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        AbstractionInterviewQuestions.printInterviewQuestions();
    }
}

// ═══════════════════════════════════════════════════════════
// BASIC ABSTRACT CLASS EXAMPLE
// ═══════════════════════════════════════════════════════════

/**
 * Abstract class - Cannot be instantiated
 * Can have both abstract and concrete methods
 */
abstract class Creature {
    // Concrete method with implementation
    public void eat() {
        System.out.println("  Creature is eating");
    }

    // Abstract method - no implementation
    public abstract void makeSound();

    // Concrete method
    public void sleep() {
        System.out.println("  Creature is sleeping");
    }
}

class Lion extends Creature {
    @Override
    public void makeSound() {
        System.out.println("  Lion roars: ROAR!");
    }
}

class Eagle extends Creature {
    @Override
    public void makeSound() {
        System.out.println("  Eagle screeches: SCREECH!");
    }
}

// ═══════════════════════════════════════════════════════════
// ABSTRACT CLASS WITH CONSTRUCTOR
// ═══════════════════════════════════════════════════════════

abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    // Constructor in abstract class
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        System.out.println("  → BankAccount constructor called");
    }

    // Concrete methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println("  Deposited: $" + amount);
    }

    public void displayBalance() {
        System.out.println("  Account: " + accountNumber + ", Balance: $" + balance);
    }

    // Abstract method - each account type implements differently
    public abstract void withdraw(double amount);

    // Abstract method
    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
        System.out.println("  → SavingsAccount constructor called");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("  Withdrawn from Savings: $" + amount);
        } else {
            System.out.println("  ⚠ Insufficient balance!");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
        System.out.println("  → CurrentAccount constructor called");
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("  Withdrawn from Current: $" + amount);
        } else {
            System.out.println("  ⚠ Exceeds overdraft limit!");
        }
    }

    @Override
    public double calculateInterest() {
        return 0; // Current accounts typically don't earn interest
    }
}

// ═══════════════════════════════════════════════════════════
// PARTIAL IMPLEMENTATION
// ═══════════════════════════════════════════════════════════

abstract class GameCharacter {
    protected String name;
    protected int health;
    protected int level;

    public GameCharacter(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
    }

    // Concrete methods
    public void displayInfo() {
        System.out.println("  Character: " + name + " | Health: " + health + " | Level: " + level);
    }

    public void levelUp() {
        level++;
        health += 10;
        System.out.println("  " + name + " leveled up to " + level);
    }

    // Abstract methods - must be implemented by subclasses
    public abstract void attack();
    public abstract void defend();
    public abstract void specialAbility();
}

class Warrior extends GameCharacter {
    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("  ⚔️ " + name + " swings sword!");
    }

    @Override
    public void defend() {
        System.out.println("  🛡️ " + name + " raises shield!");
    }

    @Override
    public void specialAbility() {
        System.out.println("  💪 " + name + " uses Berserker Rage!");
    }
}

class Mage extends GameCharacter {
    public Mage(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("  🔮 " + name + " casts fireball!");
    }

    @Override
    public void defend() {
        System.out.println("  ✨ " + name + " creates magic barrier!");
    }

    @Override
    public void specialAbility() {
        System.out.println("  ⚡ " + name + " unleashes Meteor Storm!");
    }
}

// ═══════════════════════════════════════════════════════════
// ABSTRACT CLASS HIERARCHY
// ═══════════════════════════════════════════════════════════

abstract class GeometricShape {
    protected String color;

    public void setColor(String color) {
        this.color = color;
    }
}

abstract class TwoDShape extends GeometricShape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

abstract class ThreeDShape extends GeometricShape {
    public abstract double calculateVolume();
    public abstract double calculateSurfaceArea();
}

class CircleShape extends TwoDShape {
    private double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class RectangleShape extends TwoDShape {
    private double length;
    private double width;

    public RectangleShape(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class SphereShape extends ThreeDShape {
    private double radius;

    public SphereShape(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

class CubeShape extends ThreeDShape {
    private double side;

    public CubeShape(double side) {
        this.side = side;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public double calculateSurfaceArea() {
        return 6 * side * side;
    }
}

// ═══════════════════════════════════════════════════════════
// REAL-WORLD EXAMPLE - DATABASE CONNECTION
// ═══════════════════════════════════════════════════════════

abstract class DatabaseConnection {
    protected String connectionString;
    protected boolean isConnected;

    // Template method - defines algorithm skeleton
    public final void connect() {
        System.out.println("  Opening connection...");
        establishConnection();
        authenticate();
        isConnected = true;
        System.out.println("  ✓ Connection established");
    }

    // Abstract methods - subclasses provide specific implementation
    protected abstract void establishConnection();
    protected abstract void authenticate();

    // Concrete method
    public void disconnect() {
        System.out.println("  Closing connection...");
        isConnected = false;
        System.out.println("  ✓ Connection closed");
    }

    // Abstract method
    public abstract void executeQuery(String query);
}

class MySQLConnection extends DatabaseConnection {

    @Override
    protected void establishConnection() {
        connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("  Connecting to MySQL: " + connectionString);
    }

    @Override
    protected void authenticate() {
        System.out.println("  Authenticating with MySQL credentials");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("  Executing MySQL query: " + query);
    }
}

class PostgreSQLConnection extends DatabaseConnection {

    @Override
    protected void establishConnection() {
        connectionString = "jdbc:postgresql://localhost:5432/mydb";
        System.out.println("  Connecting to PostgreSQL: " + connectionString);
    }

    @Override
    protected void authenticate() {
        System.out.println("  Authenticating with PostgreSQL credentials");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("  Executing PostgreSQL query: " + query);
    }
}

// ═══════════════════════════════════════════════════════════
// TEMPLATE METHOD PATTERN
// ═══════════════════════════════════════════════════════════

abstract class DataProcessor {

    // Template method - final to prevent override
    public final void process() {
        readData();
        validateData();
        transformData();
        saveData();
    }

    // Concrete methods
    private void validateData() {
        System.out.println("  2. Validating data...");
    }

    private void saveData() {
        System.out.println("  4. Saving data...");
    }

    // Abstract methods - vary by implementation
    protected abstract void readData();
    protected abstract void transformData();
}

class CSVDataProcessor extends DataProcessor {

    @Override
    protected void readData() {
        System.out.println("  1. Reading CSV file...");
    }

    @Override
    protected void transformData() {
        System.out.println("  3. Transforming CSV to objects...");
    }
}

class JSONDataProcessor extends DataProcessor {

    @Override
    protected void readData() {
        System.out.println("  1. Reading JSON file...");
    }

    @Override
    protected void transformData() {
        System.out.println("  3. Parsing JSON to objects...");
    }
}

// ═══════════════════════════════════════════════════════════
// ABSTRACT CLASS WITH STATIC METHODS
// ═══════════════════════════════════════════════════════════

abstract class MathOperation {

    // Abstract method
    public abstract double calculate(double a, double b);

    // Static method in abstract class
    public static boolean validateInputs(double a, double b) {
        System.out.println("  Validating inputs: " + a + ", " + b);
        return !Double.isNaN(a) && !Double.isNaN(b);
    }

    // Concrete method
    public void displayResult(double result) {
        System.out.println("  Result: " + result);
    }
}

class Addition extends MathOperation {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

class Multiplication extends MathOperation {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class AbstractionInterviewQuestions {

    static void printInterviewQuestions() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║       INTERVIEW QUESTIONS - ABSTRACTION                ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
                {
                        "1. What is abstraction?",
                        "ANSWER: Hiding implementation details, showing only essential features",
                        "  Key concepts:",
                        "  - Focus on WHAT an object does, not HOW",
                        "  - Achieved through abstract classes and interfaces",
                        "  - Reduces complexity",
                        "  - Increases code reusability",
                        "  Real-world: Car - you know how to drive (interface), not engine details"
                },
                {
                        "2. What is an abstract class?",
                        "ANSWER: Class that cannot be instantiated, may have abstract methods",
                        "  Characteristics:",
                        "  - Declared with 'abstract' keyword",
                        "  - Cannot create objects directly",
                        "  - Can have abstract methods (no body)",
                        "  - Can have concrete methods (with body)",
                        "  - Can have constructors, fields, static methods",
                        "  - Subclass must implement all abstract methods",
                        "  Syntax: abstract class Animal { }"
                },
                {
                        "3. What is an abstract method?",
                        "ANSWER: Method without implementation (only signature)",
                        "  Rules:",
                        "  - Must be in abstract class (or interface)",
                        "  - No method body, ends with semicolon",
                        "  - Subclass MUST implement it",
                        "  - Cannot be private, static, or final",
                        "  Example:",
                        "    public abstract void makeSound(); // No {}"
                },
                {
                        "4. Can abstract class have constructor?",
                        "ANSWER: Yes, even though class cannot be instantiated",
                        "  Purpose:",
                        "  - Initialize common fields",
                        "  - Called when child object is created",
                        "  - Uses super() from child constructor",
                        "  Example:",
                        "    abstract class Shape {",
                        "        String color;",
                        "        Shape(String color) { this.color = color; }",
                        "    }"
                },
                {
                        "5. Can abstract class have all concrete methods?",
                        "ANSWER: Yes, abstract class doesn't require abstract methods",
                        "  - Can have 0 or more abstract methods",
                        "  - Still cannot be instantiated",
                        "  - Used when you want to prevent direct instantiation",
                        "  Use case: Utility base class with common functionality"
                },
                {
                        "6. Difference between abstract class and interface?",
                        "ANSWER:",
                        "  Abstract Class:",
                        "  - Can have constructors",
                        "  - Can have instance variables",
                        "  - Can have concrete methods",
                        "  - Single inheritance (extends one class)",
                        "  - Can have any access modifiers",
                        "  Interface:",
                        "  - No constructors",
                        "  - Only constants (public static final)",
                        "  - All methods public (Java 8+: default/static methods)",
                        "  - Multiple inheritance (implements many interfaces)",
                        "  - Methods implicitly public abstract"
                },
                {
                        "7. When to use abstract class vs interface?",
                        "ANSWER:",
                        "  Use Abstract Class:",
                        "  - IS-A relationship with common implementation",
                        "  - Need constructors or state",
                        "  - Want to provide default behavior",
                        "  - Example: Animal → Dog, Cat",
                        "  Use Interface:",
                        "  - CAN-DO relationship",
                        "  - Multiple inheritance needed",
                        "  - Contract without implementation",
                        "  - Example: Flyable → Bird, Airplane"
                },
                {
                        "8. Can abstract class extend another abstract class?",
                        "ANSWER: Yes, abstract class can extend abstract class",
                        "  - Child abstract class doesn't need to implement parent's abstract methods",
                        "  - First concrete subclass must implement ALL abstract methods",
                        "  Example:",
                        "    abstract class Shape { abstract void draw(); }",
                        "    abstract class TwoDShape extends Shape { } // OK",
                        "    class Circle extends TwoDShape { void draw() {...} } // Must implement"
                },
                {
                        "9. Can we have abstract method in non-abstract class?",
                        "ANSWER: No, compile error",
                        "  - Abstract methods require abstract class",
                        "  - Makes sense: concrete class should have all implementations",
                        "  Exception: Interfaces can have abstract methods"
                },
                {
                        "10. Can abstract class implement interface?",
                        "ANSWER: Yes, and doesn't need to implement all methods",
                        "  - Abstract class can implement interface",
                        "  - May or may not implement interface methods",
                        "  - Concrete subclass must implement remaining methods",
                        "  Example:",
                        "    abstract class AbstractList implements List {",
                        "        // Can skip some List methods",
                        "    }"
                },
                {
                        "11. Can abstract class have static methods?",
                        "ANSWER: Yes, abstract class can have static methods",
                        "  - Static methods belong to class, not instance",
                        "  - Can be called using class name",
                        "  - Cannot be abstract (no sense - no override)",
                        "  Example:",
                        "    abstract class MathUtils {",
                        "        static int add(int a, int b) { return a + b; }",
                        "    }"
                },
                {
                        "12. Can abstract method be private?",
                        "ANSWER: No, compile error",
                        "  - Abstract methods must be overridden",
                        "  - Private methods cannot be overridden",
                        "  - Contradictory requirements",
                        "  Valid modifiers: public, protected, default (package-private)"
                },
                {
                        "13. Can abstract method be final?",
                        "ANSWER: No, compile error",
                        "  - Abstract methods must be overridden",
                        "  - Final methods cannot be overridden",
                        "  - Contradictory requirements",
                        "  Purpose conflict!"
                },
                {
                        "14. Can abstract method be static?",
                        "ANSWER: No, compile error",
                        "  - Abstract methods need instance to be overridden",
                        "  - Static methods belong to class, not instance",
                        "  - Cannot be overridden (only hidden)",
                        "  Incompatible concepts"
                },
                {
                        "15. What is the purpose of abstract class?",
                        "ANSWER: Provide common base with partial implementation",
                        "  Benefits:",
                        "  - Code reusability (shared functionality)",
                        "  - Enforce implementation (must implement abstract methods)",
                        "  - Polymorphism (reference to parent, object of child)",
                        "  - Template Method pattern (algorithm skeleton)",
                        "  - Prevent direct instantiation"
                },
                {
                        "16. Can we create reference of abstract class?",
                        "ANSWER: Yes, reference is allowed, but not object",
                        "  Valid:",
                        "    Animal a = new Dog(); // Animal is abstract",
                        "  Invalid:",
                        "    Animal a = new Animal(); // Cannot instantiate",
                        "  Use case: Polymorphism - reference to parent, object of child"
                },
                {
                        "17. Real-world examples of abstract classes in Java?",
                        "ANSWER:",
                        "  1. AbstractList - base for ArrayList, LinkedList",
                        "  2. AbstractSet - base for HashSet, TreeSet",
                        "  3. AbstractMap - base for HashMap, TreeMap",
                        "  4. InputStream - base for FileInputStream, ByteArrayInputStream",
                        "  5. HttpServlet - base for servlet implementations",
                        "  Pattern: Provides common implementation, delegates specifics"
                },
                {
                        "18. What is Template Method pattern?",
                        "ANSWER: Design pattern using abstract class",
                        "  - Define algorithm skeleton in abstract method",
                        "  - Subclasses override specific steps",
                        "  - Algorithm structure stays same",
                        "  Example:",
                        "    abstract class DataProcessor {",
                        "        final void process() {",
                        "            readData(); // Abstract",
                        "            processData(); // Abstract",
                        "            saveData(); // Concrete",
                        "        }",
                        "    }"
                },
                {
                        "19. Can abstract class have final methods?",
                        "ANSWER: Yes, abstract class can have final methods",
                        "  - Final methods cannot be overridden",
                        "  - Ensures specific behavior is not changed",
                        "  - Commonly used with Template Method pattern",
                        "  Example:",
                        "    abstract class Base {",
                        "        final void process() { ... } // Cannot override",
                        "    }"
                },
                {
                        "20. Difference between abstract class and concrete class?",
                        "ANSWER:",
                        "  Abstract Class:",
                        "  - Cannot be instantiated",
                        "  - May have abstract methods",
                        "  - Incomplete implementation",
                        "  - Declared with 'abstract' keyword",
                        "  Concrete Class:",
                        "  - Can be instantiated",
                        "  - All methods have implementation",
                        "  - Complete implementation",
                        "  - No 'abstract' keyword"
                }
        };

        for (String[] qa : questions) {
            for (String line : qa) {
                System.out.println(line);
            }
            System.out.println();
        }

        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                    KEY TAKEAWAYS                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("✓ Abstraction = Hiding implementation details");
        System.out.println("✓ Abstract class cannot be instantiated");
        System.out.println("✓ Abstract methods have no body, must be implemented by child");
        System.out.println("✓ Abstract class can have constructors, concrete methods");
        System.out.println("✓ Use abstract class for IS-A with partial implementation");
        System.out.println("✓ Abstract methods cannot be private, static, or final");
        System.out.println("✓ Template Method pattern uses abstract classes");
        System.out.println("✓ First concrete child must implement all abstract methods");
        System.out.println();
    }
}