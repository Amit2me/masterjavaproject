package com.masterjava.core.fundamentals;

/**
 * LESSON 10: EXCEPTION HANDLING
 * ==============================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand exceptions and error handling
 * 2. Master try-catch-finally blocks
 * 3. Learn checked vs unchecked exceptions
 * 4. Understand exception hierarchy
 * 5. Learn throw and throws keywords
 * 6. Master custom exceptions
 * 7. Understand try-with-resources
 * 8. Learn best practices for exception handling
 * 
 * UNDER THE HOOD (JVM):
 * --------------------
 * EXCEPTION MECHANISM:
 * - When exception occurs, JVM creates exception object
 * - Searches call stack for exception handler
 * - If found, control transfers to catch block
 * - If not found, program terminates
 * - finally block always executes
 * 
 * MEMORY IMPACT:
 * - Exception objects created in Heap
 * - Stack trace captured (performance cost)
 * - finally ensures resource cleanup
 * 
 * EXCEPTION HIERARCHY:
 * Throwable
 *   ├── Error (JVM errors, not recoverable)
 *   │   └── OutOfMemoryError, StackOverflowError
 *   └── Exception
 *       ├── RuntimeException (Unchecked)
 *       │   └── NullPointerException, ArrayIndexOutOfBoundsException
 *       └── Other Exceptions (Checked)
 *           └── IOException, SQLException
 * 
 * @author Master Java Project
 * @version 1.0
 * @since 2024
 */
public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   LESSON 10: EXCEPTION HANDLING       ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: BASIC TRY-CATCH
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. BASIC TRY-CATCH ━━━");
        
        demonstrateBasicTryCatch();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: MULTIPLE CATCH BLOCKS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. MULTIPLE CATCH BLOCKS ━━━");
        
        demonstrateMultipleCatch();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: FINALLY BLOCK
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. FINALLY BLOCK ━━━");
        
        demonstrateFinallyBlock();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: THROW KEYWORD
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. THROW KEYWORD ━━━");
        
        demonstrateThrow();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: THROWS KEYWORD
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. THROWS KEYWORD ━━━");
        
        demonstrateThrows();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: CHECKED VS UNCHECKED EXCEPTIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. CHECKED VS UNCHECKED ━━━");
        
        demonstrateCheckedVsUnchecked();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: CUSTOM EXCEPTIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. CUSTOM EXCEPTIONS ━━━");
        
        demonstrateCustomExceptions();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: TRY-WITH-RESOURCES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. TRY-WITH-RESOURCES ━━━");
        
        demonstrateTryWithResources();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: EXCEPTION CHAINING
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. EXCEPTION CHAINING ━━━");
        
        demonstrateExceptionChaining();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 10: BEST PRACTICES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 10. BEST PRACTICES ━━━");
        
        demonstrateBestPractices();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        ExceptionInterviewQuestions.printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // SECTION DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateBasicTryCatch() {
        try {
            int result = 10 / 0;  // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("  ⚠️ Caught exception: " + e.getMessage());
            System.out.println("  Cannot divide by zero!");
        }
        
        System.out.println("  ✓ Program continues after handling exception");
    }

    private static void demonstrateMultipleCatch() {
        String[] arr = {"10", "20", "abc"};
        
        for (int i = 0; i <= 3; i++) {
            try {
                int num = Integer.parseInt(arr[i]);
                int result = 100 / num;
                System.out.println("  Result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("  ⚠️ Index out of bounds: " + i);
            } catch (NumberFormatException e) {
                System.out.println("  ⚠️ Invalid number format: " + arr[i]);
            } catch (ArithmeticException e) {
                System.out.println("  ⚠️ Arithmetic error: " + e.getMessage());
            }
        }
    }

    private static void demonstrateFinallyBlock() {
        try {
            System.out.println("  Executing try block");
            int result = 10 / 2;
            System.out.println("  Result: " + result);
        } catch (Exception e) {
            System.out.println("  Executing catch block");
        } finally {
            System.out.println("  ✓ Finally block always executes");
        }
        
        System.out.println();
        
        // Finally executes even if exception occurs
        try {
            System.out.println("  Trying division by zero");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("  ⚠️ Caught exception");
        } finally {
            System.out.println("  ✓ Finally still executes");
        }
    }

    private static void demonstrateThrow() {
        try {
            validateAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("  ⚠️ Validation failed: " + e.getMessage());
        }
        
        try {
            validateAge(25);
            System.out.println("  ✓ Age validated successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("  ⚠️ Validation failed: " + e.getMessage());
        }
    }

    private static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
    }

    private static void demonstrateThrows() {
        try {
            riskyMethod();
        } catch (Exception e) {
            System.out.println("  ⚠️ Handled checked exception: " + e.getMessage());
        }
    }

    private static void riskyMethod() throws Exception {
        System.out.println("  Method that declares checked exception");
        throw new Exception("Something went wrong");
    }

    private static void demonstrateCheckedVsUnchecked() {
        // Unchecked - Runtime Exception (no compile-time check)
        System.out.println("Unchecked Exception (RuntimeException):");
        try {
            String str = null;
            System.out.println(str.length());  // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("  ⚠️ NullPointerException caught");
        }
        
        System.out.println();
        
        // Checked - Compile-time check required
        System.out.println("Checked Exception:");
        try {
            Thread.sleep(100);  // InterruptedException (checked)
            System.out.println("  ✓ Sleep completed");
        } catch (InterruptedException e) {
            System.out.println("  ⚠️ InterruptedException caught");
        }
    }

    private static void demonstrateCustomExceptions() {
        BankAccountDemo account = new BankAccountDemo(1000);
        
        try {
            account.withdraw(500);
            System.out.println("  ✓ Withdrawal successful");
        } catch (InsufficientFundsException e) {
            System.out.println("  ⚠️ " + e.getMessage());
        }
        
        try {
            account.withdraw(600);
        } catch (InsufficientFundsException e) {
            System.out.println("  ⚠️ " + e.getMessage());
            System.out.println("  Available: $" + e.getAvailableBalance());
            System.out.println("  Requested: $" + e.getRequestedAmount());
        }
    }

    private static void demonstrateTryWithResources() {
        // Try-with-resources automatically closes resources
        System.out.println("Using try-with-resources:");
        try (MyResource resource = new MyResource()) {
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("  ⚠️ Exception: " + e.getMessage());
        }
        System.out.println("  ✓ Resource automatically closed");
    }

    private static void demonstrateExceptionChaining() {
        try {
            performDatabaseOperation();
        } catch (DataAccessException e) {
            System.out.println("  ⚠️ Exception: " + e.getMessage());
            System.out.println("  Cause: " + e.getCause().getMessage());
        }
    }

    private static void performDatabaseOperation() throws DataAccessException {
        try {
            // Simulate database error
            throw new RuntimeException("Connection timeout");
        } catch (RuntimeException e) {
            // Wrap and rethrow with more context
            throw new DataAccessException("Failed to access database", e);
        }
    }

    private static void demonstrateBestPractices() {
        System.out.println("✓ Catch specific exceptions first");
        System.out.println("✓ Don't catch Exception/Throwable unless necessary");
        System.out.println("✓ Always log exceptions");
        System.out.println("✓ Clean up resources in finally or use try-with-resources");
        System.out.println("✓ Don't suppress exceptions without good reason");
        System.out.println("✓ Use custom exceptions for business logic errors");
        System.out.println("✓ Document exceptions with @throws in Javadoc");
    }
}

// ═══════════════════════════════════════════════════════════
// CUSTOM EXCEPTIONS
// ═══════════════════════════════════════════════════════════

/**
 * Custom checked exception for insufficient funds
 */
class InsufficientFundsException extends Exception {
    private double availableBalance;
    private double requestedAmount;
    
    public InsufficientFundsException(String message, double available, double requested) {
        super(message);
        this.availableBalance = available;
        this.requestedAmount = requested;
    }
    
    public double getAvailableBalance() {
        return availableBalance;
    }
    
    public double getRequestedAmount() {
        return requestedAmount;
    }
}

class BankAccountDemo {
    private double balance;
    
    public BankAccountDemo(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds for withdrawal",
                balance,
                amount
            );
        }
        balance -= amount;
    }
    
    public double getBalance() {
        return balance;
    }
}

/**
 * Custom unchecked exception for data access
 */
class DataAccessException extends RuntimeException {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

// ═══════════════════════════════════════════════════════════
// TRY-WITH-RESOURCES EXAMPLE
// ═══════════════════════════════════════════════════════════

class MyResource implements AutoCloseable {
    
    public MyResource() {
        System.out.println("  → Resource opened");
    }
    
    public void doSomething() {
        System.out.println("  → Using resource");
    }
    
    @Override
    public void close() {
        System.out.println("  → Resource closed (auto)");
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class ExceptionInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║     INTERVIEW QUESTIONS - EXCEPTION HANDLING           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. What is an exception?",
                "ANSWER: Event that disrupts normal program flow",
                "  Types:",
                "  - Error: JVM errors (OutOfMemoryError, StackOverflowError)",
                "  - Exception: Recoverable conditions",
                "  When exception occurs:",
                "  1. JVM creates exception object",
                "  2. Searches for handler in call stack",
                "  3. If found, control transfers to catch",
                "  4. If not found, program terminates"
            },
            {
                "2. Difference between checked and unchecked exceptions?",
                "ANSWER:",
                "  Checked (Compile-time):",
                "  - Must be caught or declared with throws",
                "  - Compiler enforces handling",
                "  - Extend Exception (not RuntimeException)",
                "  - Examples: IOException, SQLException",
                "  - Use: Recoverable conditions",
                "  Unchecked (Runtime):",
                "  - No compile-time check",
                "  - Extend RuntimeException",
                "  - Examples: NullPointerException, ArrayIndexOutOfBoundsException",
                "  - Use: Programming errors"
            },
            {
                "3. Difference between throw and throws?",
                "ANSWER:",
                "  throw:",
                "  - Used to explicitly throw exception",
                "  - Inside method body",
                "  - Followed by exception object",
                "  - Example: throw new Exception();",
                "  throws:",
                "  - Used in method signature",
                "  - Declares method might throw exception",
                "  - Followed by exception class",
                "  - Example: void method() throws IOException"
            },
            {
                "4. Can we have try without catch?",
                "ANSWER: Yes, with finally",
                "  Valid combinations:",
                "  - try-catch",
                "  - try-finally",
                "  - try-catch-finally",
                "  - try-with-resources (Java 7+)",
                "  Invalid:",
                "  - try alone (must have catch or finally)"
            },
            {
                "5. Can we have multiple catch blocks?",
                "ANSWER: Yes, for handling different exceptions",
                "  Rules:",
                "  - Specific exceptions first, generic last",
                "  - Child before parent (or compile error)",
                "  Example:",
                "    try { }",
                "    catch (FileNotFoundException e) { }  // Specific",
                "    catch (IOException e) { }            // General",
                "    catch (Exception e) { }              // Most general"
            },
            {
                "6. When does finally block not execute?",
                "ANSWER: In rare cases:",
                "  1. System.exit() called",
                "  2. JVM crash",
                "  3. Daemon thread terminated",
                "  4. Infinite loop in try/catch",
                "  5. Thread interrupted",
                "  Otherwise, finally ALWAYS executes",
                "  Even if: return, break, continue, exception thrown"
            },
            {
                "7. Can we have return statement in finally?",
                "ANSWER: Yes, but NOT recommended",
                "  Problem:",
                "  - Overrides return from try/catch",
                "  - Suppresses exceptions",
                "  - Confusing behavior",
                "  Example:",
                "    try { return 1; }",
                "    finally { return 2; }  // Returns 2 (not 1!)",
                "  Best practice: Avoid return in finally"
            },
            {
                "8. What is try-with-resources?",
                "ANSWER: Automatic resource management (Java 7+)",
                "  Syntax:",
                "    try (Resource r = new Resource()) {",
                "        // Use resource",
                "    } // Automatically closed",
                "  Benefits:",
                "  - No need for finally",
                "  - Resources closed automatically",
                "  - Cleaner code",
                "  Requirement: Resource must implement AutoCloseable"
            },
            {
                "9. Can we catch multiple exceptions in single catch?",
                "ANSWER: Yes, multi-catch (Java 7+)",
                "  Syntax:",
                "    catch (IOException | SQLException e) { }",
                "  Rules:",
                "  - Exceptions separated by |",
                "  - Cannot be related (parent-child)",
                "  - Variable is final",
                "  Benefits: Reduces code duplication"
            },
            {
                "10. What is exception chaining?",
                "ANSWER: Wrapping one exception in another",
                "  Purpose:",
                "  - Preserve original cause",
                "  - Add context",
                "  - Convert exception type",
                "  Example:",
                "    try {",
                "        // Low-level operation",
                "    } catch (LowLevelException e) {",
                "        throw new HighLevelException(\"Context\", e);",
                "    }",
                "  Access: getCause() method"
            },
            {
                "11. Difference between final, finally, and finalize?",
                "ANSWER:",
                "  final:",
                "  - Keyword for constants, immutability",
                "  - final variable, method, class",
                "  finally:",
                "  - Block in try-catch for cleanup",
                "  - Always executes",
                "  finalize:",
                "  - Method called before GC (deprecated)",
                "  - Don't use, use try-with-resources instead"
            },
            {
                "12. Can constructor throw exception?",
                "ANSWER: Yes, both checked and unchecked",
                "  Example:",
                "    public MyClass() throws IOException {",
                "        // Can throw exception",
                "    }",
                "  Note:",
                "  - If constructor throws, object not created",
                "  - Good for validation",
                "  - Caller must handle"
            },
            {
                "13. What is the base class of all exceptions?",
                "ANSWER: Throwable",
                "  Hierarchy:",
                "  Throwable",
                "    ├── Error (not to be caught)",
                "    └── Exception",
                "        ├── RuntimeException (unchecked)",
                "        └── Other (checked)",
                "  Common methods:",
                "  - getMessage()",
                "  - printStackTrace()",
                "  - getCause()"
            },
            {
                "14. Should we catch Error class?",
                "ANSWER: No, generally should not catch Error",
                "  Reason:",
                "  - Errors are serious JVM issues",
                "  - Usually not recoverable",
                "  - Examples: OutOfMemoryError, StackOverflowError",
                "  Exception: Logging/monitoring tools may catch",
                "  Rule: Catch Exception, not Throwable or Error"
            },
            {
                "15. What is NullPointerException? How to avoid?",
                "ANSWER: Trying to use null reference",
                "  Common causes:",
                "  - null.method()",
                "  - null.field",
                "  - null array access",
                "  Prevention:",
                "  1. Null checks: if (obj != null)",
                "  2. Objects.requireNonNull()",
                "  3. Optional class (Java 8+)",
                "  4. @NonNull annotations",
                "  5. Defensive programming"
            },
            {
                "16. How to create custom exception?",
                "ANSWER: Extend Exception or RuntimeException",
                "  Checked:",
                "    class MyException extends Exception {",
                "        public MyException(String msg) {",
                "            super(msg);",
                "        }",
                "    }",
                "  Unchecked:",
                "    class MyException extends RuntimeException { }",
                "  Best practices:",
                "  - Meaningful name",
                "  - Provide constructors",
                "  - Add custom fields if needed"
            },
            {
                "17. Can finally block throw exception?",
                "ANSWER: Yes, but dangerous",
                "  Problem:",
                "  - Suppresses exception from try/catch",
                "  - Confusing error handling",
                "  - Original exception lost",
                "  Example:",
                "    try { throw new Exception(\"A\"); }",
                "    finally { throw new Exception(\"B\"); }",
                "    // Only \"B\" is thrown, \"A\" is lost",
                "  Best practice: Don't throw from finally"
            },
            {
                "18. What is suppressed exception?",
                "ANSWER: Exception suppressed by another exception",
                "  Occurs when:",
                "  - Exception in try-with-resources close",
                "  - Exception in finally",
                "  Access: getSuppressed() method",
                "  Example:",
                "    try (Resource r = new Resource()) {",
                "        throw new Exception(\"Main\");",
                "    } // If close() throws, it's suppressed"
            },
            {
                "19. Best practices for exception handling?",
                "ANSWER:",
                "  DO:",
                "  - Catch specific exceptions",
                "  - Log exceptions",
                "  - Clean up resources",
                "  - Use try-with-resources",
                "  - Provide meaningful messages",
                "  DON'T:",
                "  - Catch Exception/Throwable unnecessarily",
                "  - Suppress exceptions silently",
                "  - Use exceptions for flow control",
                "  - Return in finally",
                "  - Catch and ignore"
            },
            {
                "20. When to use checked vs unchecked exceptions?",
                "ANSWER:",
                "  Checked:",
                "  - Recoverable conditions",
                "  - External resources (files, network)",
                "  - Caller can handle",
                "  - Example: FileNotFoundException",
                "  Unchecked:",
                "  - Programming errors",
                "  - Should be fixed, not caught",
                "  - Validation failures",
                "  - Example: IllegalArgumentException",
                "  Modern trend: Prefer unchecked for cleaner code"
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
        System.out.println("✓ Checked exceptions: compile-time check, must handle");
        System.out.println("✓ Unchecked exceptions: runtime, programming errors");
        System.out.println("✓ finally always executes (except System.exit())");
        System.out.println("✓ throw: explicitly throw, throws: declare in signature");
        System.out.println("✓ Try-with-resources for automatic cleanup");
        System.out.println("✓ Catch specific exceptions first, generic last");
        System.out.println("✓ Don't suppress exceptions without good reason");
        System.out.println("✓ Use custom exceptions for business logic");
        System.out.println();
    }
}
