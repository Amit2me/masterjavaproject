package com.masterjava.core.oop;

import static com.masterjava.core.oop.InterviewQuestions.printInterviewQuestions;

/**
 * LESSON 5: OBJECT-ORIENTED PROGRAMMING - BASICS
 * ===============================================
 *
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand classes and objects
 * 2. Master constructors (default, parameterized, copy)
 * 3. Learn encapsulation and access modifiers
 * 4. Understand 'this' keyword
 * 5. Learn instance vs class members
 * 6. Master object initialization process
 * 7. Understand object creation and lifecycle
 * 8. Learn best practices for class design
 *
 * UNDER THE HOOD (JVM):
 * --------------------
 * OBJECT CREATION PROCESS:
 * 1. Memory allocated in Heap
 * 2. Instance variables initialized to default values
 * 3. Constructor executed
 * 4. Reference returned to Stack
 *
 * MEMORY LAYOUT:
 * -------------
 * Heap:
 *   Object {
 *     Object Header (8-16 bytes):
 *       - Mark Word: hash code, GC info, lock status
 *       - Class Pointer: reference to class metadata
 *     Instance Data:
 *       - Actual field values
 *     Padding: alignment to 8-byte boundary
 *   }
 *
 * Stack (main method):
 *   person1 → [reference to Heap object]
 *
 * Method Area (Metaspace):
 *   - Class metadata
 *   - Static variables
 *   - Method bytecode
 *
 * @author Master Java Project
 * @version 1.0
 * @since 2024
 */
public class OOPBasicsDemo {

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      LESSON 5: OOP BASICS             ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: CLASSES AND OBJECTS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. CLASSES AND OBJECTS ━━━");

        // Creating objects using different constructors
        Person person1 = new Person(); // Default constructor
        Person person2 = new Person("Alice", 25); // Parameterized
        Person person3 = new Person("Bob", 30, "Engineer");

        System.out.println("Person 1: " + person1.getDetails());
        System.out.println("Person 2: " + person2.getDetails());
        System.out.println("Person 3: " + person3.getDetails());

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: ENCAPSULATION - GETTERS AND SETTERS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. ENCAPSULATION ━━━");

        // Can't access private fields directly: person1.name = "Test"; // Error!
        person1.setName("John");
        person1.setAge(28);
        person1.setOccupation("Developer");

        System.out.println("Updated person1: " + person1.getDetails());

        // Validation in setters
        person1.setAge(-5); // Will show validation error

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: THIS KEYWORD
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. 'THIS' KEYWORD ━━━");

        ThisExample example = new ThisExample("Value1");
        example.demonstrateThis();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: CONSTRUCTOR TYPES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. CONSTRUCTOR TYPES ━━━");

        // Default constructor
        Product product1 = new Product();
        System.out.println("Product 1: " + product1);

        // Parameterized constructor
        Product product2 = new Product("Laptop", 999.99);
        System.out.println("Product 2: " + product2);

        // Copy constructor
        Product product3 = new Product(product2);
        System.out.println("Product 3 (copy): " + product3);

        // Constructor chaining
        Product product4 = new Product("Phone", 599.99, 10);
        System.out.println("Product 4: " + product4);

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: STATIC VS INSTANCE MEMBERS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. STATIC VS INSTANCE MEMBERS ━━━");

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();

        counter1.incrementInstance();
        counter1.incrementInstance();

        counter2.incrementInstance();

        System.out.println("Counter 1 - Instance: " + counter1.getInstanceCount() +
                ", Static: " + Counter.getStaticCount());
        System.out.println("Counter 2 - Instance: " + counter2.getInstanceCount() +
                ", Static: " + Counter.getStaticCount());
        System.out.println("Counter 3 - Instance: " + counter3.getInstanceCount() +
                ", Static: " + Counter.getStaticCount());

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: OBJECT INITIALIZATION ORDER
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. INITIALIZATION ORDER ━━━");

        System.out.println("\nCreating InitializationDemo object:");
        InitializationDemo initDemo = new InitializationDemo("Constructor Value");

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: ACCESS MODIFIERS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. ACCESS MODIFIERS ━━━");

        AccessModifierExample accessExample = new AccessModifierExample();

        // Public - accessible
        System.out.println("Public field: " + accessExample.publicField);
        accessExample.publicMethod();

        // Default (package-private) - accessible in same package
        System.out.println("Default field: " + accessExample.defaultField);
        accessExample.defaultMethod();

        // Protected - accessible in same package (and subclasses)
        // System.out.println("Protected field: " + accessExample.protectedField); // Visible in same package

        // Private - NOT accessible
        // System.out.println(accessExample.privateField); // Error!
        // accessExample.privateMethod(); // Error!

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: IMMUTABLE OBJECTS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. IMMUTABLE OBJECTS ━━━");

        ImmutablePerson immutablePerson = new ImmutablePerson("Alice", 25);
        System.out.println("Immutable person: " + immutablePerson);

        // Can't modify - no setters!
        // immutablePerson.setName("Bob"); // Error - no such method

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        printInterviewQuestions();
    }
}

// ═══════════════════════════════════════════════════════════
// PERSON CLASS - DEMONSTRATING BASIC OOP
// ═══════════════════════════════════════════════════════════

/**
 * Person class demonstrating encapsulation, constructors, and methods
 */
class Person {
    // Private instance variables (encapsulation)
    private String name;
    private int age;
    private String occupation;

    // Static variable - shared across all instances
    private static int personCount = 0;

    /**
     * Default constructor
     */
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.occupation = "Unemployed";
        personCount++;
        System.out.println("  → Default constructor called");
    }

    /**
     * Parameterized constructor
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.occupation = "Not specified";
        personCount++;
        System.out.println("  → Parameterized constructor (2 params) called");
    }

    /**
     * Parameterized constructor with all fields
     */
    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        personCount++;
        System.out.println("  → Parameterized constructor (3 params) called");
    }

    // Getters (accessors)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public static int getPersonCount() {
        return personCount;
    }

    // Setters (mutators) with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("  ⚠ Invalid name provided!");
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("  ⚠ Invalid age: " + age);
        }
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * Method to get person details
     */
    public String getDetails() {
        return String.format("%s, %d years old, %s", name, age, occupation);
    }
}

// ═══════════════════════════════════════════════════════════
// THIS KEYWORD DEMONSTRATION
// ═══════════════════════════════════════════════════════════

class ThisExample {
    private String value;

    public ThisExample(String value) {
        // 'this' distinguishes instance variable from parameter
        this.value = value;
    }

    public void demonstrateThis() {
        String value = "Local Variable";

        System.out.println("  Local variable: " + value);
        System.out.println("  Instance variable: " + this.value);

        // 'this' to call another method
        this.helperMethod();

        // 'this' to pass current object as argument
        this.printObject(this);
    }

    private void helperMethod() {
        System.out.println("  Helper method called using 'this'");
    }

    private void printObject(ThisExample obj) {
        System.out.println("  Current object: " + obj.value);
    }
}

// ═══════════════════════════════════════════════════════════
// CONSTRUCTOR TYPES AND CHAINING
// ═══════════════════════════════════════════════════════════

class Product {
    private String name;
    private double price;
    private int quantity;

    /**
     * Default constructor
     */
    public Product() {
        this("Unknown Product", 0.0, 0);
        System.out.println("  → Default constructor");
    }

    /**
     * Parameterized constructor (2 params)
     */
    public Product(String name, double price) {
        this(name, price, 0); // Constructor chaining
        System.out.println("  → Two-parameter constructor");
    }

    /**
     * Parameterized constructor (all params) - main constructor
     */
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        System.out.println("  → Three-parameter constructor (main)");
    }

    /**
     * Copy constructor
     */
    public Product(Product other) {
        this.name = other.name;
        this.price = other.price;
        this.quantity = other.quantity;
        System.out.println("  → Copy constructor");
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f (Qty: %d)", name, price, quantity);
    }
}

// ═══════════════════════════════════════════════════════════
// STATIC VS INSTANCE MEMBERS
// ═══════════════════════════════════════════════════════════

class Counter {
    // Instance variable - each object has its own copy
    private int instanceCount = 0;

    // Static variable - shared across ALL objects
    private static int staticCount = 0;

    public Counter() {
        staticCount++; // Increment shared counter
        System.out.println("  Object #" + staticCount + " created");
    }

    public void incrementInstance() {
        instanceCount++;
        staticCount++;
    }

    public int getInstanceCount() {
        return instanceCount;
    }

    public static int getStaticCount() {
        return staticCount;
    }
}

// ═══════════════════════════════════════════════════════════
// INITIALIZATION ORDER DEMONSTRATION
// ═══════════════════════════════════════════════════════════

class InitializationDemo {
    // 1. Static variable initialization
    private static String staticField = initializeStaticField();

    // 2. Static block
    static {
        System.out.println("  3. Static block executed");
    }

    // 3. Instance variable initialization
    private String instanceField = initializeInstanceField();

    // 4. Instance initialization block
    {
        System.out.println("  5. Instance initialization block executed");
    }

    // 5. Constructor
    public InitializationDemo(String value) {
        System.out.println("  6. Constructor executed with: " + value);
    }

    private static String initializeStaticField() {
        System.out.println("  1. Static field initialized");
        return "Static Value";
    }

    private String initializeInstanceField() {
        System.out.println("  4. Instance field initialized");
        return "Instance Value";
    }
}

// ═══════════════════════════════════════════════════════════
// ACCESS MODIFIERS
// ═══════════════════════════════════════════════════════════

class AccessModifierExample {
    public String publicField = "Public - accessible everywhere";
    protected String protectedField = "Protected - accessible in package & subclasses";
    String defaultField = "Default - accessible in package only";
    private String privateField = "Private - accessible only within class";

    public void publicMethod() {
        System.out.println("  Public method - accessible everywhere");
    }

    protected void protectedMethod() {
        System.out.println("  Protected method");
    }

    void defaultMethod() {
        System.out.println("  Default method - accessible in package");
    }

    private void privateMethod() {
        System.out.println("  Private method - only within class");
    }
}

// ═══════════════════════════════════════════════════════════
// IMMUTABLE CLASS
// ═══════════════════════════════════════════════════════════

/**
 * Immutable class - cannot be modified after creation
 * Rules for immutability:
 * 1. Class should be final
 * 2. All fields should be private and final
 * 3. No setters
 * 4. Provide only getters
 * 5. If fields are mutable objects, return defensive copies
 */
final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s, %d years old", name, age);
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class InterviewQuestions {

    static void printInterviewQuestions() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          INTERVIEW QUESTIONS - OOP BASICS              ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
                {
                        "1. What are the four pillars of OOP?",
                        "ANSWER:",
                        "  1. Encapsulation - Data hiding using access modifiers",
                        "  2. Inheritance - IS-A relationship, code reusability",
                        "  3. Polymorphism - Same interface, different implementations",
                        "  4. Abstraction - Hiding implementation details"
                },
                {
                        "2. What is encapsulation? Why is it important?",
                        "ANSWER: Bundling data and methods that operate on that data",
                        "  Benefits:",
                        "  - Data hiding (private fields)",
                        "  - Validation through setters",
                        "  - Flexibility to change implementation",
                        "  - Better maintainability",
                        "  - Controlled access via getters/setters"
                },
                {
                        "3. Difference between constructor and method?",
                        "ANSWER:",
                        "  Constructor:",
                        "  - Name same as class name",
                        "  - No return type (not even void)",
                        "  - Called automatically when object is created",
                        "  - Used to initialize object state",
                        "  Method:",
                        "  - Can have any name",
                        "  - Must have return type",
                        "  - Called explicitly",
                        "  - Used to perform operations"
                },
                {
                        "4. What is constructor chaining?",
                        "ANSWER: Calling one constructor from another using 'this()'",
                        "  - Must be first statement in constructor",
                        "  - Helps avoid code duplication",
                        "  - Can call overloaded constructor",
                        "  Example: this(name, 0) calls two-parameter constructor",
                        "  Note: Can't have circular constructor calls"
                },
                {
                        "5. What is the 'this' keyword? What are its uses?",
                        "ANSWER: Reference to current object instance",
                        "  Uses:",
                        "  1. Distinguish instance variable from parameter: this.name = name",
                        "  2. Call another constructor: this(param)",
                        "  3. Pass current object: method(this)",
                        "  4. Call instance method: this.method()",
                        "  5. Return current object: return this"
                },
                {
                        "6. Can we have multiple constructors? Why?",
                        "ANSWER: Yes - Constructor Overloading",
                        "  - Same class, different parameter lists",
                        "  - Provides flexibility in object creation",
                        "  - Example: Person(), Person(name), Person(name, age)",
                        "  - Resolved at compile time",
                        "  - Common pattern in Java (StringBuilder, ArrayList, etc.)"
                },
                {
                        "7. What happens if no constructor is defined?",
                        "ANSWER: Java provides default constructor",
                        "  - No-arg constructor",
                        "  - Initializes fields to default values",
                        "  - Only provided if NO constructor is explicitly defined",
                        "  - If you define any constructor, default is NOT provided",
                        "  - Calls super() implicitly"
                },
                {
                        "8. Explain access modifiers in Java",
                        "ANSWER:",
                        "  public - accessible everywhere",
                        "  protected - accessible in same package + subclasses",
                        "  default (no modifier) - accessible in same package only",
                        "  private - accessible only within the class",
                        "",
                        "  Visibility (Most to Least restrictive):",
                        "  private < default < protected < public"
                },
                {
                        "9. What is object initialization order?",
                        "ANSWER: Specific sequence when object is created:",
                        "  1. Static variables initialized",
                        "  2. Static blocks executed (once when class loaded)",
                        "  3. Instance variables initialized",
                        "  4. Instance initialization blocks executed",
                        "  5. Constructor executed",
                        "  Note: Static initialization happens only once"
                },
                {
                        "10. What is an immutable class? How to create one?",
                        "ANSWER: Object whose state cannot be changed after creation",
                        "  Rules:",
                        "  1. Declare class as final",
                        "  2. Make all fields private and final",
                        "  3. No setter methods",
                        "  4. Initialize in constructor only",
                        "  5. Return defensive copies of mutable fields",
                        "  Examples: String, Integer, LocalDate"
                },
                {
                        "11. Difference between instance and static variables?",
                        "ANSWER:",
                        "  Instance Variable:",
                        "  - Each object has its own copy",
                        "  - Stored in heap with object",
                        "  - Accessed via object reference",
                        "  - Created when object is created",
                        "  Static Variable:",
                        "  - One copy shared by all objects",
                        "  - Stored in Method Area (Metaspace)",
                        "  - Accessed via class name (or object)",
                        "  - Created when class is loaded"
                },
                {
                        "12. What happens in memory when object is created?",
                        "ANSWER: new Person() process:",
                        "  1. Memory allocated in Heap",
                        "  2. Object header added (mark word, class pointer)",
                        "  3. Instance variables initialized to default values",
                        "  4. Constructor code executed",
                        "  5. Reference address returned",
                        "  6. Reference stored in Stack",
                        "  Note: Actual object in Heap, reference in Stack"
                },
                {
                        "13. Can constructors be private? Why?",
                        "ANSWER: Yes - for specific design patterns",
                        "  Uses:",
                        "  1. Singleton pattern - prevent instantiation",
                        "  2. Factory pattern - control object creation",
                        "  3. Utility class - prevent instantiation",
                        "  Example:",
                        "    public class Singleton {",
                        "        private static Singleton instance;",
                        "        private Singleton() {} // Private constructor",
                        "        public static Singleton getInstance() { ... }",
                        "    }"
                },
                {
                        "14. What is a copy constructor? Does Java have it?",
                        "ANSWER: Constructor that creates object from another object",
                        "  - Java doesn't have built-in copy constructor like C++",
                        "  - We can implement it manually",
                        "  Example: public Person(Person other) { ... }",
                        "  - For deep copying, use clone() or serialization",
                        "  - Modern Java: Use copy factories or builders"
                },
                {
                        "15. Can we overload constructor and method both?",
                        "ANSWER: Yes, both can be overloaded",
                        "  Constructor Overloading:",
                        "  - Same class name, different parameters",
                        "  - Example: Person(), Person(String), Person(String, int)",
                        "  Method Overloading:",
                        "  - Same method name, different parameters",
                        "  - Example: calculate(int), calculate(double)",
                        "  Both resolved at compile time"
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
        System.out.println("✓ Encapsulation = Data hiding + Controlled access");
        System.out.println("✓ Constructor has NO return type and same name as class");
        System.out.println("✓ 'this' refers to current object instance");
        System.out.println("✓ Constructor chaining uses this() as first statement");
        System.out.println("✓ Static members belong to class, instance members to object");
        System.out.println("✓ Initialization order: static → instance → constructor");
        System.out.println("✓ Immutable class: final class, private final fields, no setters");
        System.out.println("✓ Object created in Heap, reference stored in Stack");
        System.out.println();
    }
}