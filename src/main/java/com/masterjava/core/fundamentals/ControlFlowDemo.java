package com.masterjava.core.fundamentals;

/**
 * CONTROL FLOW STATEMENTS IN JAVA
 * ================================
 *
 * Comprehensive guide to controlling program execution flow:
 * - Decision Making: if, if-else, if-else-if, nested if
 * - Switch Statements: traditional and enhanced (Java 14+)
 * - Loops: for, while, do-while, enhanced for-each
 * - Jump Statements: break, continue, return
 * - Labeled Statements
 *
 * UNDER THE HOOD:
 * - How JVM handles conditional branching
 * - Switch statement compilation (tableswitch vs lookupswitch)
 * - Loop optimization by JIT compiler
 * - Stack frame management in nested structures
 *
 * INTERVIEW TOPICS:
 * - Switch vs if-else performance
 * - Enhanced switch expressions (Java 14+)
 * - Difference between break and continue
 * - Infinite loop scenarios
 * - Label usage and best practices
 *
 * @author Master Java Project
 * @version 1.0
 */
public class ControlFlowDemo {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("CONTROL FLOW STATEMENTS - COMPREHENSIVE DEMONSTRATION");
        System.out.println("=".repeat(70));

        demonstrateIfStatement();
        demonstrateIfElseStatement();
        demonstrateNestedIf();
        demonstrateTernaryVsIf();
        demonstrateTraditionalSwitch();
        demonstrateEnhancedSwitch();
        demonstrateSwitchExpressions();
        demonstrateForLoop();
        demonstrateWhileLoop();
        demonstrateDoWhileLoop();
        demonstrateEnhancedForLoop();
        demonstrateBreakStatement();
        demonstrateContinueStatement();
        demonstrateLabeledStatements();
        demonstrateAdvancedPatterns();
    }

    /**
     * IF STATEMENT
     * Basic conditional execution
     */
    private static void demonstrateIfStatement() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("1. IF STATEMENT");
        System.out.println("=".repeat(70));

        int age = 20;
        System.out.println("Age: " + age);

        if (age >= 18) {
            System.out.println("✓ You are eligible to vote");
        }

        // Single statement without braces (not recommended)
        if (age >= 21)
            System.out.println("✓ You can drink in the US");

        System.out.println("\n⚠️  BEST PRACTICE: Always use braces, even for single statements!");
        System.out.println("   Prevents bugs when adding more statements later.");
    }

    /**
     * IF-ELSE STATEMENT
     * Binary decision making
     */
    private static void demonstrateIfElseStatement() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("2. IF-ELSE STATEMENT");
        System.out.println("=".repeat(70));

        int number = 15;
        System.out.println("Number: " + number);

        if (number % 2 == 0) {
            System.out.println("Result: EVEN number");
        } else {
            System.out.println("Result: ODD number");
        }

        // If-else-if ladder
        System.out.println("\n📊 IF-ELSE-IF LADDER (Grade Calculator):");
        int marks = 87;
        System.out.println("Marks: " + marks);

        if (marks >= 90) {
            System.out.println("Grade: A+ (Excellent!)");
        } else if (marks >= 80) {
            System.out.println("Grade: A (Very Good)");
        } else if (marks >= 70) {
            System.out.println("Grade: B (Good)");
        } else if (marks >= 60) {
            System.out.println("Grade: C (Average)");
        } else if (marks >= 50) {
            System.out.println("Grade: D (Pass)");
        } else {
            System.out.println("Grade: F (Fail)");
        }
    }

    /**
     * NESTED IF STATEMENTS
     * Conditions within conditions
     */
    private static void demonstrateNestedIf() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("3. NESTED IF STATEMENTS");
        System.out.println("=".repeat(70));

        int age = 25;
        boolean hasLicense = true;
        boolean hasInsurance = true;

        System.out.println("Age: " + age);
        System.out.println("Has License: " + hasLicense);
        System.out.println("Has Insurance: " + hasInsurance);
        System.out.println();

        if (age >= 18) {
            System.out.println("✓ Age requirement met");

            if (hasLicense) {
                System.out.println("✓ License verified");

                if (hasInsurance) {
                    System.out.println("✓ Insurance verified");
                    System.out.println("🎉 APPROVED: You can rent the car!");
                } else {
                    System.out.println("✗ DENIED: Insurance required");
                }
            } else {
                System.out.println("✗ DENIED: Valid license required");
            }
        } else {
            System.out.println("✗ DENIED: Must be 18 or older");
        }

        // Better alternative: combine conditions
        System.out.println("\n💡 BETTER APPROACH - Combine conditions:");
        if (age >= 18 && hasLicense && hasInsurance) {
            System.out.println("🎉 APPROVED: You can rent the car!");
        } else {
            System.out.println("✗ DENIED: Requirements not met");
        }
    }

    /**
     * TERNARY VS IF-ELSE
     * When to use each
     */
    private static void demonstrateTernaryVsIf() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("4. TERNARY OPERATOR VS IF-ELSE");
        System.out.println("=".repeat(70));

        int a = 10, b = 20;

        // Using if-else
        System.out.println("Using if-else:");
        int max1;
        if (a > b) {
            max1 = a;
        } else {
            max1 = b;
        }
        System.out.println("  Maximum: " + max1);

        // Using ternary
        System.out.println("\nUsing ternary operator:");
        int max2 = (a > b) ? a : b;
        System.out.println("  Maximum: " + max2);

        System.out.println("\n✅ USE TERNARY WHEN:");
        System.out.println("   - Simple value assignment");
        System.out.println("   - Single expression in each branch");
        System.out.println("   - Makes code more concise and readable");

        System.out.println("\n✅ USE IF-ELSE WHEN:");
        System.out.println("   - Multiple statements in branches");
        System.out.println("   - Complex logic");
        System.out.println("   - Better readability needed");
    }

    /**
     * TRADITIONAL SWITCH STATEMENT
     * Multi-way branching
     */
    private static void demonstrateTraditionalSwitch() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("5. TRADITIONAL SWITCH STATEMENT");
        System.out.println("=".repeat(70));

        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }

        System.out.println("Day " + day + " is: " + dayName);

        // Fall-through behavior
        System.out.println("\n📉 FALL-THROUGH BEHAVIOR:");
        int month = 2;
        int year = 2024;
        int days;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = (year % 4 == 0) ? 29 : 28;
                break;
            default:
                days = 0;
        }

        System.out.println("Month " + month + " of year " + year + " has " + days + " days");

        // String switch (Java 7+)
        System.out.println("\n🔤 STRING SWITCH (Java 7+):");
        String grade = "A";

        switch (grade) {
            case "A":
                System.out.println("Excellent!");
                break;
            case "B":
                System.out.println("Very Good");
                break;
            case "C":
                System.out.println("Good");
                break;
            default:
                System.out.println("Need Improvement");
        }
    }

    /**
     * ENHANCED SWITCH STATEMENT (Java 12+)
     * Arrow syntax without fall-through
     */
    private static void demonstrateEnhancedSwitch() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("6. ENHANCED SWITCH (Java 12+) - Arrow Syntax");
        System.out.println("=".repeat(70));

        int day = 5;
        String dayType;

        // Enhanced switch with arrow syntax (no break needed!)
        switch (day) {
            case 1, 2, 3, 4, 5 -> dayType = "Weekday";
            case 6, 7 -> dayType = "Weekend";
            default -> dayType = "Invalid";
        }

        System.out.println("Day " + day + " is a: " + dayType);

        // Multiple statements with arrow syntax
        System.out.println("\n📝 MULTIPLE STATEMENTS:");
        String month = "March";

        switch (month) {
            case "December", "January", "February" -> {
                System.out.println("  Season: Winter");
                System.out.println("  Temperature: Cold ❄️");
            }
            case "March", "April", "May" -> {
                System.out.println("  Season: Spring");
                System.out.println("  Temperature: Mild 🌸");
            }
            case "June", "July", "August" -> {
                System.out.println("  Season: Summer");
                System.out.println("  Temperature: Hot ☀️");
            }
            case "September", "October", "November" -> {
                System.out.println("  Season: Autumn");
                System.out.println("  Temperature: Cool 🍂");
            }
            default -> System.out.println("  Invalid month");
        }
    }

    /**
     * SWITCH EXPRESSIONS (Java 14+)
     * Switch that returns a value
     */
    private static void demonstrateSwitchExpressions() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("7. SWITCH EXPRESSIONS (Java 14+)");
        System.out.println("=".repeat(70));

        int dayNum = 3;

        // Switch expression - assigns value directly
        String dayName = switch (dayNum) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };

        System.out.println("Day " + dayNum + " is: " + dayName);

        // Complex expression with yield
        System.out.println("\n🎯 USING YIELD FOR COMPLEX LOGIC:");
        int score = 85;

        String feedback = switch (score / 10) {
            case 10, 9 -> "Outstanding! Keep it up!";
            case 8 -> "Excellent work!";
            case 7 -> "Good job!";
            case 6 -> {
                String msg = "Passed, but ";
                msg += "there's room for improvement";
                yield msg;  // Use yield for multi-statement blocks
            }
            default -> {
                if (score < 0 || score > 100) {
                    yield "Invalid score";
                }
                yield "Need to work harder";
            }
        };

        System.out.println("Score: " + score);
        System.out.println("Feedback: " + feedback);

        System.out.println("\n✨ BENEFITS OF SWITCH EXPRESSIONS:");
        System.out.println("   ✓ More concise code");
        System.out.println("   ✓ No break statements needed");
        System.out.println("   ✓ Exhaustiveness checking");
        System.out.println("   ✓ Can be used anywhere an expression is expected");
    }

    /**
     * FOR LOOP
     * Counter-controlled iteration
     */
    private static void demonstrateForLoop() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("8. FOR LOOP");
        System.out.println("=".repeat(70));

        // Basic for loop
        System.out.println("Counting 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Reverse loop
        System.out.println("\nCounting 5 to 1:");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Step by 2
        System.out.println("\nEven numbers 0 to 10:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Multiple variables
        System.out.println("\n🔢 MULTIPLE VARIABLES IN FOR LOOP:");
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("  i = " + i + ", j = " + j);
        }

        // Nested loops
        System.out.println("\n📊 NESTED LOOPS (Multiplication Table):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        // Infinite loop
        System.out.println("\n⚠️  INFINITE LOOP EXAMPLES:");
        System.out.println("   for(;;) { }           // All parts optional");
        System.out.println("   for(int i=0; ; i++) { }  // Missing condition = always true");
    }

    /**
     * WHILE LOOP
     * Condition-controlled iteration (pre-test)
     */
    private static void demonstrateWhileLoop() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("9. WHILE LOOP");
        System.out.println("=".repeat(70));

        // Basic while loop
        System.out.println("Printing 1 to 5:");
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        // Sum of numbers
        System.out.println("\n➕ SUM OF FIRST 10 NUMBERS:");
        int num = 1;
        int sum = 0;
        while (num <= 10) {
            sum += num;
            num++;
        }
        System.out.println("Sum: " + sum);

        // While with complex condition
        System.out.println("\n🔍 FIND FIRST POWER OF 2 > 1000:");
        int power = 1;
        int exponent = 0;
        while (power <= 1000) {
            exponent++;
            power *= 2;
        }
        System.out.println("2^" + exponent + " = " + power);

        System.out.println("\n💡 USE WHILE WHEN:");
        System.out.println("   - Number of iterations unknown");
        System.out.println("   - Loop may not execute at all");
        System.out.println("   - Condition needs to be checked before first iteration");
    }

    /**
     * DO-WHILE LOOP
     * Condition-controlled iteration (post-test)
     */
    private static void demonstrateDoWhileLoop() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("10. DO-WHILE LOOP");
        System.out.println("=".repeat(70));

        // Basic do-while
        System.out.println("Printing 1 to 5:");
        int i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= 5);
        System.out.println();

        // Key difference: executes at least once
        System.out.println("\n🔑 KEY DIFFERENCE - Executes at least once:");

        System.out.println("While loop with false condition:");
        int x = 10;
        while (x < 5) {
            System.out.println("  This won't print");
        }
        System.out.println("  (Nothing printed)");

        System.out.println("\nDo-while loop with false condition:");
        x = 10;
        do {
            System.out.println("  This prints once even though condition is false");
        } while (x < 5);

        // Menu-driven program pattern
        System.out.println("\n📋 COMMON USE CASE - Menu Pattern:");
        System.out.println("do {");
        System.out.println("    displayMenu();");
        System.out.println("    choice = getUserChoice();");
        System.out.println("    processChoice(choice);");
        System.out.println("} while (choice != EXIT_OPTION);");

        System.out.println("\n💡 USE DO-WHILE WHEN:");
        System.out.println("   - Loop must execute at least once");
        System.out.println("   - Validation scenarios (input checking)");
        System.out.println("   - Menu-driven programs");
    }

    /**
     * ENHANCED FOR LOOP (For-Each)
     * Iteration over collections and arrays
     */
    private static void demonstrateEnhancedForLoop() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("11. ENHANCED FOR LOOP (For-Each)");
        System.out.println("=".repeat(70));

        // Array iteration
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array elements:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // String array
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};
        System.out.println("\nFruits:");
        for (String fruit : fruits) {
            System.out.println("  - " + fruit);
        }

        // Character array from string
        System.out.println("\n🔤 ITERATING CHARACTERS:");
        String word = "JAVA";
        for (char c : word.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Limitations
        System.out.println("\n⚠️  LIMITATIONS:");
        System.out.println("   ✗ Cannot modify array elements");
        System.out.println("   ✗ Cannot access index");
        System.out.println("   ✗ Can only iterate forward");
        System.out.println("   ✗ Cannot iterate multiple collections simultaneously");

        System.out.println("\n✅ ADVANTAGES:");
        System.out.println("   ✓ Cleaner, more readable code");
        System.out.println("   ✓ Less error-prone (no index out of bounds)");
        System.out.println("   ✓ Works with any Iterable");
    }

    /**
     * BREAK STATEMENT
     * Exit loop or switch prematurely
     */
    private static void demonstrateBreakStatement() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("12. BREAK STATEMENT");
        System.out.println("=".repeat(70));

        // Break in for loop
        System.out.println("Finding first number divisible by 7:");
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println("  Found: " + i);
                break;  // Exit loop immediately
            }
        }

        // Break in while loop
        System.out.println("\n🔍 SEARCHING IN ARRAY:");
        int[] numbers = {23, 45, 67, 12, 89, 34};
        int target = 12;
        boolean found = false;

        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] == target) {
                System.out.println("  " + target + " found at index " + i);
                found = true;
                break;
            }
            i++;
        }

        if (!found) {
            System.out.println("  " + target + " not found");
        }

        // Break in nested loop (breaks only inner loop)
        System.out.println("\n🔄 BREAK IN NESTED LOOPS:");
        System.out.println("Outer loop continues after inner break:");
        for (int outer = 1; outer <= 3; outer++) {
            System.out.println("  Outer loop: " + outer);
            for (int inner = 1; inner <= 5; inner++) {
                if (inner == 3) {
                    System.out.println("    Breaking inner loop at " + inner);
                    break;  // Breaks only inner loop
                }
                System.out.println("    Inner loop: " + inner);
            }
        }
    }

    /**
     * CONTINUE STATEMENT
     * Skip current iteration
     */
    private static void demonstrateContinueStatement() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("13. CONTINUE STATEMENT");
        System.out.println("=".repeat(70));

        // Skip even numbers
        System.out.println("Printing odd numbers 1-10:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // Skip even numbers
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // Skip specific values
        System.out.println("\n⏭️  SKIPPING MULTIPLES OF 3:");
        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // Continue in while loop
        System.out.println("\n🔢 PROCESSING VALID NUMBERS:");
        int[] numbers = {5, -2, 8, -7, 10, -3, 15};
        int sum = 0;
        int idx = 0;

        while (idx < numbers.length) {
            if (numbers[idx] < 0) {
                idx++;
                continue;  // Skip negative numbers
            }
            sum += numbers[idx];
            idx++;
        }
        System.out.println("Sum of positive numbers: " + sum);

        System.out.println("\n🆚 BREAK VS CONTINUE:");
        System.out.println("   BREAK    - Exits the loop completely");
        System.out.println("   CONTINUE - Skips to next iteration");
    }

    /**
     * LABELED STATEMENTS
     * Control nested loops with labels
     */
    private static void demonstrateLabeledStatements() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("14. LABELED STATEMENTS");
        System.out.println("=".repeat(70));

        // Break with label - exits outer loop
        System.out.println("🏷️  LABELED BREAK (exits outer loop):");

        outerLoop:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("  Breaking outer loop at i=" + i + ", j=" + j);
                    break outerLoop;  // Breaks outer loop
                }
                System.out.println("  i=" + i + ", j=" + j);
            }
        }
        System.out.println("  Outer loop exited");

        // Continue with label
        System.out.println("\n🏷️  LABELED CONTINUE (continues outer loop):");

        outer:
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer iteration: " + i);
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    continue outer;  // Goes to next iteration of outer loop
                }
                System.out.println("  Inner: " + j);
            }
            System.out.println("  This won't print when j=2");
        }

        // Practical example: finding element in 2D array
        System.out.println("\n🎯 PRACTICAL USE CASE - Search in 2D Array:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int searchFor = 5;

        search:
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == searchFor) {
                    System.out.println("  Found " + searchFor + " at [" + i + "][" + j + "]");
                    break search;  // Exit both loops
                }
            }
        }
    }

    /**
     * ADVANCED PATTERNS
     * Real-world patterns and best practices
     */
    private static void demonstrateAdvancedPatterns() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("15. ADVANCED PATTERNS & BEST PRACTICES");
        System.out.println("=".repeat(70));

        // Early return pattern
        System.out.println("✅ EARLY RETURN PATTERN:");
        System.out.println("   Instead of nested ifs, return early:");
        System.out.println("   if (!valid) return;");
        System.out.println("   if (!authenticated) return;");
        System.out.println("   // Main logic here");

        // Guard clauses
        System.out.println("\n🛡️  GUARD CLAUSES:");
        int value = 50;
        if (value < 0 || value > 100) {
            System.out.println("   Invalid value (guard clause catches it)");
        } else {
            System.out.println("   Processing value: " + value);
        }

        // State machine pattern
        System.out.println("\n🔄 STATE MACHINE PATTERN:");
        System.out.println("enum State { IDLE, PROCESSING, COMPLETED, ERROR }");
        System.out.println("State state = State.IDLE;");
        System.out.println("switch (state) {");
        System.out.println("    case IDLE -> startProcessing();");
        System.out.println("    case PROCESSING -> continueProcessing();");
        System.out.println("    ...");
        System.out.println("}");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("KEY TAKEAWAYS:");
        System.out.println("=".repeat(70));
        System.out.println("✓ Use switch for multiple discrete values");
        System.out.println("✓ Enhanced switch (Java 14+) is more expressive");
        System.out.println("✓ For-each loop for simple iteration");
        System.out.println("✓ Traditional for loop when index is needed");
        System.out.println("✓ While for unknown iteration count");
        System.out.println("✓ Do-while when loop must run at least once");
        System.out.println("✓ Use break sparingly, prefer loop conditions");
        System.out.println("✓ Labels are powerful but can reduce readability");
        System.out.println("=".repeat(70));

        // Print interview questions
        printInterviewQuestions();
    }

    /**
     * INTERVIEW QUESTIONS & ANSWERS - CONTROL FLOW
     */
    private static void printInterviewQuestions() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("INTERVIEW QUESTIONS & ANSWERS - CONTROL FLOW");
        System.out.println("=".repeat(70));

        String[][] qa = {
                {
                        "Q1: What is the difference between if-else and switch?",
                        "A: if-else:",
                        "   - Can handle complex conditions (ranges, multiple variables)",
                        "   - Uses boolean expressions",
                        "   - More flexible but can be verbose",
                        "   switch:",
                        "   - Only for discrete values (equality checks)",
                        "   - More readable for multiple discrete cases",
                        "   - Faster for many cases (jump table optimization)",
                        "   - Works with: byte, short, int, char, String, enum",
                        "   Example: Use switch for days of week, if-else for age ranges"
                },
                {
                        "Q2: What is fall-through in switch? Give example",
                        "A: When a case doesn't have break, execution continues to next case",
                        "   Example:",
                        "     switch(day) {",
                        "         case MONDAY:",
                        "         case TUESDAY:",
                        "         case WEDNESDAY:",
                        "             System.out.println(\"Weekday\");",
                        "             break;  // Without this, falls through to THURSDAY",
                        "         case THURSDAY:",
                        "             System.out.println(\"Almost weekend\");",
                        "     }",
                        "   Use case: Group multiple cases with same logic",
                        "   Modern Java: Use arrow syntax (->) to prevent fall-through"
                },
                {
                        "Q3: Difference between while and do-while loop?",
                        "A: while:",
                        "   - Condition checked BEFORE execution",
                        "   - May not execute at all if condition is false",
                        "   - while (condition) { ... }",
                        "   do-while:",
                        "   - Condition checked AFTER execution",
                        "   - Executes AT LEAST ONCE",
                        "   - do { ... } while (condition);",
                        "   Use case: do-while for menu systems (show menu at least once)"
                },
                {
                        "Q4: When to use for vs for-each loop?",
                        "A: Traditional for:",
                        "   - Need index/position",
                        "   - Iterate backwards",
                        "   - Skip elements",
                        "   - Modify during iteration",
                        "   for-each (enhanced):",
                        "   - Simple forward iteration",
                        "   - Don't need index",
                        "   - Cleaner syntax",
                        "   - Cannot modify collection",
                        "   Example:",
                        "     for (int i = 0; i < array.length; i++) // Need index",
                        "     for (String item : list)               // Simple iteration"
                },
                {
                        "Q5: Can you modify loop variable in for-each loop?",
                        "A: You can reassign the variable, but it won't affect the collection",
                        "   Example:",
                        "     int[] arr = {1, 2, 3};",
                        "     for (int num : arr) {",
                        "         num = 10;  // Only changes local copy, not array",
                        "     }",
                        "     // arr is still {1, 2, 3}",
                        "   Reason: for-each creates a copy of each element",
                        "   To modify: Use traditional for with index"
                },
                {
                        "Q6: What is the difference between break and continue?",
                        "A: break:",
                        "   - Exits the loop completely",
                        "   - No further iterations",
                        "   - Control goes to statement after loop",
                        "   continue:",
                        "   - Skips current iteration",
                        "   - Goes to next iteration",
                        "   - Loop continues",
                        "   Example:",
                        "     for (int i = 0; i < 5; i++) {",
                        "         if (i == 2) continue; // Skips i=2",
                        "         if (i == 4) break;    // Exits at i=4",
                        "     }",
                        "   Output: 0, 1, 3"
                },
                {
                        "Q7: What are labeled statements? When to use them?",
                        "A: Labels allow breaking/continuing outer loops from inner loops",
                        "   Example:",
                        "     outer:",
                        "     for (int i = 0; i < 3; i++) {",
                        "         for (int j = 0; j < 3; j++) {",
                        "             if (condition) break outer; // Exits outer loop",
                        "         }",
                        "     }",
                        "   Use cases:",
                        "   - Search in 2D array (break when found)",
                        "   - Matrix operations",
                        "   - Nested validation",
                        "   Caution: Can reduce readability, use sparingly"
                },
                {
                        "Q8: Can switch work with String? What about long?",
                        "A: String: YES (since Java 7)",
                        "   switch (str) {",
                        "       case \"MONDAY\": ...",
                        "   }",
                        "   long: NO",
                        "   - Switch works with: byte, short, int, char, String, enum",
                        "   - Does NOT work with: long, float, double, boolean",
                        "   Reason: Switch uses jump table, long is too large",
                        "   Alternative for long: Use if-else chain"
                },
                {
                        "Q9: What is infinite loop? How to create one?",
                        "A: Loop that never terminates",
                        "   Ways to create:",
                        "   1. while (true) { ... }",
                        "   2. for (;;) { ... }",
                        "   3. do { ... } while (true);",
                        "   Use cases:",
                        "   - Server programs",
                        "   - Event loops",
                        "   - Game loops",
                        "   - Background tasks",
                        "   Important: Must have exit condition (break) or external termination"
                },
                {
                        "Q10: What is the ternary operator? Give example",
                        "A: Shorthand for if-else, format: condition ? ifTrue : ifFalse",
                        "   Example:",
                        "     int max = (a > b) ? a : b;",
                        "   Equivalent to:",
                        "     int max;",
                        "     if (a > b) {",
                        "         max = a;",
                        "     } else {",
                        "         max = b;",
                        "     }",
                        "   Can be nested (but reduces readability)",
                        "   Use for: Simple conditional assignments"
                },
                {
                        "Q11: Can you use switch without default case?",
                        "A: Yes, default is optional",
                        "   Without default:",
                        "   - If no case matches, nothing executes",
                        "   - No error or exception",
                        "   Best practice:",
                        "   - Include default for completeness",
                        "   - Handles unexpected values",
                        "   - Makes code more robust",
                        "   Modern Java: Switch expressions require exhaustive cases or default"
                },
                {
                        "Q12: What is switch expression (Java 14+)?",
                        "A: Enhanced switch that returns a value",
                        "   Traditional:",
                        "     int result;",
                        "     switch (day) {",
                        "         case MONDAY: result = 1; break;",
                        "         ...",
                        "     }",
                        "   Expression:",
                        "     int result = switch (day) {",
                        "         case MONDAY -> 1;",
                        "         case TUESDAY -> 2;",
                        "         default -> 0;",
                        "     };",
                        "   Benefits:",
                        "   - No fall-through",
                        "   - Must be exhaustive",
                        "   - Returns value directly",
                        "   - More concise"
                },
                {
                        "Q13: Can you have nested loops? Any limit?",
                        "A: Yes, loops can be nested to any depth",
                        "   Example:",
                        "     for (int i = 0; i < 10; i++) {",
                        "         for (int j = 0; j < 10; j++) {",
                        "             for (int k = 0; k < 10; k++) {",
                        "                 // Triple nested",
                        "             }",
                        "         }",
                        "     }",
                        "   No technical limit, but:",
                        "   - Deep nesting (>3) reduces readability",
                        "   - Time complexity multiplies (O(n³) above)",
                        "   - Consider extracting to methods",
                        "   - Alternative: Use single loop with calculated index"
                },
                {
                        "Q14: What is loop unrolling? Why is it used?",
                        "A: Optimization technique - manually repeating loop body",
                        "   Normal loop:",
                        "     for (int i = 0; i < 100; i++) {",
                        "         process(i);",
                        "     }",
                        "   Unrolled:",
                        "     for (int i = 0; i < 100; i += 4) {",
                        "         process(i);",
                        "         process(i + 1);",
                        "         process(i + 2);",
                        "         process(i + 3);",
                        "     }",
                        "   Benefits:",
                        "   - Reduces loop overhead (fewer condition checks)",
                        "   - Better CPU pipeline utilization",
                        "   - JVM does this automatically (JIT optimization)"
                },
                {
                        "Q15: Difference between i++ in for loop header vs body?",
                        "A: Functionally equivalent for simple loops",
                        "   In header:",
                        "     for (int i = 0; i < 10; i++) {",
                        "         System.out.println(i);",
                        "     }",
                        "   In body:",
                        "     for (int i = 0; i < 10; ) {",
                        "         System.out.println(i);",
                        "         i++;",
                        "     }",
                        "   Difference:",
                        "   - Header: Standard, expected location",
                        "   - Body: More control (conditional increment, multiple increments)",
                        "   Use header unless you need special increment logic"
                }
        };

        for (int i = 0; i < qa.length; i++) {
            System.out.println("\n" + qa[i][0]);
            for (int j = 1; j < qa[i].length; j++) {
                System.out.println(qa[i][j]);
            }
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("KEY INTERVIEW TIPS:");
        System.out.println("=".repeat(70));
        System.out.println("✓ Understand when to use each loop type");
        System.out.println("✓ Know switch limitations (no long, float, double)");
        System.out.println("✓ Explain break vs continue clearly");
        System.out.println("✓ Be ready to trace nested loops");
        System.out.println("✓ Know Java 14+ switch expressions");
        System.out.println("✓ Understand do-while executes at least once");
        System.out.println("✓ Explain labeled statements use cases");
        System.out.println("=".repeat(70));
    }
}