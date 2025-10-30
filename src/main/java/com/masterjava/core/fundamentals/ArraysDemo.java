package com.masterjava.core.fundamentals;

import java.util.Arrays;

/**
 * ARRAYS IN JAVA
 * ==============
 *
 * Comprehensive guide to arrays in Java:
 * - Single-dimensional arrays
 * - Multi-dimensional arrays
 * - Jagged arrays
 * - Array declaration, initialization, and access
 * - Array operations and manipulations
 * - Common array algorithms
 * - Arrays utility class
 *
 * UNDER THE HOOD:
 * - Arrays are objects in Java (stored in heap)
 * - Array memory layout and contiguous storage
 * - Array bounds checking (ArrayIndexOutOfBoundsException)
 * - Array covariance and type safety
 * - Performance characteristics: O(1) access, fixed size
 *
 * INTERVIEW TOPICS:
 * - Array vs ArrayList differences
 * - Deep copy vs shallow copy
 * - Array sorting and searching algorithms
 * - Two-pointer technique
 * - Sliding window pattern
 * - Time and space complexity
 *
 * @author Master Java Project
 * @version 1.0
 */
public class ArraysDemo {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("ARRAYS IN JAVA - COMPREHENSIVE DEMONSTRATION");
        System.out.println("=".repeat(70));

        demonstrateArrayBasics();
        demonstrateArrayInitialization();
        demonstrateArrayAccess();
        demonstrateMultiDimensionalArrays();
        demonstrateJaggedArrays();
        demonstrateArrayOperations();
        demonstrateArraysCopyMethods();
        demonstrateArraysUtilityClass();
        demonstrateCommonAlgorithms();
        demonstrateArrayPatterns();
        demonstrateAdvancedConcepts();

        // Print interview questions
        printInterviewQuestions();
    }

    /**
     * ARRAY BASICS
     * Understanding array fundamentals
     */
    private static void demonstrateArrayBasics() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("1. ARRAY BASICS");
        System.out.println("=".repeat(70));

        // Array declaration
        int[] numbers1;         // Preferred style
        int numbers2[];         // C-style (not recommended)

        System.out.println("✅ ARRAY CHARACTERISTICS:");
        System.out.println("   • Fixed size (cannot grow or shrink)");
        System.out.println("   • Homogeneous (same data type)");
        System.out.println("   • Zero-indexed (first element at index 0)");
        System.out.println("   • Objects stored in heap memory");
        System.out.println("   • Contiguous memory allocation");

        // Array creation
        numbers1 = new int[5];  // Creates array of 5 integers
        System.out.println("\nCreated array: int[5]");
        System.out.println("Default values (int): " + Arrays.toString(numbers1));

        // Default values for different types
        boolean[] bools = new boolean[3];
        double[] doubles = new double[3];
        String[] strings = new String[3];

        System.out.println("\n📊 DEFAULT VALUES:");
        System.out.println("   boolean[]: " + Arrays.toString(bools) + " (false)");
        System.out.println("   double[]:  " + Arrays.toString(doubles) + " (0.0)");
        System.out.println("   String[]:  " + Arrays.toString(strings) + " (null)");

        // Array is an object
        System.out.println("\n🎯 ARRAY AS OBJECT:");
        System.out.println("   numbers1 instanceof Object: " + (numbers1 instanceof Object));
        System.out.println("   Array class: " + numbers1.getClass().getName());
        System.out.println("   Length: " + numbers1.length + " (property, not method!)");
    }

    /**
     * ARRAY INITIALIZATION
     * Different ways to initialize arrays
     */
    private static void demonstrateArrayInitialization() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("2. ARRAY INITIALIZATION");
        System.out.println("=".repeat(70));

        // Method 1: Declare, create, and initialize separately
        System.out.println("METHOD 1 - Separate steps:");
        int[] arr1;
        arr1 = new int[3];
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        System.out.println("   " + Arrays.toString(arr1));

        // Method 2: Declare and create together
        System.out.println("\nMETHOD 2 - Declare and create:");
        int[] arr2 = new int[5];
        System.out.println("   " + Arrays.toString(arr2) + " (default values)");

        // Method 3: Array initializer (inline initialization)
        System.out.println("\nMETHOD 3 - Array initializer:");
        int[] arr3 = {10, 20, 30, 40, 50};
        System.out.println("   " + Arrays.toString(arr3));

        // Method 4: Anonymous array
        System.out.println("\nMETHOD 4 - Anonymous array:");
        int[] arr4 = new int[]{100, 200, 300};
        System.out.println("   " + Arrays.toString(arr4));

        // Different data types
        System.out.println("\n🎨 DIFFERENT DATA TYPES:");
        double[] decimals = {1.5, 2.5, 3.5};
        char[] letters = {'J', 'A', 'V', 'A'};
        String[] words = {"Hello", "World", "Java"};
        boolean[] flags = {true, false, true};

        System.out.println("   double[]:  " + Arrays.toString(decimals));
        System.out.println("   char[]:    " + Arrays.toString(letters));
        System.out.println("   String[]:  " + Arrays.toString(words));
        System.out.println("   boolean[]: " + Arrays.toString(flags));

        // Array of objects
        System.out.println("\n📦 ARRAY OF OBJECTS:");
        Integer[] integers = {10, 20, 30};  // Wrapper class
        System.out.println("   Integer[]: " + Arrays.toString(integers));
    }

    /**
     * ARRAY ACCESS AND MODIFICATION
     * Reading and writing array elements
     */
    private static void demonstrateArrayAccess() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("3. ARRAY ACCESS AND MODIFICATION");
        System.out.println("=".repeat(70));

        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array: " + Arrays.toString(numbers));

        // Accessing elements
        System.out.println("\n📖 ACCESSING ELEMENTS:");
        System.out.println("   First element (index 0): " + numbers[0]);
        System.out.println("   Last element: " + numbers[numbers.length - 1]);
        System.out.println("   Middle element: " + numbers[numbers.length / 2]);

        // Modifying elements
        System.out.println("\n✏️  MODIFYING ELEMENTS:");
        System.out.println("Before: " + Arrays.toString(numbers));
        numbers[2] = 99;
        System.out.println("After numbers[2] = 99: " + Arrays.toString(numbers));

        // Iterating with traditional for loop
        System.out.println("\n🔄 ITERATION - Traditional for loop:");
        System.out.print("   ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // Iterating with enhanced for loop
        System.out.println("\n🔄 ITERATION - Enhanced for loop:");
        System.out.print("   ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Reverse iteration
        System.out.println("\n◀️  REVERSE ITERATION:");
        System.out.print("   ");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // Array bounds
        System.out.println("\n⚠️  ARRAY BOUNDS:");
        System.out.println("   Valid indices: 0 to " + (numbers.length - 1));
        System.out.println("   Accessing index -1 or " + numbers.length + " throws ArrayIndexOutOfBoundsException");

        try {
            int invalid = numbers[10];  // Will throw exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   ✗ Exception caught: " + e.getClass().getSimpleName());
        }
    }

    /**
     * MULTI-DIMENSIONAL ARRAYS
     * Arrays of arrays (rectangular)
     */
    private static void demonstrateMultiDimensionalArrays() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("4. MULTI-DIMENSIONAL ARRAYS");
        System.out.println("=".repeat(70));

        // 2D array creation
        int[][] matrix = new int[3][4];  // 3 rows, 4 columns
        System.out.println("Created 3x4 matrix (2D array)");

        // Initialization with values
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("\n📊 2D ARRAY (Matrix):");
        printMatrix(grid);

        // Accessing elements
        System.out.println("\n📍 ACCESSING ELEMENTS:");
        System.out.println("   grid[0][0] (top-left): " + grid[0][0]);
        System.out.println("   grid[1][1] (center): " + grid[1][1]);
        System.out.println("   grid[2][2] (bottom-right): " + grid[2][2]);

        // Dimensions
        System.out.println("\n📏 DIMENSIONS:");
        System.out.println("   Rows: " + grid.length);
        System.out.println("   Columns: " + grid[0].length);
        System.out.println("   Total elements: " + (grid.length * grid[0].length));

        // Iterating 2D array
        System.out.println("\n🔄 ITERATION:");
        System.out.println("All elements:");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        // Enhanced for loop
        System.out.println("\nUsing enhanced for loop:");
        for (int[] row : grid) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // 3D array
        System.out.println("\n🧊 3D ARRAY:");
        int[][][] cube = {
                {{1, 2}, {3, 4}},
                {{5, 6}, {7, 8}}
        };
        System.out.println("   3D array shape: 2x2x2");
        System.out.println("   cube[0][0][0]: " + cube[0][0][0]);
        System.out.println("   cube[1][1][1]: " + cube[1][1][1]);
    }

    /**
     * JAGGED ARRAYS
     * Arrays with variable row sizes
     */
    private static void demonstrateJaggedArrays() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("5. JAGGED ARRAYS (Variable Row Sizes)");
        System.out.println("=".repeat(70));

        // Creating jagged array
        int[][] jagged = new int[3][];  // 3 rows, columns not specified
        jagged[0] = new int[2];         // Row 0: 2 columns
        jagged[1] = new int[4];         // Row 1: 4 columns
        jagged[2] = new int[3];         // Row 2: 3 columns

        // Initialize with values
        int[][] triangle = {
                {1},
                {2, 3},
                {4, 5, 6},
                {7, 8, 9, 10}
        };

        System.out.println("📐 JAGGED ARRAY (Triangle):");
        for (int[] row : triangle) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println("\n📏 ROW LENGTHS:");
        for (int i = 0; i < triangle.length; i++) {
            System.out.println("   Row " + i + ": " + triangle[i].length + " elements");
        }

        // Memory efficiency
        System.out.println("\n💾 MEMORY EFFICIENCY:");
        int[][] rectangular = new int[4][4];  // 16 elements
        // triangle has only 10 elements
        System.out.println("   Rectangular 4x4: " + (4 * 4) + " elements");
        System.out.println("   Jagged triangle: " + (1 + 2 + 3 + 4) + " elements");
        System.out.println("   Memory saved: " + (16 - 10) + " elements (37.5%)");
    }

    /**
     * ARRAY OPERATIONS
     * Common operations on arrays
     */
    private static void demonstrateArrayOperations() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("6. ARRAY OPERATIONS");
        System.out.println("=".repeat(70));

        int[] numbers = {5, 2, 8, 1, 9, 3};
        System.out.println("Original array: " + Arrays.toString(numbers));

        // Sum of elements
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("\n➕ SUM: " + sum);

        // Average
        double average = (double) sum / numbers.length;
        System.out.println("📊 AVERAGE: " + average);

        // Find minimum
        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println("⬇️  MINIMUM: " + min);

        // Find maximum
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("⬆️  MAXIMUM: " + max);

        // Count occurrences
        System.out.println("\n🔢 COUNT OCCURRENCES:");
        int[] data = {1, 2, 3, 2, 4, 2, 5};
        int target = 2;
        int count = 0;
        for (int num : data) {
            if (num == target) {
                count++;
            }
        }
        System.out.println("   Array: " + Arrays.toString(data));
        System.out.println("   Occurrences of " + target + ": " + count);

        // Reverse array
        System.out.println("\n🔄 REVERSE ARRAY:");
        int[] original = {1, 2, 3, 4, 5};
        System.out.println("   Original: " + Arrays.toString(original));
        reverseArray(original);
        System.out.println("   Reversed: " + Arrays.toString(original));
    }

    /**
     * ARRAY COPY METHODS
     * Different ways to copy arrays
     */
    private static void demonstrateArraysCopyMethods() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("7. ARRAY COPY METHODS");
        System.out.println("=".repeat(70));

        int[] original = {1, 2, 3, 4, 5};
        System.out.println("Original: " + Arrays.toString(original));

        // Method 1: Manual copy
        System.out.println("\n📋 METHOD 1 - Manual loop:");
        int[] copy1 = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy1[i] = original[i];
        }
        System.out.println("   Copy: " + Arrays.toString(copy1));

        // Method 2: Arrays.copyOf()
        System.out.println("\n📋 METHOD 2 - Arrays.copyOf():");
        int[] copy2 = Arrays.copyOf(original, original.length);
        System.out.println("   Copy: " + Arrays.toString(copy2));

        int[] extended = Arrays.copyOf(original, 8);  // Extend with zeros
        System.out.println("   Extended: " + Arrays.toString(extended));

        // Method 3: Arrays.copyOfRange()
        System.out.println("\n📋 METHOD 3 - Arrays.copyOfRange():");
        int[] partial = Arrays.copyOfRange(original, 1, 4);  // From index 1 to 3
        System.out.println("   Partial [1-3]: " + Arrays.toString(partial));

        // Method 4: System.arraycopy()
        System.out.println("\n📋 METHOD 4 - System.arraycopy():");
        int[] copy4 = new int[5];
        System.arraycopy(original, 0, copy4, 0, original.length);
        System.out.println("   Copy: " + Arrays.toString(copy4));

        // Method 5: clone()
        System.out.println("\n📋 METHOD 5 - clone():");
        int[] copy5 = original.clone();
        System.out.println("   Copy: " + Arrays.toString(copy5));

        // Shallow vs Deep copy
        System.out.println("\n⚠️  SHALLOW VS DEEP COPY:");
        String[][] original2D = {{"A", "B"}, {"C", "D"}};
        String[][] shallow = original2D.clone();
        String[][] deep = new String[original2D.length][];
        for (int i = 0; i < original2D.length; i++) {
            deep[i] = original2D[i].clone();
        }

        original2D[0][0] = "X";
        System.out.println("   After modifying original[0][0] to 'X':");
        System.out.println("   Shallow copy affected: " + Arrays.deepToString(shallow));
        System.out.println("   Deep copy NOT affected: " + Arrays.deepToString(deep));
    }

    /**
     * ARRAYS UTILITY CLASS
     * Built-in methods from java.util.Arrays
     */
    private static void demonstrateArraysUtilityClass() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("8. ARRAYS UTILITY CLASS (java.util.Arrays)");
        System.out.println("=".repeat(70));

        int[] numbers = {5, 2, 8, 1, 9};
        System.out.println("Original: " + Arrays.toString(numbers));

        // Sort
        System.out.println("\n📶 SORT:");
        Arrays.sort(numbers);
        System.out.println("   Sorted: " + Arrays.toString(numbers));

        // Binary search (array must be sorted!)
        System.out.println("\n🔍 BINARY SEARCH:");
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("   Index of 8: " + index);
        System.out.println("   ⚠️  Array must be sorted for binarySearch!");

        // Fill
        System.out.println("\n🎨 FILL:");
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 99);
        System.out.println("   Filled with 99: " + Arrays.toString(fillArray));

        // Fill range
        Arrays.fill(fillArray, 1, 4, 77);  // From index 1 to 3
        System.out.println("   Fill [1-3] with 77: " + Arrays.toString(fillArray));

        // Equals
        System.out.println("\n🔗 EQUALS:");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 4};
        System.out.println("   arr1 == arr2: " + (arr1 == arr2) + " (reference)");
        System.out.println("   Arrays.equals(arr1, arr2): " + Arrays.equals(arr1, arr2) + " (content)");
        System.out.println("   Arrays.equals(arr1, arr3): " + Arrays.equals(arr1, arr3));

        // Deep equals for multidimensional
        System.out.println("\n🔗 DEEP EQUALS (2D arrays):");
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        System.out.println("   Arrays.deepEquals: " + Arrays.deepEquals(matrix1, matrix2));

        // Compare
        System.out.println("\n⚖️  COMPARE:");
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 4};
        int comparison = Arrays.compare(a, b);
        System.out.println("   Arrays.compare(a, b): " + comparison);
        System.out.println("   Negative: a < b, Zero: a == b, Positive: a > b");

        // Mismatch
        System.out.println("\n❌ MISMATCH:");
        int mismatch = Arrays.mismatch(a, b);
        System.out.println("   First mismatch at index: " + mismatch);
    }

    /**
     * COMMON ALGORITHMS
     * Classic array algorithms
     */
    private static void demonstrateCommonAlgorithms() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("9. COMMON ARRAY ALGORITHMS");
        System.out.println("=".repeat(70));

        // Linear Search
        System.out.println("🔍 LINEAR SEARCH:");
        int[] arr = {5, 2, 8, 1, 9};
        int target = 8;
        int foundIndex = linearSearch(arr, target);
        System.out.println("   Array: " + Arrays.toString(arr));
        System.out.println("   Searching for: " + target);
        System.out.println("   Found at index: " + foundIndex);
        System.out.println("   Time Complexity: O(n)");

        // Binary Search (manual implementation)
        System.out.println("\n🎯 BINARY SEARCH:");
        int[] sorted = {1, 2, 5, 8, 9};
        target = 5;
        int bsIndex = binarySearch(sorted, target);
        System.out.println("   Sorted array: " + Arrays.toString(sorted));
        System.out.println("   Searching for: " + target);
        System.out.println("   Found at index: " + bsIndex);
        System.out.println("   Time Complexity: O(log n)");

        // Bubble Sort
        System.out.println("\n🫧 BUBBLE SORT:");
        int[] unsorted = {5, 2, 8, 1, 9};
        System.out.println("   Before: " + Arrays.toString(unsorted));
        bubbleSort(unsorted);
        System.out.println("   After:  " + Arrays.toString(unsorted));
        System.out.println("   Time Complexity: O(n²)");

        // Remove duplicates from sorted array
        System.out.println("\n🗑️  REMOVE DUPLICATES (from sorted array):");
        int[] withDups = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println("   With duplicates: " + Arrays.toString(withDups));
        int newLength = removeDuplicates(withDups);
        System.out.println("   Unique elements: " + newLength);
        System.out.print("   Result: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(withDups[i] + " ");
        }
        System.out.println();

        // Rotate array
        System.out.println("\n🔄 ROTATE ARRAY:");
        int[] toRotate = {1, 2, 3, 4, 5};
        System.out.println("   Original: " + Arrays.toString(toRotate));
        rotateRight(toRotate, 2);
        System.out.println("   Rotated right by 2: " + Arrays.toString(toRotate));
    }

    /**
     * ARRAY PATTERNS
     * Common interview patterns
     */
    private static void demonstrateArrayPatterns() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("10. COMMON ARRAY PATTERNS (Interview Favorites)");
        System.out.println("=".repeat(70));

        // Two Pointer Technique
        System.out.println("👈👉 TWO POINTER TECHNIQUE:");
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("   Array: " + Arrays.toString(arr));
        System.out.println("   Pair with sum 7:");
        findPairWithSum(arr, 7);

        // Sliding Window
        System.out.println("\n🪟 SLIDING WINDOW:");
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("   Array: " + Arrays.toString(nums));
        System.out.println("   Max sum of " + k + " consecutive elements: " + maxSumSubarray(nums, k));

        // Kadane's Algorithm (Maximum Subarray)
        System.out.println("\n📈 KADANE'S ALGORITHM (Max Subarray Sum):");
        int[] kadane = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("   Array: " + Arrays.toString(kadane));
        System.out.println("   Max subarray sum: " + maxSubarraySum(kadane));

        // Dutch National Flag (Sort 0s, 1s, 2s)
        System.out.println("\n🇳🇱 DUTCH NATIONAL FLAG (Sort 0,1,2):");
        int[] dutch = {2, 0, 1, 2, 1, 0};
        System.out.println("   Before: " + Arrays.toString(dutch));
        sortColors(dutch);
        System.out.println("   After:  " + Arrays.toString(dutch));
    }

    /**
     * ADVANCED CONCEPTS
     * Memory, performance, and best practices
     */
    private static void demonstrateAdvancedConcepts() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("11. ADVANCED CONCEPTS & BEST PRACTICES");
        System.out.println("=".repeat(70));

        System.out.println("🧠 MEMORY LAYOUT:");
        System.out.println("   • Array object stored in heap");
        System.out.println("   • Reference variable in stack");
        System.out.println("   • Elements stored contiguously");
        System.out.println("   • int[5] takes: header + (5 × 4 bytes)");

        System.out.println("\n⚡ PERFORMANCE:");
        System.out.println("   • Access by index: O(1) - constant time");
        System.out.println("   • Search (unsorted): O(n) - linear time");
        System.out.println("   • Search (sorted): O(log n) - binary search");
        System.out.println("   • Insert/Delete: O(n) - requires shifting");

        System.out.println("\n🆚 ARRAY VS ARRAYLIST:");
        System.out.println("   ARRAY:");
        System.out.println("   ✓ Fixed size, better performance");
        System.out.println("   ✓ Works with primitives directly");
        System.out.println("   ✗ Cannot resize");

        System.out.println("\n   ARRAYLIST:");
        System.out.println("   ✓ Dynamic size, flexible");
        System.out.println("   ✓ Rich API (add, remove, contains, etc.)");
        System.out.println("   ✗ Only works with objects (boxing overhead)");

        System.out.println("\n✅ BEST PRACTICES:");
        System.out.println("   1. Use Arrays.toString() for printing");
        System.out.println("   2. Use enhanced for-loop when index not needed");
        System.out.println("   3. Check array bounds before access");
        System.out.println("   4. Use Arrays utility methods (sort, search, etc.)");
        System.out.println("   5. Consider ArrayList for dynamic sizing");
        System.out.println("   6. Arrays are covariant: be careful with generics");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("KEY TAKEAWAYS:");
        System.out.println("=".repeat(70));
        System.out.println("✓ Arrays are fixed-size, zero-indexed collections");
        System.out.println("✓ O(1) access time makes arrays very efficient");
        System.out.println("✓ Arrays utility class provides powerful operations");
        System.out.println("✓ Master common patterns: two-pointer, sliding window");
        System.out.println("✓ Understand deep vs shallow copy for nested arrays");
        System.out.println("✓ Use appropriate data structure: array vs ArrayList");
        System.out.println("=".repeat(70));
    }

    // Helper methods for demonstrations

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println("   " + Arrays.toString(row));
        }
    }

    private static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1;
    }

    private static void rotateRight(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void findPairWithSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("   Found: " + arr[left] + " + " + arr[right] + " = " + target);
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("   No pair found");
    }

    private static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    private static int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    private static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low++, mid++);
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high--);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * INTERVIEW QUESTIONS & ANSWERS - ARRAYS
     */
    private static void printInterviewQuestions() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("INTERVIEW QUESTIONS & ANSWERS - ARRAYS");
        System.out.println("=".repeat(70));

        String[][] qa = {
                {
                        "Q1: What is an array? What are its characteristics?",
                        "A: Array is a collection of elements of same type stored contiguously",
                        "   Characteristics:",
                        "   - Fixed size (cannot grow or shrink)",
                        "   - Elements of same type",
                        "   - Zero-indexed (first element at index 0)",
                        "   - Stored in contiguous memory locations",
                        "   - Can be single or multidimensional",
                        "   - Objects in Java (inherits from Object class)",
                        "   Example: int[] arr = new int[5]; // Creates array of size 5"
                },
                {
                        "Q2: Difference between int[] arr and int arr[]?",
                        "A: Both are valid, but int[] arr is preferred",
                        "   int[] arr;   // Recommended (type is array of int)",
                        "   int arr[];   // Valid but C-style",
                        "   For multiple declarations:",
                        "     int[] a, b;     // Both are arrays",
                        "     int a[], b;     // a is array, b is int!",
                        "   Java style guide: Type goes with type declaration (int[])"
                },
                {
                        "Q3: What is default value for array elements?",
                        "A: Depends on element type:",
                        "   Numeric (byte, short, int, long): 0",
                        "   Floating (float, double): 0.0",
                        "   boolean: false",
                        "   char: '\\u0000' (null character)",
                        "   Object references: null",
                        "   Example:",
                        "     int[] nums = new int[3];     // {0, 0, 0}",
                        "     String[] strs = new String[3]; // {null, null, null}"
                },
                {
                        "Q4: Can array size be changed after creation?",
                        "A: No, arrays are fixed size in Java",
                        "   Once created, size cannot be changed",
                        "   Workaround:",
                        "   1. Create new larger array and copy elements",
                        "      int[] newArr = new int[oldArr.length * 2];",
                        "      System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);",
                        "   2. Use ArrayList (dynamic size)",
                        "      ArrayList<Integer> list = new ArrayList<>();",
                        "   Alternative: Use Collections (ArrayList, LinkedList, etc.)"
                },
                {
                        "Q5: What is ArrayIndexOutOfBoundsException?",
                        "A: Runtime exception when accessing invalid index",
                        "   Occurs when:",
                        "   - Index < 0 (negative)",
                        "   - Index >= array.length",
                        "   Example:",
                        "     int[] arr = {1, 2, 3};",
                        "     arr[3] = 10;  // Exception! Valid indices: 0, 1, 2",
                        "   Prevention:",
                        "   - Check: if (index >= 0 && index < arr.length)",
                        "   - Use for-each loop when possible"
                },
                {
                        "Q6: Difference between Array and ArrayList?",
                        "A:",
                        "   Array:",
                        "   - Fixed size",
                        "   - Can hold primitives and objects",
                        "   - Faster (direct access)",
                        "   - Less memory overhead",
                        "   - int[] arr = new int[5];",
                        "   ArrayList:",
                        "   - Dynamic size (can grow/shrink)",
                        "   - Only holds objects (not primitives)",
                        "   - Slower (wrapper overhead)",
                        "   - More memory (stores size, capacity)",
                        "   - ArrayList<Integer> list = new ArrayList<>();",
                        "   Use Array when size is known and performance critical"
                },
                {
                        "Q7: How to copy an array?",
                        "A: Multiple ways:",
                        "   1. Manual loop:",
                        "      for (int i = 0; i < arr.length; i++)",
                        "          copy[i] = arr[i];",
                        "   2. System.arraycopy() [Fastest]:",
                        "      System.arraycopy(src, 0, dest, 0, length);",
                        "   3. Arrays.copyOf():",
                        "      int[] copy = Arrays.copyOf(arr, arr.length);",
                        "   4. clone():",
                        "      int[] copy = arr.clone();",
                        "   Note: All create shallow copy (for object arrays)"
                },
                {
                        "Q8: What is shallow copy vs deep copy?",
                        "A:",
                        "   Shallow Copy:",
                        "   - Copies references, not objects",
                        "   - Both arrays point to same objects",
                        "   - Modifying object in one affects other",
                        "   Example:",
                        "     Person[] arr1 = {new Person(\"John\")};",
                        "     Person[] arr2 = arr1.clone(); // Shallow",
                        "     arr2[0].setName(\"Jane\");",
                        "     // arr1[0] name is also \"Jane\"!",
                        "   Deep Copy:",
                        "   - Creates new objects",
                        "   - Independent copies",
                        "   - Manual implementation needed"
                },
                {
                        "Q9: Can you store different types in array?",
                        "A: No, arrays are type-safe (single type only)",
                        "   Invalid:",
                        "     int[] mixed = {1, \"Hello\", 2.5}; // Compile error",
                        "   Workaround using Object[]:",
                        "     Object[] mixed = {1, \"Hello\", 2.5};",
                        "   But:",
                        "   - Loses type safety",
                        "   - Requires casting",
                        "   - Not recommended",
                        "   Better alternative: Use proper data structure or class"
                },
                {
                        "Q10: How to find length of multidimensional array?",
                        "A:",
                        "   2D Array:",
                        "     int[][] matrix = new int[3][4];",
                        "     matrix.length        → 3 (number of rows)",
                        "     matrix[0].length     → 4 (columns in first row)",
                        "   Jagged Array (different row lengths):",
                        "     int[][] jagged = {{1,2}, {3,4,5}, {6}};",
                        "     jagged.length        → 3 (rows)",
                        "     jagged[0].length     → 2",
                        "     jagged[1].length     → 3",
                        "     jagged[2].length     → 1"
                },
                {
                        "Q11: What is the difference between length and length()?",
                        "A:",
                        "   length (property):",
                        "   - For arrays",
                        "   - int[] arr = {1,2,3};",
                        "   - arr.length → 3",
                        "   length() (method):",
                        "   - For String",
                        "   - String str = \"Hello\";",
                        "   - str.length() → 5",
                        "   Why different?",
                        "   - Array length is immutable property (final)",
                        "   - String length needs to be calculated"
                },
                {
                        "Q12: Can you make array immutable?",
                        "A: Array size is immutable, but elements can be changed",
                        "   Workarounds:",
                        "   1. final keyword (only prevents reassignment):",
                        "      final int[] arr = {1, 2, 3};",
                        "      arr[0] = 10;  // OK - modifying element",
                        "      arr = new int[5]; // Error - reassignment",
                        "   2. Unmodifiable list:",
                        "      List<Integer> list = Arrays.asList(1, 2, 3);",
                        "      list = Collections.unmodifiableList(list);",
                        "   3. Java 9+ List.of():",
                        "      List<Integer> immutable = List.of(1, 2, 3);"
                },
                {
                        "Q13: What is Arrays.sort()? Time complexity?",
                        "A: Utility method to sort arrays",
                        "   Usage:",
                        "     int[] arr = {5, 2, 8, 1};",
                        "     Arrays.sort(arr);  // {1, 2, 5, 8}",
                        "   Algorithm:",
                        "   - Primitives: Dual-Pivot Quicksort",
                        "   - Objects: TimSort (modified merge sort)",
                        "   Time Complexity:",
                        "   - Average: O(n log n)",
                        "   - Worst: O(n²) for Quicksort, O(n log n) for TimSort",
                        "   Custom comparator for objects:",
                        "     Arrays.sort(arr, Comparator.comparing(Person::getAge));"
                },
                {
                        "Q14: What is varargs? How is it different from array?",
                        "A: Variable arguments - accepts variable number of arguments",
                        "   Syntax:",
                        "     public void method(int... numbers) { }",
                        "   Usage:",
                        "     method(1, 2, 3, 4, 5);  // Any number",
                        "     method();                // Even zero",
                        "   Internally treated as array:",
                        "     // numbers is int[]",
                        "   Differences from array:",
                        "   - More flexible calling syntax",
                        "   - Must be last parameter",
                        "   - Only one varargs per method",
                        "   Example: String.format(\"%s %d\", \"Age\", 25);"
                },
                {
                        "Q15: How to convert array to ArrayList and vice versa?",
                        "A:",
                        "   Array to ArrayList:",
                        "   1. Arrays.asList() [Fixed-size list]:",
                        "      List<Integer> list = Arrays.asList(1, 2, 3);",
                        "   2. New ArrayList [Modifiable]:",
                        "      List<Integer> list = new ArrayList<>(Arrays.asList(arr));",
                        "   3. Java 8 Stream:",
                        "      List<Integer> list = Arrays.stream(arr)",
                        "                                 .boxed()",
                        "                                 .collect(Collectors.toList());",
                        "   ArrayList to Array:",
                        "   1. toArray():",
                        "      Integer[] arr = list.toArray(new Integer[0]);",
                        "   2. Java 8 Stream:",
                        "      int[] arr = list.stream().mapToInt(i -> i).toArray();"
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
        System.out.println("✓ Arrays are fixed size, use ArrayList for dynamic size");
        System.out.println("✓ Array indices start at 0, valid range: 0 to length-1");
        System.out.println("✓ Default values: 0 for numeric, false for boolean, null for objects");
        System.out.println("✓ Use Arrays.sort() for sorting (O(n log n))");
        System.out.println("✓ clone() creates shallow copy for object arrays");
        System.out.println("✓ length is property, length() is method");
        System.out.println("✓ Know how to convert between array and ArrayList");
        System.out.println("=".repeat(70));
    }
}