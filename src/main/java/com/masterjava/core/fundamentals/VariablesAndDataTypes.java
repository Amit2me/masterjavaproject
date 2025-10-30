package com.masterjava.core.fundamentals;

/**
 * ═══════════════════════════════════════════════════════════════════════════════
 * CORE JAVA 02: VARIABLES & DATA TYPES - DEEP MASTERY
 * ═══════════════════════════════════════════════════════════════════════════════
 * <p>
 * LEARNING OBJECTIVES:
 * ✓ Understand primitive data types (8 types)
 * ✓ Understand reference data types
 * ✓ Learn type conversion and casting
 * ✓ Memory allocation for different types
 * ✓ Variable scope and lifetime
 * ✓ Final variables (constants)
 * ✓ Type compatibility rules
 * <p>
 * DIFFICULTY: Beginner-Intermediate
 * TIME: 45-60 minutes
 * <p>
 * WHY THIS MATTERS:
 * • Foundation of all programming
 * • Type system prevents errors
 * • Memory efficiency depends on type choice
 * • Type casting is common source of bugs
 * • Every interview asks about this
 * <p>
 * REAL-WORLD APPLICATIONS:
 * • Choosing correct data type for performance
 * • Database column design (INT vs BIGINT)
 * • API parameter types
 * • Financial calculations (BigDecimal vs double)
 * • Memory-constrained systems (byte vs int)
 * ═══════════════════════════════════════════════════════════════════════════════
 */

public class VariablesAndDataTypes {

    // ═════════════════════════════════════════════════════════════════════════════
    // THEORY SECTION
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ JAVA DATA TYPES - COMPLETE TAXONOMY                                    │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * DATA TYPES
     * │
     * ├── PRIMITIVE (8 types - stored directly in memory)
     * │   │
     * │   ├── Numeric
     * │   │   ├── Integer Types
     * │   │   │   ├── byte      (1 byte, -128 to 127)
     * │   │   │   ├── short     (2 bytes, -32,768 to 32,767)
     * │   │   │   ├── int       (4 bytes, -2^31 to 2^31-1)
     * │   │   │   └── long      (8 bytes, -2^63 to 2^63-1)
     * │   │   │
     * │   │   └── Floating Point
     * │   │       ├── float     (4 bytes, ~6-7 decimal digits)
     * │   │       └── double    (8 bytes, ~15-17 decimal digits)
     * │   │
     * │   └── Boolean/Character
     * │       ├── boolean   (true or false, 1 byte)
     * │       └── char      (Unicode character, 2 bytes, 0 to 65535)
     * │
     * └── REFERENCE (stored as reference/pointer to heap)
     *     ├── Class (String, Integer, User, etc.)
     *     ├── Array (int[], String[], etc.)
     *     └── Interface (List, Runnable, etc.)
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ PRIMITIVE TYPES - DETAILED BREAKDOWN                                   │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * TYPE    | SIZE | RANGE                      | DEFAULT | WRAPPER CLASS
     * --------|------|----------------------------|---------|---------------
     * byte    | 1 B  | -128 to 127               | 0       | Byte
     * short   | 2 B  | -32,768 to 32,767        | 0       | Short
     * int     | 4 B  | -2,147,483,648 to...     | 0       | Integer
     * long    | 8 B  | -9,223,372,036,854,775.. | 0L      | Long
     * float   | 4 B  | ±3.4e-38 to ±3.4e38     | 0.0f    | Float
     * double  | 8 B  | ±1.7e-308 to ±1.7e308   | 0.0     | Double
     * boolean | 1 B  | true or false            | false   | Boolean
     * char    | 2 B  | 0 to 65535 (Unicode)     | '\u0000'| Character
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ WHEN TO USE WHICH PRIMITIVE TYPE                                       │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * byte   → Small integers, saving space (array of bytes)
     * short  → Rare, mostly historical reasons
     * int    → DEFAULT for integer calculations
     * long   → Large numbers, IDs, timestamps (always suffix L)
     * float  → Memory-constrained, arrays of decimals
     * double → DEFAULT for decimal calculations (more precision)
     * boolean→ Flags, conditions, true/false values
     * char   → Single characters, Unicode values
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ REFERENCE VS PRIMITIVE - KEY DIFFERENCES                               │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * PRIMITIVE                        | REFERENCE
     * ─────────────────────────────────┼──────────────────────────
     * Stored directly in memory        | Stored as pointer/reference
     * No null value (has default)      | Can be null
     * Compared by value (==)           | Compared by reference (==)
     * Smaller memory footprint         | Larger (pointer + object)
     * Faster access                    | Slightly slower (indirection)
     * Stack only                       | Object on heap, ref on stack
     * No methods                       | Can have methods
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ TYPE CONVERSION - WIDENING & NARROWING                                │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * WIDENING (smaller → larger, automatic, safe)
     * byte → short → int → long → float → double
     *
     * Example:
     * int num = 100;
     * long bigNum = num;  // Automatic, no loss
     *
     * NARROWING (larger → smaller, requires cast, may lose data)
     * double → float → long → int → short → byte
     *
     * Example:
     * double decimal = 3.14;
     * int integer = (int) decimal;  // Explicit cast required
     * // Result: 3 (loses decimal part)
     *
     * ┌─────────────────────────────────────────────────────────────────────────┐
     * │ MEMORY MODEL - HOW VARIABLES ARE STORED                               │
     * └─────────────────────────────────────────────────────────────────────────┘
     *
     * Primitive Variables:
     * STACK MEMORY
     * ┌──────────┐
     * │ int x=5  │ ← Value 5 stored directly
     * │ int y=10 │ ← Value 10 stored directly
     * └──────────┘
     *
     * Reference Variables:
     * STACK              HEAP
     * ┌─────────────────┐ ┌──────────────────────┐
     * │ String s ──────→│→ "Hello World" object │
     * │ int[] arr ─────→│→ [1, 2, 3, 4, 5]    │
     * └─────────────────┘ └──────────────────────┘
     */

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 1: PRIMITIVE DATA TYPES - COMPLETE OVERVIEW
    // ═════════════════════════════════════════════════════════════════════════════

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  CORE JAVA 02 - VARIABLES & DATA TYPES                        ║");
        System.out.println("║  Choose an example (1-6)                                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        if (args.length == 0) {
            System.out.println("Running Example 1 by default...\n");
            Example1.main(new String[]{});
        } else {
            try {
                int choice = Integer.parseInt(args[0]);
                switch (choice) {
                    case 1:
                        System.out.println("Example 1: All Primitive Types\n");
                        Example1.main(new String[]{});
                        break;
                    case 2:
                        System.out.println("Example 2: Reference Types\n");
                        Example2.main(new String[]{});
                        break;
                    case 3:
                        System.out.println("Example 3: Type Conversion\n");
                        Example3.main(new String[]{});
                        break;
                    case 4:
                        System.out.println("Example 4: Type Casting & Wrapper Classes\n");
                        Example4.main(new String[]{});
                        break;
                    case 5:
                        System.out.println("Example 5: Variable Scope\n");
                        Example5.main(new String[]{});
                        break;
                    case 6:
                        System.out.println("Example 6: Final Variables\n");
                        Example6.main(new String[]{});
                        break;
                    default:
                        System.out.println("Invalid choice. Choose 1-6");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please provide a number 1-6");
            }
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 2: REFERENCE TYPES & NULL
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: All 8 primitive types with their ranges and usage
     * Concepts: Type declaration, literals, default values
     * Output: Detailed information about each type
     */
    static class Example1 {
        public static void main(String[] args) {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║  ALL 8 PRIMITIVE DATA TYPES                            ║");
            System.out.println("╚════════════════════════════════════════════════════════╝\n");

            // INTEGER TYPES
            System.out.println("INTEGER TYPES:");
            byte byteVar = 127;  // 1 byte
            System.out.println("byte: " + byteVar + " (Range: -128 to 127, Size: 1 byte)");

            short shortVar = 32767;  // 2 bytes
            System.out.println("short: " + shortVar + " (Range: -32,768 to 32,767, Size: 2 bytes)");

            int intVar = 2147483647;  // 4 bytes (default for integer literals)
            System.out.println("int: " + intVar + " (Range: -2^31 to 2^31-1, Size: 4 bytes)");

            long longVar = 9223372036854775807L;  // 8 bytes (note L suffix)
            System.out.println("long: " + longVar + " (Range: -2^63 to 2^63-1, Size: 8 bytes)");

            // FLOATING POINT TYPES
            System.out.println("\nFLOATING POINT TYPES:");
            float floatVar = 3.14f;  // 4 bytes (note f suffix)
            System.out.println("float: " + floatVar + " (Precision: ~6-7 digits, Size: 4 bytes)");

            double doubleVar = 3.141592653589793;  // 8 bytes (default for decimal literals)
            System.out.println("double: " + doubleVar + " (Precision: ~15-17 digits, Size: 8 bytes)");

            // BOOLEAN TYPE
            System.out.println("\nBOOLEAN TYPE:");
            boolean boolTrue = true;
            boolean boolFalse = false;
            System.out.println("boolean: " + boolTrue + " or " + boolFalse + " (Size: 1 byte, Values: true/false)");

            // CHARACTER TYPE
            System.out.println("\nCHARACTER TYPE:");
            char charVar = 'A';  // Single character in single quotes
            char charNumeric = 65;  // Unicode value for 'A'
            System.out.println("char: " + charVar + " (Unicode: " + (int) charVar + ", Size: 2 bytes)");
            System.out.println("char from numeric: " + charNumeric + " (Same as 'A')");

            // SPECIAL VALUES
            System.out.println("\nSPECIAL VALUES & SCIENTIFIC NOTATION:");
            double scientific = 1.5e-10;  // Scientific notation
            System.out.println("Scientific notation: " + scientific);

            double infinity = Double.POSITIVE_INFINITY;
            double notANumber = Double.NaN;
            System.out.println("Infinity: " + infinity);
            System.out.println("NaN: " + notANumber);
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 3: TYPE CONVERSION - WIDENING & NARROWING
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Reference types vs primitives
     * Concepts: null, object references, memory locations
     * Important: Only references can be null, not primitives
     */
    static class Example2 {
        public static void main(String[] args) {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║  REFERENCE TYPES                                       ║");
            System.out.println("╚════════════════════════════════════════════════════════╝\n");

            // String reference
            String str1 = "Hello World";
            System.out.println("String: " + str1);

            // String can be null (primitive int cannot)
            String str2 = null;
            System.out.println("Null String: " + str2);

            // Array reference
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.println("Array: " + java.util.Arrays.toString(numbers));

            // Multiple references to same object
            String original = "Java";
            String copy = original;  // Both point to same object
            System.out.println("\noriginal: " + original);
            System.out.println("copy: " + copy);
            System.out.println("original == copy: " + (original == copy));  // true (same reference)

            // Creating new object
            String newString = new String("Java");
            System.out.println("\nnewString: " + newString);
            System.out.println("original == newString: " + (original == newString));  // false (different objects)
            System.out.println("original.equals(newString): " + (original.equals(newString)));  // true (same content)

            /*
             * KEY INSIGHT:
             * == compares references (memory addresses)
             * .equals() compares content (values)
             * For primitives: == compares values
             * For objects: == compares references, use .equals() for content
             */
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 4: TYPE CASTING & WRAPPER CLASSES
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Automatic and explicit type conversion
     * Concepts: Widening (automatic), Narrowing (requires cast)
     * Important: Narrowing may cause data loss
     */
    static class Example3 {
        public static void main(String[] args) {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║  TYPE CONVERSION - WIDENING & NARROWING               ║");
            System.out.println("╚════════════════════════════════════════════════════════╝\n");

            // WIDENING - Automatic, no data loss
            System.out.println("WIDENING (Automatic, Safe):");

            int intValue = 100;
            long longValue = intValue;  // Automatic
            System.out.println("int to long: " + intValue + " → " + longValue + " (No cast needed)");

            int intVal = 42;
            double doubleVal = intVal;  // Automatic
            System.out.println("int to double: " + intVal + " → " + doubleVal);

            byte byteVal = 10;
            short shortVal = byteVal;  // Automatic
            int intVal2 = byteVal;     // Automatic
            System.out.println("byte → short → int: " + byteVal + " → " + shortVal + " → " + intVal2);

            // NARROWING - Requires explicit cast, may lose data
            System.out.println("\nNARROWING (Requires Cast, May Lose Data):");

            double largeDouble = 100.99;
            int intFromDouble = (int) largeDouble;  // Explicit cast required
            System.out.println("double to int: " + largeDouble + " → " + intFromDouble + " (Lost decimal part)");

            long largeLong = 300;
            byte byteFromLong = (byte) largeLong;  // May overflow
            System.out.println("long to byte: " + largeLong + " → " + byteFromLong);

            // Data loss example
            int largeInt = 300;
            byte smallByte = (byte) largeInt;  // Overflow - wraps around
            System.out.println("Overflow: 300 as byte = " + smallByte + " (Wrapped around)");

            // MIXED OPERATIONS
            System.out.println("\nMIXED TYPE OPERATIONS:");
            int a = 10;
            double b = 3.5;
            double result = a + b;  // int automatically widened to double
            System.out.println(a + " + " + b + " = " + result);

            /*
             * CONVERSION HIERARCHY:
             * byte → short → int → long → float → double
             * char → int (and beyond)
             *
             * Rule: Smaller type auto-converts to larger type
             * Larger to smaller requires explicit cast
             */
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 5: VARIABLE SCOPE & LIFETIME
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Explicit casting, wrapper classes, boxing/unboxing
     * Concepts: Type conversion, object wrapping of primitives
     */
    static class Example4 {
        public static void main(String[] args) {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║  TYPE CASTING & WRAPPER CLASSES                        ║");
            System.out.println("╚════════════════════════════════════════════════════════╝\n");

            // EXPLICIT CASTING
            System.out.println("EXPLICIT CASTING:");
            double pi = 3.14159;
            int truncated = (int) pi;
            System.out.println("3.14159 cast to int: " + truncated + " (Truncated, not rounded)");

            float floatVal = 2.5f;
            int intVal = (int) floatVal;
            System.out.println("2.5f cast to int: " + intVal);

            // WRAPPER CLASSES - Object wrappers for primitives
            System.out.println("\nWRAPPER CLASSES:");

            // Boxing - primitive to wrapper object
            int primitive = 42;
            Integer wrapped = primitive;  // Auto-boxing
            System.out.println("Auto-boxing: " + primitive + " → " + wrapped + " (as Integer object)");

            // Unboxing - wrapper object to primitive
            Integer boxedInt = 100;
            int unboxed = boxedInt;  // Auto-unboxing
            System.out.println("Auto-unboxing: " + boxedInt + " → " + unboxed + " (as primitive)");

            // String conversion
            System.out.println("\nSTRING CONVERSION:");
            int num = 123;
            String str1 = String.valueOf(num);  // Method 1
            String str2 = "" + num;             // Method 2 (concatenation)
            String str3 = Integer.toString(num);// Method 3
            System.out.println("int to String: " + str1 + ", " + str2 + ", " + str3);

            // String to number
            String numStr = "456";
            int parsed = Integer.parseInt(numStr);
            System.out.println("String to int: \"" + numStr + "\" → " + parsed);

            double doubleParsed = Double.parseDouble("3.14");
            System.out.println("String to double: \"3.14\" → " + doubleParsed);

            // Wrapper constants
            System.out.println("\nWRAPPER CLASS CONSTANTS:");
            System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
            System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
            System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
            System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // EXAMPLE 6: FINAL VARIABLES & CONSTANTS
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Variable scope, lifetime, shadowing
     * Concepts: Local, instance, class variables
     */
    static class Example5 {
        static int classVariable = 100;  // Class variable (static)
        int instanceVariable = 50;        // Instance variable (non-static)

        public static void main(String[] args) {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║  VARIABLE SCOPE & LIFETIME                             ║");
            System.out.println("╚════════════════════════════════════════════════════════╝\n");

            int localVar = 10;  // Local variable (method scope)
            System.out.println("Local variable: " + localVar);


            {  // Block scope
                int blockVar = 20;
                System.out.println("Block-scoped variable: " + blockVar);
                // blockVar not accessible outside this block
            }

            // blockVar would cause error here

            // Loop scope
            for (int i = 0; i < 3; i++) {
                System.out.println("Loop variable i: " + i);
            }
            // i not accessible here
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // MAIN - RUN EXAMPLES
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Demonstrates: Final keyword for creating constants
     * Concepts: Immutability, constants
     */
    static class Example6 {
        // Class constants (final static)
        static final double PI = 3.14159;
        static final String COMPANY = "MasterJava";

        public static void main(String[] args) {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║  FINAL VARIABLES & CONSTANTS                           ║");
            System.out.println("╚════════════════════════════════════════════════════════╝\n");

            // Final local variable
            final int MAX_ATTEMPTS = 5;
            System.out.println("MAX_ATTEMPTS: " + MAX_ATTEMPTS);

            // This would cause error:
            // MAX_ATTEMPTS = 10;  // Error: cannot assign to final variable

            System.out.println("PI: " + PI);
            System.out.println("COMPANY: " + COMPANY);

            // Convention: Constants in UPPERCASE with underscores
            final double GROWTH_RATE = 0.05;
            System.out.println("GROWTH_RATE: " + GROWTH_RATE);

            System.out.println("\nBenefits of final:");
            System.out.println("✓ Prevents accidental modification");
            System.out.println("✓ Compiler optimization");
            System.out.println("✓ Thread-safe");
            System.out.println("✓ Intent clear to reader");
        }
    }

    // ═════════════════════════════════════════════════════════════════════════════
    // INTERVIEW Q&A
    // ═════════════════════════════════════════════════════════════════════════════

    /**
     * Q1: What are the 8 primitive data types in Java?
     * A: byte, short, int, long, float, double, boolean, char
     *
     * Q2: What's the difference between int and Integer?
     * A: int is a primitive type (stored by value on stack)
     *    Integer is a wrapper class (stored as object on heap)
     *    Integer can be null, int cannot be null
     *
     * Q3: What's the default value of different primitives?
     * A: byte/short/int/long: 0
     *    float/double: 0.0
     *    boolean: false
     *    char: '\u0000'
     *
     * Q4: Why does 300 become 44 when cast to byte?
     * A: byte range is -128 to 127. 300 exceeds range.
     *    300 in binary: 00000001 00101100
     *    Taking last 8 bits: 00101100 = 44
     *    This is called "overflow"
     *
     * Q5: When to use float vs double?
     * A: double is default and has more precision
     *    Use float only when memory critical (arrays of floats)
     *    Use BigDecimal for financial calculations
     *
     * Q6: Can you use == to compare Integers?
     * A: Yes, but risky. It compares references, not values.
     *    Integer a = 100; Integer b = 100;
     *    a == b might be true (cached) or false (different objects)
     *    Use a.equals(b) for safe comparison
     *
     * Q7: What is autoboxing and unboxing?
     * A: Autoboxing: automatic conversion of primitive to wrapper object
     *    int x = 5; Integer y = x;  // Automatic
     *    Unboxing: automatic conversion of wrapper to primitive
     *    Integer x = 5; int y = x;  // Automatic
     *
     * Q8: Difference between == and .equals()?
     * A: For primitives: == compares values
     *    For objects: == compares references (memory address)
     *    .equals() compares content
     *    Always use .equals() for object comparison
     *
     * Q9: Can you cast from double to int without losing data?
     * A: No. Casting double to int always loses decimal part.
     *    double x = 3.99; int y = (int) x;  // y = 3
     *    Use Math.round() if rounding desired
     *
     * Q10: What is type promotion?
     * A: When different numeric types are used together,
     *    they're promoted to larger type:
     *    int + double = double (int promoted to double)
     *    byte + short = int (both promoted to int)
     *
     * Q11: Why is final used for constants?
     * A: Makes code intent clear (won't change)
     *    Enables compiler optimization
     *    Thread-safe (can be shared safely)
     *    Prevents accidental modification
     *
     * Q12: What's the range of int?
     * A: -2,147,483,648 to 2,147,483,647
     *    Or -2^31 to 2^31 - 1
     *
     * Q13: What's the range of long?
     * A: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
     *    Or -2^63 to 2^63 - 1
     *    Must use L suffix for long literals: 1000000000000L
     *
     * Q14: Can you reassign a final variable?
     * A: No. Once assigned, cannot change.
     *    final int x = 5;
     *    x = 10;  // Compile error!
     *
     * Q15: Difference between String str1 = "A" and String str1 = new String("A")?
     * A: First: str1 points to string pool
     *    Second: str1 points to new object on heap
     *    str1 == "A" is true for first, false for second
     *    str1.equals("A") is true for both
     */
}