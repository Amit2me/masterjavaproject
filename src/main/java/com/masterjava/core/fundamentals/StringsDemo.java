package com.masterjava.core.fundamentals;

/**
 * LESSON 11: STRINGS & STRING MANIPULATION
 * =========================================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand String immutability
 * 2. Master String pool and memory management
 * 3. Learn String vs StringBuilder vs StringBuffer
 * 4. Master common String methods
 * 5. Understand String comparison
 * 6. Learn String formatting
 * 7. Master regular expressions basics
 * 8. Understand String performance considerations
 * 
 * UNDER THE HOOD (JVM):
 * --------------------
 * STRING POOL (String Interning):
 * - Special memory region in Heap
 * - Stores unique String literals
 * - "Hello" → stored once, reused
 * - Saves memory
 * 
 * MEMORY LAYOUT:
 * -------------
 * String Pool (Heap):
 *   "Java"    ← Stored once
 *   "Hello"   ← Stored once
 * 
 * Stack:
 *   str1 → points to "Java" in pool
 *   str2 → points to "Java" in pool (same object!)
 *   str3 → points to new String("Java") in heap (different object)
 * 
 * IMMUTABILITY:
 * - String objects cannot be changed
 * - Any modification creates new String
 * - Thread-safe by default
 * - Enables String pool optimization
 * 
 * @author Master Java Project
 * @version 1.0
 * @since 2024
 */
public class StringsDemo {

    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   LESSON 11: STRINGS                  ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: STRING CREATION & IMMUTABILITY
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. STRING CREATION & IMMUTABILITY ━━━");
        
        demonstrateStringCreation();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: STRING POOL
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. STRING POOL ━━━");
        
        demonstrateStringPool();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: STRING COMPARISON
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. STRING COMPARISON ━━━");
        
        demonstrateStringComparison();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: STRING METHODS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. COMMON STRING METHODS ━━━");
        
        demonstrateStringMethods();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: STRINGBUILDER
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. STRINGBUILDER ━━━");
        
        demonstrateStringBuilder();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: STRINGBUFFER
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. STRINGBUFFER ━━━");
        
        demonstrateStringBuffer();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: STRING FORMATTING
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. STRING FORMATTING ━━━");
        
        demonstrateStringFormatting();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: STRING MANIPULATION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. STRING MANIPULATION ━━━");
        
        demonstrateStringManipulation();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: PERFORMANCE COMPARISON
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. PERFORMANCE COMPARISON ━━━");
        
        demonstratePerformance();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 10: REGULAR EXPRESSIONS BASICS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 10. REGULAR EXPRESSIONS ━━━");
        
        demonstrateRegex();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        StringInterviewQuestions.printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // SECTION DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateStringCreation() {
        // Literal - goes to String pool
        String str1 = "Hello";
        System.out.println("  Literal: " + str1);
        
        // Using new - creates object in heap
        String str2 = new String("Hello");
        System.out.println("  Using new: " + str2);
        
        // Character array
        char[] chars = {'J', 'a', 'v', 'a'};
        String str3 = new String(chars);
        System.out.println("  From char array: " + str3);
        
        // Byte array
        byte[] bytes = {72, 101, 108, 108, 111};
        String str4 = new String(bytes);
        System.out.println("  From byte array: " + str4);
        
        // Immutability demonstration
        String original = "Java";
        System.out.println("\n  Original: " + original);
        
        String modified = original.concat(" Programming");
        System.out.println("  After concat: " + modified);
        System.out.println("  Original unchanged: " + original + " (Immutable!)");
    }

    private static void demonstrateStringPool() {
        // String literals - same object from pool
        String s1 = "Java";
        String s2 = "Java";
        System.out.println("  s1 = \"Java\"");
        System.out.println("  s2 = \"Java\"");
        System.out.println("  s1 == s2: " + (s1 == s2) + " (Same object in pool)");
        
        System.out.println();
        
        // Using new - different objects
        String s3 = new String("Java");
        String s4 = new String("Java");
        System.out.println("  s3 = new String(\"Java\")");
        System.out.println("  s4 = new String(\"Java\")");
        System.out.println("  s3 == s4: " + (s3 == s4) + " (Different objects)");
        System.out.println("  s3.equals(s4): " + s3.equals(s4) + " (Same content)");
        
        System.out.println();
        
        // intern() - add to pool
        String s5 = new String("Java").intern();
        System.out.println("  s5 = new String(\"Java\").intern()");
        System.out.println("  s1 == s5: " + (s1 == s5) + " (intern returns pool reference)");
    }

    private static void demonstrateStringComparison() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = "hello";
        
        // == comparison (reference)
        System.out.println("  str1 == str2: " + (str1 == str2));
        System.out.println("  str1 == str3: " + (str1 == str3));
        
        // equals() comparison (content)
        System.out.println("  str1.equals(str3): " + str1.equals(str3));
        System.out.println("  str1.equals(str4): " + str1.equals(str4));
        
        // equalsIgnoreCase()
        System.out.println("  str1.equalsIgnoreCase(str4): " + str1.equalsIgnoreCase(str4));
        
        // compareTo()
        System.out.println("\n  \"Apple\".compareTo(\"Banana\"): " + "Apple".compareTo("Banana"));
        System.out.println("  \"Banana\".compareTo(\"Apple\"): " + "Banana".compareTo("Apple"));
        System.out.println("  \"Java\".compareTo(\"Java\"): " + "Java".compareTo("Java"));
    }

    private static void demonstrateStringMethods() {
        String str = "  Hello Java World  ";
        
        // Length
        System.out.println("  length(): " + str.length());
        
        // Trim
        System.out.println("  trim(): '" + str.trim() + "'");
        
        // Case conversion
        System.out.println("  toUpperCase(): " + str.toUpperCase());
        System.out.println("  toLowerCase(): " + str.toLowerCase());
        
        // Substring
        String text = "Hello World";
        System.out.println("\n  substring(0, 5): " + text.substring(0, 5));
        System.out.println("  substring(6): " + text.substring(6));
        
        // Contains, startsWith, endsWith
        System.out.println("\n  contains(\"World\"): " + text.contains("World"));
        System.out.println("  startsWith(\"Hello\"): " + text.startsWith("Hello"));
        System.out.println("  endsWith(\"World\"): " + text.endsWith("World"));
        
        // Replace
        System.out.println("\n  replace('o', 'O'): " + text.replace('o', 'O'));
        System.out.println("  replaceAll(\"[aeiou]\", \"*\"): " + text.replaceAll("[aeiou]", "*"));
        
        // Split
        String csv = "Java,Python,JavaScript";
        String[] languages = csv.split(",");
        System.out.println("\n  split(\",\"): ");
        for (String lang : languages) {
            System.out.println("    - " + lang);
        }
        
        // Join (Java 8+)
        String joined = String.join(" | ", languages);
        System.out.println("  join(\" | \"): " + joined);
        
        // charAt, indexOf
        System.out.println("\n  charAt(0): " + text.charAt(0));
        System.out.println("  indexOf('o'): " + text.indexOf('o'));
        System.out.println("  lastIndexOf('o'): " + text.lastIndexOf('o'));
    }

    private static void demonstrateStringBuilder() {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("  Initial: " + sb);
        
        // Append
        sb.append(" World");
        System.out.println("  After append(\" World\"): " + sb);
        
        // Insert
        sb.insert(6, "Java ");
        System.out.println("  After insert(6, \"Java \"): " + sb);
        
        // Delete
        sb.delete(11, 17);
        System.out.println("  After delete(11, 17): " + sb);
        
        // Reverse
        StringBuilder temp = new StringBuilder("Java");
        System.out.println("  Original: " + temp);
        temp.reverse();
        System.out.println("  After reverse(): " + temp);
        
        // Capacity
        StringBuilder capacity = new StringBuilder();
        System.out.println("\n  Initial capacity: " + capacity.capacity());
        capacity.append("Hello");
        System.out.println("  After 'Hello': " + capacity.capacity());
        
        // Chain methods
        StringBuilder chain = new StringBuilder();
        String result = chain.append("Hello")
                             .append(" ")
                             .append("World")
                             .toString();
        System.out.println("  Method chaining: " + result);
    }

    private static void demonstrateStringBuffer() {
        StringBuffer sbf = new StringBuffer("Thread");
        System.out.println("  Initial: " + sbf);
        
        sbf.append("-Safe");
        System.out.println("  After append(\"-Safe\"): " + sbf);
        
        System.out.println("\n  ✓ StringBuffer is thread-safe (synchronized)");
        System.out.println("  ✓ StringBuilder is faster (not synchronized)");
        System.out.println("  ✓ Use StringBuffer in multi-threaded environment");
    }

    private static void demonstrateStringFormatting() {
        // String.format()
        String name = "Alice";
        int age = 25;
        double salary = 50000.50;
        
        String formatted = String.format("Name: %s, Age: %d, Salary: $%.2f", name, age, salary);
        System.out.println("  " + formatted);
        
        // printf()
        System.out.printf("  %%d: %d (integer)%n", 42);
        System.out.printf("  %%f: %f (float)%n", 3.14);
        System.out.printf("  %%.2f: %.2f (2 decimals)%n", 3.14159);
        System.out.printf("  %%s: %s (string)%n", "Hello");
        System.out.printf("  %%10s: %10s (width 10)%n", "Hi");
        System.out.printf("  %%-10s: %-10s (left-aligned)%n", "Hi");
        
        // Text blocks (Java 15+)
        String json = """
            {
              "name": "John",
              "age": 30
            }
            """;
        System.out.println("\n  Text block:");
        System.out.println(json);
    }

    private static void demonstrateStringManipulation() {
        // Palindrome check
        String word = "radar";
        boolean isPalindrome = word.equals(new StringBuilder(word).reverse().toString());
        System.out.println("  '" + word + "' is palindrome: " + isPalindrome);
        
        // Count vowels
        String text = "Hello World";
        int vowelCount = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowelCount++;
            }
        }
        System.out.println("  Vowels in '" + text + "': " + vowelCount);
        
        // Remove whitespace
        String withSpaces = "H e l l o";
        String noSpaces = withSpaces.replaceAll("\\s+", "");
        System.out.println("  Remove spaces: '" + withSpaces + "' → '" + noSpaces + "'");
        
        // Reverse words
        String sentence = "Hello Java World";
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        System.out.println("  Reverse words: " + reversed.toString().trim());
    }

    private static void demonstratePerformance() {
        int iterations = 10000;
        
        // String concatenation (slow)
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        long stringTime = System.currentTimeMillis() - start;
        
        // StringBuilder (fast)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long sbTime = System.currentTimeMillis() - start;
        
        System.out.println("  String concatenation: " + stringTime + "ms");
        System.out.println("  StringBuilder: " + sbTime + "ms");
        System.out.println("  ⚡ StringBuilder is " + (stringTime / (sbTime + 1)) + "x faster");
        
        System.out.println("\n  💡 Use StringBuilder for loops/multiple concatenations");
    }

    private static void demonstrateRegex() {
        String email = "user@example.com";
        String phone = "123-456-7890";
        String text = "Java123Python456";
        
        // Email validation
        boolean validEmail = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        System.out.println("  Email valid: " + validEmail);
        
        // Phone validation
        boolean validPhone = phone.matches("\\d{3}-\\d{3}-\\d{4}");
        System.out.println("  Phone valid: " + validPhone);
        
        // Extract numbers
        String numbers = text.replaceAll("[^0-9]", "");
        System.out.println("  Numbers only: " + numbers);
        
        // Extract letters
        String letters = text.replaceAll("[^a-zA-Z]", "");
        System.out.println("  Letters only: " + letters);
        
        // Split by digits
        String[] parts = text.split("\\d+");
        System.out.print("  Split by digits: ");
        for (String part : parts) {
            if (!part.isEmpty()) {
                System.out.print(part + " ");
            }
        }
        System.out.println();
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class StringInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║          INTERVIEW QUESTIONS - STRINGS                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. Why is String immutable in Java?",
                "ANSWER: Design decision with multiple benefits",
                "  Reasons:",
                "  1. String Pool: Enables string literal reuse",
                "  2. Security: Prevents modification of sensitive data",
                "  3. Thread-safety: No synchronization needed",
                "  4. Hashcode caching: HashMap key efficiency",
                "  5. Class loading: Class names are strings",
                "  Trade-off: Creates new object for each modification"
            },
            {
                "2. What is String pool?",
                "ANSWER: Special memory region in heap for String literals",
                "  How it works:",
                "  - String literals stored once",
                "  - Same literal reused",
                "  - Example: \"Java\" stored once, all references point to it",
                "  Benefits:",
                "  - Memory efficiency",
                "  - Fast comparison (==)",
                "  intern() method: Adds string to pool"
            },
            {
                "3. Difference between String, StringBuilder, and StringBuffer?",
                "ANSWER:",
                "  String:",
                "  - Immutable",
                "  - Thread-safe (can't be modified)",
                "  - Slow for concatenation in loops",
                "  StringBuilder:",
                "  - Mutable",
                "  - NOT thread-safe",
                "  - Fast (no synchronization overhead)",
                "  - Use for single-threaded",
                "  StringBuffer:",
                "  - Mutable",
                "  - Thread-safe (synchronized methods)",
                "  - Slower than StringBuilder",
                "  - Use for multi-threaded"
            },
            {
                "4. Difference between == and equals() for Strings?",
                "ANSWER:",
                "  == :",
                "  - Compares references (memory addresses)",
                "  - True if both point to same object",
                "  equals():",
                "  - Compares content (character by character)",
                "  - True if both have same characters",
                "  Example:",
                "    String s1 = \"Java\";",
                "    String s2 = \"Java\";",
                "    String s3 = new String(\"Java\");",
                "    s1 == s2  → true (same pool object)",
                "    s1 == s3  → false (different objects)",
                "    s1.equals(s3) → true (same content)"
            },
            {
                "5. What does intern() method do?",
                "ANSWER: Adds string to String pool or returns existing",
                "  Process:",
                "  1. Check if string exists in pool",
                "  2. If yes, return that reference",
                "  3. If no, add to pool and return reference",
                "  Example:",
                "    String s1 = new String(\"Java\").intern();",
                "    String s2 = \"Java\";",
                "    s1 == s2  → true (both from pool)",
                "  Use case: Reduce memory when many duplicate strings"
            },
            {
                "6. Can we create String using new keyword?",
                "ANSWER: Yes, but creates object in heap, not pool",
                "  Difference:",
                "    String s1 = \"Java\";           // Pool",
                "    String s2 = new String(\"Java\"); // Heap",
                "  Memory:",
                "  - Literal: 1 object in pool",
                "  - new: 2 objects (1 in pool for literal, 1 in heap)",
                "  Best practice: Use literals unless specific need"
            },
            {
                "7. How many objects created: String s = new String(\"Hello\")?",
                "ANSWER: 1 or 2 objects",
                "  Case 1: \"Hello\" doesn't exist in pool",
                "  - 1 object in pool (\"Hello\" literal)",
                "  - 1 object in heap (new String)",
                "  - Total: 2 objects",
                "  Case 2: \"Hello\" already in pool",
                "  - 0 objects in pool (already exists)",
                "  - 1 object in heap (new String)",
                "  - Total: 1 object"
            },
            {
                "8. Can we override equals() and hashCode() for String?",
                "ANSWER: No, String class is final",
                "  - Cannot extend String",
                "  - Cannot override methods",
                "  - Design decision for security and immutability",
                "  String class methods are final"
            },
            {
                "9. Why String is popular as HashMap key?",
                "ANSWER: Perfect characteristics for keys",
                "  Reasons:",
                "  1. Immutable: Key won't change",
                "  2. equals() and hashCode() properly implemented",
                "  3. Hashcode cached: Fast lookup",
                "  4. Thread-safe: No synchronization needed",
                "  If string changed, hashCode would change → wrong bucket!"
            },
            {
                "10. What is the difference between length() and length?",
                "ANSWER:",
                "  length() - method:",
                "  - For String",
                "  - Returns number of characters",
                "  - Example: \"Hello\".length() → 5",
                "  length - property:",
                "  - For arrays",
                "  - Returns array size",
                "  - Example: new int[5].length → 5"
            },
            {
                "11. How to reverse a String?",
                "ANSWER: Multiple approaches",
                "  1. StringBuilder:",
                "     new StringBuilder(str).reverse().toString()",
                "  2. Loop:",
                "     for (int i = str.length()-1; i >= 0; i--)",
                "         reversed += str.charAt(i);",
                "  3. Recursion:",
                "     reverse(str.substring(1)) + str.charAt(0)",
                "  Best: StringBuilder (fastest)"
            },
            {
                "12. Can String be used in switch statement?",
                "ANSWER: Yes, since Java 7",
                "  Example:",
                "    switch(str) {",
                "        case \"MONDAY\": ...",
                "        case \"TUESDAY\": ...",
                "    }",
                "  Behind scenes: Uses hashCode and equals",
                "  Note: Case-sensitive comparison"
            },
            {
                "13. What is String pool location?",
                "ANSWER: Heap memory (Java 7+)",
                "  History:",
                "  - Java 6: PermGen (fixed size)",
                "  - Java 7+: Heap (dynamic, GC eligible)",
                "  Benefits:",
                "  - No OutOfMemory from pool",
                "  - Garbage collected if unreferenced",
                "  - Larger size available"
            },
            {
                "14. Difference between substring() in Java 6 and Java 7?",
                "ANSWER: Memory leak fix",
                "  Java 6:",
                "  - Shared char array with original",
                "  - Could cause memory leak",
                "  - substring keeps reference to original",
                "  Java 7+:",
                "  - Creates new char array",
                "  - No memory leak",
                "  - Original can be GC'd"
            },
            {
                "15. How to compare String ignoring case?",
                "ANSWER: equalsIgnoreCase() method",
                "  Example:",
                "    \"Hello\".equalsIgnoreCase(\"hello\") → true",
                "  Alternative:",
                "    str1.toLowerCase().equals(str2.toLowerCase())",
                "  Note: equalsIgnoreCase() more efficient"
            },
            {
                "16. What are text blocks (Java 15+)?",
                "ANSWER: Multi-line string literals",
                "  Syntax:",
                "    String json = \"\"\"",
                "        {",
                "          \"name\": \"John\"",
                "        }",
                "        \"\"\";",
                "  Benefits:",
                "  - No escape sequences needed",
                "  - Better readability",
                "  - HTML, JSON, SQL queries"
            },
            {
                "17. How to convert String to int and vice versa?",
                "ANSWER:",
                "  String to int:",
                "    int num = Integer.parseInt(\"123\");",
                "    int num = Integer.valueOf(\"123\");",
                "  int to String:",
                "    String str = String.valueOf(123);",
                "    String str = Integer.toString(123);",
                "    String str = \"\" + 123; // Concatenation",
                "  Note: parseInt() throws NumberFormatException"
            },
            {
                "18. What is the output: \"1\" + 2 + 3?",
                "ANSWER: \"123\"",
                "  Evaluation:",
                "  - Left to right",
                "  - \"1\" + 2 → \"12\" (String concatenation)",
                "  - \"12\" + 3 → \"123\" (String concatenation)",
                "  If: 1 + 2 + \"3\" → \"33\" (addition first, then concat)"
            },
            {
                "19. How to check if String is empty or null?",
                "ANSWER: Multiple approaches",
                "  Check null first:",
                "    if (str != null && !str.isEmpty())",
                "  Java 11+:",
                "    if (str != null && !str.isBlank())",
                "  Apache Commons:",
                "    if (StringUtils.isNotBlank(str))",
                "  Difference:",
                "  - isEmpty(): length() == 0",
                "  - isBlank(): only whitespace"
            },
            {
                "20. String best practices?",
                "ANSWER:",
                "  DO:",
                "  - Use literals over new",
                "  - Use StringBuilder in loops",
                "  - Use equals() for comparison",
                "  - Null checks before operations",
                "  - Consider StringBuilder/Buffer for concatenation",
                "  DON'T:",
                "  - Use == for content comparison",
                "  - Concatenate in loops with +",
                "  - Forget null checks",
                "  - Create unnecessary String objects"
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
        System.out.println("✓ String is immutable for security and efficiency");
        System.out.println("✓ String pool stores unique literals in heap");
        System.out.println("✓ Use == for reference, equals() for content comparison");
        System.out.println("✓ StringBuilder for single-threaded, StringBuffer for multi-threaded");
        System.out.println("✓ Use StringBuilder in loops, not + concatenation");
        System.out.println("✓ String literals go to pool, new String() goes to heap");
        System.out.println("✓ intern() adds/retrieves from String pool");
        System.out.println("✓ Always null-check before String operations");
        System.out.println();
    }
}
