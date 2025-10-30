package com.masterjava.advanced.patterns;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * LESSON 17: DESIGN PATTERNS
 * ===========================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand Gang of Four (GoF) patterns
 * 2. Master Creational patterns (how objects are created)
 * 3. Master Structural patterns (how objects are composed)
 * 4. Master Behavioral patterns (how objects interact)
 * 5. Learn when and why to use each pattern
 * 6. Understand pattern trade-offs
 * 7. Master real-world implementations
 * 8. Recognize anti-patterns
 * 
 * DESIGN PATTERNS CATEGORIES:
 * ==========================
 * 
 * CREATIONAL (5):
 * - Singleton: Ensure only one instance
 * - Factory Method: Create objects without specifying class
 * - Abstract Factory: Family of related objects
 * - Builder: Construct complex objects step by step
 * - Prototype: Clone objects
 * 
 * STRUCTURAL (7):
 * - Adapter: Convert interface to another
 * - Decorator: Add behavior dynamically
 * - Proxy: Control access to object
 * - Facade: Simplified interface
 * - Composite: Tree structures
 * - Bridge: Separate abstraction from implementation
 * - Flyweight: Share objects to save memory
 * 
 * BEHAVIORAL (11):
 * - Strategy: Encapsulate algorithms
 * - Observer: Subscribe to events
 * - Command: Encapsulate requests
 * - Template Method: Define algorithm skeleton
 * - Iterator: Access elements sequentially
 * - State: Change behavior based on state
 * - Chain of Responsibility: Pass requests along chain
 * - Mediator: Centralize communication
 * - Memento: Save/restore object state
 * - Visitor: Add operations to objects
 * - Interpreter: Grammar representation
 * 
 * @author Master Java Project
 * @version 2.0
 * @since 2024
 */
public class DesignPatternsDemo {

    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║        LESSON 17: DESIGN PATTERNS                      ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // CREATIONAL PATTERNS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  CREATIONAL PATTERNS (Object Creation)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // Pattern 1: Singleton
        System.out.println("━━━ 1. SINGLETON PATTERN ━━━");
        demonstrateSingleton();
        System.out.println();

        // Pattern 2: Factory Method
        System.out.println("━━━ 2. FACTORY METHOD PATTERN ━━━");
        demonstrateFactoryMethod();
        System.out.println();

        // Pattern 3: Abstract Factory
        System.out.println("━━━ 3. ABSTRACT FACTORY PATTERN ━━━");
        demonstrateAbstractFactory();
        System.out.println();

        // Pattern 4: Builder
        System.out.println("━━━ 4. BUILDER PATTERN ━━━");
        demonstrateBuilder();
        System.out.println();

        // Pattern 5: Prototype
        System.out.println("━━━ 5. PROTOTYPE PATTERN ━━━");
        demonstratePrototype();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // STRUCTURAL PATTERNS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  STRUCTURAL PATTERNS (Object Composition)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // Pattern 6: Adapter
        System.out.println("━━━ 6. ADAPTER PATTERN ━━━");
        demonstrateAdapter();
        System.out.println();

        // Pattern 7: Decorator
        System.out.println("━━━ 7. DECORATOR PATTERN ━━━");
        demonstrateDecorator();
        System.out.println();

        // Pattern 8: Proxy
        System.out.println("━━━ 8. PROXY PATTERN ━━━");
        demonstrateProxy();
        System.out.println();

        // Pattern 9: Facade
        System.out.println("━━━ 9. FACADE PATTERN ━━━");
        demonstrateFacade();
        System.out.println();

        // Pattern 10: Composite
        System.out.println("━━━ 10. COMPOSITE PATTERN ━━━");
        demonstrateComposite();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // BEHAVIORAL PATTERNS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  BEHAVIORAL PATTERNS (Object Interaction)");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // Pattern 11: Strategy
        System.out.println("━━━ 11. STRATEGY PATTERN ━━━");
        demonstrateStrategy();
        System.out.println();

        // Pattern 12: Observer
        System.out.println("━━━ 12. OBSERVER PATTERN ━━━");
        demonstrateObserver();
        System.out.println();

        // Pattern 13: Command
        System.out.println("━━━ 13. COMMAND PATTERN ━━━");
        demonstrateCommand();
        System.out.println();

        // Pattern 14: Template Method
        System.out.println("━━━ 14. TEMPLATE METHOD PATTERN ━━━");
        demonstrateTemplateMethod();
        System.out.println();

        // Pattern 15: State
        System.out.println("━━━ 15. STATE PATTERN ━━━");
        demonstrateState();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        DesignPatternsInterviewQuestions.printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // CREATIONAL PATTERNS DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateSingleton() {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        System.out.println("  Instance 1: " + db1);
        System.out.println("  Instance 2: " + db2);
        System.out.println("  Same instance? " + (db1 == db2));
        
        db1.connect();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Database connections");
        System.out.println("  - Configuration managers");
        System.out.println("  - Logger");
        System.out.println("  - Thread pools");
        
        System.out.println("\n  ⚠️  Considerations:");
        System.out.println("  - Thread safety (use enum or double-check locking)");
        System.out.println("  - Reflection can break singleton");
        System.out.println("  - Testing difficulties");
    }

    private static void demonstrateFactoryMethod() {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory bikeFactory = new BikeFactory();
        
        Vehicle car = carFactory.createVehicle();
        Vehicle bike = bikeFactory.createVehicle();
        
        System.out.println("  Created: " + car.getType());
        car.drive();
        
        System.out.println("  Created: " + bike.getType());
        bike.drive();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Framework code (let subclass decide)");
        System.out.println("  - Plugin systems");
        System.out.println("  - Database drivers");
        System.out.println("  - Document types (PDF, Excel, Word)");
    }

    private static void demonstrateAbstractFactory() {
        UIFactory windowsFactory = new WindowsUIFactory();
        UIFactory macFactory = new MacUIFactory();
        
        Button winButton = windowsFactory.createButton();
        Checkbox winCheckbox = windowsFactory.createCheckbox();
        
        System.out.println("  Windows UI:");
        winButton.render();
        winCheckbox.render();
        
        Button macButton = macFactory.createButton();
        Checkbox macCheckbox = macFactory.createCheckbox();
        
        System.out.println("\n  Mac UI:");
        macButton.render();
        macCheckbox.render();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Cross-platform UI frameworks");
        System.out.println("  - Database abstraction layers");
        System.out.println("  - Theme systems");
    }

    private static void demonstrateBuilder() {
        Computer computer = new Computer.ComputerBuilder()
            .setCPU("Intel i9")
            .setRAM(32)
            .setStorage(1000)
            .setGPU("RTX 4090")
            .setWifi(true)
            .build();
        
        System.out.println("  Built computer: " + computer);
        
        Computer basicComputer = new Computer.ComputerBuilder()
            .setCPU("Intel i5")
            .setRAM(8)
            .setStorage(256)
            .build();
        
        System.out.println("  Basic computer: " + basicComputer);
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Complex object construction");
        System.out.println("  - Many optional parameters");
        System.out.println("  - Immutable objects");
        System.out.println("  - StringBuilder, StringBuffer");
    }

    private static void demonstratePrototype() {
        ShapePrototype circle = new Circle(5);
        ShapePrototype clonedCircle = circle.clone();
        
        System.out.println("  Original: " + circle.draw());
        System.out.println("  Cloned: " + clonedCircle.draw());
        System.out.println("  Same object? " + (circle == clonedCircle));
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Object creation is expensive");
        System.out.println("  - Similar objects with minor differences");
        System.out.println("  - Undo/Redo functionality");
        System.out.println("  - Object pools");
    }

    // ═══════════════════════════════════════════════════════════
    // STRUCTURAL PATTERNS DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateAdapter() {
        // Old interface
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        
        // Adapt to new interface
        ModernPrinter adapter = new PrinterAdapter(legacyPrinter);
        adapter.print("Hello from Adapter!");
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Legacy system integration");
        System.out.println("  - Third-party library adaptation");
        System.out.println("  - API compatibility");
        System.out.println("  - Collections.enumeration()");
    }

    private static void demonstrateDecorator() {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("  " + simpleCoffee.getDescription() + 
                         " -> $" + simpleCoffee.getCost());
        
        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println("  " + milkCoffee.getDescription() + 
                         " -> $" + milkCoffee.getCost());
        
        Coffee fancyCoffee = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println("  " + fancyCoffee.getDescription() + 
                         " -> $" + fancyCoffee.getCost());
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Add behavior dynamically");
        System.out.println("  - Java I/O streams");
        System.out.println("  - GUI components");
        System.out.println("  - Collections.synchronizedList()");
    }

    private static void demonstrateProxy() {
        Image image = new ProxyImage("photo.jpg");
        
        System.out.println("  First call (loads image):");
        image.display();
        
        System.out.println("\n  Second call (cached):");
        image.display();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Lazy loading");
        System.out.println("  - Access control");
        System.out.println("  - Logging/auditing");
        System.out.println("  - Remote proxy (RMI)");
    }

    private static void demonstrateFacade() {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        
        System.out.println("  Starting movie:");
        homeTheater.watchMovie("Inception");
        
        System.out.println("\n  Ending movie:");
        homeTheater.endMovie();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Simplify complex subsystems");
        System.out.println("  - Provide unified interface");
        System.out.println("  - JDBC DriverManager");
        System.out.println("  - SLF4J logging");
    }

    private static void demonstrateComposite() {
        FileSystemComponent file1 = new FileLeaf("file1.txt", 100);
        FileSystemComponent file2 = new FileLeaf("file2.txt", 200);
        FileSystemComponent file3 = new FileLeaf("file3.txt", 150);
        
        FolderComposite root = new FolderComposite("root");
        FolderComposite subFolder = new FolderComposite("documents");
        
        subFolder.add(file1);
        subFolder.add(file2);
        root.add(subFolder);
        root.add(file3);
        
        System.out.println("  Total size: " + root.getSize() + " bytes");
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Tree structures");
        System.out.println("  - File systems");
        System.out.println("  - GUI components");
        System.out.println("  - Organization hierarchies");
    }

    // ═══════════════════════════════════════════════════════════
    // BEHAVIORAL PATTERNS DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateStrategy() {
        ShoppingCart cart = new ShoppingCart();
        cart.setAmount(100);
        
        System.out.println("  Pay with Credit Card:");
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout();
        
        System.out.println("\n  Pay with PayPal:");
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Multiple algorithms");
        System.out.println("  - Payment methods");
        System.out.println("  - Sorting strategies");
        System.out.println("  - Compression algorithms");
    }

    private static void demonstrateObserver() {
        NewsAgency agency = new NewsAgency();
        
        Subscriber subscriber1 = new EmailSubscriber("alice@email.com");
        Subscriber subscriber2 = new EmailSubscriber("bob@email.com");
        
        agency.subscribe(subscriber1);
        agency.subscribe(subscriber2);
        
        System.out.println("  Publishing news:");
        agency.publishNews("Design Patterns are awesome!");
        
        System.out.println("\n  Unsubscribe alice:");
        agency.unsubscribe(subscriber1);
        
        System.out.println("\n  Publishing again:");
        agency.publishNews("Observer pattern in action!");
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Event handling systems");
        System.out.println("  - MVC architecture");
        System.out.println("  - Pub-sub messaging");
        System.out.println("  - Java PropertyChangeListener");
    }

    private static void demonstrateCommand() {
        Light light = new Light();
        
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        
        RemoteControl remote = new RemoteControl();
        
        System.out.println("  Turn light ON:");
        remote.setCommand(lightOn);
        remote.pressButton();
        
        System.out.println("\n  Turn light OFF:");
        remote.setCommand(lightOff);
        remote.pressButton();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Undo/Redo operations");
        System.out.println("  - Transaction systems");
        System.out.println("  - Task scheduling");
        System.out.println("  - GUI buttons");
    }

    private static void demonstrateTemplateMethod() {
        DataProcessor csvProcessor = new CSVDataProcessor();
        DataProcessor jsonProcessor = new JSONDataProcessor();
        
        System.out.println("  CSV Processing:");
        csvProcessor.process();
        
        System.out.println("\n  JSON Processing:");
        jsonProcessor.process();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - Algorithm skeleton");
        System.out.println("  - Framework design");
        System.out.println("  - Java Collections sort()");
        System.out.println("  - Servlet lifecycle");
    }

    private static void demonstrateState() {
        VendingMachine machine = new VendingMachine();
        
        System.out.println("  Insert coin:");
        machine.insertCoin();
        
        System.out.println("\n  Select product:");
        machine.selectProduct();
        
        System.out.println("\n  Dispense:");
        machine.dispense();
        
        System.out.println("\n  Try to dispense again:");
        machine.dispense();
        
        System.out.println("\n  💡 Use Cases:");
        System.out.println("  - State machines");
        System.out.println("  - Workflow systems");
        System.out.println("  - Game character states");
        System.out.println("  - Connection states");
    }
}

// ═══════════════════════════════════════════════════════════
// CREATIONAL PATTERNS IMPLEMENTATIONS
// ═══════════════════════════════════════════════════════════

// 1. SINGLETON PATTERN
class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    
    private DatabaseConnection() {
        // Private constructor
    }
    
    // Thread-safe lazy initialization
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    public void connect() {
        System.out.println("  ✓ Connected to database");
    }
}

// Alternative: Enum Singleton (best practice)
enum DatabaseConnectionEnum {
    INSTANCE;
    
    public void connect() {
        System.out.println("  ✓ Connected via enum singleton");
    }
}

// 2. FACTORY METHOD PATTERN
interface Vehicle {
    String getType();
    void drive();
}

class Car implements Vehicle {
    @Override
    public String getType() { return "Car"; }
    
    @Override
    public void drive() {
        System.out.println("  🚗 Driving car on road");
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() { return "Bike"; }
    
    @Override
    public void drive() {
        System.out.println("  🚲 Riding bike");
    }
}

abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}

// 3. ABSTRACT FACTORY PATTERN
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("  🖥️  Rendering Windows button");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("  🍎 Rendering Mac button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("  🖥️  Rendering Windows checkbox");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("  🍎 Rendering Mac checkbox");
    }
}

interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// 4. BUILDER PATTERN
class Computer {
    private String CPU;
    private int RAM;
    private int storage;
    private String GPU;
    private boolean wifi;
    
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.wifi = builder.wifi;
    }
    
    public static class ComputerBuilder {
        private String CPU;
        private int RAM;
        private int storage;
        private String GPU;
        private boolean wifi;
        
        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        
        public ComputerBuilder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }
        
        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }
        
        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }
        
        public ComputerBuilder setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
    
    @Override
    public String toString() {
        return "Computer{CPU='" + CPU + "', RAM=" + RAM + "GB, Storage=" + 
               storage + "GB, GPU='" + GPU + "', WiFi=" + wifi + "}";
    }
}

// 5. PROTOTYPE PATTERN
interface ShapePrototype extends Cloneable {
    ShapePrototype clone();
    String draw();
}

class Circle implements ShapePrototype {
    private int radius;
    
    public Circle(int radius) {
        this.radius = radius;
    }
    
    @Override
    public ShapePrototype clone() {
        return new Circle(this.radius);
    }
    
    @Override
    public String draw() {
        return "Circle with radius " + radius;
    }
}

// ═══════════════════════════════════════════════════════════
// STRUCTURAL PATTERNS IMPLEMENTATIONS
// ═══════════════════════════════════════════════════════════

// 6. ADAPTER PATTERN
class LegacyPrinter {
    public void oldPrint(String text) {
        System.out.println("  [Legacy] Printing: " + text);
    }
}

interface ModernPrinter {
    void print(String text);
}

class PrinterAdapter implements ModernPrinter {
    private LegacyPrinter legacyPrinter;
    
    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }
    
    @Override
    public void print(String text) {
        legacyPrinter.oldPrint(text);
    }
}

// 7. DECORATOR PATTERN
interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    
    @Override
    public double getCost() {
        return 2.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Sugar";
    }
    
    @Override
    public double getCost() {
        return coffee.getCost() + 0.3;
    }
}

// 8. PROXY PATTERN
interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;
    
    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }
    
    private void loadFromDisk() {
        System.out.println("  Loading image: " + filename);
    }
    
    @Override
    public void display() {
        System.out.println("  Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    
    public ProxyImage(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// 9. FACADE PATTERN
class DVDPlayer {
    public void on() { System.out.println("  DVD Player ON"); }
    public void play(String movie) { System.out.println("  Playing: " + movie); }
    public void stop() { System.out.println("  DVD Player STOP"); }
    public void off() { System.out.println("  DVD Player OFF"); }
}

class Amplifier {
    public void on() { System.out.println("  Amplifier ON"); }
    public void setVolume(int level) { System.out.println("  Volume: " + level); }
    public void off() { System.out.println("  Amplifier OFF"); }
}

class Projector {
    public void on() { System.out.println("  Projector ON"); }
    public void wideScreenMode() { System.out.println("  Widescreen mode"); }
    public void off() { System.out.println("  Projector OFF"); }
}

class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Amplifier amp;
    private Projector projector;
    
    public HomeTheaterFacade() {
        this.dvd = new DVDPlayer();
        this.amp = new Amplifier();
        this.projector = new Projector();
    }
    
    public void watchMovie(String movie) {
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(10);
        dvd.on();
        dvd.play(movie);
    }
    
    public void endMovie() {
        dvd.stop();
        dvd.off();
        amp.off();
        projector.off();
    }
}

// 10. COMPOSITE PATTERN
interface FileSystemComponent {
    int getSize();
}

class FileLeaf implements FileSystemComponent {
    private String name;
    private int size;
    
    public FileLeaf(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    @Override
    public int getSize() {
        return size;
    }
}

class FolderComposite implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();
    
    public FolderComposite(String name) {
        this.name = name;
    }
    
    public void add(FileSystemComponent component) {
        children.add(component);
    }
    
    @Override
    public int getSize() {
        int total = 0;
        for (FileSystemComponent child : children) {
            total += child.getSize();
        }
        return total;
    }
}

// ═══════════════════════════════════════════════════════════
// BEHAVIORAL PATTERNS IMPLEMENTATIONS
// ═══════════════════════════════════════════════════════════

// 11. STRATEGY PATTERN
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("  💳 Paid $" + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("  💰 Paid $" + amount + " using PayPal");
    }
}

class ShoppingCart {
    private int amount;
    private PaymentStrategy paymentStrategy;
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    
    public void checkout() {
        paymentStrategy.pay(amount);
    }
}

// 12. OBSERVER PATTERN
interface Subscriber {
    void update(String news);
}

class EmailSubscriber implements Subscriber {
    private String email;
    
    public EmailSubscriber(String email) {
        this.email = email;
    }
    
    @Override
    public void update(String news) {
        System.out.println("  📧 Email to " + email + ": " + news);
    }
}

class NewsAgency {
    private List<Subscriber> subscribers = new CopyOnWriteArrayList<>();
    
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
    
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
    
    public void publishNews(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}

// 13. COMMAND PATTERN
interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("  💡 Light is ON");
    }
    
    public void turnOff() {
        System.out.println("  🔌 Light is OFF");
    }
}

class LightOnCommand implements Command {
    private Light light;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;
    
    public LightOffCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void pressButton() {
        command.execute();
    }
}

// 14. TEMPLATE METHOD PATTERN
abstract class DataProcessor {
    // Template method
    public final void process() {
        loadData();
        parseData();
        processData();
        saveData();
    }
    
    protected abstract void loadData();
    protected abstract void parseData();
    
    protected void processData() {
        System.out.println("  Processing data...");
    }
    
    protected void saveData() {
        System.out.println("  Saving data...");
    }
}

class CSVDataProcessor extends DataProcessor {
    @Override
    protected void loadData() {
        System.out.println("  Loading CSV data");
    }
    
    @Override
    protected void parseData() {
        System.out.println("  Parsing CSV format");
    }
}

class JSONDataProcessor extends DataProcessor {
    @Override
    protected void loadData() {
        System.out.println("  Loading JSON data");
    }
    
    @Override
    protected void parseData() {
        System.out.println("  Parsing JSON format");
    }
}

// 15. STATE PATTERN
interface VendingMachineState {
    void insertCoin();
    void selectProduct();
    void dispense();
}

class NoCoinState implements VendingMachineState {
    private VendingMachine machine;
    
    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("  ✓ Coin inserted");
        machine.setState(machine.getHasCoinState());
    }
    
    @Override
    public void selectProduct() {
        System.out.println("  ⚠️  Insert coin first");
    }
    
    @Override
    public void dispense() {
        System.out.println("  ⚠️  No product selected");
    }
}

class HasCoinState implements VendingMachineState {
    private VendingMachine machine;
    
    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("  ⚠️  Coin already inserted");
    }
    
    @Override
    public void selectProduct() {
        System.out.println("  ✓ Product selected");
        machine.setState(machine.getDispenseState());
    }
    
    @Override
    public void dispense() {
        System.out.println("  ⚠️  Select product first");
    }
}

class DispenseState implements VendingMachineState {
    private VendingMachine machine;
    
    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }
    
    @Override
    public void insertCoin() {
        System.out.println("  ⚠️  Please wait, dispensing");
    }
    
    @Override
    public void selectProduct() {
        System.out.println("  ⚠️  Already selected");
    }
    
    @Override
    public void dispense() {
        System.out.println("  ✓ Dispensing product");
        machine.setState(machine.getNoCoinState());
    }
}

class VendingMachine {
    private VendingMachineState noCoinState;
    private VendingMachineState hasCoinState;
    private VendingMachineState dispenseState;
    private VendingMachineState currentState;
    
    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        dispenseState = new DispenseState(this);
        currentState = noCoinState;
    }
    
    public void setState(VendingMachineState state) {
        this.currentState = state;
    }
    
    public void insertCoin() { currentState.insertCoin(); }
    public void selectProduct() { currentState.selectProduct(); }
    public void dispense() { currentState.dispense(); }
    
    public VendingMachineState getNoCoinState() { return noCoinState; }
    public VendingMachineState getHasCoinState() { return hasCoinState; }
    public VendingMachineState getDispenseState() { return dispenseState; }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class DesignPatternsInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║       INTERVIEW QUESTIONS - DESIGN PATTERNS            ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. What are design patterns?",
                "ANSWER: Reusable solutions to common software design problems",
                "  Categories:",
                "  - Creational: Object creation (5 patterns)",
                "  - Structural: Object composition (7 patterns)",
                "  - Behavioral: Object interaction (11 patterns)",
                "  Origin: Gang of Four (GoF) book (1994)",
                "  Benefits:",
                "  - Proven solutions",
                "  - Common vocabulary",
                "  - Best practices",
                "  - Maintainable code"
            },
            {
                "2. What is Singleton pattern?",
                "ANSWER: Ensure only one instance of class exists",
                "  Implementation:",
                "  - Private constructor",
                "  - Static instance",
                "  - Public static getInstance()",
                "  Thread-safe options:",
                "  1. Eager initialization",
                "  2. Double-checked locking",
                "  3. Bill Pugh (inner static class)",
                "  4. Enum (best practice)",
                "  Use cases: Database, Logger, Configuration",
                "  Drawbacks: Testing difficulties, global state"
            },
            {
                "3. Difference between Factory Method and Abstract Factory?",
                "ANSWER:",
                "  Factory Method:",
                "  - Creates single product",
                "  - Uses inheritance",
                "  - Subclass decides which class to instantiate",
                "  - Example: createVehicle()",
                "  Abstract Factory:",
                "  - Creates family of related products",
                "  - Uses composition",
                "  - Factory creates multiple products",
                "  - Example: createButton() + createCheckbox()",
                "  Use Abstract Factory: When products must work together"
            },
            {
                "4. What is Builder pattern?",
                "ANSWER: Construct complex objects step by step",
                "  When to use:",
                "  - Many optional parameters",
                "  - Complex construction logic",
                "  - Immutable objects",
                "  Benefits:",
                "  - Readable code",
                "  - No telescoping constructors",
                "  - Control over construction",
                "  Example: StringBuilder, Lombok @Builder",
                "  Alternative: Constructor with many parameters (bad)"
            },
            {
                "5. What is Adapter pattern?",
                "ANSWER: Convert interface of class to another expected by clients",
                "  Types:",
                "  - Class adapter (inheritance)",
                "  - Object adapter (composition)",
                "  Use cases:",
                "  - Legacy system integration",
                "  - Third-party library adaptation",
                "  - API incompatibility",
                "  Real examples:",
                "  - Arrays.asList()",
                "  - Collections.enumeration()",
                "  - InputStreamReader (InputStream → Reader)"
            },
            {
                "6. What is Decorator pattern?",
                "ANSWER: Add behavior to objects dynamically",
                "  How it works:",
                "  - Wrapper around original object",
                "  - Same interface",
                "  - Adds new functionality",
                "  Benefits:",
                "  - Open/Closed principle",
                "  - Flexible than inheritance",
                "  - Runtime behavior addition",
                "  Real examples:",
                "  - Java I/O streams",
                "  - BufferedInputStream wraps FileInputStream",
                "  - Collections.synchronizedList()"
            },
            {
                "7. What is Proxy pattern?",
                "ANSWER: Control access to another object",
                "  Types:",
                "  1. Virtual proxy: Lazy loading",
                "  2. Protection proxy: Access control",
                "  3. Remote proxy: Remote object (RMI)",
                "  4. Logging proxy: Add logging",
                "  Use cases:",
                "  - Expensive object creation",
                "  - Security/authentication",
                "  - Caching",
                "  Difference from Decorator:",
                "  - Proxy controls access, Decorator adds behavior"
            },
            {
                "8. What is Strategy pattern?",
                "ANSWER: Define family of algorithms, make them interchangeable",
                "  Components:",
                "  - Context: Uses strategy",
                "  - Strategy interface",
                "  - Concrete strategies",
                "  Benefits:",
                "  - Open/Closed principle",
                "  - Eliminates conditionals",
                "  - Runtime algorithm selection",
                "  Use cases:",
                "  - Payment methods",
                "  - Sorting algorithms",
                "  - Compression strategies",
                "  Real example: Comparator interface"
            },
            {
                "9. What is Observer pattern?",
                "ANSWER: Define one-to-many dependency",
                "  Components:",
                "  - Subject (Observable): Notifies observers",
                "  - Observer: Receives notifications",
                "  How it works:",
                "  1. Observers register with subject",
                "  2. Subject notifies all observers on change",
                "  3. Observers update themselves",
                "  Use cases:",
                "  - Event handling",
                "  - MVC (Model notifies View)",
                "  - Pub-sub messaging",
                "  Java examples: PropertyChangeListener, EventListener"
            },
            {
                "10. What is Command pattern?",
                "ANSWER: Encapsulate request as object",
                "  Components:",
                "  - Command interface",
                "  - Concrete commands",
                "  - Invoker: Executes commands",
                "  - Receiver: Actual work",
                "  Benefits:",
                "  - Undo/Redo functionality",
                "  - Command queuing",
                "  - Logging requests",
                "  - Macro commands",
                "  Use cases:",
                "  - GUI buttons",
                "  - Transaction systems",
                "  - Task scheduling"
            },
            {
                "11. Difference between Strategy and State pattern?",
                "ANSWER:",
                "  Strategy:",
                "  - Client chooses strategy",
                "  - Strategies independent",
                "  - Focus: Algorithm selection",
                "  - Example: Payment method",
                "  State:",
                "  - Context changes state internally",
                "  - States aware of transitions",
                "  - Focus: State transitions",
                "  - Example: Vending machine states",
                "  Both: Use composition over inheritance"
            },
            {
                "12. What is Template Method pattern?",
                "ANSWER: Define algorithm skeleton, let subclasses override steps",
                "  How it works:",
                "  - Abstract class with template method",
                "  - Template method calls abstract/hook methods",
                "  - Subclasses implement specific steps",
                "  Benefits:",
                "  - Code reuse",
                "  - Control flow in parent",
                "  - Hollywood Principle (don't call us, we'll call you)",
                "  Real examples:",
                "  - HttpServlet.service()",
                "  - Collections.sort()"
            },
            {
                "13. What is Facade pattern?",
                "ANSWER: Provide simplified interface to complex subsystem",
                "  Purpose:",
                "  - Hide complexity",
                "  - Unified interface",
                "  - Loose coupling",
                "  Benefits:",
                "  - Easy to use",
                "  - Shields clients from subsystem",
                "  - Promotes loose coupling",
                "  Use cases:",
                "  - Complex libraries",
                "  - Legacy system wrapper",
                "  Real examples:",
                "  - JDBC (hides database complexity)",
                "  - SLF4J (logging facade)"
            },
            {
                "14. What is Composite pattern?",
                "ANSWER: Compose objects into tree structures",
                "  When to use:",
                "  - Part-whole hierarchies",
                "  - Treat individual and composite uniformly",
                "  Components:",
                "  - Component interface",
                "  - Leaf: No children",
                "  - Composite: Has children",
                "  Use cases:",
                "  - File systems",
                "  - GUI components",
                "  - Organization structures",
                "  Real example: Swing containers"
            },
            {
                "15. What is Dependency Injection?",
                "ANSWER: Design pattern for implementing IoC",
                "  Types:",
                "  1. Constructor injection",
                "  2. Setter injection",
                "  3. Interface injection",
                "  Benefits:",
                "  - Loose coupling",
                "  - Testability",
                "  - Maintainability",
                "  - Flexibility",
                "  Frameworks: Spring, Guice, Dagger",
                "  Principle: Inversion of Control (IoC)"
            },
            {
                "16. When NOT to use design patterns?",
                "ANSWER:",
                "  Don't use when:",
                "  - Over-engineering simple solutions",
                "  - YAGNI (You Aren't Gonna Need It)",
                "  - Premature optimization",
                "  - Forcing pattern where doesn't fit",
                "  Remember:",
                "  - Patterns are tools, not rules",
                "  - Simplicity first",
                "  - Use when problem fits",
                "  - Don't complicate unnecessarily"
            },
            {
                "17. What is the difference between Adapter and Proxy?",
                "ANSWER:",
                "  Adapter:",
                "  - Changes interface",
                "  - Makes incompatible interfaces work",
                "  - Example: USB-C to USB-A adapter",
                "  Proxy:",
                "  - Same interface",
                "  - Controls access",
                "  - Adds behavior (caching, logging)",
                "  - Example: Image proxy for lazy loading",
                "  Key: Adapter changes interface, Proxy doesn't"
            },
            {
                "18. What is SOLID principles relation to patterns?",
                "ANSWER: Patterns implement SOLID principles",
                "  S - Single Responsibility:",
                "  - Strategy, Command",
                "  O - Open/Closed:",
                "  - Decorator, Strategy",
                "  L - Liskov Substitution:",
                "  - Factory Method",
                "  I - Interface Segregation:",
                "  - Adapter",
                "  D - Dependency Inversion:",
                "  - Factory, Abstract Factory",
                "  Patterns embody good OOP design"
            },
            {
                "19. How to choose which pattern to use?",
                "ANSWER:",
                "  Ask yourself:",
                "  - What problem am I solving?",
                "  - Is there object creation issue? → Creational",
                "  - Is there structure/composition issue? → Structural",
                "  - Is there behavior/algorithm issue? → Behavioral",
                "  Consider:",
                "  - Problem domain",
                "  - Trade-offs",
                "  - Team familiarity",
                "  - Maintenance",
                "  Don't: Force patterns where not needed"
            },
            {
                "20. Most commonly used patterns in enterprise Java?",
                "ANSWER:",
                "  Most used:",
                "  1. Singleton - Configuration, Logger",
                "  2. Factory - Object creation",
                "  3. Builder - Complex objects",
                "  4. Adapter - Integration",
                "  5. Decorator - I/O streams",
                "  6. Proxy - AOP, Security",
                "  7. Strategy - Business rules",
                "  8. Observer - Event handling",
                "  9. Template Method - Framework hooks",
                "  10. Dependency Injection - Spring framework",
                "  Less used: Flyweight, Interpreter, Visitor"
            }
        };

        for (String[] qa : questions) {
            for (String line : qa) {
                System.out.println(line);
            }
            System.out.println();
        }

        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  KEY TAKEAWAYS                         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("✓ Patterns are proven solutions, not inventions");
        System.out.println("✓ Creational = creation, Structural = composition, Behavioral = interaction");
        System.out.println("✓ Singleton: One instance (use enum for best practice)");
        System.out.println("✓ Factory: Encapsulate object creation");
        System.out.println("✓ Builder: Complex object construction");
        System.out.println("✓ Adapter: Interface conversion");
        System.out.println("✓ Decorator: Dynamic behavior addition");
        System.out.println("✓ Strategy: Interchangeable algorithms");
        System.out.println("✓ Observer: Event notification");
        System.out.println("✓ Use patterns wisely, don't over-engineer");
        System.out.println();
    }
}
