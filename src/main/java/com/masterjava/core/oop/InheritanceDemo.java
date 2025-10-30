package com.masterjava.core.oop;

import static com.masterjava.core.oop.InheritanceInterviewQuestions.printInterviewQuestions;

/**
 * LESSON 6: INHERITANCE
 * =====================
 *
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand inheritance and IS-A relationship
 * 2. Master 'extends' keyword
 * 3. Learn 'super' keyword usage
 * 4. Understand method overriding
 * 5. Learn constructor chaining in inheritance
 * 6. Master types of inheritance
 * 7. Understand Object class and its methods
 * 8. Learn final keyword with inheritance
 *
 * UNDER THE HOOD (JVM):
 * --------------------
 * OBJECT CREATION WITH INHERITANCE:
 * When you create: Dog dog = new Dog();
 *
 * 1. Memory allocated for ENTIRE object (including parent parts)
 * 2. Parent constructor called first (super())
 * 3. Parent fields initialized
 * 4. Child constructor called
 * 5. Child fields initialized
 *
 * MEMORY LAYOUT:
 * -------------
 * Heap:
 *   Dog Object {
 *     Object Header
 *     ├── Animal fields (name, age)
 *     └── Dog fields (breed)
 *     Method Table Pointer → Dog's vtable
 *   }
 *
 * Method Area (Metaspace):
 *   Animal.class metadata
 *   Dog.class metadata
 *   Virtual Method Table (vtable) for dynamic dispatch
 *
 * METHOD DISPATCH:
 * - Static methods: Resolved at compile time (method hiding)
 * - Instance methods: Resolved at runtime (dynamic dispatch via vtable)
 * - Final methods: Cannot be overridden, direct invocation
 *
 * @author Master Java Project
 * @version 1.0
 * @since 2024
 */
public class InheritanceDemo {

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║      LESSON 6: INHERITANCE            ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: BASIC INHERITANCE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. BASIC INHERITANCE ━━━");

        // Create parent object
        Animal animal = new Animal("Generic Animal", 5);
        animal.displayInfo();
        animal.makeSound();

        System.out.println();

        // Create child object
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        dog.displayInfo(); // Inherited method
        dog.makeSound();   // Overridden method
        dog.fetch();       // Dog-specific method

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: SUPER KEYWORD
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. SUPER KEYWORD ━━━");

        Cat cat = new Cat("Whiskers", 2, "Tabby");
        cat.displayInfo(); // Uses super to call parent method
        cat.makeSound();   // Overridden but uses super inside

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: METHOD OVERRIDING
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. METHOD OVERRIDING ━━━");

        // Polymorphic behavior - runtime polymorphism
        Animal myAnimal1 = new Dog("Max", 4, "Labrador");
        Animal myAnimal2 = new Cat("Luna", 1, "Persian");

        myAnimal1.makeSound(); // Calls Dog's makeSound()
        myAnimal2.makeSound(); // Calls Cat's makeSound()

        // Can't call Dog-specific methods through Animal reference
        // myAnimal1.fetch(); // Compile error!

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: CONSTRUCTOR CHAINING
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. CONSTRUCTOR CHAINING ━━━");

        System.out.println("\nCreating Bird object:");
        Bird bird = new Bird("Tweety", 1, "Yellow");

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: MULTILEVEL INHERITANCE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. MULTILEVEL INHERITANCE ━━━");

        PuppyDog puppy = new PuppyDog("Charlie", 1, "Beagle", true);
        puppy.displayInfo();
        puppy.makeSound();
        puppy.fetch();
        puppy.play();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: OBJECT CLASS METHODS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. OBJECT CLASS METHODS ━━━");

        Dog dog1 = new Dog("Rocky", 5, "Bulldog");
        Dog dog2 = new Dog("Rocky", 5, "Bulldog");
        Dog dog3 = dog1;

        // toString()
        System.out.println("dog1.toString(): " + dog1.toString());

        // equals()
        System.out.println("dog1.equals(dog2): " + dog1.equals(dog2));
        System.out.println("dog1.equals(dog3): " + dog1.equals(dog3));
        System.out.println("dog1 == dog3: " + (dog1 == dog3));

        // hashCode()
        System.out.println("dog1.hashCode(): " + dog1.hashCode());
        System.out.println("dog2.hashCode(): " + dog2.hashCode());

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: FINAL KEYWORD WITH INHERITANCE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. FINAL KEYWORD ━━━");

        FinalExample finalExample = new FinalExample();
        finalExample.normalMethod();
        finalExample.finalMethod();
        // FinalExample.cannotOverride(); // Cannot override final method

        // Cannot extend final class
        // class SubFinalClass extends FinalClass {} // Compile error!

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: INSTANCEOF OPERATOR
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. INSTANCEOF OPERATOR ━━━");

        Animal testAnimal = new Dog("Test", 3, "Poodle");

        System.out.println("testAnimal instanceof Dog: " + (testAnimal instanceof Dog));
        System.out.println("testAnimal instanceof Animal: " + (testAnimal instanceof Animal));
        System.out.println("testAnimal instanceof Cat: " + (testAnimal instanceof Cat));
        System.out.println("testAnimal instanceof Object: " + (testAnimal instanceof Object));

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: TYPE CASTING
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. TYPE CASTING ━━━");

        // Upcasting (implicit)
        Animal upcastedDog = new Dog("Upcasted", 2, "Husky");
        upcastedDog.makeSound();
        // upcastedDog.fetch(); // Cannot access Dog methods

        // Downcasting (explicit)
        if (upcastedDog instanceof Dog) {
            Dog downcastedDog = (Dog) upcastedDog;
            downcastedDog.fetch(); // Now can access Dog methods
        }

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        printInterviewQuestions();
    }
}

// ═══════════════════════════════════════════════════════════
// PARENT CLASS - ANIMAL
// ═══════════════════════════════════════════════════════════

/**
 * Parent class demonstrating inheritance basics
 */
class Animal {
    // Protected - accessible in subclasses
    protected String name;
    protected int age;

    /**
     * Parent constructor
     */
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("  → Animal constructor called");
    }

    /**
     * Method to be inherited
     */
    public void displayInfo() {
        System.out.println("  Name: " + name + ", Age: " + age);
    }

    /**
     * Method to be overridden
     */
    public void makeSound() {
        System.out.println("  " + name + " makes a generic animal sound");
    }

    /**
     * Final method - cannot be overridden
     */
    public final void breathe() {
        System.out.println("  " + name + " is breathing");
    }
}

// ═══════════════════════════════════════════════════════════
// CHILD CLASS - DOG
// ═══════════════════════════════════════════════════════════

/**
 * Child class extending Animal
 */
class Dog extends Animal {
    // Additional field
    private String breed;

    /**
     * Dog constructor - must call super()
     */
    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent constructor
        this.breed = breed;
        System.out.println("  → Dog constructor called");
    }

    /**
     * Overriding parent method
     */
    @Override
    public void makeSound() {
        System.out.println("  " + name + " (Dog) says: Woof! Woof!");
    }

    /**
     * Dog-specific method
     */
    public void fetch() {
        System.out.println("  " + name + " is fetching the ball!");
    }

    /**
     * Override toString() from Object class
     */
    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + age + ", breed='" + breed + "'}";
    }

    /**
     * Override equals() from Object class
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Dog dog = (Dog) obj;
        return age == dog.age &&
                name.equals(dog.name) &&
                breed.equals(dog.breed);
    }

    /**
     * Override hashCode() from Object class
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + breed.hashCode();
        return result;
    }
}

// ═══════════════════════════════════════════════════════════
// CHILD CLASS - CAT (DEMONSTRATING SUPER)
// ═══════════════════════════════════════════════════════════

/**
 * Cat class demonstrating super keyword usage
 */
class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
        System.out.println("  → Cat constructor called");
    }

    /**
     * Override with super call
     */
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("  Color: " + color);
    }

    /**
     * Override makeSound
     */
    @Override
    public void makeSound() {
        System.out.println("  " + name + " (Cat) says: Meow! Meow!");
        // Can also call parent version
        // super.makeSound();
    }
}

// ═══════════════════════════════════════════════════════════
// CONSTRUCTOR CHAINING DEMONSTRATION
// ═══════════════════════════════════════════════════════════

class Bird extends Animal {
    private String color;

    public Bird(String name, int age, String color) {
        super(name, age); // Must be first statement
        this.color = color;
        System.out.println("  → Bird constructor called");
    }

    @Override
    public void makeSound() {
        System.out.println("  " + name + " (Bird) says: Chirp! Chirp!");
    }
}

// ═══════════════════════════════════════════════════════════
// MULTILEVEL INHERITANCE
// ═══════════════════════════════════════════════════════════

/**
 * PuppyDog extends Dog, which extends Animal
 * This is multilevel inheritance
 */
class PuppyDog extends Dog {
    private boolean isPlayful;

    public PuppyDog(String name, int age, String breed, boolean isPlayful) {
        super(name, age, breed);
        this.isPlayful = isPlayful;
        System.out.println("  → PuppyDog constructor called");
    }

    /**
     * Override Dog's makeSound
     */
    @Override
    public void makeSound() {
        System.out.println("  " + name + " (Puppy) says: Yip! Yip!");
    }

    /**
     * Puppy-specific method
     */
    public void play() {
        if (isPlayful) {
            System.out.println("  " + name + " is playing energetically!");
        } else {
            System.out.println("  " + name + " is resting");
        }
    }
}

// ═══════════════════════════════════════════════════════════
// FINAL KEYWORD DEMONSTRATIONS
// ═══════════════════════════════════════════════════════════

class FinalExample {

    /**
     * Normal method - can be overridden
     */
    public void normalMethod() {
        System.out.println("  Normal method - can be overridden");
    }

    /**
     * Final method - CANNOT be overridden
     */
    public final void finalMethod() {
        System.out.println("  Final method - cannot be overridden");
    }
}

/**
 * Attempting to override final method will cause compile error
 */
class SubFinalExample extends FinalExample {

    @Override
    public void normalMethod() {
        System.out.println("  Overridden normal method");
    }

    // Cannot override final method
    // @Override
    // public void finalMethod() { } // Compile error!
}

/**
 * Final class - CANNOT be extended
 */
final class FinalClass {
    public void someMethod() {
        System.out.println("Method in final class");
    }
}

// Cannot extend final class
// class SubFinalClass extends FinalClass { } // Compile error!

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class InheritanceInterviewQuestions {

    static void printInterviewQuestions() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          INTERVIEW QUESTIONS - INHERITANCE             ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
                {
                        "1. What is inheritance? Why is it useful?",
                        "ANSWER: Mechanism where one class acquires properties of another",
                        "  Benefits:",
                        "  - Code reusability (DRY principle)",
                        "  - Method overriding (runtime polymorphism)",
                        "  - Establishes IS-A relationship",
                        "  - Extensibility - add features without modifying parent",
                        "  Syntax: class Child extends Parent { }"
                },
                {
                        "2. What are types of inheritance in Java?",
                        "ANSWER: Java supports:",
                        "  1. Single - One parent, one child (Dog extends Animal)",
                        "  2. Multilevel - Chain of inheritance (Puppy → Dog → Animal)",
                        "  3. Hierarchical - Multiple children from one parent",
                        "     (Dog → Animal, Cat → Animal)",
                        "",
                        "  NOT SUPPORTED (via classes):",
                        "  4. Multiple - One child, multiple parents (Diamond problem)",
                        "  5. Hybrid - Combination of above",
                        "  Note: Multiple inheritance achieved via interfaces"
                },
                {
                        "3. What is the 'super' keyword? What are its uses?",
                        "ANSWER: Reference to immediate parent class",
                        "  Uses:",
                        "  1. Call parent constructor: super(args) - must be first statement",
                        "  2. Access parent method: super.methodName()",
                        "  3. Access parent field: super.fieldName",
                        "  Note: super() is implicitly called if not explicitly mentioned"
                },
                {
                        "4. Difference between method overriding and overloading?",
                        "ANSWER:",
                        "  Method Overriding:",
                        "  - Same signature in child and parent class",
                        "  - Runtime polymorphism (dynamic dispatch)",
                        "  - @Override annotation recommended",
                        "  - Return type must be same or covariant",
                        "  Method Overloading:",
                        "  - Same name, different parameters in same class",
                        "  - Compile-time polymorphism",
                        "  - Return type can be different"
                },
                {
                        "5. Rules for method overriding?",
                        "ANSWER: Method in child class must follow:",
                        "  1. Same method name",
                        "  2. Same parameter list (signature)",
                        "  3. Same or covariant return type",
                        "  4. Cannot have more restrictive access modifier",
                        "  5. Cannot throw broader checked exceptions",
                        "  6. Cannot override static, final, or private methods",
                        "  7. Use @Override annotation (recommended)"
                },
                {
                        "6. Can we override static methods?",
                        "ANSWER: No, static methods are hidden, not overridden",
                        "  - Static methods belong to class, not instance",
                        "  - Resolved at compile time (not runtime)",
                        "  - Called method hiding, not overriding",
                        "  - No polymorphic behavior",
                        "  Example:",
                        "    Parent p = new Child();",
                        "    p.staticMethod(); // Calls Parent's version (compile-time)"
                },
                {
                        "7. Can we override private methods?",
                        "ANSWER: No, private methods are not inherited",
                        "  - Private methods not visible to child class",
                        "  - You can define method with same name in child (not overriding)",
                        "  - It's a completely new method, not an override",
                        "  - No @Override annotation possible"
                },
                {
                        "8. What is constructor chaining in inheritance?",
                        "ANSWER: Calling parent constructor from child constructor",
                        "  - super() must be first statement in child constructor",
                        "  - If not explicitly called, Java adds super() automatically",
                        "  - Ensures parent is initialized before child",
                        "  Order: Parent constructor → Child constructor",
                        "  Example: super(name, age);"
                },
                {
                        "9. Can constructor be inherited?",
                        "ANSWER: No, constructors are NOT inherited",
                        "  - Each class defines its own constructors",
                        "  - Child must explicitly call parent constructor using super()",
                        "  - If parent has no no-arg constructor, child MUST call",
                        "    parameterized constructor using super(args)"
                },
                {
                        "10. What is the diamond problem? How does Java solve it?",
                        "ANSWER: Ambiguity when class inherits from two classes with same method",
                        "  Problem:",
                        "    B and C extend A (both have method m())",
                        "    D extends B and C - which m() to inherit?",
                        "  Java Solution:",
                        "  - No multiple inheritance via classes",
                        "  - Use interfaces (Java 8+ default methods handle this)"
                },
                {
                        "11. Difference between IS-A and HAS-A relationship?",
                        "ANSWER:",
                        "  IS-A (Inheritance):",
                        "  - Dog IS-A Animal",
                        "  - Uses 'extends' keyword",
                        "  - Tight coupling",
                        "  HAS-A (Composition):",
                        "  - Car HAS-A Engine",
                        "  - Object as instance variable",
                        "  - Loose coupling",
                        "  Note: Favor composition over inheritance (design principle)"
                },
                {
                        "12. What is the Object class?",
                        "ANSWER: Root of Java class hierarchy",
                        "  - Every class implicitly extends Object",
                        "  - Located in java.lang package",
                        "  Key methods:",
                        "  - toString() - string representation",
                        "  - equals() - logical equality",
                        "  - hashCode() - hash value for collections",
                        "  - getClass() - runtime class",
                        "  - clone() - object copy",
                        "  - finalize() - cleanup before GC (deprecated)"
                },
                {
                        "13. When to override equals() and hashCode()?",
                        "ANSWER: When using objects in collections (HashMap, HashSet)",
                        "  Contract:",
                        "  - If equals() returns true, hashCode() must be same",
                        "  - If hashCode() is same, equals() may or may not be true",
                        "  - Consistent: multiple calls return same value",
                        "  Best Practice: Use IDE to generate or use Objects.hash()"
                },
                {
                        "14. What is covariant return type?",
                        "ANSWER: Overriding method can return subtype of parent's return type",
                        "  Parent: Animal getAnimal()",
                        "  Child: Dog getAnimal() // Dog extends Animal - valid!",
                        "  Introduced in Java 5",
                        "  Makes method overriding more flexible"
                },
                {
                        "15. What are uses of 'final' keyword in inheritance?",
                        "ANSWER:",
                        "  final method - Cannot be overridden",
                        "    public final void calculate() { }",
                        "  final class - Cannot be extended",
                        "    final class FinalClass { }",
                        "  final variable - Cannot be reassigned (constant)",
                        "    final int MAX = 100;",
                        "  Use Cases: Immutability, security, performance"
                },
                {
                        "16. What happens when you create a child object?",
                        "ANSWER: Object creation sequence:",
                        "  1. Memory allocated for ENTIRE object (parent + child)",
                        "  2. Parent's static members loaded (if first time)",
                        "  3. Child's static members loaded (if first time)",
                        "  4. Parent's instance variables initialized",
                        "  5. Parent constructor executed",
                        "  6. Child's instance variables initialized",
                        "  7. Child constructor executed",
                        "  8. Reference returned"
                },
                {
                        "17. Can we have different access modifiers in overridden method?",
                        "ANSWER: Yes, but with restrictions",
                        "  Rule: Cannot be MORE restrictive than parent",
                        "  Valid progression:",
                        "    private < default < protected < public",
                        "  Examples:",
                        "    Parent: protected → Child: public ✓",
                        "    Parent: public → Child: private ✗",
                        "  Reason: Violates IS-A relationship (Liskov Substitution)"
                },
                {
                        "18. What is upcasting and downcasting?",
                        "ANSWER:",
                        "  Upcasting (Implicit):",
                        "  - Child to Parent reference",
                        "  - Animal a = new Dog(); // Automatic",
                        "  - Safe, no ClassCastException",
                        "  - Lose access to child-specific methods",
                        "  Downcasting (Explicit):",
                        "  - Parent to Child reference",
                        "  - Dog d = (Dog) a; // Manual cast",
                        "  - Can throw ClassCastException",
                        "  - Use instanceof to check before casting"
                },
                {
                        "19. Why doesn't Java support multiple inheritance?",
                        "ANSWER: To avoid ambiguity (diamond problem)",
                        "  Issues:",
                        "  - Which parent's method to inherit?",
                        "  - Complexity in method resolution",
                        "  - Harder to maintain and debug",
                        "  Alternative: Use interfaces (can implement multiple)",
                        "  Note: Java 8+ interfaces can have default methods"
                },
                {
                        "20. Difference between super() and this()?",
                        "ANSWER:",
                        "  super():",
                        "  - Calls parent class constructor",
                        "  - Used in child class",
                        "  - Must be first statement",
                        "  this():",
                        "  - Calls another constructor in same class",
                        "  - Constructor chaining within class",
                        "  - Must be first statement",
                        "  Note: Can't use both in same constructor"
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
        System.out.println("✓ Inheritance = Code reusability + IS-A relationship");
        System.out.println("✓ Use 'extends' keyword for inheritance");
        System.out.println("✓ super() calls parent constructor (must be first)");
        System.out.println("✓ Method overriding = Runtime polymorphism");
        System.out.println("✓ Can't override static, final, or private methods");
        System.out.println("✓ Every class extends Object (implicitly)");
        System.out.println("✓ Multiple inheritance NOT supported via classes");
        System.out.println("✓ Use instanceof before downcasting");
        System.out.println("✓ Override equals() and hashCode() together");
        System.out.println();
    }
}