package com.masterjava.advanced;

import java.util.*;

/**
 * LESSON 13: GENERICS
 * ====================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand generics and type safety
 * 2. Master generic classes and interfaces
 * 3. Learn generic methods
 * 4. Understand bounded type parameters
 * 5. Master wildcards (?, extends, super)
 * 6. Learn type erasure
 * 7. Understand generic restrictions
 * 8. Master real-world generic patterns
 * 
 * UNDER THE HOOD (JVM):
 * --------------------
 * TYPE ERASURE:
 * - Generics are compile-time feature
 * - Type information removed at runtime
 * - Replaced with Object or bound
 * - Bridge methods added for compatibility
 * 
 * BEFORE COMPILATION:
 * List<String> list = new ArrayList<String>();
 * list.add("Hello");
 * String s = list.get(0);
 * 
 * AFTER TYPE ERASURE (BYTECODE):
 * List list = new ArrayList();
 * list.add("Hello");
 * String s = (String) list.get(0); // Cast added by compiler
 * 
 * WHY TYPE ERASURE:
 * 1. Backward compatibility with pre-Java 5 code
 * 2. No runtime overhead
 * 3. Single class file for all type parameters
 * 
 * LIMITATIONS:
 * - Cannot create instances: new T()
 * - Cannot create arrays: new T[]
 * - Cannot use primitives: List<int> (must use List<Integer>)
 * - Cannot check instance: obj instanceof List<String>
 * - Static context cannot use type parameters
 * 
 * @author Master Java Project
 * @version 2.0
 * @since 2024
 */
public class GenericsDemo {

    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           LESSON 13: GENERICS                          ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: WHY GENERICS - PROBLEM WITHOUT GENERICS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. WHY GENERICS? ━━━");
        demonstrateWithoutGenerics();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: GENERIC CLASS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. GENERIC CLASS ━━━");
        demonstrateGenericClass();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: MULTIPLE TYPE PARAMETERS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. MULTIPLE TYPE PARAMETERS ━━━");
        demonstrateMultipleTypeParameters();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: GENERIC METHODS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. GENERIC METHODS ━━━");
        demonstrateGenericMethods();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: BOUNDED TYPE PARAMETERS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. BOUNDED TYPE PARAMETERS ━━━");
        demonstrateBoundedTypes();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: WILDCARDS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. WILDCARDS (?, extends, super) ━━━");
        demonstrateWildcards();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: GENERIC INTERFACE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. GENERIC INTERFACE ━━━");
        demonstrateGenericInterface();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: TYPE ERASURE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. TYPE ERASURE ━━━");
        demonstrateTypeErasure();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: GENERIC RESTRICTIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. GENERIC RESTRICTIONS ━━━");
        demonstrateRestrictions();
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
        GenericsInterviewQuestions.printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // SECTION DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateWithoutGenerics() {
        System.out.println("  Without Generics (Pre-Java 5):");
        
        // Old way - no type safety
        List oldList = new ArrayList();
        oldList.add("String");
        oldList.add(123); // Can add any type!
        oldList.add(45.67);
        
        System.out.println("  ⚠️  Can add any type: " + oldList);
        
        // Runtime error risk
        try {
            String str = (String) oldList.get(1); // ClassCastException!
        } catch (ClassCastException e) {
            System.out.println("  ❌ Runtime error: " + e.getMessage());
        }
        
        System.out.println("\n  With Generics (Java 5+):");
        List<String> newList = new ArrayList<>();
        newList.add("String");
        // newList.add(123); // Compile error - type safety!
        
        String str = newList.get(0); // No cast needed
        System.out.println("  ✓ Type safe: " + str);
        System.out.println("  ✓ No explicit cast needed");
        System.out.println("  ✓ Compile-time error detection");
    }

    private static void demonstrateGenericClass() {
        // Generic Box with Integer
        GenericBox<Integer> intBox = new GenericBox<>(100);
        System.out.println("  Integer Box: " + intBox.get());
        intBox.set(200);
        System.out.println("  After set: " + intBox.get());
        
        // Generic Box with String
        GenericBox<String> strBox = new GenericBox<>("Hello");
        System.out.println("  String Box: " + strBox.get());
        
        // Generic Box with custom object
        GenericBox<Person> personBox = new GenericBox<>(new Person("Alice", 25));
        System.out.println("  Person Box: " + personBox.get());
        
        System.out.println("  ✓ Type safety enforced at compile time");
    }

    private static void demonstrateMultipleTypeParameters() {
        // Key-Value pair
        Pair<String, Integer> pair1 = new Pair<>("Age", 25);
        System.out.println("  Pair: " + pair1.getKey() + " = " + pair1.getValue());
        
        Pair<Integer, String> pair2 = new Pair<>(1, "First");
        System.out.println("  Pair: " + pair2.getKey() + " = " + pair2.getValue());
        
        // Triple
        Triple<String, Integer, Boolean> triple = new Triple<>("Active", 100, true);
        System.out.println("  Triple: " + triple.getFirst() + ", " + 
                          triple.getSecond() + ", " + triple.getThird());
    }

    private static void demonstrateGenericMethods() {
        // Generic method with arrays
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C"};
        
        System.out.println("  Print Integer Array:");
        printArray(intArray);
        
        System.out.println("  Print String Array:");
        printArray(strArray);
        
        // Generic method with return type
        Integer max = getMax(10, 20, 30);
        System.out.println("  Max of 10, 20, 30: " + max);
        
        String maxStr = getMax("Apple", "Banana", "Cherry");
        System.out.println("  Max of strings: " + maxStr);
        
        // Swap
        Pair<String, Integer> beforeSwap = new Pair<>("Name", 25);
        System.out.println("  Before swap: " + beforeSwap);
        Pair<Integer, String> afterSwap = swap(beforeSwap);
        System.out.println("  After swap: " + afterSwap);
    }

    private static void demonstrateBoundedTypes() {
        // Upper bounded
        NumberBox<Integer> intNumberBox = new NumberBox<>(42);
        System.out.println("  Integer NumberBox: " + intNumberBox.get());
        System.out.println("  Double value: " + intNumberBox.getDoubleValue());
        
        NumberBox<Double> doubleNumberBox = new NumberBox<>(3.14);
        System.out.println("  Double NumberBox: " + doubleNumberBox.get());
        
        // NumberBox<String> strBox = new NumberBox<>("Error"); // Compile error!
        
        // Multiple bounds
        BoundedBox<Integer> boundedBox = new BoundedBox<>(100);
        System.out.println("  BoundedBox: " + boundedBox.get());
        System.out.println("  Comparison: " + boundedBox.compareTo(50));
        
        // Sum of numbers
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        double sum = sumOfNumbers(intList);
        System.out.println("  Sum of integers: " + sum);
        
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
        sum = sumOfNumbers(doubleList);
        System.out.println("  Sum of doubles: " + sum);
    }

    private static void demonstrateWildcards() {
        // Unbounded wildcard
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("A", "B", "C");
        
        System.out.println("  Unbounded wildcard (?):");
        printList(intList);
        printList(strList);
        
        // Upper bounded wildcard (? extends)
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        
        System.out.println("\n  Upper bounded (? extends Number):");
        System.out.println("  Sum: " + sumOfList(integers));
        System.out.println("  Sum: " + sumOfList(doubles));
        
        // Lower bounded wildcard (? super)
        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println("\n  Lower bounded (? super Integer): " + numbers);
        
        // PECS: Producer Extends, Consumer Super
        System.out.println("\n  💡 PECS Rule:");
        System.out.println("  - Use 'extends' when reading (Producer)");
        System.out.println("  - Use 'super' when writing (Consumer)");
    }

    private static void demonstrateGenericInterface() {
        // Comparable implementation
        ComparableBox<Integer> box1 = new ComparableBox<>(10);
        ComparableBox<Integer> box2 = new ComparableBox<>(20);
        
        System.out.println("  box1.compareTo(box2): " + box1.compareTo(box2));
        System.out.println("  box2.compareTo(box1): " + box2.compareTo(box1));
        
        // Repository pattern
        Repository<Person> personRepo = new PersonRepository();
        Person person = new Person("Bob", 30);
        personRepo.save(person);
        System.out.println("  Saved: " + personRepo.findById(1));
        System.out.println("  All: " + personRepo.findAll());
    }

    private static void demonstrateTypeErasure() {
        System.out.println("  Type Erasure Concept:");
        System.out.println("  - Generics exist only at compile time");
        System.out.println("  - Runtime: type information erased");
        System.out.println("  - Replaced with Object or bound");
        
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        
        // Same class at runtime
        System.out.println("  strList.getClass(): " + strList.getClass());
        System.out.println("  intList.getClass(): " + intList.getClass());
        System.out.println("  Same class? " + (strList.getClass() == intList.getClass()));
        
        System.out.println("\n  What compiler does:");
        System.out.println("  Before: List<String> list = new ArrayList<>();");
        System.out.println("  After:  List list = new ArrayList();");
        System.out.println("  Before: String s = list.get(0);");
        System.out.println("  After:  String s = (String) list.get(0);");
    }

    private static void demonstrateRestrictions() {
        System.out.println("  Generic Restrictions:");
        System.out.println("  ❌ Cannot instantiate type parameter: new T()");
        System.out.println("  ❌ Cannot create array of type parameter: new T[]");
        System.out.println("  ❌ Cannot use primitives: List<int> (use List<Integer>)");
        System.out.println("  ❌ Cannot instanceof with type: obj instanceof List<String>");
        System.out.println("  ❌ Cannot use in static context");
        System.out.println("  ❌ Cannot create generic exceptions");
        System.out.println("  ❌ Cannot overload with different type parameters");
        
        System.out.println("\n  Workarounds:");
        System.out.println("  ✓ Use Class<T> parameter for instantiation");
        System.out.println("  ✓ Use ArrayList instead of arrays");
        System.out.println("  ✓ Use wrapper classes for primitives");
    }

    private static void demonstrateRealWorldExamples() {
        // Example 1: Generic DAO pattern
        UserDAO userDAO = new UserDAO();
        User user = new User(1, "admin");
        userDAO.save(user);
        System.out.println("  User DAO - Saved: " + userDAO.findById(1).orElse(null));
        
        // Example 2: Generic Builder pattern
        Response<String> successResponse = Response.<String>builder()
            .status(200)
            .data("Success")
            .message("Operation completed")
            .build();
        System.out.println("  Response Builder: " + successResponse);
        
        // Example 3: Generic Cache
        Cache<String, Person> personCache = new Cache<>();
        personCache.put("user1", new Person("John", 25));
        System.out.println("  Cache get: " + personCache.get("user1").orElse(null));
        
        // Example 4: Generic Result wrapper
        Result<Integer> divisionResult = divide(10, 2);
        divisionResult.ifSuccess(value -> 
            System.out.println("  Division result: " + value)
        );
        
        Result<Integer> errorResult = divide(10, 0);
        errorResult.ifFailure(error -> 
            System.out.println("  Division error: " + error)
        );
    }

    // Helper methods
    private static <T> void printArray(T[] array) {
        System.out.print("    ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static <T extends Comparable<T>> T getMax(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;
        return max;
    }

    private static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
        return new Pair<>(pair.getValue(), pair.getKey());
    }

    private static double sumOfNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    private static void printList(List<?> list) {
        System.out.print("    ");
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    private static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    private static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    private static Result<Integer> divide(int a, int b) {
        if (b == 0) {
            return Result.failure("Cannot divide by zero");
        }
        return Result.success(a / b);
    }
}

// ═══════════════════════════════════════════════════════════
// GENERIC CLASSES
// ═══════════════════════════════════════════════════════════

class GenericBox<T> {
    private T value;
    
    public GenericBox(T value) {
        this.value = value;
    }
    
    public T get() {
        return value;
    }
    
    public void set(T value) {
        this.value = value;
    }
}

class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
    
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

class Triple<F, S, T> {
    private F first;
    private S second;
    private T third;
    
    public Triple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public F getFirst() { return first; }
    public S getSecond() { return second; }
    public T getThird() { return third; }
}

// Bounded type parameter
class NumberBox<T extends Number> {
    private T value;
    
    public NumberBox(T value) {
        this.value = value;
    }
    
    public T get() {
        return value;
    }
    
    public double getDoubleValue() {
        return value.doubleValue();
    }
}

// Multiple bounds
class BoundedBox<T extends Number & Comparable<T>> {
    private T value;
    
    public BoundedBox(T value) {
        this.value = value;
    }
    
    public T get() {
        return value;
    }
    
    public int compareTo(T other) {
        return value.compareTo(other);
    }
}

// ═══════════════════════════════════════════════════════════
// GENERIC INTERFACES
// ═══════════════════════════════════════════════════════════

interface Repository<T> {
    void save(T entity);
    T findById(int id);
    List<T> findAll();
    void delete(int id);
}

class PersonRepository implements Repository<Person> {
    private Map<Integer, Person> storage = new HashMap<>();
    private int idCounter = 1;
    
    @Override
    public void save(Person entity) {
        storage.put(idCounter++, entity);
    }
    
    @Override
    public Person findById(int id) {
        return storage.get(id);
    }
    
    @Override
    public List<Person> findAll() {
        return new ArrayList<>(storage.values());
    }
    
    @Override
    public void delete(int id) {
        storage.remove(id);
    }
}

class ComparableBox<T extends Comparable<T>> implements Comparable<ComparableBox<T>> {
    private T value;
    
    public ComparableBox(T value) {
        this.value = value;
    }
    
    @Override
    public int compareTo(ComparableBox<T> other) {
        return this.value.compareTo(other.value);
    }
}

// ═══════════════════════════════════════════════════════════
// REAL-WORLD EXAMPLES
// ═══════════════════════════════════════════════════════════

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

// Generic DAO
class GenericDAO<T> {
    protected Map<Integer, T> storage = new HashMap<>();
    protected int idCounter = 1;
    
    public void save(T entity) {
        storage.put(idCounter++, entity);
    }
    
    public Optional<T> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }
    
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}

class User {
    private int id;
    private String username;
    
    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }
    
    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "'}";
    }
}

class UserDAO extends GenericDAO<User> {
    // Inherits all generic DAO methods
}

// Generic Response
class Response<T> {
    private int status;
    private T data;
    private String message;
    
    private Response(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
    
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }
    
    static class Builder<T> {
        private int status;
        private T data;
        private String message;
        
        public Builder<T> status(int status) {
            this.status = status;
            return this;
        }
        
        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }
        
        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }
        
        public Response<T> build() {
            return new Response<>(status, data, message);
        }
    }
    
    @Override
    public String toString() {
        return "Response{status=" + status + ", data=" + data + ", message='" + message + "'}";
    }
}

// Generic Cache
class Cache<K, V> {
    private Map<K, V> cache = new HashMap<>();
    
    public void put(K key, V value) {
        cache.put(key, value);
    }
    
    public Optional<V> get(K key) {
        return Optional.ofNullable(cache.get(key));
    }
    
    public void clear() {
        cache.clear();
    }
}

// Generic Result (Either pattern)
class Result<T> {
    private T value;
    private String error;
    private boolean isSuccess;
    
    private Result(T value, String error, boolean isSuccess) {
        this.value = value;
        this.error = error;
        this.isSuccess = isSuccess;
    }
    
    public static <T> Result<T> success(T value) {
        return new Result<>(value, null, true);
    }
    
    public static <T> Result<T> failure(String error) {
        return new Result<>(null, error, false);
    }
    
    public void ifSuccess(java.util.function.Consumer<T> action) {
        if (isSuccess) {
            action.accept(value);
        }
    }
    
    public void ifFailure(java.util.function.Consumer<String> action) {
        if (!isSuccess) {
            action.accept(error);
        }
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class GenericsInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║          INTERVIEW QUESTIONS - GENERICS                ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. What are Generics in Java?",
                "ANSWER: Compile-time type safety feature",
                "  Definition:",
                "  - Parameterized types",
                "  - Type checking at compile time",
                "  - Eliminate casts",
                "  - Enable generic algorithms",
                "  Benefits:",
                "  1. Type safety (compile-time errors)",
                "  2. No explicit casting",
                "  3. Reusable code",
                "  4. Stronger type checks",
                "  Introduced: Java 5 (2004)"
            },
            {
                "2. What is type erasure?",
                "ANSWER: Removal of generic type information at runtime",
                "  Process:",
                "  1. Replace type parameters with Object or bound",
                "  2. Insert type casts",
                "  3. Generate bridge methods",
                "  Example:",
                "    List<String> → List",
                "    T extends Number → Number",
                "  Why:",
                "  - Backward compatibility with pre-Java 5",
                "  - No runtime overhead",
                "  - Single class file for all types",
                "  Consequence: No generic info at runtime"
            },
            {
                "3. Difference between T, E, K, V, N in generics?",
                "ANSWER: Naming conventions for type parameters",
                "  Conventions:",
                "  - T: Type",
                "  - E: Element (collections)",
                "  - K: Key",
                "  - V: Value",
                "  - N: Number",
                "  - S, U: Additional types",
                "  Examples:",
                "    class Box<T> { }",
                "    interface List<E> { }",
                "    interface Map<K, V> { }",
                "  Note: Just conventions, any name works"
            },
            {
                "4. Can we use primitives with generics?",
                "ANSWER: No, must use wrapper classes",
                "  Invalid:",
                "    List<int> list; // Compile error",
                "  Valid:",
                "    List<Integer> list = new ArrayList<>();",
                "  Reason:",
                "  - Type erasure replaces with Object",
                "  - Primitives are not objects",
                "  - Cannot be null",
                "  Workaround: Autoboxing (automatic conversion)"
            },
            {
                "5. What is bounded type parameter?",
                "ANSWER: Restricts types that can be used",
                "  Upper bound (extends):",
                "    <T extends Number>",
                "    // T must be Number or subclass",
                "  Multiple bounds:",
                "    <T extends Number & Comparable<T>>",
                "    // T must extend Number AND implement Comparable",
                "  No lower bound: Cannot use 'super' for classes",
                "  Use case: Restrict types, call specific methods"
            },
            {
                "6. Difference between <?> and <? extends Object>?",
                "ANSWER: Effectively the same",
                "  <?> :",
                "  - Unbounded wildcard",
                "  - Equivalent to <? extends Object>",
                "  - Can read Object, cannot write",
                "  <? extends Object>:",
                "  - Explicitly upper bounded",
                "  - Same behavior as <?>",
                "  Best practice: Use <?> for simplicity"
            },
            {
                "7. What is PECS rule?",
                "ANSWER: Producer Extends, Consumer Super",
                "  Producer Extends:",
                "  - Use '? extends T' when reading",
                "  - Can safely read T",
                "  - Cannot write (except null)",
                "  - Example: public void addAll(Collection<? extends T>)",
                "  Consumer Super:",
                "  - Use '? super T' when writing",
                "  - Can safely write T",
                "  - Can read only Object",
                "  - Example: public void addTo(Collection<? super T>)",
                "  Memory: GET-extends, PUT-super"
            },
            {
                "8. Can we create generic array?",
                "ANSWER: No, due to type erasure",
                "  Invalid:",
                "    T[] array = new T[10]; // Compile error",
                "    List<String>[] lists = new List<String>[10]; // Error",
                "  Reason:",
                "  - Arrays are covariant, generics are invariant",
                "  - Type information lost at runtime",
                "  - Heap pollution risk",
                "  Workaround:",
                "    ArrayList<T> list = new ArrayList<>();",
                "    Object[] array = new Object[10];",
                "    @SuppressWarnings(\"unchecked\")",
                "    T[] array = (T[]) new Object[10];"
            },
            {
                "9. What is heap pollution?",
                "ANSWER: When variable of parameterized type refers to object not of that type",
                "  Causes:",
                "  - Raw types",
                "  - Unchecked casts",
                "  - Generic arrays",
                "  Example:",
                "    List<String> strList = new ArrayList<>();",
                "    List rawList = strList;",
                "    rawList.add(123); // Heap pollution!",
                "    String s = strList.get(0); // ClassCastException",
                "  Prevention:",
                "  - Avoid raw types",
                "  - Heed compiler warnings",
                "  - Use @SafeVarargs for varargs"
            },
            {
                "10. Can we overload methods with different generics?",
                "ANSWER: No, due to type erasure",
                "  Invalid:",
                "    void method(List<String> list) { }",
                "    void method(List<Integer> list) { } // Error!",
                "  After erasure:",
                "    void method(List list) { }",
                "    void method(List list) { } // Duplicate!",
                "  Reason: Same erasure",
                "  Workaround: Different method names"
            },
            {
                "11. What is raw type?",
                "ANSWER: Generic class/interface used without type parameter",
                "  Example:",
                "    List rawList = new ArrayList(); // Raw type",
                "    List<String> typedList = new ArrayList<>(); // Generic",
                "  Problems:",
                "  - No type safety",
                "  - Compiler warnings",
                "  - Heap pollution risk",
                "  When used:",
                "  - Legacy code compatibility",
                "  - Class literals (List.class)",
                "  Best practice: Avoid raw types"
            },
            {
                "12. Can static method be generic?",
                "ANSWER: Yes, but with its own type parameter",
                "  Valid:",
                "    class MyClass<T> {",
                "        static <E> void method(E element) { }",
                "    }",
                "  Invalid:",
                "    class MyClass<T> {",
                "        static void method(T element) { } // Error!",
                "    }",
                "  Reason:",
                "  - Static belongs to class, not instance",
                "  - Class type parameter is instance-specific",
                "  - Static method needs own type parameter"
            },
            {
                "13. Can we create instance of type parameter?",
                "ANSWER: No, due to type erasure",
                "  Invalid:",
                "    class Box<T> {",
                "        T create() {",
                "            return new T(); // Error!",
                "        }",
                "    }",
                "  Reason: Runtime type information unavailable",
                "  Workaround:",
                "    class Box<T> {",
                "        T create(Class<T> clazz) {",
                "            return clazz.newInstance();",
                "        }",
                "    }",
                "    // Usage:",
                "    box.create(String.class);"
            },
            {
                "14. What is bridge method?",
                "ANSWER: Compiler-generated method for type erasure compatibility",
                "  Purpose: Preserve polymorphism after erasure",
                "  Example:",
                "    class Node<T> {",
                "        public void setData(T data) { }",
                "    }",
                "    class IntNode extends Node<Integer> {",
                "        public void setData(Integer data) { }",
                "    }",
                "  Bridge method generated:",
                "    public void setData(Object data) {",
                "        setData((Integer) data);",
                "    }",
                "  Hidden from developers"
            },
            {
                "15. Difference between ArrayList<Object> and ArrayList<?>?",
                "ANSWER:",
                "  ArrayList<Object>:",
                "  - Can read Object",
                "  - Can write Object",
                "  - Example: list.add(new Object())",
                "  ArrayList<?>:",
                "  - Can read Object",
                "  - Cannot write (except null)",
                "  - Unknown type",
                "  - Example: list.add(\"String\") // Error!",
                "  Use ArrayList<?> when type unknown"
            },
            {
                "16. Can we use instanceof with generics?",
                "ANSWER: Limited, due to type erasure",
                "  Invalid:",
                "    if (obj instanceof List<String>) { } // Error",
                "  Valid:",
                "    if (obj instanceof List) { } // OK",
                "    if (obj instanceof List<?>) { } // OK",
                "  Reason: Type info erased at runtime",
                "  Workaround: Check class, not type parameter"
            },
            {
                "17. What is covariance and contravariance?",
                "ANSWER: Variance refers to subtyping relationships",
                "  Covariance (Producer - extends):",
                "  - List<? extends Number>",
                "  - Can assign List<Integer>, List<Double>",
                "  - Can read Number",
                "  - Cannot write",
                "  Contravariance (Consumer - super):",
                "  - List<? super Integer>",
                "  - Can assign List<Number>, List<Object>",
                "  - Can write Integer",
                "  - Can read only Object",
                "  Invariance:",
                "  - List<Number>",
                "  - Cannot assign List<Integer>"
            },
            {
                "18. Can we have generic exception class?",
                "ANSWER: No, not allowed",
                "  Invalid:",
                "    class MyException<T> extends Exception { } // Error",
                "  Reason:",
                "  - catch block needs exact type",
                "  - Type erasure prevents proper exception handling",
                "  - Cannot catch generic exceptions",
                "  Also invalid:",
                "    catch (T ex) { } // Error in generic method"
            },
            {
                "19. What is use-site variance vs declaration-site variance?",
                "ANSWER:",
                "  Use-site variance (Java):",
                "  - Wildcards at usage point",
                "  - Example: List<? extends Number> list",
                "  - Flexible but verbose",
                "  Declaration-site variance (Kotlin, C#):",
                "  - Variance at class declaration",
                "  - Example: interface List<out E>",
                "  - Cleaner but less flexible",
                "  Java uses use-site variance"
            },
            {
                "20. Generics best practices?",
                "ANSWER:",
                "  DO:",
                "  - Use generics for type safety",
                "  - Follow PECS rule",
                "  - Use bounded types when needed",
                "  - Prefer List<String> over List",
                "  - Use wildcards for flexibility",
                "  DON'T:",
                "  - Use raw types",
                "  - Ignore compiler warnings",
                "  - Use generics for arrays",
                "  - Catch generic exceptions",
                "  - Overload with different type parameters",
                "  Always: Eliminate unchecked warnings"
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
        System.out.println("✓ Generics provide compile-time type safety");
        System.out.println("✓ Type erasure removes type info at runtime");
        System.out.println("✓ Cannot use primitives, must use wrappers");
        System.out.println("✓ PECS: Producer extends, Consumer super");
        System.out.println("✓ Bounded types restrict acceptable types");
        System.out.println("✓ Wildcards (?) for unknown types");
        System.out.println("✓ Cannot create generic arrays or exceptions");
        System.out.println("✓ Avoid raw types for type safety");
        System.out.println();
    }
}
