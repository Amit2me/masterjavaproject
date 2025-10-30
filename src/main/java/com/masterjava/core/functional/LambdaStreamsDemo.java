package com.masterjava.core.functional;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * LESSON 16: LAMBDA EXPRESSIONS & STREAMS
 * ========================================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand functional programming concepts
 * 2. Master lambda expressions
 * 3. Learn functional interfaces
 * 4. Master method references
 * 5. Understand Stream API
 * 6. Learn intermediate vs terminal operations
 * 7. Master collectors and grouping
 * 8. Understand parallel streams
 * 
 * UNDER THE HOOD (JVM):
 * --------------------
 * LAMBDA IMPLEMENTATION:
 * - NOT anonymous inner classes
 * - Uses invokedynamic (Java 7 bytecode)
 * - Lazily creates lambda at runtime
 * - Better performance than anonymous classes
 * 
 * STREAMS:
 * - Lazy evaluation (intermediate operations)
 * - Short-circuit operations (findFirst, anyMatch)
 * - No storage (operates on source)
 * - Functional in nature
 * - Potentially parallel
 * 
 * STREAM PIPELINE:
 * Source → Intermediate Operations → Terminal Operation
 *          (lazy, returns stream)   (eager, produces result)
 * 
 * PARALLEL STREAMS:
 * - Uses ForkJoinPool
 * - Splits data into chunks
 * - Processes in parallel
 * - Combines results
 * - Good for: CPU-intensive, large data
 * - Bad for: I/O operations, small data
 * 
 * @author Master Java Project
 * @version 2.0
 * @since 2024
 */
public class LambdaStreamsDemo {

    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║     LESSON 16: LAMBDA & STREAMS (JAVA 8+)             ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: LAMBDA BASICS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. LAMBDA EXPRESSIONS ━━━");
        demonstrateLambdaBasics();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: FUNCTIONAL INTERFACES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. FUNCTIONAL INTERFACES ━━━");
        demonstrateFunctionalInterfaces();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: METHOD REFERENCES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. METHOD REFERENCES ━━━");
        demonstrateMethodReferences();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: STREAM BASICS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. STREAM BASICS ━━━");
        demonstrateStreamBasics();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: INTERMEDIATE OPERATIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. INTERMEDIATE OPERATIONS ━━━");
        demonstrateIntermediateOperations();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: TERMINAL OPERATIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. TERMINAL OPERATIONS ━━━");
        demonstrateTerminalOperations();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: COLLECTORS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. COLLECTORS ━━━");
        demonstrateCollectors();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: GROUPING & PARTITIONING
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. GROUPING & PARTITIONING ━━━");
        demonstrateGrouping();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: PARALLEL STREAMS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. PARALLEL STREAMS ━━━");
        demonstrateParallelStreams();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 10: REAL-WORLD EXAMPLES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 10. REAL-WORLD EXAMPLES ━━━");
        demonstrateRealWorldExamples();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        LambdaStreamsInterviewQuestions.printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // SECTION DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateLambdaBasics() {
        System.out.println("  Traditional anonymous class:");
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("    Anonymous class");
            }
        };
        r1.run();
        
        System.out.println("\n  Lambda expression:");
        Runnable r2 = () -> System.out.println("    Lambda expression");
        r2.run();
        
        // Lambda with parameters
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        
        System.out.println("\n  Lambda with parameters:");
        System.out.println("    5 + 3 = " + add.calculate(5, 3));
        System.out.println("    5 * 3 = " + multiply.calculate(5, 3));
        
        // Lambda with block
        Calculator complex = (a, b) -> {
            int result = a + b;
            result *= 2;
            return result;
        };
        System.out.println("    (5 + 3) * 2 = " + complex.calculate(5, 3));
        
        System.out.println("\n  💡 Lambda syntax:");
        System.out.println("  - () -> expression");
        System.out.println("  - (params) -> expression");
        System.out.println("  - (params) -> { statements; }");
    }

    private static void demonstrateFunctionalInterfaces() {
        // Predicate<T> - boolean test(T t)
        System.out.println("  Predicate<T> (test condition):");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("    10 is even: " + isEven.test(10));
        System.out.println("    15 is even: " + isEven.test(15));
        
        // Function<T, R> - R apply(T t)
        System.out.println("\n  Function<T, R> (transform):");
        Function<String, Integer> length = s -> s.length();
        System.out.println("    Length of 'Hello': " + length.apply("Hello"));
        
        // Consumer<T> - void accept(T t)
        System.out.println("\n  Consumer<T> (consume/process):");
        Consumer<String> printer = s -> System.out.println("    " + s);
        printer.accept("Consuming value");
        
        // Supplier<T> - T get()
        System.out.println("\n  Supplier<T> (supply value):");
        Supplier<Double> random = () -> Math.random();
        System.out.println("    Random: " + random.get());
        
        // BiFunction<T, U, R> - R apply(T t, U u)
        System.out.println("\n  BiFunction<T, U, R> (two inputs):");
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("    10 + 20 = " + sum.apply(10, 20));
        
        // UnaryOperator<T> - T apply(T t) [special Function]
        System.out.println("\n  UnaryOperator<T> (same type in/out):");
        UnaryOperator<Integer> square = n -> n * n;
        System.out.println("    Square of 5: " + square.apply(5));
        
        System.out.println("\n  💡 Built-in functional interfaces:");
        System.out.println("  ✓ Predicate - boolean test");
        System.out.println("  ✓ Function - transformation");
        System.out.println("  ✓ Consumer - consumption");
        System.out.println("  ✓ Supplier - generation");
    }

    private static void demonstrateMethodReferences() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        System.out.println("  Lambda:");
        names.forEach(name -> System.out.println("    " + name));
        
        System.out.println("\n  Method reference:");
        names.forEach(System.out::println);
        
        // Static method reference
        Function<String, Integer> parser = Integer::parseInt;
        System.out.println("\n  Static method reference:");
        System.out.println("    Parse '123': " + parser.apply("123"));
        
        // Instance method reference
        String str = "hello";
        Supplier<String> upper = str::toUpperCase;
        System.out.println("\n  Instance method reference:");
        System.out.println("    Uppercase: " + upper.get());
        
        // Constructor reference
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> newList = listSupplier.get();
        System.out.println("\n  Constructor reference:");
        System.out.println("    Created list: " + newList.getClass().getSimpleName());
        
        System.out.println("\n  💡 Method reference types:");
        System.out.println("  - Static: ClassName::staticMethod");
        System.out.println("  - Instance: object::instanceMethod");
        System.out.println("  - Arbitrary: ClassName::instanceMethod");
        System.out.println("  - Constructor: ClassName::new");
    }

    private static void demonstrateStreamBasics() {
        // Create streams
        System.out.println("  Creating streams:");
        
        // From collection
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = numbers.stream();
        System.out.println("    From collection: " + numbers);
        
        // From array
        String[] array = {"A", "B", "C"};
        Stream<String> stream2 = Arrays.stream(array);
        System.out.println("    From array: " + Arrays.toString(array));
        
        // Stream.of()
        Stream<Integer> stream3 = Stream.of(10, 20, 30);
        System.out.println("    Stream.of(): 10, 20, 30");
        
        // Generate
        Stream<Double> stream4 = Stream.generate(Math::random).limit(3);
        System.out.println("    Generated random (limited to 3)");
        
        // Iterate
        Stream<Integer> stream5 = Stream.iterate(0, n -> n + 2).limit(5);
        System.out.println("    Iterate: " + stream5.collect(Collectors.toList()));
        
        System.out.println("\n  💡 Stream characteristics:");
        System.out.println("  - No storage (operates on source)");
        System.out.println("  - Functional (doesn't modify source)");
        System.out.println("  - Lazy evaluation");
        System.out.println("  - Can be infinite");
    }

    private static void demonstrateIntermediateOperations() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // filter
        System.out.println("  filter (even numbers):");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .forEach(n -> System.out.print("    " + n + " "));
        System.out.println();
        
        // map
        System.out.println("\n  map (square each):");
        numbers.stream()
            .map(n -> n * n)
            .limit(5)
            .forEach(n -> System.out.print("    " + n + " "));
        System.out.println();
        
        // flatMap
        System.out.println("\n  flatMap (flatten nested lists):");
        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6)
        );
        nested.stream()
            .flatMap(List::stream)
            .forEach(n -> System.out.print("    " + n + " "));
        System.out.println();
        
        // distinct
        System.out.println("\n  distinct (remove duplicates):");
        Arrays.asList(1, 2, 2, 3, 3, 3, 4).stream()
            .distinct()
            .forEach(n -> System.out.print("    " + n + " "));
        System.out.println();
        
        // sorted
        System.out.println("\n  sorted (ascending):");
        Arrays.asList(5, 2, 8, 1, 9).stream()
            .sorted()
            .forEach(n -> System.out.print("    " + n + " "));
        System.out.println();
        
        // sorted with comparator
        System.out.println("\n  sorted (descending):");
        Arrays.asList(5, 2, 8, 1, 9).stream()
            .sorted(Comparator.reverseOrder())
            .forEach(n -> System.out.print("    " + n + " "));
        System.out.println();
        
        // peek (debugging)
        System.out.println("\n  peek (debug stream):");
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println("    Filtered: " + n))
            .map(n -> n * n)
            .peek(n -> System.out.println("    Squared: " + n))
            .limit(3)
            .collect(Collectors.toList());
        
        System.out.println("\n  💡 Intermediate operations are lazy");
        System.out.println("  - Return new stream");
        System.out.println("  - Not executed until terminal operation");
    }

    private static void demonstrateTerminalOperations() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // forEach
        System.out.print("  forEach: ");
        numbers.stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // count
        long count = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println("  count (even): " + count);
        
        // reduce
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("  reduce (sum): " + sum.orElse(0));
        
        int product = numbers.stream().limit(5).reduce(1, (a, b) -> a * b);
        System.out.println("  reduce (product): " + product);
        
        // collect
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("  collect (to list): " + evens);
        
        // min/max
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("  min: " + min.orElse(0) + ", max: " + max.orElse(0));
        
        // anyMatch, allMatch, noneMatch
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("  anyEven: " + anyEven + ", allPositive: " + allPositive + 
                         ", noneNegative: " + noneNegative);
        
        // findFirst, findAny
        Optional<Integer> first = numbers.stream().filter(n -> n > 5).findFirst();
        Optional<Integer> any = numbers.stream().filter(n -> n > 5).findAny();
        System.out.println("  findFirst: " + first.orElse(0) + ", findAny: " + any.orElse(0));
        
        System.out.println("\n  💡 Terminal operations:");
        System.out.println("  - Produce result or side-effect");
        System.out.println("  - Stream cannot be reused after");
    }

    private static void demonstrateCollectors() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        
        // toList
        List<String> list = names.stream().collect(Collectors.toList());
        System.out.println("  toList: " + list);
        
        // toSet
        Set<String> set = names.stream().collect(Collectors.toSet());
        System.out.println("  toSet: " + set);
        
        // toMap
        Map<String, Integer> map = names.stream()
            .collect(Collectors.toMap(s -> s, String::length));
        System.out.println("  toMap (name -> length): " + map);
        
        // joining
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println("  joining: " + joined);
        
        String prefixed = names.stream()
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("  joining (with prefix/suffix): " + prefixed);
        
        // counting
        long count = names.stream().collect(Collectors.counting());
        System.out.println("  counting: " + count);
        
        // summingInt
        int totalLength = names.stream()
            .collect(Collectors.summingInt(String::length));
        System.out.println("  summingInt (total length): " + totalLength);
        
        // averagingInt
        double avgLength = names.stream()
            .collect(Collectors.averagingInt(String::length));
        System.out.println("  averagingInt: " + avgLength);
        
        // summarizingInt
        IntSummaryStatistics stats = names.stream()
            .collect(Collectors.summarizingInt(String::length));
        System.out.println("  summarizingInt: " + stats);
        
        System.out.println("\n  💡 Collectors are powerful reducers");
    }

    private static void demonstrateGrouping() {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 70000),
            new Employee("Bob", "HR", 50000),
            new Employee("Charlie", "IT", 80000),
            new Employee("David", "HR", 55000),
            new Employee("Eve", "Finance", 60000)
        );
        
        // groupingBy
        System.out.println("  groupingBy (department):");
        Map<String, List<Employee>> byDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
        byDept.forEach((dept, emps) -> {
            System.out.println("    " + dept + ": " + emps.size() + " employees");
        });
        
        // groupingBy with counting
        System.out.println("\n  groupingBy with counting:");
        Map<String, Long> countByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment, 
                Collectors.counting()
            ));
        System.out.println("    " + countByDept);
        
        // groupingBy with averagingDouble
        System.out.println("\n  groupingBy with averagingDouble:");
        Map<String, Double> avgSalary = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
        avgSalary.forEach((dept, avg) -> 
            System.out.println("    " + dept + ": $" + String.format("%.0f", avg))
        );
        
        // partitioningBy
        System.out.println("\n  partitioningBy (salary > 60000):");
        Map<Boolean, List<Employee>> partitioned = employees.stream()
            .collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
        System.out.println("    High salary: " + partitioned.get(true).size());
        System.out.println("    Low salary: " + partitioned.get(false).size());
        
        System.out.println("\n  💡 Grouping operations:");
        System.out.println("  - groupingBy: group by key");
        System.out.println("  - partitioningBy: split by predicate (true/false)");
    }

    private static void demonstrateParallelStreams() {
        List<Integer> largeList = IntStream.rangeClosed(1, 1000)
            .boxed()
            .collect(Collectors.toList());
        
        // Sequential
        long start = System.currentTimeMillis();
        long sum1 = largeList.stream()
            .mapToLong(i -> i)
            .sum();
        long seqTime = System.currentTimeMillis() - start;
        
        // Parallel
        start = System.currentTimeMillis();
        long sum2 = largeList.parallelStream()
            .mapToLong(i -> i)
            .sum();
        long parTime = System.currentTimeMillis() - start;
        
        System.out.println("  Sequential time: " + seqTime + "ms");
        System.out.println("  Parallel time: " + parTime + "ms");
        System.out.println("  Both sums equal: " + (sum1 == sum2));
        
        System.out.println("\n  💡 Parallel streams:");
        System.out.println("  Good for:");
        System.out.println("  - Large data sets");
        System.out.println("  - CPU-intensive operations");
        System.out.println("  - Independent operations");
        System.out.println("\n  Bad for:");
        System.out.println("  - Small data sets (overhead)");
        System.out.println("  - I/O operations");
        System.out.println("  - Operations requiring order");
        System.out.println("  ⚠️  Use with caution!");
    }

    private static void demonstrateRealWorldExamples() {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 999.99, "Electronics"),
            new Product("Mouse", 29.99, "Electronics"),
            new Product("Desk", 199.99, "Furniture"),
            new Product("Chair", 149.99, "Furniture"),
            new Product("Monitor", 299.99, "Electronics")
        );
        
        // Example 1: Filter and transform
        System.out.println("  Example 1: Expensive electronics");
        products.stream()
            .filter(p -> p.getCategory().equals("Electronics"))
            .filter(p -> p.getPrice() > 100)
            .map(Product::getName)
            .forEach(name -> System.out.println("    - " + name));
        
        // Example 2: Calculate total price by category
        System.out.println("\n  Example 2: Total price by category");
        Map<String, Double> totalByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.summingDouble(Product::getPrice)
            ));
        totalByCategory.forEach((cat, total) -> 
            System.out.println("    " + cat + ": $" + String.format("%.2f", total))
        );
        
        // Example 3: Get top 3 most expensive
        System.out.println("\n  Example 3: Top 3 most expensive");
        products.stream()
            .sorted(Comparator.comparing(Product::getPrice).reversed())
            .limit(3)
            .forEach(p -> System.out.println("    " + p.getName() + ": $" + p.getPrice()));
        
        // Example 4: Count products per category
        System.out.println("\n  Example 4: Products per category");
        products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.counting()
            ))
            .forEach((cat, count) -> 
                System.out.println("    " + cat + ": " + count + " products")
            );
        
        // Example 5: Find average price
        System.out.println("\n  Example 5: Average price");
        OptionalDouble avgPrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average();
        System.out.println("    $" + String.format("%.2f", avgPrice.orElse(0)));
        
        System.out.println("\n  💡 Streams make data processing elegant!");
    }
}

// ═══════════════════════════════════════════════════════════
// HELPER CLASSES & INTERFACES
// ═══════════════════════════════════════════════════════════

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

class Employee {
    private String name;
    private String department;
    private double salary;
    
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return name + " (" + department + ", $" + salary + ")";
    }
}

class Product {
    private String name;
    private double price;
    private String category;
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class LambdaStreamsInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║       INTERVIEW QUESTIONS - LAMBDA & STREAMS           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. What is a lambda expression?",
                "ANSWER: Anonymous function with concise syntax (Java 8)",
                "  Characteristics:",
                "  - No name",
                "  - No explicit type declaration",
                "  - Compact syntax",
                "  - Can be passed as argument",
                "  Syntax:",
                "  - () -> expression",
                "  - (params) -> expression",
                "  - (params) -> { statements; }",
                "  Example: (a, b) -> a + b",
                "  Replaces: Anonymous inner classes"
            },
            {
                "2. What is a functional interface?",
                "ANSWER: Interface with exactly one abstract method (SAM)",
                "  Characteristics:",
                "  - Single Abstract Method (SAM)",
                "  - Can have default/static methods",
                "  - @FunctionalInterface annotation (optional)",
                "  - Target type for lambda",
                "  Examples:",
                "  - Runnable: void run()",
                "  - Callable: V call()",
                "  - Comparator: int compare(T, T)",
                "  - Predicate: boolean test(T)"
            },
            {
                "3. Built-in functional interfaces in Java?",
                "ANSWER: java.util.function package",
                "  Main interfaces:",
                "  - Predicate<T>: boolean test(T)",
                "  - Function<T,R>: R apply(T)",
                "  - Consumer<T>: void accept(T)",
                "  - Supplier<T>: T get()",
                "  - BiFunction<T,U,R>: R apply(T,U)",
                "  - UnaryOperator<T>: T apply(T)",
                "  - BinaryOperator<T>: T apply(T,T)",
                "  Primitive variants: IntPredicate, LongFunction, etc."
            },
            {
                "4. What is method reference?",
                "ANSWER: Shorthand for lambda calling existing method",
                "  Types:",
                "  1. Static: ClassName::staticMethod",
                "     Example: Integer::parseInt",
                "  2. Instance: object::instanceMethod",
                "     Example: str::toUpperCase",
                "  3. Arbitrary: ClassName::instanceMethod",
                "     Example: String::length",
                "  4. Constructor: ClassName::new",
                "     Example: ArrayList::new",
                "  Equivalent: Method reference <=> Lambda"
            },
            {
                "5. What is Stream API?",
                "ANSWER: Declarative way to process collections (Java 8)",
                "  Characteristics:",
                "  - No storage (operates on source)",
                "  - Functional (immutable source)",
                "  - Lazy evaluation",
                "  - Possibly unbounded",
                "  - Consumable (use once)",
                "  Pipeline:",
                "    Source → Intermediate → Terminal",
                "  Benefits:",
                "  - Readable code",
                "  - Easy parallelization",
                "  - Declarative approach"
            },
            {
                "6. Difference between intermediate and terminal operations?",
                "ANSWER:",
                "  Intermediate:",
                "  - Return stream",
                "  - Lazy (not executed immediately)",
                "  - Can be chained",
                "  - Examples: filter, map, sorted, distinct",
                "  Terminal:",
                "  - Return result or side-effect",
                "  - Eager (triggers execution)",
                "  - Ends stream pipeline",
                "  - Examples: forEach, collect, reduce, count",
                "  Rule: No terminal = nothing executed"
            },
            {
                "7. What is lazy evaluation in streams?",
                "ANSWER: Operations executed only when needed",
                "  How it works:",
                "  - Intermediate operations build pipeline",
                "  - Nothing executed until terminal operation",
                "  - Process elements one by one",
                "  - Short-circuit when possible",
                "  Example:",
                "    stream.filter(...).map(...); // Nothing happens",
                "    stream.filter(...).map(...).collect(); // Executes",
                "  Benefits:",
                "  - Performance optimization",
                "  - Avoid unnecessary work",
                "  - Works with infinite streams"
            },
            {
                "8. What is the difference between map and flatMap?",
                "ANSWER:",
                "  map:",
                "  - One-to-one transformation",
                "  - Stream<T> → Stream<R>",
                "  - Example: stream.map(String::toUpperCase)",
                "  - Result: [\"A\", \"B\", \"C\"]",
                "  flatMap:",
                "  - One-to-many transformation",
                "  - Stream<T> → Stream<R> (flattens)",
                "  - Example: stream.flatMap(s -> Stream.of(s.split(\" \")))",
                "  - Flattens nested structures",
                "  Use flatMap: When function returns Stream"
            },
            {
                "9. What is reduce operation?",
                "ANSWER: Combines stream elements into single result",
                "  Forms:",
                "  1. Optional<T> reduce(BinaryOperator<T>)",
                "     Example: stream.reduce((a,b) -> a+b)",
                "  2. T reduce(T identity, BinaryOperator<T>)",
                "     Example: stream.reduce(0, (a,b) -> a+b)",
                "  3. <U> U reduce(U identity, BiFunction, BinaryOperator)",
                "     For parallel streams",
                "  Use cases:",
                "  - Sum, product",
                "  - Min, max",
                "  - String concatenation"
            },
            {
                "10. Difference between Collection and Stream?",
                "ANSWER:",
                "  Collection:",
                "  - Data structure",
                "  - Stores elements",
                "  - Can iterate multiple times",
                "  - Eager (all elements in memory)",
                "  - Can add/remove elements",
                "  Stream:",
                "  - Doesn't store elements",
                "  - Process elements",
                "  - Can use only once",
                "  - Lazy evaluation",
                "  - Immutable source",
                "  Convert: collection.stream()"
            },
            {
                "11. What is parallel stream?",
                "ANSWER: Stream that processes elements in parallel",
                "  How it works:",
                "  - Uses ForkJoinPool",
                "  - Splits data into chunks",
                "  - Processes in parallel threads",
                "  - Combines results",
                "  Creation:",
                "    collection.parallelStream()",
                "    stream.parallel()",
                "  Good for:",
                "  - Large data sets",
                "  - CPU-intensive operations",
                "  Bad for: I/O, small data, ordered operations"
            },
            {
                "12. When to use parallel streams?",
                "ANSWER: Large data + CPU-intensive operations",
                "  Use when:",
                "  - Large data set (>10,000 elements)",
                "  - CPU-intensive operations",
                "  - Independent operations",
                "  - Stateless operations",
                "  Avoid when:",
                "  - Small data set (overhead > benefit)",
                "  - I/O operations (blocking)",
                "  - Order matters",
                "  - Shared mutable state",
                "  Always: Benchmark first!"
            },
            {
                "13. What are collectors?",
                "ANSWER: Reduction operation that accumulates into collection",
                "  Common collectors:",
                "  - toList(), toSet(), toMap()",
                "  - joining()",
                "  - groupingBy()",
                "  - partitioningBy()",
                "  - counting()",
                "  - summingInt(), averagingInt()",
                "  - maxBy(), minBy()",
                "  Usage:",
                "    stream.collect(Collectors.toList())",
                "  Custom: Collector interface"
            },
            {
                "14. What is Optional class?",
                "ANSWER: Container that may or may not contain value",
                "  Purpose: Avoid NullPointerException",
                "  Creation:",
                "  - Optional.of(value) // value must not be null",
                "  - Optional.ofNullable(value) // value can be null",
                "  - Optional.empty()",
                "  Methods:",
                "  - get() // throws if empty",
                "  - orElse(default)",
                "  - orElseGet(supplier)",
                "  - isPresent(), ifPresent(consumer)",
                "  - map(), flatMap(), filter()",
                "  Use: Stream terminal operations return Optional"
            },
            {
                "15. Difference between findFirst and findAny?",
                "ANSWER:",
                "  findFirst:",
                "  - Returns first element",
                "  - Deterministic",
                "  - Same result always",
                "  - Use: When order matters",
                "  findAny:",
                "  - Returns any element",
                "  - Non-deterministic in parallel",
                "  - Better performance in parallel",
                "  - Use: When order doesn't matter",
                "  Both: Return Optional<T>"
            },
            {
                "16. What is peek() used for?",
                "ANSWER: Debug intermediate operations",
                "  Behavior:",
                "  - Intermediate operation",
                "  - Doesn't transform elements",
                "  - Performs action on each element",
                "  - Returns same stream",
                "  Usage:",
                "    stream.peek(System.out::println)",
                "  Use cases:",
                "  - Debugging stream pipeline",
                "  - Logging",
                "  - Side effects (use carefully)",
                "  Not for: Modifying elements (use map)"
            },
            {
                "17. Can we reuse a stream?",
                "ANSWER: No, streams are consumable",
                "  Why:",
                "  - Stream is consumed after terminal operation",
                "  - Throws IllegalStateException if reused",
                "  Solution:",
                "  - Create new stream from source",
                "  - Use Supplier<Stream<T>>",
                "  Example error:",
                "    Stream<String> stream = list.stream();",
                "    stream.forEach(...); // OK",
                "    stream.forEach(...); // IllegalStateException"
            },
            {
                "18. What is short-circuit operation?",
                "ANSWER: Operation that can terminate early",
                "  Intermediate:",
                "  - limit(n) // Stop after n elements",
                "  - skip(n) // Skip first n",
                "  Terminal:",
                "  - findFirst(), findAny()",
                "  - anyMatch(), allMatch(), noneMatch()",
                "  Benefit:",
                "  - Don't process entire stream",
                "  - Performance optimization",
                "  - Essential for infinite streams"
            },
            {
                "19. Difference between anyMatch, allMatch, noneMatch?",
                "ANSWER:",
                "  anyMatch:",
                "  - Returns true if ANY element matches",
                "  - Short-circuits on first match",
                "  - Example: stream.anyMatch(n -> n > 10)",
                "  allMatch:",
                "  - Returns true if ALL elements match",
                "  - Short-circuits on first non-match",
                "  - Example: stream.allMatch(n -> n > 0)",
                "  noneMatch:",
                "  - Returns true if NO element matches",
                "  - Short-circuits on first match",
                "  - Example: stream.noneMatch(n -> n < 0)",
                "  All: Return boolean, short-circuit"
            },
            {
                "20. Lambda and Streams best practices?",
                "ANSWER:",
                "  DO:",
                "  - Use method references when possible",
                "  - Keep lambdas short (1-2 lines)",
                "  - Use built-in functional interfaces",
                "  - Prefer streams for collections",
                "  - Use parallel streams for large data",
                "  - Use Optional to avoid null checks",
                "  DON'T:",
                "  - Modify state in lambdas",
                "  - Reuse streams",
                "  - Use parallel for small data",
                "  - Overuse nested lambdas",
                "  - Use peek for side effects (use forEach)",
                "  Remember: Readability over cleverness"
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
        System.out.println("✓ Lambda = anonymous function with concise syntax");
        System.out.println("✓ Functional interface = Single Abstract Method (SAM)");
        System.out.println("✓ Stream = declarative data processing pipeline");
        System.out.println("✓ Intermediate operations are lazy, terminal are eager");
        System.out.println("✓ map transforms 1-to-1, flatMap flattens nested structures");
        System.out.println("✓ Collectors accumulate stream into collections");
        System.out.println("✓ Parallel streams for large data + CPU-intensive work");
        System.out.println("✓ Streams are consumable (cannot reuse)");
        System.out.println();
    }
}
