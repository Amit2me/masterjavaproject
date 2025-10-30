package com.masterjava.core.oop;

/**
 * LESSON 9: INTERFACES
 * ====================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand interfaces and their purpose
 * 2. Master interface declaration and implementation
 * 3. Learn multiple inheritance with interfaces
 * 4. Understand default and static methods (Java 8+)
 * 5. Learn functional interfaces and lambdas
 * 6. Master interface vs abstract class
 * 7. Understand marker interfaces
 * 8. Learn real-world interface patterns
 * 
 * UNDER THE HOOD (JVM):
 * --------------------
 * INTERFACE BEHAVIOR:
 * - Interfaces define contract (what, not how)
 * - All methods implicitly public abstract (pre-Java 8)
 * - All fields implicitly public static final
 * - Cannot be instantiated
 * - Multiple interfaces can be implemented
 * 
 * MEMORY LAYOUT:
 * -------------
 * Interface metadata in Method Area
 * No object creation (only references)
 * Implementing class objects in Heap
 * 
 * METHOD DISPATCH:
 * - invoke interface bytecode instruction
 * - Similar to invoke virtual but for interfaces
 * - Slightly slower due to additional lookup
 * 
 * JAVA 8+ CHANGES:
 * - default methods: concrete methods in interface
 * - static methods: utility methods in interface
 * - Enables interface evolution without breaking implementations
 * 
 * @author Master Java Project
 * @version 1.0
 * @since 2024
 */
public class InterfacesDemo {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      LESSON 9: INTERFACES             ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: BASIC INTERFACE IMPLEMENTATION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. BASIC INTERFACE ━━━");
        
        // Cannot instantiate interface
        // Flyable flyable = new Flyable(); // Compile error!
        
        Flyable bird = new Sparrow();
        Flyable airplane = new Airplane();
        
        bird.fly();
        bird.land();
        
        System.out.println();
        
        airplane.fly();
        airplane.land();
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: MULTIPLE INTERFACE IMPLEMENTATION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. MULTIPLE INTERFACES ━━━");
        
        SmartPhone phone = new SmartPhone();
        
        // Phone implements multiple interfaces
        phone.call();           // Callable
        phone.browse();         // Browsable
        phone.takePhoto();      // Camera
        phone.displayInfo();    // Own method
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: INTERFACE INHERITANCE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. INTERFACE INHERITANCE ━━━");
        
        ElectricCar tesla = new ElectricCar();
        
        tesla.start();          // Startable (inherited)
        tesla.stop();           // Stoppable (inherited)
        tesla.charge();         // ElectricVehicle
        tesla.drive();          // Own method
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: DEFAULT METHODS (JAVA 8+)
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. DEFAULT METHODS ━━━");
        
        MusicPlayer mp3Player = new MP3Player();
        MusicPlayer streamingPlayer = new StreamingPlayer();
        
        mp3Player.play();
        mp3Player.pause();      // Default method
        mp3Player.stop();
        
        System.out.println();
        
        streamingPlayer.play();
        streamingPlayer.pause(); // Overridden default method
        streamingPlayer.stop();
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: STATIC METHODS IN INTERFACES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. STATIC METHODS ━━━");
        
        // Static methods called on interface
        System.out.println("Random: " + NumberGenerator.generateRandom(1, 100));
        System.out.println("Is even: " + NumberGenerator.isEven(42));
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: FUNCTIONAL INTERFACES & LAMBDAS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. FUNCTIONAL INTERFACES ━━━");
        
        // Traditional anonymous class
        Calculator1 addition = new Calculator1() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Addition (anonymous): " + addition.calculate(10, 5));
        
        // Lambda expression (Java 8+)
        Calculator1 subtraction = (a, b) -> a - b;
        System.out.println("Subtraction (lambda): " + subtraction.calculate(10, 5));
        
        Calculator1 multiplication = (a, b) -> a * b;
        System.out.println("Multiplication (lambda): " + multiplication.calculate(10, 5));
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: INTERFACE CONSTANTS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. INTERFACE CONSTANTS ━━━");
        
        System.out.println("Max speed: " + VehicleConstants.MAX_SPEED);
        System.out.println("Min speed: " + VehicleConstants.MIN_SPEED);
        System.out.println("Default fuel: " + VehicleConstants.DEFAULT_FUEL_TYPE);
        
        // Constants are public static final
        // VehicleConstants.MAX_SPEED = 200; // Compile error!
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: MARKER INTERFACES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. MARKER INTERFACES ━━━");
        
        Document doc1 = new ImportantDocument();
        Document doc2 = new RegularDocument();
        
        processDocument(doc1);
        processDocument(doc2);
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: REAL-WORLD EXAMPLE - PAYMENT GATEWAY
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. REAL-WORLD: PAYMENT GATEWAY ━━━");
        
        PaymentGateway creditCard = new CreditCardGateway();
        PaymentGateway paypal = new PayPalGateway();
        PaymentGateway crypto = new CryptoGateway();
        
        creditCard.authenticate();
        creditCard.processPayment(100.0);
        creditCard.generateReceipt();
        
        System.out.println();
        
        paypal.authenticate();
        paypal.processPayment(50.0);
        paypal.generateReceipt();
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 10: INTERFACE SEGREGATION PRINCIPLE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 10. INTERFACE SEGREGATION ━━━");
        
        LaserPrinter laser = new LaserPrinter();
        SimplePrinter simple = new SimplePrinter();
        
        laser.print();
        laser.scan();
        laser.fax();
        
        System.out.println();
        
        simple.print(); // Only print, no scan/fax
        
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        InterfaceInterviewQuestions.printInterviewQuestions();
    }
    
    // Helper method for marker interface demo
    private static void processDocument(Document doc) {
        if (doc instanceof Confidential) {
            System.out.println("  🔒 Processing confidential document with encryption");
        } else {
            System.out.println("  📄 Processing regular document");
        }
    }
}

// ═══════════════════════════════════════════════════════════
// BASIC INTERFACE
// ═══════════════════════════════════════════════════════════

interface Flyable {
    // Abstract methods (implicitly public abstract)
    void fly();
    void land();
}

class Sparrow implements Flyable {
    @Override
    public void fly() {
        System.out.println("  🐦 Sparrow flies by flapping wings");
    }
    
    @Override
    public void land() {
        System.out.println("  🐦 Sparrow lands on a tree branch");
    }
}

class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("  ✈️ Airplane flies with jet engines");
    }
    
    @Override
    public void land() {
        System.out.println("  ✈️ Airplane lands on runway");
    }
}

// ═══════════════════════════════════════════════════════════
// MULTIPLE INTERFACE IMPLEMENTATION
// ═══════════════════════════════════════════════════════════

interface Callable {
    void call();
}

interface Browsable {
    void browse();
}

interface Camera {
    void takePhoto();
}

class SmartPhone implements Callable, Browsable, Camera {
    @Override
    public void call() {
        System.out.println("  📞 Making phone call");
    }
    
    @Override
    public void browse() {
        System.out.println("  🌐 Browsing internet");
    }
    
    @Override
    public void takePhoto() {
        System.out.println("  📷 Taking photo");
    }
    
    public void displayInfo() {
        System.out.println("  📱 SmartPhone with multiple capabilities");
    }
}

// ═══════════════════════════════════════════════════════════
// INTERFACE INHERITANCE
// ═══════════════════════════════════════════════════════════

interface Startable {
    void start();
}

interface Stoppable {
    void stop();
}

// Interface can extend multiple interfaces
interface ElectricVehicle extends Startable, Stoppable {
    void charge();
}

class ElectricCar implements ElectricVehicle {
    @Override
    public void start() {
        System.out.println("  🔋 Electric car starting silently");
    }
    
    @Override
    public void stop() {
        System.out.println("  🔋 Electric car stopping");
    }
    
    @Override
    public void charge() {
        System.out.println("  ⚡ Charging battery");
    }
    
    public void drive() {
        System.out.println("  🚗 Driving electric car");
    }
}

// ═══════════════════════════════════════════════════════════
// DEFAULT METHODS (JAVA 8+)
// ═══════════════════════════════════════════════════════════

interface MusicPlayer {
    // Abstract methods
    void play();
    void stop();
    
    // Default method with implementation
    default void pause() {
        System.out.println("  ⏸️ Pausing (default implementation)");
    }
    
    // Can have multiple default methods
    default void showInfo() {
        System.out.println("  ℹ️ Music Player Interface");
    }
}

class MP3Player implements MusicPlayer {
    @Override
    public void play() {
        System.out.println("  ▶️ Playing MP3 file");
    }
    
    @Override
    public void stop() {
        System.out.println("  ⏹️ Stopping MP3");
    }
    
    // Using default pause method
}

class StreamingPlayer implements MusicPlayer {
    @Override
    public void play() {
        System.out.println("  ▶️ Streaming music online");
    }
    
    @Override
    public void stop() {
        System.out.println("  ⏹️ Stopping stream");
    }
    
    // Overriding default method
    @Override
    public void pause() {
        System.out.println("  ⏸️ Pausing stream (custom implementation)");
    }
}

// ═══════════════════════════════════════════════════════════
// STATIC METHODS IN INTERFACES
// ═══════════════════════════════════════════════════════════

interface NumberGenerator {
    
    // Static utility method
    static int generateRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
    // Another static method
    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

// ═══════════════════════════════════════════════════════════
// FUNCTIONAL INTERFACES
// ═══════════════════════════════════════════════════════════

@FunctionalInterface
interface Calculator1 {
    // Single abstract method (SAM)
    int calculate(int a, int b);
    
    // Can have default methods
    default void displayResult(int result) {
        System.out.println("  Result: " + result);
    }
    
    // Can have static methods
    static void info() {
        System.out.println("  Calculator11 functional interface");
    }
}

// ═══════════════════════════════════════════════════════════
// INTERFACE CONSTANTS
// ═══════════════════════════════════════════════════════════

interface VehicleConstants {
    // All fields are implicitly: public static final
    int MAX_SPEED = 200;
    int MIN_SPEED = 0;
    String DEFAULT_FUEL_TYPE = "Petrol";
    
    // Equivalent explicit declaration:
    // public static final int MAX_SPEED = 200;
}

// ═══════════════════════════════════════════════════════════
// MARKER INTERFACES
// ═══════════════════════════════════════════════════════════

// Marker interface - no methods, just marks a type
interface Confidential {
    // Empty interface
}

interface Document {
    // Some methods
}

class ImportantDocument implements Document, Confidential {
    // Marked as confidential
}

class RegularDocument implements Document {
    // Not confidential
}

// ═══════════════════════════════════════════════════════════
// REAL-WORLD EXAMPLE - PAYMENT GATEWAY
// ═══════════════════════════════════════════════════════════

interface PaymentGateway {
    void authenticate();
    void processPayment(double amount);
    
    // Default method
    default void generateReceipt() {
        System.out.println("  📄 Generating receipt (default)");
    }
    
    // Static utility method
    static boolean validateAmount(double amount) {
        return amount > 0;
    }
}

class CreditCardGateway implements PaymentGateway {
    @Override
    public void authenticate() {
        System.out.println("  🔐 Authenticating credit card");
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("  💳 Processing credit card payment: $" + amount);
    }
    
    @Override
    public void generateReceipt() {
        System.out.println("  📄 Generating detailed credit card receipt");
    }
}

class PayPalGateway implements PaymentGateway {
    @Override
    public void authenticate() {
        System.out.println("  🔐 Authenticating PayPal account");
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("  💰 Processing PayPal payment: $" + amount);
    }
}

class CryptoGateway implements PaymentGateway {
    @Override
    public void authenticate() {
        System.out.println("  🔐 Authenticating crypto wallet");
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("  ₿ Processing crypto payment: $" + amount);
    }
}

// ═══════════════════════════════════════════════════════════
// INTERFACE SEGREGATION PRINCIPLE
// ═══════════════════════════════════════════════════════════

// Bad: Fat interface (forces unnecessary methods)
// interface MultiFunctionDevice {
//     void print();
//     void scan();
//     void fax();
// }

// Good: Segregated interfaces
interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax();
}

// Multi-function printer implements all
class LaserPrinter implements Printable, Scannable, Faxable {
    @Override
    public void print() {
        System.out.println("  🖨️ Laser printer printing");
    }
    
    @Override
    public void scan() {
        System.out.println("  📷 Laser printer scanning");
    }
    
    @Override
    public void fax() {
        System.out.println("  📠 Laser printer faxing");
    }
}

// Simple printer only implements what it needs
class SimplePrinter implements Printable {
    @Override
    public void print() {
        System.out.println("  🖨️ Simple printer printing only");
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class InterfaceInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          INTERVIEW QUESTIONS - INTERFACES              ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. What is an interface?",
                "ANSWER: Blueprint/contract that defines what a class must do",
                "  Key points:",
                "  - 100% abstraction (pre-Java 8)",
                "  - All methods implicitly public abstract",
                "  - All fields implicitly public static final",
                "  - Cannot be instantiated",
                "  - Implemented using 'implements' keyword",
                "  - A class can implement multiple interfaces"
            },
            {
                "2. Difference between interface and abstract class?",
                "ANSWER:",
                "  Interface:",
                "  - 100% abstraction (all methods abstract pre-Java 8)",
                "  - Multiple inheritance (implement many)",
                "  - No constructors",
                "  - Only public static final fields",
                "  - Methods implicitly public",
                "  - Use: Contract, CAN-DO capability",
                "  Abstract Class:",
                "  - Partial abstraction (can have concrete methods)",
                "  - Single inheritance (extend one)",
                "  - Can have constructors",
                "  - Any type of fields",
                "  - Any access modifiers",
                "  - Use: IS-A relationship, shared implementation"
            },
            {
                "3. Can interface have constructors?",
                "ANSWER: No, interfaces cannot have constructors",
                "  Reason:",
                "  - Interfaces cannot be instantiated",
                "  - No state to initialize",
                "  - Fields are static (initialized at class loading)",
                "  - Constructors are for object creation"
            },
            {
                "4. Can interface extend another interface?",
                "ANSWER: Yes, interface can extend one or more interfaces",
                "  Example:",
                "    interface A { void methodA(); }",
                "    interface B { void methodB(); }",
                "    interface C extends A, B { void methodC(); }",
                "  Implementing class must implement all methods from A, B, C",
                "  Use case: Building complex contracts from simpler ones"
            },
            {
                "5. Can interface implement another interface?",
                "ANSWER: No, interfaces cannot implement",
                "  - Interfaces can only extend (not implement)",
                "  - 'implements' is for classes",
                "  - 'extends' is for interfaces",
                "  Correct: interface B extends A",
                "  Wrong: interface B implements A"
            },
            {
                "6. What are default methods in interfaces (Java 8)?",
                "ANSWER: Methods with implementation in interface",
                "  Syntax:",
                "    default void methodName() { // implementation }",
                "  Purpose:",
                "  - Add new methods without breaking existing implementations",
                "  - Provide default behavior",
                "  - Interface evolution",
                "  Example: Java 8 added forEach() to Iterable",
                "  Can be overridden by implementing class"
            },
            {
                "7. What are static methods in interfaces (Java 8)?",
                "ANSWER: Utility methods that belong to interface",
                "  Syntax:",
                "    static void methodName() { // implementation }",
                "  Characteristics:",
                "  - Called using interface name: InterfaceName.method()",
                "  - Cannot be overridden",
                "  - Not inherited by implementing class",
                "  - Useful for helper/utility methods",
                "  Example: Comparator.comparing()"
            },
            {
                "8. Can interface have instance variables?",
                "ANSWER: No, only constants (public static final)",
                "  All fields in interface are:",
                "  - public (accessible everywhere)",
                "  - static (belong to interface, not instance)",
                "  - final (cannot be changed)",
                "  Example:",
                "    interface Config {",
                "        int MAX_SIZE = 100; // public static final",
                "    }"
            },
            {
                "9. What is a functional interface?",
                "ANSWER: Interface with exactly one abstract method (SAM)",
                "  Characteristics:",
                "  - Single Abstract Method (SAM) interface",
                "  - Can have multiple default/static methods",
                "  - Used with lambda expressions",
                "  - @FunctionalInterface annotation (optional but recommended)",
                "  Examples: Runnable, Callable, Comparator, Predicate",
                "  Usage: (a, b) -> a + b"
            },
            {
                "10. Can class implement multiple interfaces with same method?",
                "ANSWER: Yes, if signatures match (return type and parameters)",
                "  Example:",
                "    interface A { void display(); }",
                "    interface B { void display(); }",
                "    class C implements A, B {",
                "        public void display() { } // Single implementation for both",
                "    }",
                "  Conflict: If return types differ, compile error",
                "  Diamond problem solved by single implementation"
            },
            {
                "11. What is marker interface? Give examples",
                "ANSWER: Interface with no methods, just marks a capability",
                "  Purpose: Tag/mark classes for special treatment",
                "  Examples in Java:",
                "  - Serializable: Object can be serialized",
                "  - Cloneable: Object can be cloned",
                "  - Remote: Object can be used remotely (RMI)",
                "  Usage: if (obj instanceof Serializable) { }",
                "  Modern alternative: Annotations (@Serializable)"
            },
            {
                "12. Can interface have private methods (Java 9)?",
                "ANSWER: Yes, since Java 9",
                "  Purpose:",
                "  - Code reuse within interface",
                "  - Helper methods for default methods",
                "  - Not accessible to implementing classes",
                "  Example:",
                "    interface MyInterface {",
                "        default void method1() { helper(); }",
                "        default void method2() { helper(); }",
                "        private void helper() { } // Shared logic",
                "    }"
            },
            {
                "13. Difference between abstract class and interface after Java 8?",
                "ANSWER: Still significant differences despite default methods",
                "  Interface (even with default methods):",
                "  - No state (no instance variables)",
                "  - No constructors",
                "  - Multiple inheritance",
                "  - All fields public static final",
                "  Abstract Class:",
                "  - Can have state (instance variables)",
                "  - Can have constructors",
                "  - Single inheritance",
                "  - Any field types and modifiers",
                "  Use interface for contracts, abstract class for shared state"
            },
            {
                "14. What is Interface Segregation Principle (ISP)?",
                "ANSWER: Clients shouldn't depend on interfaces they don't use",
                "  Bad:",
                "    interface Worker { work(); eat(); sleep(); }",
                "    class Robot implements Worker { } // Robot doesn't eat/sleep!",
                "  Good:",
                "    interface Workable { work(); }",
                "    interface Eatable { eat(); }",
                "    interface Sleepable { sleep(); }",
                "  Benefits:",
                "  - Smaller, focused interfaces",
                "  - Classes implement only what they need",
                "  - Better maintainability"
            },
            {
                "15. Can interface extend class?",
                "ANSWER: No, interface cannot extend class",
                "  - Interface can only extend interface(s)",
                "  - Class can only extend class",
                "  - Class can implement interface(s)",
                "  Valid: interface B extends A (A is interface)",
                "  Invalid: interface B extends C (C is class)"
            },
            {
                "16. What happens if interface and class have same default method?",
                "ANSWER: Class method wins (class takes precedence)",
                "  Rule hierarchy:",
                "  1. Class method (highest priority)",
                "  2. Interface default method",
                "  3. Parent interface default method",
                "  Example:",
                "    interface I { default void m() { } }",
                "    class C { void m() { } }",
                "    class D extends C implements I { }",
                "  D inherits m() from C, not from I"
            },
            {
                "17. Real-world examples of interfaces in Java?",
                "ANSWER:",
                "  1. List, Set, Map - Collection framework contracts",
                "  2. Runnable - Task to be executed by thread",
                "  3. Comparable - Natural ordering",
                "  4. Comparator - Custom comparison",
                "  5. Serializable - Object can be serialized",
                "  6. Cloneable - Object can be cloned",
                "  7. ActionListener - GUI event handling",
                "  8. Connection, Statement - JDBC database operations",
                "  9. Servlet - Web request handling"
            },
            {
                "18. Can we declare interface as final?",
                "ANSWER: No, compile error",
                "  - final means cannot be extended/inherited",
                "  - Interface purpose is to be implemented",
                "  - Contradictory requirements",
                "  - final interface makes no sense"
            },
            {
                "19. Difference between implements and extends?",
                "ANSWER:",
                "  implements:",
                "  - Used by class to implement interface(s)",
                "  - Can implement multiple interfaces",
                "  - Example: class C implements I1, I2",
                "  extends:",
                "  - Class extends class (single inheritance)",
                "  - Interface extends interface(s) (multiple)",
                "  - Example: class C extends B",
                "  - Example: interface I extends I1, I2"
            },
            {
                "20. What is the purpose of @FunctionalInterface annotation?",
                "ANSWER: Indicates interface is functional (single abstract method)",
                "  Benefits:",
                "  - Compile-time checking (ensures SAM)",
                "  - Clear intent to developers",
                "  - Prevents accidental addition of methods",
                "  - Not mandatory but highly recommended",
                "  Example:",
                "    @FunctionalInterface",
                "    interface Calculator11 {",
                "        int calculate(int a, int b);",
                "    }"
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
        System.out.println("✓ Interface = Contract defining what class must do");
        System.out.println("✓ Multiple inheritance possible with interfaces");
        System.out.println("✓ All fields are public static final (constants)");
        System.out.println("✓ Java 8+: default and static methods allowed");
        System.out.println("✓ Functional interface = Single abstract method");
        System.out.println("✓ Use for CAN-DO capabilities, not IS-A relationships");
        System.out.println("✓ Interface segregation: prefer small, focused interfaces");
        System.out.println("✓ Class method takes precedence over interface default method");
        System.out.println();
    }
}
