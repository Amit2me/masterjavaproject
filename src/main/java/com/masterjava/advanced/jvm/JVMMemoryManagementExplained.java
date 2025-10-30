package com.masterjava.advanced.jvm;

import java.lang.management.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * ═══════════════════════════════════════════════════════════════════════════════════
 * COMPREHENSIVE JVM, STACK & MEMORY DEEP-DIVE FOR EXPERT ENGINEERS
 * ═══════════════════════════════════════════════════════════════════════════════════
 *
 * FILE NAME: JVMMemoryManagementExplained.java
 * PURPOSE: Master deep understanding of JVM architecture, Stack vs Heap, Memory allocation,
 *          Garbage Collection, and performance optimization techniques.
 *
 * LEARNING OBJECTIVES:
 * ✓ Understand JVM architecture and memory regions
 * ✓ Distinguish Stack vs Heap with practical examples
 * ✓ Master garbage collection algorithms and their impact
 * ✓ Learn memory leaks detection and prevention
 * ✓ Implement memory-efficient code patterns
 * ✓ Monitor and profile JVM memory in production
 *
 * PREREQUISITES: Java 8+, Basic OOP knowledge
 * DIFFICULTY LEVEL: Expert (Interview + Production Grade)
 *
 * @author Expert Java Coach
 * @version 3.0 (JVM 11+)
 * @since Java 8
 * ═══════════════════════════════════════════════════════════════════════════════════
 */

// ═════════════════════════════════════════════════════════════════════════════════════
// SECTION 1: JVM MEMORY ARCHITECTURE - THE FOUNDATION
// ═════════════════════════════════════════════════════════════════════════════════════

/**
 * SECTION 1: Understanding JVM Memory Architecture
 * 
 * The JVM divides memory into distinct regions, each serving specific purposes:
 *
 * ┌─────────────────────────────────────────────────────────────────────┐
 * │                    JVM MEMORY STRUCTURE                              │
 * ├─────────────────────────────────────────────────────────────────────┤
 * │  HEAP (Shared across all threads)                                   │
 * │  ├─ Young Generation (Eden, S0, S1)      → Nursery for new objects  │
 * │  ├─ Old Generation (Tenured)             → Long-lived objects       │
 * │  └─ Metaspace (Java 8+)                  → Class metadata           │
 * │                                                                       │
 * │  STACK (Per-thread, automatically freed)                            │
 * │  ├─ Local variables                      → Primitive types          │
 * │  ├─ Object references                    → Pointers to heap        │
 * │  └─ Method call frames                   → Call stack               │
 * │                                                                       │
 * │  CODE CACHE                              → JIT compiled bytecode    │
 * │  NATIVE HEAP                             → JNI, Direct Memory       │
 * └─────────────────────────────────────────────────────────────────────┘
 *
 * KEY CHARACTERISTICS:
 * • HEAP: Shared, larger size (depends on -Xmx), slower, GC managed, fragmented
 * • STACK: Per-thread, smaller (typically 1MB), faster, auto-freed, LIFO structure
 * • METASPACE: Stores class definitions, method data, constant runtime data
 *
 * MEMORY LIFECYCLE:
 * 1. Object Creation:  Memory allocated on HEAP
 * 2. Reference Store:  Reference stored on STACK
 * 3. Usage:            JVM manages both references and objects
 * 4. Garbage Collection: Unreferenced objects in HEAP are reclaimed
 * 5. Stack Cleanup:    Automatic when method scope ends
 */

// ═════════════════════════════════════════════════════════════════════════════════════
// SECTION 2: STACK VS HEAP - PRACTICAL EXAMPLES & MEMORY VISUALIZATION
// ═════════════════════════════════════════════════════════════════════════════════════

/**
 * DEMONSTRATION CLASS: Stack and Heap Memory Allocation
 *
 * This class demonstrates how Java allocates memory for different data types
 * and object references, showing the clear distinction between stack and heap.
 *
 * VISUAL MEMORY LAYOUT:
 * ┌────────────────┐                    ┌──────────────────┐
 * │ STACK (Thread) │                    │ HEAP             │
 * ├────────────────┤                    ├──────────────────┤
 * │ primitiveInt   │ 42                 │ String@0x7f1a    │
 * │ stringRef      │ ─────────────────→ │ "Hello"          │
 * │ personRef      │ ─────────────────→ │ Person@0x8a2b    │
 * │ arrayRef       │ ─────────────────→ │ int[] {1,2,3}    │
 * └────────────────┘                    └──────────────────┘
 */
class StackVsHeapDemo {
    
    /**
     * Demonstrates Stack allocation for primitive types.
     * 
     * MEMORY BEHAVIOR:
     * • primitiveInt (4 bytes)  → Allocated directly on STACK
     * • primitiveDouble (8 bytes) → Allocated directly on STACK
     * • primitiveBoolean (1 byte) → Allocated directly on STACK
     *
     * CHARACTERISTICS:
     * ✓ Allocated when declared
     * ✓ Automatically freed when scope ends (method returns)
     * ✓ Size determined at compile time
     * ✓ Very fast access (no indirection)
     * ✓ Memory never fragmented
     *
     * EXECUTION FLOW:
     * 1. Method called → Stack frame created
     * 2. Variables allocated → Direct stack memory assigned
     * 3. Method returns → Stack frame destroyed, memory freed
     *
     * @return void
     */
    void demonstrateStackAllocation() {
        // These are allocated on the STACK
        int primitiveInt = 42;           // 4 bytes on stack
        double primitiveDouble = 3.14;   // 8 bytes on stack
        boolean flag = true;             // 1 byte on stack
        
        System.out.println("Stack Allocation:");
        System.out.println("primitiveInt address (conceptual): " + 
                         System.identityHashCode(primitiveInt));
        System.out.println("primitiveDouble value: " + primitiveDouble);
        
        // Stack memory is freed here when method scope ends
    }
    
    /**
     * Demonstrates Heap allocation for reference types and objects.
     *
     * MEMORY BEHAVIOR:
     * • stringRef → Stack contains reference (8 bytes on 64-bit JVM)
     * • String object → Heap contains actual "Hello World" data
     * • Arrays → Stack: reference, Heap: actual array elements
     *
     * CHARACTERISTICS:
     * ✓ Reference stored on stack (address pointer)
     * ✓ Actual object stored on heap (can be large)
     * ✓ Freed by Garbage Collector when unreferenced
     * ✓ Size can be determined at runtime
     * ✓ Access requires dereferencing (one extra step)
     * ✓ Memory can be fragmented
     *
     * EXECUTION FLOW:
     * 1. String object created → Allocated on HEAP
     * 2. Reference created → Stored on STACK
     * 3. Method returns → Reference removed from stack
     * 4. Object eligible for GC → Eventually freed from heap
     *
     * @return void
     */
    void demonstrateHeapAllocation() {
        // stringRef is on STACK (8 bytes), String object is on HEAP
        String stringRef = new String("Hello World");
        
        // personRef is on STACK, Person object is on HEAP
        Person personRef = new Person("John", 30);
        
        // arrayRef is on STACK, int array is on HEAP
        int[] arrayRef = {1, 2, 3, 4, 5};
        
        System.out.println("Heap Allocation:");
        System.out.println("stringRef object hash: " + 
                         System.identityHashCode(stringRef));
        System.out.println("personRef object hash: " + 
                         System.identityHashCode(personRef));
        System.out.println("arrayRef object hash: " + 
                         System.identityHashCode(arrayRef));
        
        // References freed from stack, but objects remain in heap until GC
    }
    
    /**
     * Demonstrates the relationship between multiple references and single object.
     *
     * KEY CONCEPT: Multiple references can point to the same object on the heap.
     * This is crucial for understanding memory efficiency and aliasing issues.
     *
     * MEMORY LAYOUT:
     * ┌────────────────┐
     * │ STACK          │
     * ├────────────────┤
     * │ ref1  ───────┐ │
     * │ ref2  ───────┼─────→ ┌─────────────────┐
     * │ ref3  ───────┘ │     │ Person Object   │
     * │ ref4  ────────────→  │ HEAP            │
     * └────────────────┘     │ "Alice", 25     │
     *                        └─────────────────┘
     *
     * IMPLICATIONS:
     * • Changes through any reference affect all other references
     * • Only freed when ALL references are gone (RC or GC)
     * • Can cause unexpected behavior if not careful (aliasing bug)
     *
     * @return void
     */
    void demonstrateAliasing() {
        // All these references point to the SAME object on HEAP
        Person ref1 = new Person("Alice", 25);
        Person ref2 = ref1;  // Same reference
        Person ref3 = ref1;  // Same reference
        Person ref4 = ref1;  // Same reference
        
        System.out.println("All references point to same object:");
        System.out.println("ref1 hash: " + System.identityHashCode(ref1));
        System.out.println("ref2 hash: " + System.identityHashCode(ref2));
        System.out.println("ref3 hash: " + System.identityHashCode(ref3));
        System.out.println("ref4 hash: " + System.identityHashCode(ref4));
        
        // Modify through one reference
        ref1.setName("Bob");
        
        // ALL references see the change (aliasing)
        System.out.println("After modification through ref1:");
        System.out.println("ref2 name: " + ref2.getName()); // Shows "Bob"!
    }
}

// ═════════════════════════════════════════════════════════════════════════════════════
// SECTION 3: GARBAGE COLLECTION DEEP-DIVE
// ═════════════════════════════════════════════════════════════════════════════════════

/**
 * GARBAGE COLLECTION MECHANICS
 *
 * Garbage Collection is the automatic memory management mechanism that frees
 * unreachable objects from the heap.
 *
 * GC GENERATIONS MODEL (Generational GC):
 * ┌─────────────────────────────────────────────────────────┐
 * │ YOUNG GENERATION (90% of objects die here)              │
 * │ ├─ Eden Space         → New objects allocated           │
 * │ ├─ Survivor Space 0   → Survived GC once               │
 * │ └─ Survivor Space 1   → Moved between SOS0 and SOS1    │
 * │ ⚡ Minor GC (frequent, fast)                            │
 * ├─────────────────────────────────────────────────────────┤
 * │ OLD GENERATION (Survived multiple Young GCs)            │
 * │ ⚡ Major GC/Full GC (rare, slow, affects all app)      │
 * ├─────────────────────────────────────────────────────────┤
 * │ METASPACE (Class metadata)                              │
 * │ ⚡ Metaspace Collection (when class unloaded)           │
 * └─────────────────────────────────────────────────────────┘
 *
 * GC ALGORITHMS:
 * 1. Mark-Sweep-Compact (Serial GC)     → Single threaded, pauses entire app
 * 2. Parallel GC                        → Multiple threads, lower pause time
 * 3. CMS (Concurrent Mark Sweep)        → Low latency, concurrent marking
 * 4. G1GC (Garbage First)               → Predictable pause times, heap regions
 * 5. ZGC                                → Ultra-low latency (<10ms pause)
 * 6. Shenandoah                         → Low pause concurrent GC
 *
 * MARK-SWEEP-COMPACT ALGORITHM:
 * ┌─────────────────────────────────────────────────────────┐
 * │ MARK PHASE: Traverse from GC roots, mark reachable      │
 * │ ┌──────────────────────────────────────────────────────┐
 * │ │ Root Set (Stack, Statics, JNI)                       │
 * │ │ ↓ Follow references                                  │
 * │ │ □ Object1 [MARKED]                                   │
 * │ │ □ Object2 [MARKED]                                   │
 * │ │ ✗ Object3 [UNMARKED - garbage]                       │
 * │ └──────────────────────────────────────────────────────┘
 * │                                                          │
 * │ SWEEP PHASE: Free unmarked objects, reclaim memory      │
 * │ ┌──────────────────────────────────────────────────────┐
 * │ │ FREE: Object3 memory reclaimed                        │
 * │ │ Heap: [Object1][Object2][FREE SPACE]                 │
 * │ └──────────────────────────────────────────────────────┘
 * │                                                          │
 * │ COMPACT PHASE: Defragment heap, compact live objects    │
 * │ ┌──────────────────────────────────────────────────────┐
 * │ │ Result: [Object1][Object2][CONTIGUOUS FREE]          │
 * │ │ Allocation pointer reset for new objects             │
 * │ └──────────────────────────────────────────────────────┘
 * └─────────────────────────────────────────────────────────┘
 *
 * GC ROOT SET (What GC starts from):
 * ✓ Active thread stacks (local variables)
 * ✓ Static variables (class references)
 * ✓ Constant pool references
 * ✓ JNI references
 * ✓ Objects in monitor state (synchronized)
 */
class GarbageCollectionDemo {
    
    /**
     * Demonstrates how unreferenced objects become eligible for GC.
     *
     * GARBAGE COLLECTION LIFECYCLE:
     * 1. Object created → Allocated on heap
     * 2. Reference exists → Object reachable
     * 3. Reference nullified → Object unreachable
     * 4. GC detects → Object marked for collection
     * 5. GC runs → Memory reclaimed
     *
     * REACHING GARBAGE:
     * • Explicit null assignment: ref = null
     * • Reference goes out of scope
     * • Reference overwritten with another object
     * • Collection object cleared
     *
     * @return void
     */
    void demonstrateGarbageCollection() {
        // Object created, referenced on stack
        String obj1 = new String("Object 1");
        
        // Object now eligible for GC
        obj1 = null;  // Reference lost
        
        // OR by overwriting
        String obj2 = new String("Object 2");
        obj2 = new String("Object 2 - NEW");  // Old object unreachable
        
        // OR by going out of scope
        {
            String obj3 = new String("Object 3");
            // obj3 eligible for GC when block ends
        }
        
        System.out.println("Objects eligible for GC after reference loss");
    }
    
    /**
     * Demonstrates memory leaks - objects that should be freed but aren't.
     *
     * MEMORY LEAK PATTERNS IN JAVA:
     * 1. Holding strong references to unused objects
     * 2. Static collection accumulating objects
     * 3. Listeners/Callbacks not unregistered
     * 4. ThreadLocal variables not cleaned up
     * 5. Inner class holding outer class reference
     *
     * CONSEQUENCES:
     * • Heap fills up over time
     * • Minor GCs become frequent
     * • Major GC pause times increase
     * • Eventually: OutOfMemoryError
     *
     * @return void
     */
    void demonstrateMemoryLeak() {
        // LEAK PATTERN 1: Static collection holding references
         class LeakyCache {
            static List<byte[]> cache = new ArrayList<>();
            
            static void addToCache(int size) {
                // Objects added but never removed - LEAK!
                cache.add(new byte[size]);
            }
        }

        // LEAK PATTERN 2: Listener not unregistered
        class DataListener {
            private String[] hugeBuffer = new String[1000000];
            
            void onDataReceived(Data data) {
                // Listener registered but never unregistered
                // Listener holds reference to entire object hierarchy
            }
        }
        
        // LEAK PATTERN 3: ThreadLocal not cleaned
        class ThreadLocalLeak {
            static ThreadLocal<byte[]> tl = ThreadLocal.withInitial(
                () -> new byte[1024 * 1024]  // 1MB per thread
            );
            
            void process() {
                // Not calling tl.remove()
                // Memory held even after thread returns to pool
            }
        }
    }
    
    /**
     * Demonstrates monitoring GC events and heap usage.
     *
     * MONITORING APPROACH:
     * • MemoryMXBean for heap statistics
     * • GarbageCollectorMXBean for GC events
     * • Runtime.getRuntime() for quick checks
     *
     * @return void
     */
    void monitorGCMetrics() {
        // Get memory information
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        
        System.out.println("=== HEAP MEMORY USAGE ===");
        System.out.println("Init: " + formatBytes(heapUsage.getInit()));
        System.out.println("Used: " + formatBytes(heapUsage.getUsed()));
        System.out.println("Committed: " + formatBytes(heapUsage.getCommitted()));
        System.out.println("Max: " + formatBytes(heapUsage.getMax()));
        
        // Get GC information
        List<GarbageCollectorMXBean> gcBeans = 
            ManagementFactory.getGarbageCollectorMXBeans();
        
        System.out.println("\n=== GARBAGE COLLECTORS ===");
        for (GarbageCollectorMXBean gc : gcBeans) {
            System.out.println("GC Name: " + gc.getName());
            System.out.println("  Collections: " + gc.getCollectionCount());
            System.out.println("  Time (ms): " + gc.getCollectionTime());
        }
    }
    
    /**
     * Utility method to format bytes to human-readable format.
     *
     * @param bytes Number of bytes
     * @return Formatted string (e.g., "256 MB")
     */
    private String formatBytes(long bytes) {
        if (bytes <= 0) return "0 B";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(bytes) / Math.log10(1024));
        return String.format("%.2f %s", 
            bytes / Math.pow(1024, digitGroups), 
            units[digitGroups]);
    }
}

// ═════════════════════════════════════════════════════════════════════════════════════
// SECTION 4: MEMORY EFFICIENCY PATTERNS AND BEST PRACTICES
// ═════════════════════════════════════════════════════════════════════════════════════

/**
 * MEMORY-EFFICIENT PROGRAMMING PATTERNS
 *
 * Professional engineers write code that minimizes memory footprint and
 * GC pressure, improving application performance and reducing latency.
 */
class MemoryEfficientPatterns {
    
    /**
     * PATTERN 1: Object Pooling
     *
     * Reuse objects instead of creating and discarding them repeatedly.
     * Reduces heap allocation and GC pressure.
     *
     * USE CASES:
     * • Connection pooling
     * • Thread pools
     * • Buffer reuse
     * • Large object recycling
     *
     * BENEFITS:
     * ✓ Reduced GC pause time
     * ✓ Better cache locality
     * ✓ Predictable memory usage
     *
     * DRAWBACKS:
     * ✗ Thread safety complexity
     * ✗ State reset overhead
     *
     * @return ObjectPool instance
     */
    static class ObjectPool<T> {
        private final Queue<T> pool;
        private final ObjectFactory<T> factory;
        private final int maxSize;
        
        interface ObjectFactory<T> {
            T create();
            void reset(T obj);
        }
        
        ObjectPool(ObjectFactory<T> factory, int maxSize) {
            this.factory = factory;
            this.maxSize = maxSize;
            this.pool = new ConcurrentLinkedQueue<>();
        }
        
        T acquire() {
            T obj = pool.poll();
            if (obj == null) {
                obj = factory.create();
            }
            return obj;
        }
        
        void release(T obj) {
            if (pool.size() < maxSize) {
                factory.reset(obj);
                pool.offer(obj);
            }
        }
    }
    
    /**
     * PATTERN 2: Lazy Initialization
     *
     * Delay object creation until actually needed.
     * Reduces startup memory footprint and improves startup time.
     *
     * @return void
     */
    static class LazyInitializationDemo {
        private ExpensiveResource resource;
        private final Object lock = new Object();
        
        /**
         * Double-checked locking pattern for lazy initialization.
         * Safe and efficient for multi-threaded access.
         *
         * MEMORY IMPLICATION:
         * • ExpensiveResource created only on first access
         * • Saved if never accessed
         * • Slight overhead: null check and synchronization
         *
         * @return ExpensiveResource instance
         */
        ExpensiveResource getResource() {
            if (resource == null) {
                synchronized (lock) {
                    if (resource == null) {
                        resource = new ExpensiveResource();
                    }
                }
            }
            return resource;
        }
    }
    
    /**
     * PATTERN 3: String Interning for Memory Optimization
     *
     * String literals are automatically interned in the string pool,
     * allowing multiple references to share same memory.
     *
     * MEMORY LAYOUT:
     * ┌──────────────────┐         ┌──────────────────┐
     * │ String Pool      │         │ Heap             │
     * ├──────────────────┤         ├──────────────────┤
     * │ "Hello" ────────────────→ │ "Hello" (1 copy) │
     * │ s1 ref ──────┐   │         │                  │
     * │ s2 ref ──────┼───────────→ │ (Shared!)        │
     * │ s3 ref ──────┘   │         │                  │
     * └──────────────────┘         └──────────────────┘
     *
     * BENEFITS:
     * ✓ Significant memory savings for repeated strings
     * ✓ Fast equality checks (reference equality)
     *
     * DRAWBACKS:
     * ✗ Manual interning has overhead
     * ✗ Can cause string pool pollution
     *
     * @return void
     */
    void demonstrateStringInterning() {
        // Automatic interning for string literals
        String s1 = "Hello";  // Interned
        String s2 = "Hello";  // Same reference (pooled)
        
        System.out.println(s1 == s2);  // true (same object)
        
        // Manual interning (rarely needed)
        String s3 = new String("World").intern();
        String s4 = "World";
        System.out.println(s3 == s4);  // true (both interned)
    }
    
    /**
     * PATTERN 4: Primitive Arrays over Object Collections for bulk data
     *
     * Using primitive arrays dramatically reduces memory overhead
     * compared to object-based collections.
     *
     * MEMORY COMPARISON:
     * ┌───────────────────────────────────────────┐
     * │ int[] array (1000 elements)               │
     * │ Size: 4000 bytes (pure data)              │
     * │ Overhead: ~64 bytes (object header)       │
     * │ Total: ~4064 bytes                        │
     * └───────────────────────────────────────────┘
     *
     * ┌───────────────────────────────────────────┐
     * │ List<Integer> list (1000 elements)        │
     * │ Per element:                              │
     * │ • Integer wrapper: 16 bytes (object)      │
     * │ • Reference: 8 bytes (64-bit JVM)         │
     * │ • List node: 24 bytes (reference + size)  │
     * │ Per element total: 40+ bytes              │
     * │ Total: 40,000+ bytes (10x more!)          │
     * └───────────────────────────────────────────┘
     *
     * @return void
     */
    void compareDataStructures() {
        int[] primitiveArray = new int[1000];
        List<Integer> objectList = new ArrayList<>(1000);
        
        System.out.println("Memory usage:");
        System.out.println("int[1000]: ~4 KB");
        System.out.println("List<Integer>[1000]: ~40+ KB");
        System.out.println("Savings with primitives: ~10x");
    }
}

// ═════════════════════════════════════════════════════════════════════════════════════
// SECTION 5: ADVANCED TOPICS - DIRECT MEMORY & NATIVE BUFFERS
// ═════════════════════════════════════════════════════════════════════════════════════

/**
 * DIRECT MEMORY (Off-Heap Memory)
 *
 * Memory outside JVM heap, allocated using sun.misc.Unsafe or NIO ByteBuffer.
 *
 * USE CASES:
 * • Zero-copy I/O operations
 * • Networking applications (kernel can directly access)
 * • Memory-mapped files
 * • Shared memory between processes
 *
 * CHARACTERISTICS:
 * ✓ Not managed by GC (manual cleanup required)
 * ✓ Faster I/O (kernel can access directly)
 * ✓ Shared across processes (if needed)
 * ✗ Risk of memory leaks if not freed properly
 * ✗ More complex cleanup logic
 *
 * MEMORY STRUCTURE:
 * ┌─────────────────────────────────────────────┐
 * │ JVM HEAP                                     │
 * │ ┌─────────────────────────────────────────┐ │
 * │ │ ByteBuffer wrapper reference            │ │
 * │ └─────────────────────────────────────────┘ │
 * │            ↓                                 │
 * │ ┌─────────────────────────────────────────┐ │
 * │ NATIVE/OFF-HEAP MEMORY (Not GC managed)   │ │
 * │ ┌─────────────────────────────────────────┐ │
 * │ │ Actual byte data (1MB, 1GB, etc)        │ │
 * │ └─────────────────────────────────────────┘ │
 * └─────────────────────────────────────────────┘
 */
class DirectMemoryDemo {
    
    /**
     * Demonstrates direct memory allocation via ByteBuffer.
     *
     * ALLOCATION METHODS:
     * • allocateDirect() → Uses off-heap memory
     * • allocate() → Uses heap memory
     *
     * WHEN TO USE DIRECT MEMORY:
     * ✓ Performing I/O operations (network, files)
     * ✓ Building zero-copy architectures
     * ✓ Processing large data volumes
     * ✓ Need predictable GC pauses
     *
     * WHEN NOT TO USE:
     * ✗ General data structures
     * ✗ Small temporary buffers
     * ✗ If frequent allocation/deallocation
     *
     * @return void
     */
    void demonstrateDirectBuffers() {
        // HEAP BUFFER (GC managed, slower I/O)
        java.nio.ByteBuffer heapBuffer = 
            java.nio.ByteBuffer.allocate(1024 * 1024);
        
        // DIRECT BUFFER (Off-heap, fast I/O, manual cleanup)
        java.nio.ByteBuffer directBuffer = 
            java.nio.ByteBuffer.allocateDirect(1024 * 1024);
        
        System.out.println("Heap buffer: " + heapBuffer.isDirect());     // false
        System.out.println("Direct buffer: " + directBuffer.isDirect()); // true
        
        // Write data to direct buffer (accessible by kernel)
        directBuffer.putInt(42);
        directBuffer.putDouble(3.14);
        
        // No explicit cleanup needed with ByteBuffer
        // But Unsafe allocated memory requires manual cleanup
    }
}

// ═════════════════════════════════════════════════════════════════════════════════════
// SECTION 6: HELPER CLASSES
// ═════════════════════════════════════════════════════════════════════════════════════

/**
 * Simple Person class for demonstration purposes.
 */
class Person {
    private String name;
    private int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    void setName(String name) {
        this.name = name;
    }
    
    String getName() {
        return name;
    }
}

/**
 * Placeholder for expensive resource class.
 */
class ExpensiveResource {
    private final byte[] data = new byte[1024 * 1024];  // 1MB resource
}

/**
 * Placeholder for data class.
 */
class Data {}

// ═════════════════════════════════════════════════════════════════════════════════════
// MAIN DEMONSTRATION
// ═════════════════════════════════════════════════════════════════════════════════════

public class JVMMemoryManagementExplained {
    
    /**
     * Main method demonstrating all JVM memory concepts.
     *
     * EXECUTION FLOW:
     * 1. Stack vs Heap demonstrations
     * 2. Garbage Collection mechanics
     * 3. Memory efficiency patterns
     * 4. Direct memory exploration
     * 5. GC metrics monitoring
     *
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║ JVM MEMORY MANAGEMENT - EXPERT DEEP DIVE              ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        // Section 1: Stack vs Heap
        System.out.println("▶ SECTION 1: STACK VS HEAP ALLOCATION");
        System.out.println("═".repeat(50));
        StackVsHeapDemo stackHeapDemo = new StackVsHeapDemo();
        stackHeapDemo.demonstrateStackAllocation();
        stackHeapDemo.demonstrateHeapAllocation();
        stackHeapDemo.demonstrateAliasing();
        
        // Section 2: Garbage Collection
        System.out.println("\n▶ SECTION 2: GARBAGE COLLECTION MECHANICS");
        System.out.println("═".repeat(50));
        GarbageCollectionDemo gcDemo = new GarbageCollectionDemo();
        gcDemo.demonstrateGarbageCollection();
        gcDemo.monitorGCMetrics();
        
        // Section 3: Memory Efficient Patterns
        System.out.println("\n▶ SECTION 3: MEMORY EFFICIENT PATTERNS");
        System.out.println("═".repeat(50));
        MemoryEfficientPatterns patterns = new MemoryEfficientPatterns();
        patterns.demonstrateStringInterning();
        patterns.compareDataStructures();
        
        // Section 4: Direct Memory
        System.out.println("\n▶ SECTION 4: DIRECT MEMORY & NATIVE BUFFERS");
        System.out.println("═".repeat(50));
        DirectMemoryDemo directDemo = new DirectMemoryDemo();
        directDemo.demonstrateDirectBuffers();
        
        System.out.println("\n✓ Demonstrations complete!");
    }
}
