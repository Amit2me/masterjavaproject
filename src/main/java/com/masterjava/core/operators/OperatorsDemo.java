package com.masterjava.core.operators;

/**
 * OPERATORS IN JAVA
 * =================
 *
 * Comprehensive guide to all operator types in Java:
 * - Arithmetic Operators (+, -, *, /, %)
 * - Relational Operators (==, !=, >, <, >=, <=)
 * - Logical Operators (&&, ||, !)
 * - Bitwise Operators (&, |, ^, ~, <<, >>, >>>)
 * - Assignment Operators (=, +=, -=, *=, /=, %=)
 * - Unary Operators (++, --, !, ~)
 * - Ternary Operator (? :)
 * - instanceof Operator
 *
 * UNDER THE HOOD:
 * - Operator precedence and associativity
 * - Expression evaluation order
 * - Short-circuit evaluation in logical operators
 * - Bitwise operations at binary level
 * - Integer promotion in operations
 *
 * INTERVIEW TOPICS:
 * - Difference between == and .equals()
 * - Pre-increment vs Post-increment
 * - Short-circuit vs Non-short-circuit operators
 * - Bitwise manipulation use cases
 * - Operator precedence rules
 *
 * @author Master Java Project
 * @version 1.0
 */
public class OperatorsDemo {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("OPERATORS IN JAVA - COMPREHENSIVE DEMONSTRATION");
        System.out.println("=".repeat(70));

        demonstrateArithmeticOperators();
        demonstrateRelationalOperators();
        demonstrateLogicalOperators();
        demonstrateBitwiseOperators();
        demonstrateAssignmentOperators();
        demonstrateUnaryOperators();
        demonstrateTernaryOperator();
        demonstrateInstanceofOperator();
        demonstrateOperatorPrecedence();
        demonstrateAdvancedConcepts();
    }

    /**
     * ARITHMETIC OPERATORS
     * Basic mathematical operations
     */
    private static void demonstrateArithmeticOperators() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("1. ARITHMETIC OPERATORS (+, -, *, /, %)");
        System.out.println("=".repeat(70));

        int a = 15;
        int b = 4;

        System.out.println("Given: a = " + a + ", b = " + b);
        System.out.println("\nBasic Operations:");
        System.out.println("  Addition (a + b)      = " + (a + b));
        System.out.println("  Subtraction (a - b)   = " + (a - b));
        System.out.println("  Multiplication (a * b) = " + (a * b));
        System.out.println("  Division (a / b)      = " + (a / b) + " (integer division)");
        System.out.println("  Modulus (a % b)       = " + (a % b) + " (remainder)");

        // Floating point division
        System.out.println("\nFloating Point Division:");
        System.out.println("  (double) a / b        = " + ((double) a / b));

        // String concatenation with +
        System.out.println("\nString Concatenation:");
        System.out.println("  \"Result: \" + a        = " + "Result: " + a);
        System.out.println("  a + \" apples\"          = " + a + " apples");

        // Integer overflow
        System.out.println("\nInteger Overflow Example:");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("  Integer.MAX_VALUE     = " + maxInt);
        System.out.println("  MAX_VALUE + 1         = " + (maxInt + 1) + " (overflow!)");
    }

    /**
     * RELATIONAL OPERATORS
     * Compare two values and return boolean
     */
    private static void demonstrateRelationalOperators() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("2. RELATIONAL OPERATORS (==, !=, >, <, >=, <=)");
        System.out.println("=".repeat(70));

        int x = 10;
        int y = 20;

        System.out.println("Given: x = " + x + ", y = " + y);
        System.out.println("\nComparisons:");
        System.out.println("  x == y  : " + (x == y) + "  (equal to)");
        System.out.println("  x != y  : " + (x != y) + "  (not equal to)");
        System.out.println("  x > y   : " + (x > y) + "  (greater than)");
        System.out.println("  x < y   : " + (x < y) + "   (less than)");
        System.out.println("  x >= y  : " + (x >= y) + "  (greater than or equal)");
        System.out.println("  x <= y  : " + (x <= y) + "   (less than or equal)");

        // String comparison caveat
        System.out.println("\n⚠️  IMPORTANT - String Comparison:");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("  str1 == str2        : " + (str1 == str2) + " (same reference in pool)");
        System.out.println("  str1 == str3        : " + (str1 == str3) + " (different objects)");
        System.out.println("  str1.equals(str3)   : " + (str1.equals(str3)) + " (content comparison)");
        System.out.println("  👉 Use .equals() for String content comparison!");
    }

    /**
     * LOGICAL OPERATORS
     * Boolean logic operations with short-circuit evaluation
     */
    private static void demonstrateLogicalOperators() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("3. LOGICAL OPERATORS (&&, ||, !)");
        System.out.println("=".repeat(70));

        boolean a = true;
        boolean b = false;

        System.out.println("Given: a = " + a + ", b = " + b);
        System.out.println("\nLogical Operations:");
        System.out.println("  a && b  : " + (a && b) + "  (AND - both must be true)");
        System.out.println("  a || b  : " + (a || b) + "   (OR - at least one true)");
        System.out.println("  !a      : " + (!a) + "  (NOT - inverts boolean)");
        System.out.println("  !b      : " + (!b) + "   (NOT)");

        // Short-circuit evaluation
        System.out.println("\n🚀 SHORT-CIRCUIT EVALUATION:");
        int count = 0;

        System.out.println("Expression: false && (++count > 0)");
        boolean result1 = false && (++count > 0);
        System.out.println("  Result: " + result1 + ", count = " + count + " (second part NOT evaluated)");

        System.out.println("\nExpression: true || (++count > 0)");
        boolean result2 = true || (++count > 0);
        System.out.println("  Result: " + result2 + ", count = " + count + " (second part NOT evaluated)");

        // Non-short-circuit operators
        System.out.println("\n📊 NON-SHORT-CIRCUIT OPERATORS (&, |):");
        count = 0;
        System.out.println("Expression: false & (++count > 0)");
        boolean result3 = false & (++count > 0);
        System.out.println("  Result: " + result3 + ", count = " + count + " (second part WAS evaluated)");
    }

    /**
     * BITWISE OPERATORS
     * Operations at binary bit level
     */
    private static void demonstrateBitwiseOperators() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("4. BITWISE OPERATORS (&, |, ^, ~, <<, >>, >>>)");
        System.out.println("=".repeat(70));

        int a = 5;  // 0101 in binary
        int b = 3;  // 0011 in binary

        System.out.println("Given: a = " + a + " (binary: " + Integer.toBinaryString(a) + ")");
        System.out.println("       b = " + b + " (binary: " + Integer.toBinaryString(b) + ")");

        System.out.println("\nBitwise Operations:");
        System.out.println("  a & b   = " + (a & b) + " (AND: " + Integer.toBinaryString(a & b) + ")");
        System.out.println("  a | b   = " + (a | b) + " (OR: " + Integer.toBinaryString(a | b) + ")");
        System.out.println("  a ^ b   = " + (a ^ b) + " (XOR: " + Integer.toBinaryString(a ^ b) + ")");
        System.out.println("  ~a      = " + (~a) + " (NOT - inverts all bits)");

        System.out.println("\nBit Shift Operations:");
        int num = 8;
        System.out.println("  num = " + num + " (binary: " + Integer.toBinaryString(num) + ")");
        System.out.println("  num << 2  = " + (num << 2) + " (left shift: multiply by 2^2)");
        System.out.println("  num >> 2  = " + (num >> 2) + " (right shift: divide by 2^2)");

        // Unsigned right shift
        int negative = -8;
        System.out.println("\n  Negative: " + negative);
        System.out.println("  negative >> 2   = " + (negative >> 2) + " (signed shift)");
        System.out.println("  negative >>> 2  = " + (negative >>> 2) + " (unsigned shift)");

        // Practical use case
        System.out.println("\n💡 PRACTICAL USE CASE - Fast multiplication/division by powers of 2:");
        System.out.println("  num * 4  = " + (num * 4) + " (traditional)");
        System.out.println("  num << 2 = " + (num << 2) + " (bitwise - faster!)");
    }

    /**
     * ASSIGNMENT OPERATORS
     * Assign and modify values
     */
    private static void demonstrateAssignmentOperators() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("5. ASSIGNMENT OPERATORS (=, +=, -=, *=, /=, %=)");
        System.out.println("=".repeat(70));

        int num = 10;
        System.out.println("Initial value: num = " + num);

        num += 5;  // num = num + 5
        System.out.println("After num += 5  : " + num);

        num -= 3;  // num = num - 3
        System.out.println("After num -= 3  : " + num);

        num *= 2;  // num = num * 2
        System.out.println("After num *= 2  : " + num);

        num /= 4;  // num = num / 4
        System.out.println("After num /= 4  : " + num);

        num %= 3;  // num = num % 3
        System.out.println("After num %= 3  : " + num);

        // Chained assignment
        System.out.println("\n🔗 CHAINED ASSIGNMENT:");
        int x, y, z;
        x = y = z = 100;
        System.out.println("  x = y = z = 100");
        System.out.println("  x = " + x + ", y = " + y + ", z = " + z);
    }

    /**
     * UNARY OPERATORS
     * Operators that work with single operand
     */
    private static void demonstrateUnaryOperators() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("6. UNARY OPERATORS (++, --, +, -, !)");
        System.out.println("=".repeat(70));

        // Post-increment vs Pre-increment
        System.out.println("📈 INCREMENT/DECREMENT:");
        int a = 5;
        System.out.println("Initial: a = " + a);

        System.out.println("\nPost-increment (a++):");
        System.out.println("  Value returned: " + a++ + " (returns then increments)");
        System.out.println("  Current a: " + a);

        a = 5;  // reset
        System.out.println("\nPre-increment (++a):");
        System.out.println("  Value returned: " + ++a + " (increments then returns)");
        System.out.println("  Current a: " + a);

        // Common interview question
        System.out.println("\n⚠️  INTERVIEW QUESTION:");
        int x = 5;
        int result = x++ + ++x + x++;
        System.out.println("  int x = 5;");
        System.out.println("  int result = x++ + ++x + x++;");
        System.out.println("  Step by step: 5 + 7 + 7 = 19");
        System.out.println("  Final result: " + result + ", x: " + x);

        // Unary plus and minus
        System.out.println("\n➕ UNARY PLUS/MINUS:");
        int positive = 10;
        System.out.println("  +positive = " + (+positive));
        System.out.println("  -positive = " + (-positive));
    }

    /**
     * TERNARY OPERATOR
     * Compact if-else alternative
     */
    private static void demonstrateTernaryOperator() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("7. TERNARY OPERATOR (? :)");
        System.out.println("=".repeat(70));

        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age: " + age);
        System.out.println("Status: " + status + " (using ternary operator)");

        // Nested ternary
        int marks = 75;
        String grade = (marks >= 90) ? "A" :
                (marks >= 80) ? "B" :
                        (marks >= 70) ? "C" :
                                (marks >= 60) ? "D" : "F";
        System.out.println("\nMarks: " + marks);
        System.out.println("Grade: " + grade + " (nested ternary)");

        // Ternary with method calls
        System.out.println("\n💡 TERNARY WITH EXPRESSIONS:");
        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println("Max of " + a + " and " + b + " is: " + max);
    }

    /**
     * INSTANCEOF OPERATOR
     * Type checking at runtime
     */
    private static void demonstrateInstanceofOperator() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("8. INSTANCEOF OPERATOR");
        System.out.println("=".repeat(70));

        String str = "Hello";
        Integer num = 42;
        Object obj = "I'm a String in Object reference";

        System.out.println("str instanceof String  : " + (str instanceof String));
        System.out.println("str instanceof Object  : " + (str instanceof Object));
        System.out.println("num instanceof Integer : " + (num instanceof Integer));
        System.out.println("num instanceof Number  : " + (num instanceof Number));
        System.out.println("obj instanceof String  : " + (obj instanceof String));

        // Null check
        String nullStr = null;
        System.out.println("\nnullStr instanceof String : " + (nullStr instanceof String));
        System.out.println("👉 instanceof returns false for null references");

        // Pattern matching (Java 16+)
        System.out.println("\n🆕 PATTERN MATCHING WITH INSTANCEOF (Java 16+):");
        if (obj instanceof String s) {
            System.out.println("  String length: " + s.length());
            System.out.println("  Uppercase: " + s.toUpperCase());
        }
    }

    /**
     * OPERATOR PRECEDENCE
     * Order of evaluation in complex expressions
     */
    private static void demonstrateOperatorPrecedence() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("9. OPERATOR PRECEDENCE & ASSOCIATIVITY");
        System.out.println("=".repeat(70));

        int result = 2 + 3 * 4;
        System.out.println("Expression: 2 + 3 * 4");
        System.out.println("Result: " + result + " (multiplication before addition)");

        result = (2 + 3) * 4;
        System.out.println("\nExpression: (2 + 3) * 4");
        System.out.println("Result: " + result + " (parentheses first)");

        result = 20 / 4 * 2;
        System.out.println("\nExpression: 20 / 4 * 2");
        System.out.println("Result: " + result + " (left-to-right for same precedence)");

        // Complex expression
        int a = 5, b = 10, c = 15;
        boolean complexResult = a < b && b < c || a > c;
        System.out.println("\nExpression: " + a + " < " + b + " && " + b + " < " + c + " || " + a + " > " + c);
        System.out.println("Result: " + complexResult);
        System.out.println("Evaluation: (true && true) || false = true");

        System.out.println("\n📋 PRECEDENCE ORDER (High to Low):");
        System.out.println("  1. Postfix (x++, x--)");
        System.out.println("  2. Unary (++x, --x, !, ~)");
        System.out.println("  3. Multiplicative (*, /, %)");
        System.out.println("  4. Additive (+, -)");
        System.out.println("  5. Shift (<<, >>, >>>)");
        System.out.println("  6. Relational (<, >, <=, >=, instanceof)");
        System.out.println("  7. Equality (==, !=)");
        System.out.println("  8. Bitwise AND (&)");
        System.out.println("  9. Bitwise XOR (^)");
        System.out.println("  10. Bitwise OR (|)");
        System.out.println("  11. Logical AND (&&)");
        System.out.println("  12. Logical OR (||)");
        System.out.println("  13. Ternary (? :)");
        System.out.println("  14. Assignment (=, +=, -=, etc.)");
    }

    /**
     * ADVANCED CONCEPTS
     * Real-world applications and interview scenarios
     */
    private static void demonstrateAdvancedConcepts() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("10. ADVANCED CONCEPTS & BEST PRACTICES");
        System.out.println("=".repeat(70));

        // Swap without temp variable
        System.out.println("🔄 SWAP WITHOUT TEMP VARIABLE:");
        int x = 10, y = 20;
        System.out.println("Before: x = " + x + ", y = " + y);
        x = x + y;  // x = 30
        y = x - y;  // y = 10
        x = x - y;  // x = 20
        System.out.println("After:  x = " + x + ", y = " + y);

        // Using XOR for swap
        x = 10; y = 20;
        System.out.println("\n🔄 SWAP USING XOR:");
        System.out.println("Before: x = " + x + ", y = " + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After:  x = " + x + ", y = " + y);

        // Check if number is power of 2
        System.out.println("\n⚡ CHECK IF POWER OF 2 (Bitwise trick):");
        int[] numbers = {1, 2, 4, 8, 15, 16, 32, 33};
        for (int num : numbers) {
            boolean isPowerOf2 = (num > 0) && ((num & (num - 1)) == 0);
            System.out.println("  " + num + " is power of 2: " + isPowerOf2);
        }

        // Count set bits
        System.out.println("\n🔢 COUNT SET BITS (Brian Kernighan's Algorithm):");
        int num = 29;  // Binary: 11101
        System.out.println("Number: " + num + " (binary: " + Integer.toBinaryString(num) + ")");
        int count = 0;
        int temp = num;
        while (temp > 0) {
            temp = temp & (temp - 1);
            count++;
        }
        System.out.println("Set bits: " + count);

        System.out.println("\n" + "=".repeat(70));
        System.out.println("KEY TAKEAWAYS:");
        System.out.println("=".repeat(70));
        System.out.println("✓ Use == for primitives, .equals() for objects");
        System.out.println("✓ Short-circuit operators (&&, ||) optimize performance");
        System.out.println("✓ Bitwise operators provide efficient low-level operations");
        System.out.println("✓ Understand precedence to write correct expressions");
        System.out.println("✓ Pre/post increment affects expression evaluation");
        System.out.println("✓ Ternary operator provides concise conditional assignment");
        System.out.println("=".repeat(70));

        // Print interview questions
        printInterviewQuestions();
    }

    /**
     * INTERVIEW QUESTIONS & ANSWERS - OPERATORS
     */
    private static void printInterviewQuestions() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("INTERVIEW QUESTIONS & ANSWERS - OPERATORS");
        System.out.println("=".repeat(70));

        String[][] qa = {
                {
                        "Q1: What is the difference between == and .equals()?",
                        "A: For primitives: == compares values",
                        "   For objects: == compares references (memory addresses)",
                        "   .equals() compares content/values",
                        "   Example:",
                        "     String s1 = new String(\"Java\");",
                        "     String s2 = new String(\"Java\");",
                        "     s1 == s2        → false (different objects)",
                        "     s1.equals(s2)   → true (same content)"
                },
                {
                        "Q2: Explain pre-increment vs post-increment",
                        "A: Pre-increment (++x): Increment first, then use value",
                        "   Post-increment (x++): Use value first, then increment",
                        "   Example:",
                        "     int x = 5;",
                        "     int a = ++x;  // x becomes 6, a = 6",
                        "     int b = x++;  // b = 6, then x becomes 7",
                        "   Interview Trap: What is result of: int x = 5; int y = x++ + ++x;",
                        "   Answer: y = 5 + 7 = 12 (x becomes 6 after first, then 7 before second)"
                },
                {
                        "Q3: What is short-circuit evaluation?",
                        "A: Logical operators && and || stop evaluation when result is known",
                        "   && (AND): If left is false, right is not evaluated (result is false)",
                        "   || (OR): If left is true, right is not evaluated (result is true)",
                        "   Example:",
                        "     if (obj != null && obj.method())  // Safe: second not called if obj is null",
                        "   Non-short-circuit: & and | always evaluate both sides",
                        "   Use case: Prevents NullPointerException and improves performance"
                },
                {
                        "Q4: What is operator precedence? Give examples",
                        "A: Order in which operators are evaluated in an expression",
                        "   Precedence (highest to lowest):",
                        "   1. Postfix: x++, x--",
                        "   2. Unary: ++x, --x, !, ~",
                        "   3. Multiplicative: *, /, %",
                        "   4. Additive: +, -",
                        "   5. Shift: <<, >>, >>>",
                        "   6. Relational: <, >, <=, >=",
                        "   7. Equality: ==, !=",
                        "   8. Bitwise AND: &",
                        "   9. Bitwise XOR: ^",
                        "   10. Bitwise OR: |",
                        "   11. Logical AND: &&",
                        "   12. Logical OR: ||",
                        "   13. Ternary: ? :",
                        "   14. Assignment: =, +=, -=, etc.",
                        "   Example: 5 + 3 * 2 = 11 (not 16, because * has higher precedence)"
                },
                {
                        "Q5: What does the modulo (%) operator do?",
                        "A: Returns the remainder after division",
                        "   Examples:",
                        "     10 % 3 = 1  (10 ÷ 3 = 3 remainder 1)",
                        "     15 % 4 = 3  (15 ÷ 4 = 3 remainder 3)",
                        "     20 % 5 = 0  (20 ÷ 5 = 4 remainder 0)",
                        "   Common uses:",
                        "   - Check if number is even: (n % 2 == 0)",
                        "   - Cycle through array: index = (index + 1) % arrayLength",
                        "   - Extract digits: lastDigit = num % 10"
                },
                {
                        "Q6: Explain the ternary operator",
                        "A: Shorthand for if-else, format: condition ? valueIfTrue : valueIfFalse",
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
                        "   Use case: Concise conditional assignments"
                },
                {
                        "Q7: What are bitwise operators? When to use them?",
                        "A: Operators that work on binary representation of numbers",
                        "   & (AND): Sets bit to 1 if both bits are 1",
                        "   | (OR): Sets bit to 1 if at least one bit is 1",
                        "   ^ (XOR): Sets bit to 1 if bits are different",
                        "   ~ (NOT): Inverts all bits",
                        "   << (Left shift): Multiplies by 2^n",
                        "   >> (Right shift): Divides by 2^n",
                        "   Use cases:",
                        "   - Flag management: status = status | FLAG_ACTIVE",
                        "   - Masking: extracting specific bits",
                        "   - Performance: x * 2 vs x << 1 (shift is faster)",
                        "   - Cryptography, compression, low-level programming"
                },
                {
                        "Q8: What is the difference between >> and >>>?",
                        "A: >> (Signed right shift): Preserves sign bit",
                        "   >>> (Unsigned right shift): Fills with 0s",
                        "   Example:",
                        "     int negative = -8;  // Binary: 11111111...11111000",
                        "     negative >> 1       // Result: -4 (sign preserved)",
                        "     negative >>> 1      // Result: 2147483644 (filled with 0s)",
                        "   Use case: >>> used when treating number as unsigned"
                },
                {
                        "Q9: Can you use ++ operator on final variables?",
                        "A: No, compile error",
                        "   final int x = 5;",
                        "   x++;  // Error: cannot assign a value to final variable x",
                        "   Reason: ++ is shorthand for x = x + 1, which is reassignment",
                        "   final variables can be assigned only once"
                },
                {
                        "Q10: What is compound assignment operator?",
                        "A: Combines operation with assignment: +=, -=, *=, /=, %=",
                        "   Example:",
                        "     x += 5;  // Equivalent to: x = x + 5",
                        "     x *= 2;  // Equivalent to: x = x * 2",
                        "   Benefit: More concise",
                        "   Important: Includes implicit cast",
                        "     byte b = 10;",
                        "     b += 5;     // OK (implicit cast)",
                        "     b = b + 5;  // Error (int cannot be assigned to byte without cast)"
                },
                {
                        "Q11: What happens with division by zero?",
                        "A: For integers: throws ArithmeticException",
                        "     int result = 10 / 0;  // Exception!",
                        "   For floating point: returns Infinity or NaN",
                        "     double result = 10.0 / 0.0;  // Infinity",
                        "     double result = 0.0 / 0.0;   // NaN (Not a Number)",
                        "   Check with: Double.isInfinite() or Double.isNaN()"
                },
                {
                        "Q12: Explain XOR (^) operator with examples",
                        "A: XOR returns true if bits are different",
                        "   Truth table: 0^0=0, 0^1=1, 1^0=1, 1^1=0",
                        "   Properties:",
                        "   - x ^ 0 = x (identity)",
                        "   - x ^ x = 0 (self-inverse)",
                        "   - x ^ y = y ^ x (commutative)",
                        "   Common use cases:",
                        "   1. Swap without temp: a ^= b; b ^= a; a ^= b;",
                        "   2. Toggle bit: x ^= (1 << n)",
                        "   3. Find single number: XOR all elements",
                        "   4. Simple encryption"
                },
                {
                        "Q13: What is instanceof operator?",
                        "A: Tests if object is instance of specific class/interface",
                        "   Returns boolean (true/false)",
                        "   Example:",
                        "     String str = \"Hello\";",
                        "     str instanceof String     // true",
                        "     str instanceof Object     // true (String extends Object)",
                        "     str instanceof Integer    // false",
                        "   Use before casting to prevent ClassCastException",
                        "   Returns false if object is null"
                },
                {
                        "Q14: Can operators be overloaded in Java?",
                        "A: No, Java does not support operator overloading (unlike C++)",
                        "   Exception: + operator is overloaded for String concatenation",
                        "   Design decision: Keeps language simple and predictable",
                        "   Alternative: Create methods like add(), multiply(), etc."
                },
                {
                        "Q15: What is the result of: 5 + 3 * 2 - 8 / 4 + 1?",
                        "A: Step-by-step evaluation (following precedence):",
                        "   1. 3 * 2 = 6        (multiplication first)",
                        "   2. 8 / 4 = 2        (division)",
                        "   3. 5 + 6 = 11       (addition, left to right)",
                        "   4. 11 - 2 = 9       (subtraction)",
                        "   5. 9 + 1 = 10       (addition)",
                        "   Answer: 10",
                        "   Always use parentheses for clarity: 5 + (3 * 2) - (8 / 4) + 1"
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
        System.out.println("✓ Always explain == vs .equals() difference");
        System.out.println("✓ Know precedence of common operators");
        System.out.println("✓ Understand short-circuit evaluation for && and ||");
        System.out.println("✓ Be ready to trace pre/post increment in expressions");
        System.out.println("✓ Know bitwise operations for flags and bit manipulation");
        System.out.println("✓ Remember: Java doesn't support operator overloading");
        System.out.println("=".repeat(70));
    }
}