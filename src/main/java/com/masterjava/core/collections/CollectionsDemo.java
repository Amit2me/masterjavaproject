package com.masterjava.core.collections;

import java.util.*;
import java.util.concurrent.*;

/**
 * LESSON 12: COLLECTIONS FRAMEWORK
 * =================================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Master Collection hierarchy and interfaces
 * 2. Understand List implementations (ArrayList, LinkedList, Vector)
 * 3. Master Set implementations (HashSet, LinkedHashSet, TreeSet)
 * 4. Understand Map implementations (HashMap, LinkedHashMap, TreeMap, Hashtable)
 * 5. Learn Queue and Deque implementations
 * 6. Master Collections utility class
 * 7. Understand thread-safe collections
 * 8. Learn performance characteristics and use cases
 * 
 * UNDER THE HOOD (JVM):
 * --------------------
 * COLLECTION HIERARCHY:
 * 
 * Iterable
 *   └── Collection
 *       ├── List (ordered, allows duplicates)
 *       │   ├── ArrayList (dynamic array, fast random access)
 *       │   ├── LinkedList (doubly-linked, fast insert/delete)
 *       │   └── Vector (synchronized ArrayList)
 *       │
 *       ├── Set (unique elements)
 *       │   ├── HashSet (HashMap based, no order)
 *       │   ├── LinkedHashSet (maintains insertion order)
 *       │   └── TreeSet (sorted, Red-Black tree)
 *       │
 *       └── Queue (FIFO/LIFO)
 *           ├── PriorityQueue (heap-based priority)
 *           ├── ArrayDeque (resizable array deque)
 *           └── LinkedList (also implements Queue)
 * 
 * Map (separate hierarchy, not Collection)
 *   ├── HashMap (hash table, null key/values allowed)
 *   ├── LinkedHashMap (maintains insertion order)
 *   ├── TreeMap (sorted, Red-Black tree)
 *   ├── Hashtable (synchronized, no null)
 *   └── ConcurrentHashMap (thread-safe, high performance)
 * 
 * MEMORY & PERFORMANCE:
 * --------------------
 * ArrayList:
 *   - Resizable array: grows by ~50% when full
 *   - Get: O(1), Add: O(1) amortized, Insert: O(n), Remove: O(n)
 *   - Memory: Contiguous block
 * 
 * LinkedList:
 *   - Doubly linked nodes
 *   - Get: O(n), Add: O(1), Insert: O(1), Remove: O(1)
 *   - Memory: More overhead (node objects + pointers)
 * 
 * HashMap:
 *   - Array + LinkedList/TreeNode (buckets)
 *   - Load factor: 0.75, capacity: 16 (default)
 *   - When bucket size > 8: converts to Red-Black tree (Java 8+)
 *   - Get/Put: O(1) average, O(log n) worst case
 * 
 * TreeMap/TreeSet:
 *   - Red-Black tree (self-balancing BST)
 *   - All operations: O(log n)
 *   - Maintains sorted order
 * 
 * @author Master Java Project
 * @version 2.0
 * @since 2024
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║      LESSON 12: COLLECTIONS FRAMEWORK                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: ARRAYLIST - DYNAMIC ARRAY
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. ARRAYLIST (DYNAMIC ARRAY) ━━━");
        demonstrateArrayList();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: LINKEDLIST - DOUBLY LINKED LIST
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. LINKEDLIST (DOUBLY LINKED) ━━━");
        demonstrateLinkedList();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: VECTOR - SYNCHRONIZED LIST
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. VECTOR (LEGACY, SYNCHRONIZED) ━━━");
        demonstrateVector();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: HASHSET - UNIQUE ELEMENTS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. HASHSET (UNIQUE, UNORDERED) ━━━");
        demonstrateHashSet();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: LINKEDHASHSET - ORDERED SET
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. LINKEDHASHSET (INSERTION ORDER) ━━━");
        demonstrateLinkedHashSet();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: TREESET - SORTED SET
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. TREESET (SORTED) ━━━");
        demonstrateTreeSet();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: HASHMAP - KEY-VALUE PAIRS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. HASHMAP (KEY-VALUE) ━━━");
        demonstrateHashMap();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: LINKEDHASHMAP - ORDERED MAP
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. LINKEDHASHMAP (INSERTION ORDER) ━━━");
        demonstrateLinkedHashMap();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: TREEMAP - SORTED MAP
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. TREEMAP (SORTED BY KEY) ━━━");
        demonstrateTreeMap();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 10: QUEUE - FIFO
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 10. QUEUE & DEQUE ━━━");
        demonstrateQueue();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 11: PRIORITYQUEUE - HEAP BASED
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 11. PRIORITYQUEUE (HEAP) ━━━");
        demonstratePriorityQueue();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 12: COLLECTIONS UTILITY CLASS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 12. COLLECTIONS UTILITY ━━━");
        demonstrateCollectionsUtility();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 13: THREAD-SAFE COLLECTIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 13. THREAD-SAFE COLLECTIONS ━━━");
        demonstrateThreadSafeCollections();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 14: REAL-WORLD EXAMPLES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 14. REAL-WORLD EXAMPLES ━━━");
        demonstrateRealWorldExamples();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 15: PERFORMANCE COMPARISON
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 15. PERFORMANCE COMPARISON ━━━");
        demonstratePerformance();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        CollectionInterviewQuestions.printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // SECTION DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateArrayList() {
        // Creation
        List<String> fruits = new ArrayList<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple"); // Duplicates allowed
        System.out.println("  Initial: " + fruits);
        
        // Access by index
        System.out.println("  Get(0): " + fruits.get(0));
        
        // Insert at position
        fruits.add(1, "Mango");
        System.out.println("  After insert at 1: " + fruits);
        
        // Remove
        fruits.remove("Apple"); // Removes first occurrence
        System.out.println("  After remove 'Apple': " + fruits);
        
        // Contains
        System.out.println("  Contains 'Banana': " + fruits.contains("Banana"));
        
        // Size
        System.out.println("  Size: " + fruits.size());
        
        // Iterate
        System.out.print("  Iteration: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // Initial capacity
        List<Integer> numbers = new ArrayList<>(100); // Initial capacity
        System.out.println("  ✓ ArrayList with initial capacity: 100");
    }

    private static void demonstrateLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        
        // Add elements
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("  List: " + list);
        
        // Add at beginning/end
        list.addFirst("START");
        list.addLast("END");
        System.out.println("  After addFirst/Last: " + list);
        
        // Remove first/last
        list.removeFirst();
        list.removeLast();
        System.out.println("  After removeFirst/Last: " + list);
        
        // Get first/last
        System.out.println("  First: " + list.getFirst());
        System.out.println("  Last: " + list.getLast());
        
        // Use as Queue
        list.offer("D"); // Add to end
        System.out.println("  Poll (remove first): " + list.poll());
        
        // Use as Stack
        list.push("X"); // Add to beginning
        System.out.println("  Pop (remove first): " + list.pop());
        
        System.out.println("  ✓ LinkedList: fast insert/delete, slow random access");
    }

    private static void demonstrateVector() {
        Vector<Integer> vector = new Vector<>();
        
        vector.add(10);
        vector.add(20);
        vector.add(30);
        System.out.println("  Vector: " + vector);
        
        // Capacity and size
        System.out.println("  Size: " + vector.size());
        System.out.println("  Capacity: " + vector.capacity());
        
        // Legacy methods
        vector.addElement(40);
        System.out.println("  After addElement: " + vector);
        
        System.out.println("  ⚠️  Vector is synchronized (thread-safe but slower)");
        System.out.println("  💡 Use ArrayList instead (not thread-safe but faster)");
    }

    private static void demonstrateHashSet() {
        Set<String> colors = new HashSet<>();
        
        // Add elements
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Red"); // Duplicate - ignored
        System.out.println("  HashSet: " + colors);
        System.out.println("  Size: " + colors.size() + " (duplicate ignored)");
        
        // Contains
        System.out.println("  Contains 'Blue': " + colors.contains("Blue"));
        
        // Remove
        colors.remove("Green");
        System.out.println("  After remove 'Green': " + colors);
        
        // No order guarantee
        System.out.println("  ⚠️  No order guarantee in HashSet");
        
        // Use case: Remove duplicates from list
        List<Integer> withDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        Set<Integer> unique = new HashSet<>(withDuplicates);
        System.out.println("  Remove duplicates: " + withDuplicates + " → " + unique);
    }

    private static void demonstrateLinkedHashSet() {
        Set<String> orderedSet = new LinkedHashSet<>();
        
        orderedSet.add("First");
        orderedSet.add("Second");
        orderedSet.add("Third");
        orderedSet.add("First"); // Duplicate ignored
        
        System.out.println("  LinkedHashSet: " + orderedSet);
        System.out.println("  ✓ Maintains insertion order");
        System.out.println("  ✓ No duplicates");
    }

    private static void demonstrateTreeSet() {
        Set<Integer> sortedSet = new TreeSet<>();
        
        sortedSet.add(50);
        sortedSet.add(10);
        sortedSet.add(30);
        sortedSet.add(20);
        sortedSet.add(10); // Duplicate ignored
        
        System.out.println("  TreeSet: " + sortedSet);
        System.out.println("  ✓ Automatically sorted");
        System.out.println("  ✓ No duplicates");
        
        // Custom comparator
        Set<String> reverseSet = new TreeSet<>(Collections.reverseOrder());
        reverseSet.addAll(Arrays.asList("C", "A", "B"));
        System.out.println("  Reverse order: " + reverseSet);
        
        // NavigableSet operations
        TreeSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("  Higher than 5: " + numbers.higher(5));
        System.out.println("  Lower than 5: " + numbers.lower(5));
        System.out.println("  Subset [3, 7): " + numbers.subSet(3, 7));
    }

    private static void demonstrateHashMap() {
        Map<String, Integer> ages = new HashMap<>();
        
        // Put entries
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);
        ages.put("Alice", 26); // Updates existing key
        System.out.println("  HashMap: " + ages);
        
        // Get value
        System.out.println("  Get 'Bob': " + ages.get("Bob"));
        System.out.println("  Get 'Unknown': " + ages.get("Unknown")); // null
        
        // GetOrDefault
        System.out.println("  GetOrDefault 'Unknown': " + ages.getOrDefault("Unknown", 0));
        
        // Contains
        System.out.println("  ContainsKey 'Alice': " + ages.containsKey("Alice"));
        System.out.println("  ContainsValue 30: " + ages.containsValue(30));
        
        // Remove
        ages.remove("Charlie");
        System.out.println("  After remove 'Charlie': " + ages);
        
        // Iterate
        System.out.println("  Iteration:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println("    " + entry.getKey() + " → " + entry.getValue());
        }
        
        // Java 8 methods
        ages.putIfAbsent("David", 40);
        ages.compute("Bob", (k, v) -> v + 1);
        System.out.println("  After putIfAbsent & compute: " + ages);
        
        System.out.println("  ✓ O(1) average get/put");
        System.out.println("  ✓ Allows null key and values");
    }

    private static void demonstrateLinkedHashMap() {
        Map<String, String> orderedMap = new LinkedHashMap<>();
        
        orderedMap.put("First", "1");
        orderedMap.put("Second", "2");
        orderedMap.put("Third", "3");
        
        System.out.println("  LinkedHashMap: " + orderedMap);
        System.out.println("  ✓ Maintains insertion order");
        
        // LRU Cache using LinkedHashMap
        Map<String, String> lruCache = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3; // Max 3 entries
            }
        };
        
        lruCache.put("A", "1");
        lruCache.put("B", "2");
        lruCache.put("C", "3");
        lruCache.get("A"); // Access A
        lruCache.put("D", "4"); // B is removed (least recently used)
        
        System.out.println("  LRU Cache: " + lruCache);
        System.out.println("  💡 Use LinkedHashMap for LRU cache");
    }

    private static void demonstrateTreeMap() {
        Map<Integer, String> sortedMap = new TreeMap<>();
        
        sortedMap.put(3, "Three");
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");
        sortedMap.put(5, "Five");
        sortedMap.put(4, "Four");
        
        System.out.println("  TreeMap: " + sortedMap);
        System.out.println("  ✓ Sorted by keys");
        
        // NavigableMap operations
        TreeMap<Integer, String> navMap = new TreeMap<>(sortedMap);
        System.out.println("  FirstKey: " + navMap.firstKey());
        System.out.println("  LastKey: " + navMap.lastKey());
        System.out.println("  SubMap [2, 4]: " + navMap.subMap(2, 5));
        
        // Custom comparator
        Map<String, Integer> reverseMap = new TreeMap<>(Collections.reverseOrder());
        reverseMap.put("C", 3);
        reverseMap.put("A", 1);
        reverseMap.put("B", 2);
        System.out.println("  Reverse order: " + reverseMap);
    }

    private static void demonstrateQueue() {
        // Queue (FIFO)
        Queue<String> queue = new LinkedList<>();
        
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("  Queue: " + queue);
        
        System.out.println("  Poll (remove): " + queue.poll());
        System.out.println("  Peek (view): " + queue.peek());
        System.out.println("  After poll: " + queue);
        
        // Deque (Double-ended queue)
        Deque<Integer> deque = new ArrayDeque<>();
        
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("\n  Deque: " + deque);
        
        // Use as Stack (LIFO)
        Deque<String> stack = new ArrayDeque<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("  Stack: " + stack);
        System.out.println("  Pop: " + stack.pop());
        
        System.out.println("  ✓ ArrayDeque faster than LinkedList for Stack/Queue");
    }

    private static void demonstratePriorityQueue() {
        // Min heap (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);
        
        System.out.println("  Min Heap:");
        while (!minHeap.isEmpty()) {
            System.out.print("  " + minHeap.poll() + " ");
        }
        System.out.println();
        
        // Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);
        
        System.out.println("  Max Heap:");
        while (!maxHeap.isEmpty()) {
            System.out.print("  " + maxHeap.poll() + " ");
        }
        System.out.println();
        
        // Custom comparator
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(
            Comparator.comparingInt(task -> task.priority)
        );
        
        taskQueue.offer(new Task("Low", 3));
        taskQueue.offer(new Task("High", 1));
        taskQueue.offer(new Task("Medium", 2));
        
        System.out.println("  Task Priority Queue:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("    " + task.name + " (Priority: " + task.priority + ")");
        }
    }

    private static void demonstrateCollectionsUtility() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println("  Original: " + numbers);
        
        // Sort
        Collections.sort(numbers);
        System.out.println("  Sorted: " + numbers);
        
        // Reverse
        Collections.reverse(numbers);
        System.out.println("  Reversed: " + numbers);
        
        // Shuffle
        Collections.shuffle(numbers);
        System.out.println("  Shuffled: " + numbers);
        
        // Binary search (requires sorted list)
        Collections.sort(numbers);
        int index = Collections.binarySearch(numbers, 5);
        System.out.println("  Binary search for 5: index " + index);
        
        // Min/Max
        System.out.println("  Min: " + Collections.min(numbers));
        System.out.println("  Max: " + Collections.max(numbers));
        
        // Frequency
        List<String> words = Arrays.asList("a", "b", "a", "c", "a");
        System.out.println("  Frequency of 'a': " + Collections.frequency(words, "a"));
        
        // Unmodifiable collection
        List<String> immutableList = Collections.unmodifiableList(
            new ArrayList<>(Arrays.asList("A", "B", "C"))
        );
        System.out.println("  Unmodifiable: " + immutableList);
        // immutableList.add("D"); // UnsupportedOperationException
        
        // Synchronized collection
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        System.out.println("  ✓ Synchronized list created");
    }

    private static void demonstrateThreadSafeCollections() {
        // ConcurrentHashMap
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        System.out.println("  ConcurrentHashMap: " + concurrentMap);
        System.out.println("  ✓ Thread-safe, high performance");
        
        // CopyOnWriteArrayList
        List<String> cowList = new CopyOnWriteArrayList<>();
        cowList.add("A");
        cowList.add("B");
        System.out.println("  CopyOnWriteArrayList: " + cowList);
        System.out.println("  ✓ Thread-safe, good for more reads than writes");
        
        // BlockingQueue
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(3);
        try {
            blockingQueue.put(1);
            blockingQueue.put(2);
            System.out.println("  BlockingQueue: " + blockingQueue);
            System.out.println("  ✓ Thread-safe queue with blocking operations");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void demonstrateRealWorldExamples() {
        // Example 1: Word frequency counter
        String text = "the quick brown fox jumps over the lazy dog the fox";
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word : text.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("  Word Frequency:");
        wordCount.forEach((word, count) -> 
            System.out.println("    " + word + ": " + count)
        );
        
        // Example 2: Remove duplicates while maintaining order
        List<Integer> withDups = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);
        List<Integer> noDups = new ArrayList<>(new LinkedHashSet<>(withDups));
        System.out.println("\n  Remove duplicates: " + withDups + " → " + noDups);
        
        // Example 3: Find common elements
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("  Intersection: " + intersection);
    }

    private static void demonstratePerformance() {
        int size = 100000;
        
        // ArrayList vs LinkedList - Random access
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(size / 2);
        }
        long arrayTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get(size / 2);
        }
        long linkedTime = System.nanoTime() - start;
        
        System.out.println("  Random Access (1000 gets):");
        System.out.println("    ArrayList: " + arrayTime / 1000 + " μs");
        System.out.println("    LinkedList: " + linkedTime / 1000 + " μs");
        System.out.println("    ⚡ ArrayList is " + (linkedTime / arrayTime) + "x faster");
        
        System.out.println("\n  💡 PERFORMANCE GUIDE:");
        System.out.println("  - Random access: ArrayList > LinkedList");
        System.out.println("  - Insert/Delete at ends: LinkedList > ArrayList");
        System.out.println("  - Insert/Delete in middle: LinkedList > ArrayList");
        System.out.println("  - Memory overhead: ArrayList < LinkedList");
    }
}

// ═══════════════════════════════════════════════════════════
// HELPER CLASSES
// ═══════════════════════════════════════════════════════════

class Task {
    String name;
    int priority;
    
    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class CollectionInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║       INTERVIEW QUESTIONS - COLLECTIONS                ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. What is Java Collections Framework?",
                "ANSWER: Unified architecture for storing and manipulating groups of objects",
                "  Components:",
                "  - Interfaces: Collection, List, Set, Map, Queue",
                "  - Implementations: ArrayList, HashSet, HashMap, etc.",
                "  - Algorithms: sort, search, shuffle (Collections class)",
                "  Benefits:",
                "  - Reduces programming effort",
                "  - Increases performance",
                "  - Provides interoperability",
                "  - Reduces learning curve"
            },
            {
                "2. Difference between Collection and Collections?",
                "ANSWER:",
                "  Collection (interface):",
                "  - Root interface of collection hierarchy",
                "  - Defines basic operations: add, remove, contains",
                "  - Extended by List, Set, Queue",
                "  Collections (class):",
                "  - Utility class with static methods",
                "  - Operations: sort, reverse, shuffle, binarySearch",
                "  - Creating synchronized/unmodifiable collections",
                "  Example: Collections.sort(list);"
            },
            {
                "3. Difference between ArrayList and LinkedList?",
                "ANSWER:",
                "  ArrayList:",
                "  - Dynamic array implementation",
                "  - Fast random access: O(1)",
                "  - Slow insert/delete in middle: O(n)",
                "  - Less memory overhead",
                "  - Better for: read-heavy operations",
                "  LinkedList:",
                "  - Doubly linked list implementation",
                "  - Slow random access: O(n)",
                "  - Fast insert/delete: O(1)",
                "  - More memory overhead (node objects)",
                "  - Better for: frequent insert/delete"
            },
            {
                "4. How does ArrayList grow dynamically?",
                "ANSWER: Automatic resizing when capacity exceeded",
                "  Process:",
                "  1. Default initial capacity: 10",
                "  2. When full, creates new array 1.5x larger",
                "  3. Copies all elements to new array",
                "  4. Old array garbage collected",
                "  Formula: newCapacity = oldCapacity + (oldCapacity >> 1)",
                "  Performance: Amortized O(1) for add",
                "  Tip: Specify initial capacity if size known"
            },
            {
                "5. Difference between HashSet and TreeSet?",
                "ANSWER:",
                "  HashSet:",
                "  - Hash table implementation",
                "  - Unordered",
                "  - Allows null",
                "  - O(1) add, remove, contains",
                "  - Use: Fast lookups",
                "  TreeSet:",
                "  - Red-Black tree implementation",
                "  - Sorted order (natural or comparator)",
                "  - No null (NullPointerException)",
                "  - O(log n) add, remove, contains",
                "  - Use: Sorted unique elements"
            },
            {
                "6. How does HashMap work internally?",
                "ANSWER: Array of buckets using hashing",
                "  Structure:",
                "  1. Array of Node objects (buckets)",
                "  2. Each Node: key, value, hash, next",
                "  3. Hash determines bucket index",
                "  4. Collision handling: LinkedList or TreeNode",
                "  Process:",
                "  1. Calculate hash: key.hashCode()",
                "  2. Find bucket: hash & (n-1)",
                "  3. If empty, add entry",
                "  4. If occupied, check equals()",
                "  5. If collision, chain (list/tree)",
                "  Java 8+: Tree if bucket size > 8",
                "  Load factor: 0.75, Initial capacity: 16"
            },
            {
                "7. Why is HashMap not thread-safe?",
                "ANSWER: No synchronization, race conditions possible",
                "  Problems:",
                "  1. Lost updates in concurrent put",
                "  2. Infinite loop during resize (Java 7)",
                "  3. ConcurrentModificationException",
                "  Solutions:",
                "  - Collections.synchronizedMap()",
                "  - ConcurrentHashMap (better)",
                "  - Hashtable (legacy, avoid)",
                "  ConcurrentHashMap:",
                "  - Segment locking (Java 7)",
                "  - CAS operations (Java 8+)",
                "  - Better performance than synchronized"
            },
            {
                "8. Difference between HashMap and Hashtable?",
                "ANSWER:",
                "  HashMap:",
                "  - Not synchronized (not thread-safe)",
                "  - Allows null key (one) and null values",
                "  - Faster",
                "  - Iterator (fail-fast)",
                "  - Introduced: Java 1.2",
                "  Hashtable:",
                "  - Synchronized (thread-safe)",
                "  - No null key or values",
                "  - Slower",
                "  - Enumerator (not fail-fast)",
                "  - Legacy (Java 1.0)",
                "  Recommendation: Use HashMap or ConcurrentHashMap"
            },
            {
                "9. What is fail-fast iterator?",
                "ANSWER: Iterator that throws exception on concurrent modification",
                "  Behavior:",
                "  - Detects structural changes during iteration",
                "  - Throws ConcurrentModificationException",
                "  - Uses modCount to track changes",
                "  Example:",
                "    List<Integer> list = new ArrayList<>();",
                "    for (Integer i : list) {",
                "        list.remove(i); // ConcurrentModificationException",
                "    }",
                "  Safe alternatives:",
                "  - Iterator.remove()",
                "  - CopyOnWriteArrayList",
                "  - ConcurrentHashMap"
            },
            {
                "10. Difference between Comparable and Comparator?",
                "ANSWER:",
                "  Comparable (interface):",
                "  - Natural ordering",
                "  - Single sorting sequence",
                "  - In same class: implements Comparable",
                "  - Method: compareTo(Object)",
                "  - Example: String, Integer",
                "  Comparator (interface):",
                "  - Custom ordering",
                "  - Multiple sorting sequences",
                "  - Separate class",
                "  - Method: compare(Object, Object)",
                "  - Use: External to class",
                "  When: Comparable for default, Comparator for flexibility"
            },
            {
                "11. What is the difference between Set and List?",
                "ANSWER:",
                "  List:",
                "  - Ordered collection (index-based)",
                "  - Allows duplicates",
                "  - Allows null elements",
                "  - Implementations: ArrayList, LinkedList",
                "  - Methods: get(index), add(index, element)",
                "  Set:",
                "  - Unordered (or sorted in TreeSet)",
                "  - No duplicates",
                "  - Typically allows one null",
                "  - Implementations: HashSet, TreeSet",
                "  - No index-based methods"
            },
            {
                "12. How to make a collection thread-safe?",
                "ANSWER: Multiple approaches",
                "  1. Collections.synchronizedXxx():",
                "     List<T> syncList = Collections.synchronizedList(new ArrayList<>());",
                "     Note: Manual synchronization for iteration",
                "  2. Concurrent collections:",
                "     - ConcurrentHashMap",
                "     - CopyOnWriteArrayList",
                "     - ConcurrentLinkedQueue",
                "  3. Legacy:",
                "     - Vector, Hashtable (avoid)",
                "  Best: Use java.util.concurrent classes"
            },
            {
                "13. What is ConcurrentHashMap?",
                "ANSWER: Thread-safe HashMap with high concurrency",
                "  Java 7:",
                "  - Segment locking (16 segments)",
                "  - Multiple threads can write simultaneously",
                "  Java 8+:",
                "  - Node locking + CAS",
                "  - Better scalability",
                "  - Tree bins for large buckets",
                "  Benefits:",
                "  - Better performance than synchronized",
                "  - No locking for reads",
                "  - Fail-safe iterator",
                "  Note: Doesn't allow null key/values"
            },
            {
                "14. Difference between Queue and Deque?",
                "ANSWER:",
                "  Queue:",
                "  - FIFO (First-In-First-Out)",
                "  - Add at rear, remove from front",
                "  - Methods: offer, poll, peek",
                "  - Implementations: LinkedList, PriorityQueue",
                "  Deque (Double-ended queue):",
                "  - Add/remove from both ends",
                "  - Can work as Queue or Stack",
                "  - Methods: addFirst, addLast, removeFirst, removeLast",
                "  - Implementation: ArrayDeque, LinkedList",
                "  Use Deque: More flexible, can replace Stack"
            },
            {
                "15. What is PriorityQueue?",
                "ANSWER: Queue ordered by priority (heap-based)",
                "  Characteristics:",
                "  - Elements ordered by natural order or Comparator",
                "  - Min heap by default",
                "  - poll() returns lowest element",
                "  - O(log n) for insert and remove",
                "  - O(1) for peek",
                "  - Not thread-safe",
                "  Use cases:",
                "  - Task scheduling",
                "  - Dijkstra's algorithm",
                "  - Huffman coding"
            },
            {
                "16. Why should we override hashCode() when overriding equals()?",
                "ANSWER: Contract between equals() and hashCode()",
                "  Rules:",
                "  1. If a.equals(b), then a.hashCode() == b.hashCode()",
                "  2. If a.hashCode() != b.hashCode(), then !a.equals(b)",
                "  Why:",
                "  - Hash-based collections (HashMap, HashSet) rely on this",
                "  - Without proper hashCode(), objects won't be found",
                "  Example problem:",
                "    Person p1 = new Person(\"John\");",
                "    set.add(p1);",
                "    set.contains(new Person(\"John\")); // false without hashCode!"
            },
            {
                "17. What is the difference between Iterator and Enumeration?",
                "ANSWER:",
                "  Iterator (modern):",
                "  - Introduced: Java 1.2",
                "  - Methods: hasNext(), next(), remove()",
                "  - Fail-fast (detects modifications)",
                "  - Can remove elements",
                "  - All collections",
                "  Enumeration (legacy):",
                "  - Introduced: Java 1.0",
                "  - Methods: hasMoreElements(), nextElement()",
                "  - Not fail-fast",
                "  - Cannot remove elements",
                "  - Vector, Hashtable only",
                "  Recommendation: Use Iterator"
            },
            {
                "18. What is CopyOnWriteArrayList?",
                "ANSWER: Thread-safe variant of ArrayList",
                "  How it works:",
                "  - Creates copy of array on every write",
                "  - Reads don't require locking",
                "  - Iterator uses snapshot",
                "  Benefits:",
                "  - Thread-safe",
                "  - No ConcurrentModificationException",
                "  - Good for more reads than writes",
                "  Drawbacks:",
                "  - Expensive writes (array copy)",
                "  - Memory overhead",
                "  Use case: Event listeners, observer pattern"
            },
            {
                "19. How to convert Array to ArrayList?",
                "ANSWER: Multiple ways",
                "  1. Arrays.asList() (fixed size):",
                "     List<String> list = Arrays.asList(\"A\", \"B\", \"C\");",
                "     Note: Fixed size, can't add/remove",
                "  2. New ArrayList (modifiable):",
                "     List<String> list = new ArrayList<>(Arrays.asList(arr));",
                "  3. Streams (Java 8+):",
                "     List<String> list = Stream.of(arr).collect(Collectors.toList());",
                "  4. Collections.addAll():",
                "     List<String> list = new ArrayList<>();",
                "     Collections.addAll(list, arr);"
            },
            {
                "20. Collections performance summary?",
                "ANSWER:",
                "  ArrayList:",
                "  - Get: O(1), Add: O(1)*, Insert: O(n), Remove: O(n)",
                "  LinkedList:",
                "  - Get: O(n), Add: O(1), Insert: O(1), Remove: O(1)",
                "  HashSet:",
                "  - Add: O(1), Remove: O(1), Contains: O(1)",
                "  TreeSet:",
                "  - Add: O(log n), Remove: O(log n), Contains: O(log n)",
                "  HashMap:",
                "  - Get: O(1)*, Put: O(1)*, Remove: O(1)*",
                "  TreeMap:",
                "  - Get: O(log n), Put: O(log n), Remove: O(log n)",
                "  PriorityQueue:",
                "  - Add: O(log n), Poll: O(log n), Peek: O(1)",
                "  * = average case, worst case may differ"
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
        System.out.println("✓ ArrayList: Fast random access, slow insert/delete");
        System.out.println("✓ LinkedList: Fast insert/delete, slow random access");
        System.out.println("✓ HashSet: Fast lookup, no order, no duplicates");
        System.out.println("✓ TreeSet: Sorted, no duplicates, O(log n) operations");
        System.out.println("✓ HashMap: Fast key-value lookup, no order");
        System.out.println("✓ TreeMap: Sorted by keys, O(log n) operations");
        System.out.println("✓ Use ConcurrentHashMap for thread-safe maps");
        System.out.println("✓ Override hashCode() when overriding equals()");
        System.out.println("✓ Use appropriate collection based on requirements");
        System.out.println();
    }
}
