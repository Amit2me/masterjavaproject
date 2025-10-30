package com.masterjava.core.fundamentals;

/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * CORE JAVA 01: HELLO WORLD & PROGRAM STRUCTURE
 * ═══════════════════════════════════════════════════════════════════════════════
 *
 * LEARNING OBJECTIVES:
 * ✓ Understand Java program structure
 * ✓ Learn compilation and execution process
 * ✓ Understand main method and its role
 * ✓ Command-line argument handling
 * ✓ Output using System.out
 * ✓ Package and import concepts
 *
 * DIFFICULTY: Beginner
 * TIME: 30-45 minutes
 *
 * WHY THIS MATTERS:
 * • Every Java program starts with understanding this structure
 * • Foundation for all other Java concepts
 * • Commonly asked in interviews for juniors
 * • Essential for debugging and understanding program flow
 *
 * REAL-WORLD APPLICATIONS:
 * • Entry point of any Java application
 * • Command-line tools and utilities
 * • Batch processing systems
 * • Microservices entry points
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class HelloWorld {

    // ═════════════════════════════════════════════════════════════════════════════
    // THEORY SECTION - DEEP DIVE INTO CONCEPTS
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ JAVA PROGRAM EXECUTION FLOW - UNDER THE HOOD                            │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * 1. SOURCE CODE (.java file)
     *    ↓
     * 2. COMPILATION (javac HelloWorld.java)
     *    • Java compiler reads source code
     *    • Checks syntax and semantics
     *    • Converts to bytecode
     *    ↓
     * 3. BYTECODE (.class file)
     *    • Platform-independent intermediate code
     *    • Same .class works on Windows, Mac, Linux
     *    • Not directly executable by CPU
     *    ↓
     * 4. JVM (java HelloWorld)
     *    • Java Virtual Machine loads .class file
     *    • Interprets/JIT compiles bytecode to native code
     *    • Manages memory and resources
     *    ↓
     * 5. EXECUTION
     *    • Native CPU instructions execute
     *    • Output produced
     *
     * WHY BYTECODE?
     * ✓ Write Once, Run Anywhere (WORA)
     * ✓ Platform independence
     * ✓ Security through sandboxing
     * ✓ Runtime optimization
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ CLASS STRUCTURE - WHAT EVERY CLASS NEEDS                               │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * Anatomy of a Java class:
     *
     * [package declaration]          // Optional but recommended
     * [import statements]            // Import external classes
     * [class declaration]            // public class ClassName
     * {
     *     [static variables]         // Shared by all instances
     *     [instance variables]       // Unique to each instance
     *     [constructors]             // Initialize objects
     *     [methods]                  // Define behavior
     *     [inner classes]            // Classes within classes
     * }
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ MAIN METHOD - THE ENTRY POINT                                          │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * Signature: public static void main(String[] args)
     *
     *   public       → Accessible from anywhere (JVM requirement)
     *   static       → Belongs to class, not instance (no new needed)
     *   void         → Returns nothing
     *   main         → Method name (JVM looks for this specifically)
     *   String[]     → Array of command-line arguments
     *   args         → Variable name (can be different, but convention is "args")
     *
     * IMPORTANT:
     * • JVM specifically looks for: public static void main(String[] args)
     * • You can overload main() but only the above signature starts program
     * • If main is missing, compilation succeeds but runtime fails
     * • Static means JVM calls it without creating object instance
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ MEMORY LAYOUT - HOW STACK AND HEAP WORK                                │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * When main() executes:
     *
     * STACK                          HEAP
     * ┌──────────────────┐          ┌────────────────────┐
     * │ args: [array]────┼──────────→│ String[] {content} │
     * │ message: ref─────┼──────────→│ "Hello World!"     │
     * │ count: 5         │          │                    │
     * └──────────────────┘          └────────────────────┘
     *
     * • Stack: Primitives and references stored here, auto-cleared
     * • Heap: Objects and arrays stored here, garbage collected
     * • References point from stack to heap
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ COMMON MISTAKES & HOW TO AVOID THEM                                    │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * ✗ WRONG:
     *   public void main(String[] args)        // Missing 'static'
     *   public static int main(String[] args)  // Wrong return type
     *   public static void main(String args)   // Not an array
     *
     * ✓ CORRECT:
     *   public static void main(String[] args)
     *
     * ✗ WRONG: File name doesn't match class
     *   File: Test.java, Class: public class MyClass
     *
     * ✓ CORRECT:
     *   File: MyClass.java, Class: public class MyClass
     */

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 1: SIMPLEST POSSIBLE HELLO WORLD
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Basic program structure with minimal code
     * Concepts: main method, System.out.println
     * Output: Single line of text
     *
     * How it works:
     * 1. JVM starts, looks for main() method
     * 2. Executes System.out.println()
     * 3. Prints "Hello World!" to console
     * 4. main() ends, program terminates
     */
    static class Example1 {
        public static void main(String[] args) {
            System.out.println("Hello World!");

            /*
             * System.out.println breakdown:
             * System   → Built-in class from java.lang package
             * .out     → Static PrintStream field
             * .println → Method to print with newline
             */
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 2: UNDERSTANDING SYSTEM.OUT
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Different output methods
     * Concepts: println, print, printf
     * Output: Multiple lines with different formatting
     */
    static class Example2 {
        public static void main(String[] args) {
            System.out.println("1. Using println() - includes newline");
            System.out.print("2. Using print() - ");
            System.out.print("no newline added");
            System.out.println();  // Explicit newline

            System.out.printf("3. Using printf() - %s with %s%n", "formatted", "arguments");

            /*
             * Difference:
             * println()  → Prints + adds newline (\n)
             * print()    → Prints without newline
             * printf()   → Formatted output (like C printf)
             *            %s = string, %d = int, %f = float, %n = newline
             */
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 3: COMMAND-LINE ARGUMENTS
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Processing command-line arguments
     * Concepts: args array, accessing array elements
     *
     * Run: java Example3 Alice 25 Developer
     *
     * Important:
     * • args is NEVER null (always at least empty array)
     * • args.length tells you how many arguments passed
     * • Useful for configuration and parameters
     */
    static class Example3 {
        public static void main(String[] args) {
            System.out.println("Number of arguments received: " + args.length);

            // Always check length before accessing
            if (args.length == 0) {
                System.out.println("No arguments provided!");
                System.out.println("Usage: java Example3 <name> <age> <role>");
                return;  // Exit early
            }

            // Access arguments by index (0-based)
            System.out.println("Argument 0: " + args[0]);

            if (args.length > 1) {
                System.out.println("Argument 1: " + args[1]);
            }

            if (args.length > 2) {
                System.out.println("Argument 2: " + args[2]);
            }

            // Loop through all arguments
            System.out.println("\nAll arguments in loop:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("  args[" + i + "] = " + args[i]);
            }

            // Enhanced for loop (cleaner)
            System.out.println("\nUsing enhanced for loop:");
            for (String arg : args) {
                System.out.println("  " + arg);
            }

            /*
             * KEY POINTS:
             * ✓ args is always initialized (never null)
             * ✓ Empty array if no arguments
             * ✓ Always check length before accessing
             * ✓ ArrayIndexOutOfBoundsException if access invalid index
             */
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 4: MULTIPLE METHODS & EXECUTION ORDER
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Method calls and execution sequence
     * Concepts: Method definition, calling, control flow
     *
     * Execution order:
     * 1. main() starts
     * 2. Calls greeting()
     * 3. greeting() returns to main()
     * 4. main() calls display()
     * 5. display() returns to main()
     * 6. main() ends
     */
    static class Example4 {
        static void greeting() {
            System.out.println("This is greeting() method");
        }

        static void display() {
            System.out.println("This is display() method");
            System.out.println("Multiple lines in one method");
        }

        public static void main(String[] args) {
            System.out.println("START: main() method begins");

            greeting();  // Call method 1
            System.out.println("Returned from greeting()");

            display();   // Call method 2
            System.out.println("Returned from display()");

            System.out.println("END: main() method ends");
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 5: RETURN VALUES & PARAMETERS
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Methods with parameters and return values
     * Concepts: Parameters, return statements, types
     */
    static class Example5 {
        // Method with parameter and return value
        static int add(int a, int b) {
            return a + b;
        }

        // Method with multiple parameters
        static void greetPerson(String name, int age) {
            System.out.println("Hello " + name + "! You are " + age + " years old.");
        }

        // Method that returns String
        static String getSystemInfo() {
            return "Java Version: " + System.getProperty("java.version") +
                    ", OS: " + System.getProperty("os.name");
        }

        public static void main(String[] args) {
            // Call method with return value
            int result = add(10, 20);
            System.out.println("10 + 20 = " + result);

            // Call method with void return
            greetPerson("Alice", 25);

            // Call method returning String
            System.out.println(getSystemInfo());
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 6: COMPLETE PROGRAM WITH ALL CONCEPTS
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Real-world usage combining all concepts
     * Concepts: Complex program flow, multiple methods
     */
    static class Example6 {
        static void printSeparator() {
            System.out.println("════════════════════════════════════════════════");
        }

        static void displayMenu() {
            printSeparator();
            System.out.println("       MASTER JAVA - HELLO WORLD MODULE");
            printSeparator();
            System.out.println("1. Simple Greeting");
            System.out.println("2. Program Information");
            System.out.println("3. Exit");
            printSeparator();
        }

        static void simpleGreeting(String name) {
            System.out.println("Hello, " + name + "!");
        }

        static void displayInfo() {
            System.out.println("Java Version: " + System.getProperty("java.version"));
            System.out.println("OS: " + System.getProperty("os.name"));
            System.out.println("User: " + System.getProperty("user.name"));
        }

        public static void main(String[] args) {
            displayMenu();

            if (args.length > 0) {
                String name = args[0];
                simpleGreeting(name);
            } else {
                simpleGreeting("World");
            }

            System.out.println();
            displayInfo();

            printSeparator();
            System.out.println("Program completed successfully!");
            printSeparator();
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // MAIN - CHOOSE WHICH EXAMPLE TO RUN
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Run different examples:
     * java HelloWorld         → Runs Example1
     * java HelloWorld 1       → Runs Example1
     * java HelloWorld 2       → Runs Example2
     * java HelloWorld 3 arg1 arg2 arg3  → Runs Example3 with arguments
     * ... and so on
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  CORE JAVA 01 - HELLO WORLD & PROGRAM STRUCTURE               ║");
        System.out.println("║  Choose an example to run (1-6)                               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        if (args.length == 0) {
            System.out.println("Running Example 1 by default...\n");
            Example1.main(new String[]{});
        } else {
            try {
                int choice = Integer.parseInt(args[0]);
                String[] remainingArgs = new String[args.length - 1];
                System.arraycopy(args, 1, remainingArgs, 0, args.length - 1);

                switch (choice) {
                    case 1:
                        System.out.println("Example 1: Simplest Hello World\n");
                        Example1.main(new String[]{});
                        break;
                    case 2:
                        System.out.println("Example 2: Understanding System.out\n");
                        Example2.main(new String[]{});
                        break;
                    case 3:
                        System.out.println("Example 3: Command-Line Arguments\n");
                        Example3.main(remainingArgs);
                        break;
                    case 4:
                        System.out.println("Example 4: Multiple Methods & Execution Order\n");
                        Example4.main(new String[]{});
                        break;
                    case 5:
                        System.out.println("Example 5: Return Values & Parameters\n");
                        Example5.main(new String[]{});
                        break;
                    case 6:
                        System.out.println("Example 6: Complete Program\n");
                        Example6.main(remainingArgs);
                        break;
                    default:
                        System.out.println("Invalid choice. Choose 1-6");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please provide a number 1-6 as first argument");
            }
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // INTERVIEW Q&A SECTION
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ INTERVIEW QUESTIONS & ANSWERS                                           │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * Q1: What is the role of the main method in Java?
     * A: The main method is the entry point of a Java program. When you run a
     *    Java program, the JVM looks for a method with the exact signature:
     *    "public static void main(String[] args)" and starts execution from there.
     *    It's called only once at program startup.
     *
     * Q2: Why is the main method static?
     * A: The main method is static because the JVM needs to call it without
     *    creating an instance of the class. Static methods belong to the class
     *    itself, not to instances. This allows the JVM to invoke main() directly
     *    on the class without instantiation overhead.
     *
     * Q3: Can we change the main method signature?
     * A: No, not for the program entry point. You can have other main methods
     *    with different signatures (overloading), but the JVM specifically looks
     *    for "public static void main(String[] args)". Having a different
     *    signature won't prevent compilation but the program won't start.
     *    Example:
     *    public static void main(String name) { } // Won't work as entry point
     *
     * Q4: What happens if main is missing?
     * A: The program will compile successfully, but at runtime, you'll get:
     *    "Error: Main method not found in class X, please define the main method
     *     as: public static void main(String[] args)"
     *
     * Q5: What is bytecode and why is it important?
     * A: Bytecode is an intermediate representation between Java source code
     *    and machine code. It's platform-independent and run by the JVM.
     *    Importance:
     *    • Write Once, Run Anywhere (WORA)
     *    • Security through sandboxing
     *    • JVM can optimize bytecode at runtime
     *    • Platform independence without recompilation
     *
     * Q6: Explain the compilation and execution process.
     * A: Process:
     *    1. Write Java source code (.java file)
     *    2. Compile with javac: javac HelloWorld.java
     *       Creates HelloWorld.class (bytecode)
     *    3. Run with java: java HelloWorld
     *       JVM loads .class file
     *       JVM executes bytecode (interprets or JIT compiles)
     *       CPU executes native instructions
     *       Output produced
     *
     * Q7: What is the difference between String args and String[] args?
     * A: String args is a single string parameter.
     *    String[] args is an array of strings.
     *    The JVM specifically expects String[] (array) for the main method.
     *    Using just String args won't work as the program entry point.
     *    String[] allows multiple command-line arguments.
     *
     * Q8: Can we access args if nothing is passed?
     * A: Yes, args will be an empty array (length 0), never null.
     *    So you should always check args.length before accessing elements:
     *    if (args.length > 0) { String first = args[0]; }
     *
     * Q9: What does System.out refer to?
     * A: System is a class in java.lang package.
     *    out is a static PrintStream field of System class.
     *    println() is a method of PrintStream that prints with newline.
     *    So System.out.println() means: class.field.method()
     *
     * Q10: Why is args never null even if no arguments passed?
     * A: The JVM always initializes args as an empty array.
     *     This is by design to prevent NullPointerException.
     *     Empty array: args.length = 0
     *     This allows safe checking: if (args.length > 0)
     *
     * Q11: Can we have multiple main methods?
     * A: Yes, through method overloading. You can have:
     *    public static void main(String[] args) { }  // Entry point
     *    public static void main(String name) { }    // Won't be entry point
     *    public static void main(int x) { }          // Won't be entry point
     *    Only the one with String[] parameter is called by JVM as entry point.
     *
     * Q12: What's the difference between print and println?
     * A: print() outputs without newline
     *    println() outputs with newline (\n)
     *    Example:
     *    System.out.print("A");  // Output: A
     *    System.out.print("B");  // Output: AB
     *    System.out.println("C");// Output: ABC (then newline)
     *    System.out.print("D");  // Output: D (on new line)
     *
     * Q13: How do you pass command-line arguments in IntelliJ?
     * A: Run → Edit Configurations
     *    Find "Program arguments" field
     *    Enter: arg1 arg2 arg3
     *    These will be available as args[0], args[1], args[2]
     *
     * Q14: What is System.getProperty()?
     * A: Returns system properties as strings.
     *    Common properties:
     *    java.version       - JDK version
     *    os.name           - Operating system name
     *    os.version        - OS version
     *    user.name         - Current username
     *    user.dir          - Current working directory
     *    java.home         - JDK installation directory
     *
     * Q15: Can main method be private?
     * A: No, main must be public. The JVM needs to access it from outside
     *    the class, so it must be public. If you make it private, you'll get
     *    runtime error: "Error: Main method is not public."
     */

    // ═════════════════════════════════════════════════════════════════════════════
    // SUMMARY & KEY TAKEAWAYS
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * KEY TAKEAWAYS:
     *
     * 1. STRUCTURE
     *    ✓ Every program has a main() method
     *    ✓ Main is: public static void main(String[] args)
     *    ✓ File name must match public class name
     *
     * 2. EXECUTION
     *    ✓ Source → Bytecode → JVM → Native Code
     *    ✓ Bytecode is platform-independent
     *    ✓ JVM handles the conversion
     *
     * 3. ARGUMENTS
     *    ✓ args is String array from command line
     *    ✓ Never null, always initialized
     *    ✓ Check length before accessing
     *
     * 4. OUTPUT
     *    ✓ System.out.println() - print with newline
     *    ✓ System.out.print() - print without newline
     *    ✓ System.out.printf() - formatted output
     *
     * 5. MEMORY
     *    ✓ Stack: stores primitives and references
     *    ✓ Heap: stores objects
     *    ✓ References point from stack to heap
     *
     * PRACTICE:
     * ✓ Run all 6 examples
     * ✓ Modify examples and see output
     * ✓ Pass different command-line arguments
     * ✓ Add more methods and call them
     * ✓ Try to break the program and fix it
     */
}