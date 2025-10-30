package com.masterjava.core.oop;

import static com.masterjava.core.oop.PolymorphismInterviewQuestions.printInterviewQuestions;

/**
 * LESSON 7: POLYMORPHISM
 * ======================
 *
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand polymorphism concept (many forms)
 * 2. Master compile-time polymorphism (method overloading)
 * 3. Master runtime polymorphism (method overriding)
 * 4. Learn dynamic method dispatch
 * 5. Understand virtual method table (vtable)
 * 6. Learn upcasting and downcasting
 * 7. Master instanceof and type checking
 * 8. Understand polymorphism with interfaces
 *
 * UNDER THE HOOD (JVM):
 * --------------------
 * RUNTIME POLYMORPHISM MECHANISM:
 *
 * Virtual Method Table (vtable):
 * - Each class has a method table in Method Area
 * - Object header contains pointer to class's vtable
 * - At runtime, JVM follows the pointer to find actual method
 *
 * Example:
 * Animal a = new Dog();
 * a.makeSound(); // Which makeSound()?
 *
 * 1. JVM looks at actual object type (Dog)
 * 2. Follows vtable pointer in object header
 * 3. Finds Dog's vtable
 * 4. Executes Dog's makeSound() - Dynamic Dispatch!
 *
 * BYTECODE:
 * - invokestatic: Static method calls (compile-time)
 * - invokevirtual: Instance method calls (runtime dispatch)
 * - invokespecial: Constructor, super, private methods
 * - invokeinterface: Interface method calls
 * - invokedynamic: Lambda expressions (Java 7+)
 *
 * @author Master Java Project
 * @version 1.0
 * @since 2024
 */
public class PolymorphismDemo {

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      LESSON 7: POLYMORPHISM           ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: COMPILE-TIME POLYMORPHISM (METHOD OVERLOADING)
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. COMPILE-TIME POLYMORPHISM ━━━");

        Calculator calc = new Calculator();

        System.out.println("add(5, 3): " + calc.add(5, 3));
        System.out.println("add(5.5, 3.2): " + calc.add(5.5, 3.2));
        System.out.println("add(1, 2, 3): " + calc.add(1, 2, 3));
        System.out.println("add(\"10\", \"20\"): " + calc.add("10", "20"));

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: RUNTIME POLYMORPHISM (METHOD OVERRIDING)
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. RUNTIME POLYMORPHISM ━━━");

        // Reference type: Shape, Object type: Circle
        Shape shape1 = new Circle(5.0);
        Shape shape2 = new Rectangle(4.0, 6.0);
        Shape shape3 = new Triangle(3.0, 7.0);

        // Dynamic method dispatch - calls actual object's method
        System.out.println("Circle area: " + shape1.calculateArea());
        System.out.println("Rectangle area: " + shape2.calculateArea());
        System.out.println("Triangle area: " + shape3.calculateArea());

        shape1.draw();
        shape2.draw();
        shape3.draw();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: POLYMORPHIC ARRAYS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. POLYMORPHIC ARRAYS ━━━");

        Shape[] shapes = {
                new Circle(3.0),
                new Rectangle(5.0, 2.0),
                new Triangle(4.0, 6.0),
                new Circle(7.0)
        };

        double totalArea = 0;
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println(shape.getClass().getSimpleName() + " area: " + area);
            totalArea += area;
        }
        System.out.println("Total area: " + totalArea);

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: DYNAMIC METHOD DISPATCH IN DETAIL
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. DYNAMIC METHOD DISPATCH ━━━");

        Vehicle vehicle1 = new Car("Tesla Model 3");
        Vehicle vehicle2 = new Bike("Harley Davidson");
        Vehicle vehicle3 = new Truck("Ford F-150");

        // All have same interface but different implementations
        vehicle1.start();
        vehicle1.accelerate();
        vehicle1.stop();

        System.out.println();

        vehicle2.start();
        vehicle2.accelerate();
        vehicle2.stop();

        System.out.println();

        vehicle3.start();
        vehicle3.accelerate();
        vehicle3.stop();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: UPCASTING AND DOWNCASTING
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. UPCASTING & DOWNCASTING ━━━");

        // Upcasting (implicit, safe)
        Vehicle myVehicle = new Car("BMW"); // Automatic upcasting
        myVehicle.start();
        // myVehicle.playMusic(); // Error! Can't access Car-specific methods

        // Downcasting (explicit, risky)
        if (myVehicle instanceof Car) {
            Car myCar = (Car) myVehicle; // Manual downcasting
            myCar.playMusic(); // Now can access Car-specific methods
        }

        // Unsafe downcasting example
        Vehicle anotherVehicle = new Bike("Yamaha");
        try {
            Car wrongCast = (Car) anotherVehicle; // ClassCastException!
        } catch (ClassCastException e) {
            System.out.println("  ⚠ Cannot cast Bike to Car: " + e.getMessage());
        }

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: INSTANCEOF OPERATOR
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. INSTANCEOF OPERATOR ━━━");

        Vehicle testVehicle = new Car("Audi");

        System.out.println("testVehicle instanceof Car: " + (testVehicle instanceof Car));
        System.out.println("testVehicle instanceof Vehicle: " + (testVehicle instanceof Vehicle));
        System.out.println("testVehicle instanceof Bike: " + (testVehicle instanceof Bike));
        System.out.println("testVehicle instanceof Object: " + (testVehicle instanceof Object));

        // Safe downcasting pattern
        if (testVehicle instanceof Car) {
            Car car = (Car) testVehicle;
            car.playMusic();
        }

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: POLYMORPHISM WITH INTERFACES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. INTERFACE POLYMORPHISM ━━━");

        Playable[] media = {
                new Song("Bohemian Rhapsody"),
                new Video("Inception"),
                new Podcast("Tech Talk")
        };

        for (Playable item : media) {
            item.play();
            item.pause();
            item.stop();
            System.out.println();
        }

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: METHOD HIDING (STATIC METHODS)
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. METHOD HIDING (STATIC) ━━━");

        Parent parent = new Parent();
        Parent childAsParent = new Child();
        Child child = new Child();

        // Static methods - no polymorphism (compile-time binding)
        parent.staticMethod();          // Parent's static
        childAsParent.staticMethod();   // Parent's static (reference type)
        child.staticMethod();           // Child's static

        // Instance methods - polymorphism works (runtime binding)
        parent.instanceMethod();        // Parent's instance
        childAsParent.instanceMethod(); // Child's instance (actual object)
        child.instanceMethod();         // Child's instance

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: COVARIANT RETURN TYPES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. COVARIANT RETURN TYPES ━━━");

        AnimalFactory factory = new DogFactory();
        Animal1 animal = factory.createAnimal();
        animal.makeSound();

        // With covariant return type
        DogFactory dogFactory = new DogFactory();
        Dog1 dog = dogFactory.createAnimal(); // Returns Dog, not Animal
        dog.makeSound();
        dog.bark();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 10: REAL-WORLD EXAMPLE - PAYMENT SYSTEM
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 10. REAL-WORLD: PAYMENT SYSTEM ━━━");

        PaymentProcessor processor = new PaymentProcessor();

        Payment[] payments = {
                new CreditCardPayment("1234-5678-9012-3456", 100.0),
                new PayPalPayment("user@example.com", 50.0),
                new CryptoPayment("1A2B3C4D5E", 75.0)
        };

        for (Payment payment : payments) {
            processor.processPayment(payment);
        }

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        printInterviewQuestions();
    }
}

// ═══════════════════════════════════════════════════════════
// COMPILE-TIME POLYMORPHISM (METHOD OVERLOADING)
// ═══════════════════════════════════════════════════════════

class Calculator {

    public int add(int a, int b) {
        System.out.println("  → int version called");
        return a + b;
    }

    public double add(double a, double b) {
        System.out.println("  → double version called");
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("  → three parameter version called");
        return a + b + c;
    }

    public int add(String a, String b) {
        System.out.println("  → String version called");
        return Integer.parseInt(a) + Integer.parseInt(b);
    }
}

// ═══════════════════════════════════════════════════════════
// RUNTIME POLYMORPHISM (METHOD OVERRIDING)
// ═══════════════════════════════════════════════════════════

abstract class Shape {
    protected String color;

    public abstract double calculateArea();

    public void draw() {
        System.out.println("  Drawing " + this.getClass().getSimpleName());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("  🔵 Drawing a Circle with radius " + radius);
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void draw() {
        System.out.println("  🟦 Drawing a Rectangle " + length + "x" + width);
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("  🔺 Drawing a Triangle with base " + base);
    }
}

// ═══════════════════════════════════════════════════════════
// DYNAMIC METHOD DISPATCH
// ═══════════════════════════════════════════════════════════

class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println("  " + name + " is starting...");
    }

    public void accelerate() {
        System.out.println("  " + name + " is accelerating...");
    }

    public void stop() {
        System.out.println("  " + name + " is stopping...");
    }
}

class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("  🚗 " + name + " engine started with key");
    }

    @Override
    public void accelerate() {
        System.out.println("  🚗 " + name + " accelerating smoothly");
    }

    public void playMusic() {
        System.out.println("  🎵 Playing music in " + name);
    }
}

class Bike extends Vehicle {
    public Bike(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("  🏍️ " + name + " started with kick");
    }

    @Override
    public void accelerate() {
        System.out.println("  🏍️ " + name + " accelerating with twist throttle");
    }
}

class Truck extends Vehicle {
    public Truck(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("  🚚 " + name + " diesel engine roaring");
    }

    @Override
    public void accelerate() {
        System.out.println("  🚚 " + name + " slowly gaining speed");
    }
}

// ═══════════════════════════════════════════════════════════
// INTERFACE POLYMORPHISM
// ═══════════════════════════════════════════════════════════

interface Playable {
    void play();
    void pause();
    void stop();
}

class Song implements Playable {
    private String title;

    public Song(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("  🎵 Playing song: " + title);
    }

    @Override
    public void pause() {
        System.out.println("  ⏸️ Song paused");
    }

    @Override
    public void stop() {
        System.out.println("  ⏹️ Song stopped");
    }
}

class Video implements Playable {
    private String title;

    public Video(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("  🎬 Playing video: " + title);
    }

    @Override
    public void pause() {
        System.out.println("  ⏸️ Video paused");
    }

    @Override
    public void stop() {
        System.out.println("  ⏹️ Video stopped");
    }
}

class Podcast implements Playable {
    private String title;

    public Podcast(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("  🎙️ Playing podcast: " + title);
    }

    @Override
    public void pause() {
        System.out.println("  ⏸️ Podcast paused");
    }

    @Override
    public void stop() {
        System.out.println("  ⏹️ Podcast stopped");
    }
}

// ═══════════════════════════════════════════════════════════
// METHOD HIDING (STATIC METHODS)
// ═══════════════════════════════════════════════════════════

class Parent {
    public static void staticMethod() {
        System.out.println("  Parent's static method");
    }

    public void instanceMethod() {
        System.out.println("  Parent's instance method");
    }
}

class Child extends Parent {
    // This HIDES parent's static method (not overriding)
    public static void staticMethod() {
        System.out.println("  Child's static method");
    }

    // This OVERRIDES parent's instance method
    @Override
    public void instanceMethod() {
        System.out.println("  Child's instance method");
    }
}

// ═══════════════════════════════════════════════════════════
// COVARIANT RETURN TYPES
// ═══════════════════════════════════════════════════════════

 class Animal1 {
    public void makeSound() {
        System.out.println("  Animal sound");
    }
}

class Dog1 extends Animal1 {
    @Override
    public void makeSound() {
        System.out.println("  Woof!");
    }

    public void bark() {
        System.out.println("  Bark! Bark!");
    }
}

class AnimalFactory {
    public Animal1 createAnimal() {
        return new Animal1();
    }
}

class DogFactory extends AnimalFactory {
    // Covariant return type - returns Dog instead of Animal
    @Override
    public Dog1 createAnimal() {
        return new Dog1();
    }
}

// ═══════════════════════════════════════════════════════════
// REAL-WORLD EXAMPLE - PAYMENT SYSTEM
// ═══════════════════════════════════════════════════════════

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void processPayment();
    public abstract String getPaymentMethod();
}

class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber, double amount) {
        super(amount);
        this.cardNumber = maskCardNumber(cardNumber);
    }

    @Override
    public void processPayment() {
        System.out.println("  💳 Processing Credit Card payment");
        System.out.println("     Card: " + cardNumber);
        System.out.println("     Amount: $" + amount);
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    private String maskCardNumber(String cardNumber) {
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}

class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(String email, double amount) {
        super(amount);
        this.email = email;
    }

    @Override
    public void processPayment() {
        System.out.println("  💰 Processing PayPal payment");
        System.out.println("     Email: " + email);
        System.out.println("     Amount: $" + amount);
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}

class CryptoPayment extends Payment {
    private String walletAddress;

    public CryptoPayment(String walletAddress, double amount) {
        super(amount);
        this.walletAddress = walletAddress;
    }

    @Override
    public void processPayment() {
        System.out.println("  ₿ Processing Crypto payment");
        System.out.println("     Wallet: " + walletAddress);
        System.out.println("     Amount: $" + amount);
    }

    @Override
    public String getPaymentMethod() {
        return "Cryptocurrency";
    }
}

class PaymentProcessor {
    public void processPayment(Payment payment) {
        System.out.println("\n  Processing " + payment.getPaymentMethod() + " payment:");
        payment.processPayment();
        System.out.println("  ✓ Payment successful!\n");
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class PolymorphismInterviewQuestions {

    static void printInterviewQuestions() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          INTERVIEW QUESTIONS - POLYMORPHISM            ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
                {
                        "1. What is polymorphism? What are its types?",
                        "ANSWER: Ability of object to take many forms",
                        "  Types:",
                        "  1. Compile-time (Static) - Method Overloading",
                        "     - Resolved at compile time",
                        "     - Same method name, different parameters",
                        "  2. Runtime (Dynamic) - Method Overriding",
                        "     - Resolved at runtime",
                        "     - Same signature in parent and child"
                },
                {
                        "2. What is dynamic method dispatch?",
                        "ANSWER: Runtime resolution of overridden method call",
                        "  Process:",
                        "  1. Reference type checked at compile time",
                        "  2. Actual object type determined at runtime",
                        "  3. JVM uses vtable (Virtual Method Table)",
                        "  4. Calls method of actual object, not reference",
                        "  Example: Animal a = new Dog(); a.sound(); // Dog's sound"
                },
                {
                        "3. Difference between overloading and overriding?",
                        "ANSWER:",
                        "  Overloading:",
                        "  - Same class, same name, different parameters",
                        "  - Compile-time (static binding)",
                        "  - Return type can be different",
                        "  - private, static, final methods can be overloaded",
                        "  Overriding:",
                        "  - Parent-child classes, same signature",
                        "  - Runtime (dynamic binding)",
                        "  - Return type must be same/covariant",
                        "  - Cannot override private, static, final"
                },
                {
                        "4. Can we achieve runtime polymorphism with static methods?",
                        "ANSWER: No, static methods cannot be overridden",
                        "  - Static methods are bound at compile time",
                        "  - Belong to class, not instance",
                        "  - Called 'method hiding', not overriding",
                        "  - No polymorphic behavior",
                        "  Reason: vtable only contains instance methods"
                },
                {
                        "5. What is the Virtual Method Table (vtable)?",
                        "ANSWER: Data structure for dynamic method dispatch",
                        "  - Created for each class at class loading",
                        "  - Stored in Method Area",
                        "  - Contains pointers to instance methods",
                        "  - Object header contains vtable pointer",
                        "  - Used to find actual method implementation at runtime",
                        "  Note: Final and private methods not in vtable"
                },
                {
                        "6. Can constructors be overloaded? Overridden?",
                        "ANSWER:",
                        "  Overloading: YES",
                        "  - Same class can have multiple constructors",
                        "  - Different parameter lists",
                        "  - Example: Person(), Person(String), Person(String, int)",
                        "  Overriding: NO",
                        "  - Constructors are not inherited",
                        "  - Child must call parent constructor using super()"
                },
                {
                        "7. What is upcasting? Is it safe?",
                        "ANSWER: Converting child reference to parent reference",
                        "  - Implicit conversion (automatic)",
                        "  - Always safe, no ClassCastException",
                        "  - Lose access to child-specific methods",
                        "  Example: Animal a = new Dog(); // Upcasting",
                        "  Use case: Achieve polymorphism, work with generics"
                },
                {
                        "8. What is downcasting? When is it needed?",
                        "ANSWER: Converting parent reference to child reference",
                        "  - Explicit cast required",
                        "  - Can throw ClassCastException",
                        "  - Use instanceof to check before casting",
                        "  Example:",
                        "    Animal a = new Dog();",
                        "    if (a instanceof Dog) {",
                        "        Dog d = (Dog) a; // Safe downcasting",
                        "    }",
                        "  Needed: To access child-specific methods"
                },
                {
                        "9. What is the purpose of instanceof operator?",
                        "ANSWER: Check if object is instance of specific class/interface",
                        "  - Returns boolean (true/false)",
                        "  - Used before downcasting to prevent exceptions",
                        "  - Checks entire inheritance hierarchy",
                        "  Example:",
                        "    if (animal instanceof Dog) {",
                        "        Dog dog = (Dog) animal;",
                        "    }",
                        "  Note: Returns false if object is null"
                },
                {
                        "10. What is covariant return type?",
                        "ANSWER: Overriding method can return subtype of parent's return",
                        "  Parent: Animal getAnimal()",
                        "  Child: Dog getAnimal() // Valid! (Java 5+)",
                        "  Benefits:",
                        "  - More specific return type",
                        "  - No need to cast result",
                        "  - Better type safety",
                        "  Example: clone() method"
                },
                {
                        "11. Can we override private methods?",
                        "ANSWER: No, private methods cannot be overridden",
                        "  - Private methods not inherited",
                        "  - Not visible to child class",
                        "  - Can define method with same name in child (not override)",
                        "  - Not part of vtable",
                        "  - No polymorphic behavior"
                },
                {
                        "12. Can we override final methods?",
                        "ANSWER: No, final methods cannot be overridden",
                        "  - Declared with 'final' keyword",
                        "  - Prevents modification in subclasses",
                        "  - Direct method invocation (no vtable lookup)",
                        "  - Slightly better performance",
                        "  Use case: Security, critical methods, immutability"
                },
                {
                        "13. What happens if child and parent have same variable?",
                        "ANSWER: Variable hiding (not overriding)",
                        "  - Variables are bound at compile time",
                        "  - Reference type determines which variable accessed",
                        "  - No polymorphism for variables!",
                        "  Example:",
                        "    Parent p = new Child();",
                        "    p.x // Parent's x, not Child's x",
                        "  Reason: Variables not in vtable"
                },
                {
                        "14. Can we have polymorphism without inheritance?",
                        "ANSWER: Yes, through interfaces",
                        "  - Multiple classes implement same interface",
                        "  - Different implementations of interface methods",
                        "  - Achieve polymorphism without IS-A relationship",
                        "  Example:",
                        "    Playable p = new Song(); // or new Video()",
                        "    p.play(); // Polymorphic behavior"
                },
                {
                        "15. What is the difference between early and late binding?",
                        "ANSWER:",
                        "  Early Binding (Static/Compile-time):",
                        "  - Method resolved at compile time",
                        "  - Static, private, final methods",
                        "  - Faster execution",
                        "  - Example: method overloading",
                        "  Late Binding (Dynamic/Runtime):",
                        "  - Method resolved at runtime",
                        "  - Instance methods (virtual methods)",
                        "  - Slight overhead for vtable lookup",
                        "  - Example: method overriding"
                },
                {
                        "16. Why is runtime polymorphism slower than compile-time?",
                        "ANSWER: Additional vtable lookup overhead",
                        "  Runtime:",
                        "  1. Check actual object type",
                        "  2. Follow vtable pointer",
                        "  3. Find method in vtable",
                        "  4. Execute method",
                        "  Compile-time:",
                        "  - Method address known at compile time",
                        "  - Direct invocation",
                        "  Note: Difference is minimal, modern JVMs optimize this"
                },
                {
                        "17. Can we achieve polymorphism with constructor?",
                        "ANSWER: No, constructors don't participate in polymorphism",
                        "  - Constructors not inherited",
                        "  - Cannot be overridden",
                        "  - Always bound statically",
                        "  - Used with 'new' keyword at compile time",
                        "  Alternative: Factory pattern for polymorphic object creation"
                },
                {
                        "18. What is method signature? Why is it important?",
                        "ANSWER: Method name + parameter types (order matters)",
                        "  Components:",
                        "  - Method name",
                        "  - Parameter types",
                        "  - Parameter order",
                        "  NOT included: return type, access modifier, exceptions",
                        "  Importance:",
                        "  - Determines method uniqueness",
                        "  - Used in overloading",
                        "  - Must match exactly in overriding"
                },
                {
                        "19. Explain the Liskov Substitution Principle",
                        "ANSWER: Child objects should be substitutable for parent objects",
                        "  - Child must fulfill parent's contract",
                        "  - Cannot weaken preconditions",
                        "  - Cannot strengthen postconditions",
                        "  - Cannot throw new checked exceptions",
                        "  Example:",
                        "    void doSomething(Animal a) { a.eat(); }",
                        "    // Should work with any Animal subtype"
                },
                {
                        "20. Real-world benefits of polymorphism?",
                        "ANSWER:",
                        "  1. Code reusability - Write once, use with many types",
                        "  2. Flexibility - Easy to add new types",
                        "  3. Maintainability - Changes localized",
                        "  4. Extensibility - Add features without modifying existing code",
                        "  5. Loose coupling - Depend on abstractions, not implementations",
                        "  Example: Payment processing with multiple payment types"
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
        System.out.println("✓ Polymorphism = One interface, multiple implementations");
        System.out.println("✓ Compile-time = Overloading, Runtime = Overriding");
        System.out.println("✓ Dynamic dispatch uses vtable for method resolution");
        System.out.println("✓ Upcasting is safe and implicit");
        System.out.println("✓ Downcasting needs instanceof check");
        System.out.println("✓ Static methods cannot be overridden (method hiding)");
        System.out.println("✓ Variables don't participate in polymorphism");
        System.out.println("✓ Interfaces enable polymorphism without inheritance");
        System.out.println("✓ Covariant return types allowed since Java 5");
        System.out.println();
    }
}