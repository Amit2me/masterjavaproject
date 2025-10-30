package com.masterjava.core.fundamentals;

/**
 * LESSON 4: METHODS AND FUNCTIONS
 * =================================
 *
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand method declaration and invocation
 * 2. Master parameter passing (pass by value)
 * 3. Learn method overloading
 * 4. Understand return types and void methods
 * 5. Explore variable arguments (varargs)
 * 6. Learn static vs instance methods
 * 7. Understand method call stack
 * 8. Master recursion
 *
 * UNDER THE HOOD (JVM):
 * --------------------
 * - Methods are stored in Method Area (Metaspace in Java 8+)
 * - Method invocations use the Stack (frames pushed/popped)
 * - Each method call creates a Stack Frame containing:
 *   * Local variables
 *   * Operand stack
 *   * Frame data (return address, exception info)
 * - Static methods: invokestatic bytecode
 * - Instance methods: invokevirtual (dynamic dispatch)
 * - Pass by value: primitives copy value, objects copy reference value
 *
 * MEMORY LAYOUT EXAMPLE:
 * ---------------------
 * Stack:
 *   main() frame
 *     ├── calculate(5, 3) frame [pushed]
 *     │   ├── local var: a = 5
 *     │   ├── local var: b = 3
 *     │   └── return value: 8
 *     └── [frame popped after return]
 *
 * @author Master Java Project
 * @version 1.0
 * @since 2024
 */
public class MethodsDemo {

    // Instance variable for demonstration
    private int instanceValue = 100;

    // Static variable for demonstration
    private static int staticCounter = 0;

    /**
     * Main method - Entry point of the program
     */
    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   LESSON 4: METHODS AND FUNCTIONS     ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Create instance for non-static method calls
        MethodsDemo demo = new MethodsDemo();

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: BASIC METHOD DECLARATION AND INVOCATION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. BASIC METHODS ━━━");

        demo.greet();
        demo.greetWithName("Alice");

        int sum = demo.add(10, 20);
        System.out.println("Sum: " + sum);

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: RETURN TYPES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. RETURN TYPES ━━━");

        // void - no return
        demo.printMessage("Hello World");

        // primitive return
        int result = demo.multiply(5, 6);
        System.out.println("Multiply result: " + result);

        // object return
        String reversed = demo.reverseString("Java");
        System.out.println("Reversed string: " + reversed);

        // array return
        int[] squares = demo.getSquares(5);
        System.out.print("Squares: ");
        for (int square : squares) {
            System.out.print(square + " ");
        }
        System.out.println("\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: METHOD OVERLOADING (COMPILE-TIME POLYMORPHISM)
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. METHOD OVERLOADING ━━━");

        System.out.println("Calculate(5, 3): " + demo.calculate(5, 3));
        System.out.println("Calculate(5.5, 3.2): " + demo.calculate(5.5, 3.2));
        System.out.println("Calculate(2, 3, 4): " + demo.calculate(2, 3, 4));
        System.out.println("Calculate(\"10\", \"20\"): " + demo.calculate("10", "20"));

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: PASS BY VALUE DEMONSTRATION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. PASS BY VALUE ━━━");

        // Primitive - value is copied
        int original = 10;
        demo.modifyPrimitive(original);
        System.out.println("Original primitive after method: " + original); // Still 10

        // Object - reference value is copied (both point to same object)
        int[] array = {1, 2, 3};
        demo.modifyArray(array);
        System.out.print("Original array after method: ");
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println(); // Array is modified!

        // String - immutable, so appears like pass by value
        String text = "Hello";
        demo.modifyString(text);
        System.out.println("Original string after method: " + text); // Still "Hello"

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: VARIABLE ARGUMENTS (VARARGS)
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. VARIABLE ARGUMENTS (VARARGS) ━━━");

        System.out.println("Sum of 1, 2, 3: " + demo.sumAll(1, 2, 3));
        System.out.println("Sum of 10, 20, 30, 40, 50: " + demo.sumAll(10, 20, 30, 40, 50));
        System.out.println("Sum of no arguments: " + demo.sumAll());

        demo.printWithLabel("Numbers", 1, 2, 3, 4, 5);

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: STATIC VS INSTANCE METHODS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. STATIC VS INSTANCE METHODS ━━━");

        // Static method - called on class
        int max = MethodsDemo.findMax(15, 25);
        System.out.println("Max (static method): " + max);

        // Instance method - needs object
        demo.displayInstanceValue();

        // Static method can be called on instance (but not recommended)
        demo.incrementCounter();
        System.out.println("Counter: " + MethodsDemo.staticCounter);

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: RECURSION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. RECURSION ━━━");

        System.out.println("Factorial of 5: " + demo.factorial(5));
        System.out.println("Fibonacci of 7: " + demo.fibonacci(7));
        System.out.println("Sum 1 to 10: " + demo.sumRecursive(10));

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: METHOD CALL STACK VISUALIZATION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. CALL STACK VISUALIZATION ━━━");

        demo.methodA();

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: COMMON PATTERNS AND BEST PRACTICES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. BEST PRACTICES ━━━");

        // Single Responsibility
        boolean isValid = demo.validateEmail("user@example.com");
        System.out.println("Email valid: " + isValid);

        // Defensive copying
        int[] data = {1, 2, 3};
        int[] copy = demo.getDefensiveCopy(data);
        data[0] = 999; // Original modified
        System.out.println("Copy still safe: " + copy[0]); // Copy unchanged

        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // METHOD IMPLEMENTATIONS
    // ═══════════════════════════════════════════════════════════

    /**
     * Simple greeting method - void return type
     */
    public void greet() {
        System.out.println("Hello!");
    }

    /**
     * Greeting with parameter
     */
    public void greetWithName(String name) {
        System.out.println("Hello, " + name + "!");
    }

    /**
     * Method with return value
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Void method example
     */
    public void printMessage(String message) {
        System.out.println("Message: " + message);
    }

    /**
     * Primitive return type
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Object return type
     */
    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Array return type
     */
    public int[] getSquares(int count) {
        int[] squares = new int[count];
        for (int i = 0; i < count; i++) {
            squares[i] = (i + 1) * (i + 1);
        }
        return squares;
    }

    // ═══════════════════════════════════════════════════════════
    // METHOD OVERLOADING EXAMPLES
    // ═══════════════════════════════════════════════════════════

    /**
     * Calculate - int parameters
     */
    public int calculate(int a, int b) {
        System.out.println("  → Using int version");
        return a + b;
    }

    /**
     * Calculate - double parameters (different type)
     */
    public double calculate(double a, double b) {
        System.out.println("  → Using double version");
        return a + b;
    }

    /**
     * Calculate - three parameters (different number)
     */
    public int calculate(int a, int b, int c) {
        System.out.println("  → Using three parameter version");
        return a + b + c;
    }

    /**
     * Calculate - String parameters (different type)
     */
    public int calculate(String a, String b) {
        System.out.println("  → Using String version");
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    // ═══════════════════════════════════════════════════════════
    // PASS BY VALUE DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    /**
     * Attempting to modify primitive (won't affect original)
     */
    public void modifyPrimitive(int value) {
        value = 999;
        System.out.println("  Inside method: " + value);
    }

    /**
     * Modifying array content (will affect original)
     */
    public void modifyArray(int[] arr) {
        arr[0] = 999;
        System.out.println("  Inside method, first element: " + arr[0]);
    }

    /**
     * Attempting to modify String (won't affect original - immutable)
     */
    public void modifyString(String str) {
        str = "Modified";
        System.out.println("  Inside method: " + str);
    }

    // ═══════════════════════════════════════════════════════════
    // VARIABLE ARGUMENTS (VARARGS)
    // ═══════════════════════════════════════════════════════════

    /**
     * Varargs - accepts any number of integers
     */
    public int sumAll(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    /**
     * Varargs with other parameters (varargs must be last)
     */
    public void printWithLabel(String label, int... numbers) {
        System.out.print(label + ": ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // ═══════════════════════════════════════════════════════════
    // STATIC VS INSTANCE METHODS
    // ═══════════════════════════════════════════════════════════

    /**
     * Static method - belongs to class
     */
    public static int findMax(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * Instance method - needs object instance
     */
    public void displayInstanceValue() {
        System.out.println("Instance value: " + this.instanceValue);
    }

    /**
     * Static method modifying static variable
     */
    public static void incrementCounter() {
        staticCounter++;
    }

    // ═══════════════════════════════════════════════════════════
    // RECURSION EXAMPLES
    // ═══════════════════════════════════════════════════════════

    /**
     * Factorial using recursion
     * 5! = 5 * 4 * 3 * 2 * 1 = 120
     */
    public int factorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }

    /**
     * Fibonacci using recursion
     * F(n) = F(n-1) + F(n-2)
     */
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Sum from 1 to n using recursion
     */
    public int sumRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumRecursive(n - 1);
    }

    // ═══════════════════════════════════════════════════════════
    // CALL STACK VISUALIZATION
    // ═══════════════════════════════════════════════════════════

    public void methodA() {
        System.out.println("  Entering methodA");
        methodB();
        System.out.println("  Exiting methodA");
    }

    public void methodB() {
        System.out.println("    Entering methodB");
        methodC();
        System.out.println("    Exiting methodB");
    }

    public void methodC() {
        System.out.println("      Entering methodC");
        System.out.println("      Exiting methodC");
    }

    // ═══════════════════════════════════════════════════════════
    // BEST PRACTICES
    // ═══════════════════════════════════════════════════════════

    /**
     * Single Responsibility - method does one thing well
     */
    public boolean validateEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    /**
     * Defensive copying - return copy to prevent external modification
     */
    public int[] getDefensiveCopy(int[] original) {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }

    // ═══════════════════════════════════════════════════════════
    // INTERVIEW QUESTIONS
    // ═══════════════════════════════════════════════════════════

    /**
     * Print common interview questions about methods
     */
    private static void printInterviewQuestions() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          INTERVIEW QUESTIONS - METHODS                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
                {
                        "1. Is Java pass-by-value or pass-by-reference?",
                        "ANSWER: Java is ALWAYS pass-by-value.",
                        "  - For primitives: The actual value is copied",
                        "  - For objects: The reference VALUE is copied (not the object itself)",
                        "  - Both variables point to same object, but are different references",
                        "  - You can't change what the original reference points to"
                },
                {
                        "2. What is method overloading? What are the rules?",
                        "ANSWER: Same method name, different parameters (compile-time polymorphism)",
                        "  Rules:",
                        "  - Must have different parameter list (number, type, or order)",
                        "  - Return type alone is NOT sufficient",
                        "  - Access modifier can be different",
                        "  - Can throw different exceptions",
                        "  Example: calculate(int, int) vs calculate(double, double)"
                },
                {
                        "3. Can we overload main method?",
                        "ANSWER: Yes, but JVM only calls main(String[] args)",
                        "  - You can have: main(int x), main(String x), etc.",
                        "  - These won't be entry points",
                        "  - Only public static void main(String[]) is the entry point"
                },
                {
                        "4. What is a varargs method? What are the rules?",
                        "ANSWER: Variable number of arguments using Type...",
                        "  Rules:",
                        "  - Varargs must be last parameter: method(String label, int... nums)",
                        "  - Only one varargs per method",
                        "  - Treated as array inside method",
                        "  - Can pass 0 or more arguments",
                        "  Example: sumAll(int... numbers)"
                },
                {
                        "5. Difference between static and instance methods?",
                        "ANSWER:",
                        "  Static Method:",
                        "  - Belongs to class, not instance",
                        "  - Called using ClassName.methodName()",
                        "  - Can't access instance variables/methods directly",
                        "  - Loaded when class is loaded",
                        "  Instance Method:",
                        "  - Belongs to object instance",
                        "  - Called using objectReference.methodName()",
                        "  - Can access both static and instance members",
                        "  - Created when object is created"
                },
                {
                        "6. What happens in memory during method invocation?",
                        "ANSWER: Stack frame is created:",
                        "  1. New frame pushed onto call stack",
                        "  2. Frame contains: local variables, parameters, return address",
                        "  3. Method executes using its frame",
                        "  4. Return value (if any) passed back",
                        "  5. Frame popped from stack",
                        "  6. Control returns to calling method"
                },
                {
                        "7. What is tail recursion?",
                        "ANSWER: Recursive call is the last operation",
                        "  - Can be optimized by compiler (tail call optimization)",
                        "  - Java doesn't optimize tail recursion (JVM limitation)",
                        "  - Better to use iteration for performance in Java",
                        "  Example: factorial(n, accumulator) vs factorial(n) * n"
                },
                {
                        "8. Can a method return multiple values?",
                        "ANSWER: Not directly, but workarounds exist:",
                        "  1. Return array: return new int[]{value1, value2}",
                        "  2. Return Collection: return List.of(value1, value2)",
                        "  3. Return custom object/record",
                        "  4. Use out parameters (not recommended in Java)",
                        "  5. Java 16+: Use Records for clean multi-value return"
                },
                {
                        "9. What is method hiding vs method overriding?",
                        "ANSWER:",
                        "  Method Hiding (static methods):",
                        "  - Resolved at compile time",
                        "  - Based on reference type",
                        "  Method Overriding (instance methods):",
                        "  - Resolved at runtime (dynamic dispatch)",
                        "  - Based on actual object type",
                        "  Note: Static methods can't be overridden, only hidden"
                },
                {
                        "10. What causes StackOverflowError?",
                        "ANSWER: Stack memory exhaustion, commonly from:",
                        "  - Infinite recursion (no base case or wrong condition)",
                        "  - Too deep recursion (even with base case)",
                        "  - Each method call adds frame to stack",
                        "  - Default stack size varies by JVM",
                        "  - Can increase with -Xss flag, but better to fix the logic"
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
        System.out.println("✓ Java is ALWAYS pass-by-value (including object references)");
        System.out.println("✓ Method overloading = same name, different parameters");
        System.out.println("✓ Each method call creates a stack frame");
        System.out.println("✓ Static methods belong to class, instance methods to object");
        System.out.println("✓ Recursion needs a base case to prevent StackOverflowError");
        System.out.println("✓ Varargs must be the last parameter");
        System.out.println("✓ Return type alone can't differentiate overloaded methods");
        System.out.println();
    }
}