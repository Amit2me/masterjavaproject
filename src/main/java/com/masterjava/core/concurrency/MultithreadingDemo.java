package com.masterjava.core.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.util.*;

/**
 * LESSON 15: MULTITHREADING & CONCURRENCY
 * ========================================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand threads and process model
 * 2. Master thread creation (Thread class, Runnable, Callable)
 * 3. Learn thread lifecycle and states
 * 4. Understand synchronization and race conditions
 * 5. Master locks and concurrent collections
 * 6. Learn ExecutorService and thread pools
 * 7. Understand Future and CompletableFuture
 * 8. Master modern concurrency utilities
 * 
 * UNDER THE HOOD (JVM):
 * --------------------
 * THREAD MODEL:
 * - Each thread has its own stack
 * - All threads share heap memory
 * - Context switching overhead
 * - Race conditions without synchronization
 * 
 * MEMORY MODEL:
 * Stack (per thread):
 *   - Local variables
 *   - Method calls
 *   - Primitives
 * 
 * Heap (shared):
 *   - Objects
 *   - Instance variables
 *   - Static variables
 * 
 * HAPPENS-BEFORE RELATIONSHIP:
 * - synchronized: lock release happens-before lock acquire
 * - volatile: write happens-before read
 * - Thread start: start() happens-before run()
 * - Thread join: thread completion happens-before join() returns
 * 
 * SYNCHRONIZATION MECHANISMS:
 * 1. synchronized keyword (intrinsic locks)
 * 2. volatile (visibility, no atomicity)
 * 3. Locks (ReentrantLock, ReadWriteLock)
 * 4. Atomic variables (CAS operations)
 * 5. Concurrent collections
 * 
 * THREAD STATES:
 * NEW → RUNNABLE ⇄ WAITING/TIMED_WAITING/BLOCKED → TERMINATED
 * 
 * @author Master Java Project
 * @version 2.0
 * @since 2024
 */
public class MultithreadingDemo {

    public static void main(String[] args) throws Exception {
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║    LESSON 15: MULTITHREADING & CONCURRENCY            ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // ═══════════════════════════════════════════════════════════
        // SECTION 1: THREAD BASICS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 1. THREAD BASICS ━━━");
        demonstrateThreadBasics();
        Thread.sleep(100);
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 2: THREAD LIFECYCLE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 2. THREAD LIFECYCLE ━━━");
        demonstrateThreadLifecycle();
        Thread.sleep(100);
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 3: RACE CONDITION PROBLEM
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 3. RACE CONDITION ━━━");
        demonstrateRaceCondition();
        Thread.sleep(100);
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 4: SYNCHRONIZATION
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 4. SYNCHRONIZATION ━━━");
        demonstrateSynchronization();
        Thread.sleep(100);
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 5: VOLATILE KEYWORD
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 5. VOLATILE KEYWORD ━━━");
        demonstrateVolatile();
        Thread.sleep(100);
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 6: LOCKS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 6. LOCKS (REENTRANTLOCK) ━━━");
        demonstrateLocks();
        Thread.sleep(100);
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 7: ATOMIC VARIABLES
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 7. ATOMIC VARIABLES ━━━");
        demonstrateAtomicVariables();
        Thread.sleep(100);
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 8: THREAD POOLS & EXECUTORS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 8. THREAD POOLS & EXECUTORS ━━━");
        demonstrateExecutors();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 9: CALLABLE & FUTURE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 9. CALLABLE & FUTURE ━━━");
        demonstrateCallableAndFuture();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 10: COMPLETABLEFUTURE
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 10. COMPLETABLEFUTURE ━━━");
        demonstrateCompletableFuture();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 11: CONCURRENT COLLECTIONS
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 11. CONCURRENT COLLECTIONS ━━━");
        demonstrateConcurrentCollections();
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // SECTION 12: PRODUCER-CONSUMER PROBLEM
        // ═══════════════════════════════════════════════════════════
        System.out.println("━━━ 12. PRODUCER-CONSUMER ━━━");
        demonstrateProducerConsumer();
        Thread.sleep(500);
        System.out.println();

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        MultithreadingInterviewQuestions.printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // SECTION DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateThreadBasics() throws InterruptedException {
        System.out.println("  Method 1: Extending Thread class");
        MyThread thread1 = new MyThread("Thread-1");
        thread1.start(); // Starts new thread
        
        System.out.println("  Method 2: Implementing Runnable");
        Thread thread2 = new Thread(new MyRunnable("Thread-2"));
        thread2.start();
        
        System.out.println("  Method 3: Lambda (Java 8+)");
        Thread thread3 = new Thread(() -> {
            System.out.println("  " + Thread.currentThread().getName() + " running with lambda");
        }, "Thread-3");
        thread3.start();
        
        // Wait for threads to complete
        thread1.join();
        thread2.join();
        thread3.join();
        
        System.out.println("  ✓ All threads completed");
    }

    private static void demonstrateThreadLifecycle() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("  Thread RUNNABLE");
                Thread.sleep(100); // TIMED_WAITING
                System.out.println("  Thread awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        System.out.println("  State: " + thread.getState()); // NEW
        thread.start();
        System.out.println("  State: " + thread.getState()); // RUNNABLE
        Thread.sleep(50);
        System.out.println("  State: " + thread.getState()); // TIMED_WAITING
        thread.join();
        System.out.println("  State: " + thread.getState()); // TERMINATED
        
        System.out.println("\n  Thread States:");
        System.out.println("  NEW → RUNNABLE → WAITING/TIMED_WAITING/BLOCKED → TERMINATED");
    }

    private static void demonstrateRaceCondition() throws InterruptedException {
        UnsafeCounter counter = new UnsafeCounter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("  Expected count: 2000");
        System.out.println("  Actual count: " + counter.getCount());
        System.out.println("  ⚠️  Race condition! Count incorrect without synchronization");
    }

    private static void demonstrateSynchronization() throws InterruptedException {
        SafeCounter counter = new SafeCounter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("  Expected count: 2000");
        System.out.println("  Actual count: " + counter.getCount());
        System.out.println("  ✓ Synchronized correctly!");
        
        System.out.println("\n  Synchronization types:");
        System.out.println("  - synchronized method");
        System.out.println("  - synchronized block");
        System.out.println("  - static synchronized method");
    }

    private static void demonstrateVolatile() throws InterruptedException {
        VolatileExample example = new VolatileExample();
        
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(100);
                example.setFlag(true);
                System.out.println("  Writer: flag set to true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        Thread reader = new Thread(() -> {
            while (!example.isFlag()) {
                // Busy wait
            }
            System.out.println("  Reader: flag is true, exiting");
        });
        
        reader.start();
        writer.start();
        reader.join(1000); // Wait max 1 second
        writer.join();
        
        System.out.println("\n  💡 volatile ensures:");
        System.out.println("  - Visibility across threads");
        System.out.println("  - No caching in CPU registers");
        System.out.println("  - Happens-before guarantee");
        System.out.println("  ⚠️  Does NOT provide atomicity");
    }

    private static void demonstrateLocks() throws InterruptedException {
        BankAccountWithLock account = new BankAccountWithLock(1000);
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                account.withdraw(10);
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                account.deposit(10);
            }
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("  Final balance: " + account.getBalance());
        System.out.println("  ✓ ReentrantLock provides thread safety");
        
        System.out.println("\n  Lock advantages over synchronized:");
        System.out.println("  - tryLock() (non-blocking)");
        System.out.println("  - lockInterruptibly()");
        System.out.println("  - Multiple condition variables");
        System.out.println("  - Fair/unfair locking");
    }

    private static void demonstrateAtomicVariables() throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("  Expected: 10000");
        System.out.println("  Actual: " + counter.getCount());
        System.out.println("  ✓ Atomic variables use CAS (lock-free)");
        
        System.out.println("\n  Atomic classes:");
        System.out.println("  - AtomicInteger, AtomicLong");
        System.out.println("  - AtomicBoolean");
        System.out.println("  - AtomicReference");
        System.out.println("  - CAS: Compare-And-Swap (hardware supported)");
    }

    private static void demonstrateExecutors() throws InterruptedException {
        System.out.println("  Single Thread Executor:");
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        singleExecutor.submit(() -> System.out.println("    Task in single thread"));
        singleExecutor.shutdown();
        singleExecutor.awaitTermination(1, TimeUnit.SECONDS);
        
        System.out.println("\n  Fixed Thread Pool:");
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            fixedPool.submit(() -> 
                System.out.println("    Task " + taskId + " on " + Thread.currentThread().getName())
            );
        }
        fixedPool.shutdown();
        fixedPool.awaitTermination(1, TimeUnit.SECONDS);
        
        System.out.println("\n  Cached Thread Pool:");
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 3; i++) {
            int taskId = i;
            cachedPool.submit(() -> 
                System.out.println("    Task " + taskId + " on " + Thread.currentThread().getName())
            );
        }
        cachedPool.shutdown();
        cachedPool.awaitTermination(1, TimeUnit.SECONDS);
        
        System.out.println("\n  💡 Executor types:");
        System.out.println("  - SingleThreadExecutor: 1 thread");
        System.out.println("  - FixedThreadPool: N threads");
        System.out.println("  - CachedThreadPool: Dynamic sizing");
        System.out.println("  - ScheduledThreadPool: Delayed/periodic");
    }

    private static void demonstrateCallableAndFuture() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Callable returns value
        Callable<Integer> task = () -> {
            Thread.sleep(100);
            return 42;
        };
        
        System.out.println("  Submitting task...");
        Future<Integer> future = executor.submit(task);
        
        System.out.println("  Doing other work...");
        Thread.sleep(50);
        
        System.out.println("  Getting result (blocks if not ready)...");
        Integer result = future.get(); // Blocks until result available
        System.out.println("  Result: " + result);
        
        // Multiple futures
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            Future<Integer> f = executor.submit(() -> taskId * 10);
            futures.add(f);
        }
        
        System.out.println("\n  Multiple task results:");
        for (Future<Integer> f : futures) {
            System.out.println("    " + f.get());
        }
        
        executor.shutdown();
        
        System.out.println("\n  💡 Callable vs Runnable:");
        System.out.println("  Runnable: void run() - no return");
        System.out.println("  Callable: V call() throws Exception - returns value");
    }

    private static void demonstrateCompletableFuture() throws Exception {
        System.out.println("  Basic CompletableFuture:");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(100);
            return "Hello";
        });
        
        String result = future.get();
        System.out.println("  Result: " + result);
        
        // Chaining
        System.out.println("\n  Chaining operations:");
        CompletableFuture.supplyAsync(() -> "Hello")
            .thenApply(s -> s + " World")
            .thenApply(String::toUpperCase)
            .thenAccept(s -> System.out.println("  Chained result: " + s))
            .get();
        
        // Combining
        System.out.println("\n  Combining futures:");
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "World");
        
        CompletableFuture<String> combined = f1.thenCombine(f2, (s1, s2) -> s1 + " " + s2);
        System.out.println("  Combined: " + combined.get());
        
        // Exception handling
        System.out.println("\n  Exception handling:");
        CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Oops!");
            return "Success";
        }).exceptionally(ex -> "Recovered: " + ex.getMessage())
          .thenAccept(s -> System.out.println("  " + s))
          .get();
        
        System.out.println("\n  💡 CompletableFuture advantages:");
        System.out.println("  - Non-blocking");
        System.out.println("  - Functional composition");
        System.out.println("  - Exception handling");
        System.out.println("  - Combining multiple futures");
    }

    private static void demonstrateConcurrentCollections() throws InterruptedException {
        // ConcurrentHashMap
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        System.out.println("  ConcurrentHashMap: " + concurrentMap);
        System.out.println("  - Thread-safe without locking entire map");
        System.out.println("  - Better than Collections.synchronizedMap");
        
        // CopyOnWriteArrayList
        List<String> cowList = new CopyOnWriteArrayList<>();
        cowList.add("Item1");
        cowList.add("Item2");
        System.out.println("\n  CopyOnWriteArrayList: " + cowList);
        System.out.println("  - Thread-safe for read-heavy scenarios");
        System.out.println("  - Creates copy on write");
        
        // BlockingQueue
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        queue.put(1);
        queue.put(2);
        System.out.println("\n  BlockingQueue: " + queue);
        System.out.println("  - Thread-safe queue");
        System.out.println("  - Blocking put/take operations");
        
        System.out.println("\n  💡 Concurrent collections:");
        System.out.println("  ✓ ConcurrentHashMap - concurrent map");
        System.out.println("  ✓ CopyOnWriteArrayList - copy-on-write list");
        System.out.println("  ✓ BlockingQueue - producer-consumer");
        System.out.println("  ✓ ConcurrentSkipListMap - sorted concurrent map");
    }

    private static void demonstrateProducerConsumer() throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        
        // Producer
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.put(i);
                    System.out.println("  Produced: " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Integer item = queue.take();
                    System.out.println("  Consumed: " + item);
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        
        System.out.println("  ✓ Producer-Consumer pattern completed");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// ═══════════════════════════════════════════════════════════
// HELPER CLASSES
// ═══════════════════════════════════════════════════════════

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        System.out.println("  " + getName() + " running (extends Thread)");
    }
}

class MyRunnable implements Runnable {
    private String name;
    
    public MyRunnable(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        System.out.println("  " + name + " running (implements Runnable)");
    }
}

class UnsafeCounter {
    private int count = 0;
    
    public void increment() {
        count++; // Not atomic! Read-modify-write
    }
    
    public int getCount() {
        return count;
    }
}

class SafeCounter {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public synchronized int getCount() {
        return count;
    }
}

class VolatileExample {
    private volatile boolean flag = false;
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    public boolean isFlag() {
        return flag;
    }
}

class BankAccountWithLock {
    private int balance;
    private final Lock lock = new ReentrantLock();
    
    public BankAccountWithLock(int initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(int amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }
    
    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }
    
    public int getBalance() {
        return balance;
    }
}

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);
    
    public void increment() {
        count.incrementAndGet(); // Atomic operation
    }
    
    public int getCount() {
        return count.get();
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class MultithreadingInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║      INTERVIEW QUESTIONS - MULTITHREADING              ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. What is a thread?",
                "ANSWER: Lightweight subprocess, smallest unit of execution",
                "  Characteristics:",
                "  - Independent path of execution",
                "  - Shares memory with other threads",
                "  - Has own stack",
                "  - Lighter than process",
                "  Benefits:",
                "  - Better CPU utilization",
                "  - Faster than creating processes",
                "  - Resource sharing",
                "  - Responsive applications"
            },
            {
                "2. Difference between process and thread?",
                "ANSWER:",
                "  Process:",
                "  - Independent execution",
                "  - Separate memory space",
                "  - Heavy weight",
                "  - Costly context switching",
                "  - IPC needed for communication",
                "  Thread:",
                "  - Subprocess",
                "  - Shared memory space",
                "  - Light weight",
                "  - Cheap context switching",
                "  - Direct communication (shared memory)",
                "  Summary: Thread is lighter, faster, shares memory"
            },
            {
                "3. How to create thread in Java?",
                "ANSWER: Three ways",
                "  1. Extend Thread class:",
                "     class MyThread extends Thread {",
                "         public void run() { }",
                "     }",
                "     new MyThread().start();",
                "  2. Implement Runnable:",
                "     new Thread(new Runnable() {",
                "         public void run() { }",
                "     }).start();",
                "  3. Lambda (Java 8+):",
                "     new Thread(() -> { }).start();",
                "  Best practice: Implement Runnable (more flexible)"
            },
            {
                "4. Difference between start() and run()?",
                "ANSWER:",
                "  start():",
                "  - Creates new thread",
                "  - Calls run() in new thread",
                "  - Can be called only once",
                "  - Throws IllegalThreadStateException if called twice",
                "  run():",
                "  - Normal method call",
                "  - Executes in current thread",
                "  - Can be called multiple times",
                "  - No new thread created",
                "  Always use: start() to create new thread"
            },
            {
                "5. What are thread states?",
                "ANSWER: Six states in Thread.State enum",
                "  1. NEW: Created but not started",
                "  2. RUNNABLE: Executing or ready to execute",
                "  3. BLOCKED: Waiting for monitor lock",
                "  4. WAITING: Waiting indefinitely (wait(), join())",
                "  5. TIMED_WAITING: Waiting for specified time (sleep())",
                "  6. TERMINATED: Execution completed",
                "  Lifecycle: NEW → RUNNABLE ⇄ WAITING/BLOCKED → TERMINATED"
            },
            {
                "6. What is race condition?",
                "ANSWER: Multiple threads accessing shared data concurrently",
                "  Problem:",
                "  - Thread A reads value: 0",
                "  - Thread B reads value: 0",
                "  - Thread A increments: 1",
                "  - Thread B increments: 1",
                "  - Result: 1 (expected: 2)",
                "  Cause: Non-atomic operations",
                "  Solution:",
                "  - Synchronization",
                "  - Locks",
                "  - Atomic variables"
            },
            {
                "7. What is synchronization?",
                "ANSWER: Controlling access to shared resources",
                "  Methods:",
                "  1. Synchronized method:",
                "     synchronized void method() { }",
                "  2. Synchronized block:",
                "     synchronized(obj) { }",
                "  3. Static synchronized:",
                "     synchronized static void method() { }",
                "  How it works:",
                "  - One thread at a time",
                "  - Others wait for lock",
                "  - Prevents race conditions",
                "  Cost: Performance overhead"
            },
            {
                "8. Difference between synchronized method and block?",
                "ANSWER:",
                "  Synchronized method:",
                "  - Locks entire method",
                "  - Lock on 'this' object",
                "  - Simpler syntax",
                "  - Example: synchronized void method() { }",
                "  Synchronized block:",
                "  - Locks only critical section",
                "  - Can specify lock object",
                "  - Better performance",
                "  - Example: synchronized(obj) { }",
                "  Best practice: Use block for smaller critical sections"
            },
            {
                "9. What is volatile keyword?",
                "ANSWER: Ensures visibility of changes across threads",
                "  Guarantees:",
                "  - Reads/writes directly to main memory",
                "  - No CPU caching",
                "  - Happens-before relationship",
                "  - Visibility of changes",
                "  Does NOT guarantee:",
                "  - Atomicity (count++ not atomic)",
                "  Use case: Flags, status variables",
                "  Example: volatile boolean flag;"
            },
            {
                "10. Difference between synchronized and volatile?",
                "ANSWER:",
                "  synchronized:",
                "  - Mutual exclusion (locks)",
                "  - Atomicity + visibility",
                "  - Works on methods/blocks",
                "  - Can cause blocking",
                "  volatile:",
                "  - No locking",
                "  - Visibility only",
                "  - Works on variables",
                "  - No blocking",
                "  Use synchronized for: Atomicity needed",
                "  Use volatile for: Simple flags"
            },
            {
                "11. What is deadlock?",
                "ANSWER: Circular wait where threads block each other",
                "  Example:",
                "  Thread 1: locks A, waits for B",
                "  Thread 2: locks B, waits for A",
                "  Result: Both stuck forever",
                "  Conditions (all 4 needed):",
                "  1. Mutual exclusion",
                "  2. Hold and wait",
                "  3. No preemption",
                "  4. Circular wait",
                "  Prevention:",
                "  - Lock ordering",
                "  - tryLock() with timeout",
                "  - Avoid nested locks"
            },
            {
                "12. What is thread pool?",
                "ANSWER: Reusable worker threads for tasks",
                "  Benefits:",
                "  - Reuse threads (no creation overhead)",
                "  - Limit concurrent threads",
                "  - Better resource management",
                "  - Task queue management",
                "  Types:",
                "  - FixedThreadPool(n): Fixed size",
                "  - CachedThreadPool: Dynamic sizing",
                "  - SingleThreadExecutor: One thread",
                "  - ScheduledThreadPool: Delayed tasks",
                "  Use: ExecutorService"
            },
            {
                "13. Difference between Runnable and Callable?",
                "ANSWER:",
                "  Runnable:",
                "  - void run()",
                "  - No return value",
                "  - Cannot throw checked exceptions",
                "  - execute() method",
                "  Callable:",
                "  - V call() throws Exception",
                "  - Returns value",
                "  - Can throw checked exceptions",
                "  - submit() method returns Future",
                "  Use Callable when: Need return value or exception handling"
            },
            {
                "14. What is Future?",
                "ANSWER: Result of asynchronous computation",
                "  Methods:",
                "  - get(): Blocks until result ready",
                "  - get(timeout): Blocks with timeout",
                "  - isDone(): Check if completed",
                "  - cancel(): Attempt to cancel",
                "  - isCancelled(): Check if cancelled",
                "  Example:",
                "    Future<Integer> future = executor.submit(callable);",
                "    Integer result = future.get(); // Blocks",
                "  Limitation: Blocking, no composition"
            },
            {
                "15. What is CompletableFuture?",
                "ANSWER: Enhanced Future with functional composition (Java 8)",
                "  Features:",
                "  - Non-blocking",
                "  - Functional composition (thenApply, thenCompose)",
                "  - Exception handling (exceptionally)",
                "  - Combining futures (thenCombine)",
                "  - Async execution",
                "  Example:",
                "    CompletableFuture.supplyAsync(() -> \"Hello\")",
                "        .thenApply(s -> s + \" World\")",
                "        .thenAccept(System.out::println);",
                "  Better than Future: Non-blocking, composable"
            },
            {
                "16. What is ThreadLocal?",
                "ANSWER: Thread-confined variables",
                "  Behavior:",
                "  - Each thread has own copy",
                "  - No sharing between threads",
                "  - No synchronization needed",
                "  Usage:",
                "    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();",
                "    threadLocal.set(42);",
                "    int value = threadLocal.get();",
                "  Use cases:",
                "  - User sessions",
                "  - Database connections",
                "  - Date formatters",
                "  Warning: Memory leaks if not removed"
            },
            {
                "17. What are atomic classes?",
                "ANSWER: Lock-free thread-safe variables",
                "  Classes:",
                "  - AtomicInteger, AtomicLong",
                "  - AtomicBoolean",
                "  - AtomicReference",
                "  How: CAS (Compare-And-Swap) operations",
                "  Methods:",
                "  - get(), set()",
                "  - incrementAndGet()",
                "  - compareAndSet(expected, new)",
                "  Benefits:",
                "  - No locking (better performance)",
                "  - Hardware-supported atomicity",
                "  Use when: Simple atomic operations needed"
            },
            {
                "18. What is ConcurrentHashMap?",
                "ANSWER: Thread-safe HashMap without locking entire map",
                "  Java 7:",
                "  - Segment locking (16 segments)",
                "  - Multiple threads write concurrently",
                "  Java 8+:",
                "  - Node locking + CAS",
                "  - Better scalability",
                "  - Tree bins for large buckets",
                "  Benefits:",
                "  - Better than synchronized HashMap",
                "  - No locking for reads",
                "  - High concurrency",
                "  Note: No null keys/values"
            },
            {
                "19. What is wait() and notify()?",
                "ANSWER: Inter-thread communication",
                "  wait():",
                "  - Releases lock",
                "  - Thread waits until notified",
                "  - Must be in synchronized block",
                "  notify():",
                "  - Wakes up one waiting thread",
                "  - Must be in synchronized block",
                "  notifyAll():",
                "  - Wakes up all waiting threads",
                "  Example: Producer-Consumer problem",
                "  Modern alternative: BlockingQueue"
            },
            {
                "20. Multithreading best practices?",
                "ANSWER:",
                "  DO:",
                "  - Use thread pools (ExecutorService)",
                "  - Prefer Runnable over Thread",
                "  - Use concurrent collections",
                "  - Minimize synchronized sections",
                "  - Use atomic variables when possible",
                "  - Always shutdown executors",
                "  - Use CompletableFuture for async",
                "  DON'T:",
                "  - Create unlimited threads",
                "  - Synchronize everything",
                "  - Call run() instead of start()",
                "  - Ignore InterruptedException",
                "  - Use Thread.stop() (deprecated)",
                "  Remember: Concurrency is hard, test thoroughly"
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
        System.out.println("✓ Use start() not run() to create new thread");
        System.out.println("✓ Synchronization prevents race conditions");
        System.out.println("✓ volatile ensures visibility, not atomicity");
        System.out.println("✓ Use ExecutorService instead of creating threads");
        System.out.println("✓ Callable returns value, Runnable doesn't");
        System.out.println("✓ CompletableFuture better than Future");
        System.out.println("✓ Atomic classes for lock-free operations");
        System.out.println("✓ ConcurrentHashMap for thread-safe maps");
        System.out.println();
    }
}
