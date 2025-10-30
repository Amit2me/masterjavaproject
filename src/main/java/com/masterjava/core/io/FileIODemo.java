package com.masterjava.core.io;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

/**
 * LESSON 14: FILE I/O & NIO
 * ==========================
 * 
 * LEARNING OBJECTIVES:
 * -------------------
 * 1. Understand File I/O basics
 * 2. Master byte streams and character streams
 * 3. Learn buffered streams for performance
 * 4. Understand serialization
 * 5. Master NIO.2 (Path, Files, etc.)
 * 6. Learn file operations (copy, move, delete)
 * 7. Understand directory operations
 * 8. Master modern file processing techniques
 * 
 * UNDER THE HOOD (JVM):
 * --------------------
 * I/O STREAMS HIERARCHY:
 * 
 * InputStream (byte streams)
 *   ├── FileInputStream
 *   ├── BufferedInputStream
 *   ├── DataInputStream
 *   └── ObjectInputStream
 * 
 * OutputStream (byte streams)
 *   ├── FileOutputStream
 *   ├── BufferedOutputStream
 *   ├── DataOutputStream
 *   └── ObjectOutputStream
 * 
 * Reader (character streams)
 *   ├── FileReader
 *   ├── BufferedReader
 *   └── InputStreamReader
 * 
 * Writer (character streams)
 *   ├── FileWriter
 *   ├── BufferedWriter
 *   └── OutputStreamWriter
 * 
 * BUFFERING:
 * - Without buffer: Each read/write = system call (slow)
 * - With buffer: Multiple operations batched (fast)
 * - Default buffer size: 8192 bytes (8KB)
 * 
 * NIO vs IO:
 * - IO: Stream-based, blocking
 * - NIO: Buffer-based, non-blocking, channels
 * - NIO.2 (Java 7): Path, Files, better API
 * 
 * @author Master Java Project
 * @version 2.0
 * @since 2024
 */
public class FileIODemo {

    // Working directory for examples
    private static final String WORK_DIR = System.getProperty("user.home");
    private static final String DEMO_FILE = WORK_DIR + "/demo.txt";
    private static final String DEMO_BIN = WORK_DIR + "/demo.bin";
    private static final String DEMO_OBJ = WORK_DIR + "/demo.obj";
    
    public static void main(String[] args) {
        
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║        LESSON 14: FILE I/O & NIO                       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        try {
            // ═══════════════════════════════════════════════════════════
            // SECTION 1: BASIC FILE OPERATIONS
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 1. BASIC FILE OPERATIONS ━━━");
            demonstrateBasicFileOperations();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 2: BYTE STREAMS
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 2. BYTE STREAMS ━━━");
            demonstrateByteStreams();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 3: CHARACTER STREAMS
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 3. CHARACTER STREAMS ━━━");
            demonstrateCharacterStreams();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 4: BUFFERED STREAMS
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 4. BUFFERED STREAMS (PERFORMANCE) ━━━");
            demonstrateBufferedStreams();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 5: DATA STREAMS
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 5. DATA STREAMS (PRIMITIVES) ━━━");
            demonstrateDataStreams();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 6: OBJECT SERIALIZATION
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 6. OBJECT SERIALIZATION ━━━");
            demonstrateSerialization();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 7: NIO.2 - PATH API
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 7. NIO.2 - PATH API ━━━");
            demonstratePathAPI();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 8: NIO.2 - FILES API
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 8. NIO.2 - FILES API ━━━");
            demonstrateFilesAPI();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 9: DIRECTORY OPERATIONS
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 9. DIRECTORY OPERATIONS ━━━");
            demonstrateDirectoryOperations();
            System.out.println();

            // ═══════════════════════════════════════════════════════════
            // SECTION 10: FILE WATCHING
            // ═══════════════════════════════════════════════════════════
            System.out.println("━━━ 10. MODERN FILE TECHNIQUES ━━━");
            demonstrateModernTechniques();
            System.out.println();

            // Cleanup
            cleanup();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        // ═══════════════════════════════════════════════════════════
        // INTERVIEW QUESTIONS
        // ═══════════════════════════════════════════════════════════
        FileIOInterviewQuestions.printInterviewQuestions();
    }

    // ═══════════════════════════════════════════════════════════
    // SECTION DEMONSTRATIONS
    // ═══════════════════════════════════════════════════════════

    private static void demonstrateBasicFileOperations() throws IOException {
        File file = new File(DEMO_FILE);
        
        // Create file
        if (file.createNewFile()) {
            System.out.println("  ✓ File created: " + file.getName());
        } else {
            System.out.println("  ℹ File already exists");
        }
        
        // File properties
        System.out.println("  Absolute path: " + file.getAbsolutePath());
        System.out.println("  Can read: " + file.canRead());
        System.out.println("  Can write: " + file.canWrite());
        System.out.println("  Is file: " + file.isFile());
        System.out.println("  Is directory: " + file.isDirectory());
        System.out.println("  Is hidden: " + file.isHidden());
        System.out.println("  Size: " + file.length() + " bytes");
        System.out.println("  Last modified: " + new Date(file.lastModified()));
        
        // File operations
        File renamed = new File(WORK_DIR + "/demo_renamed.txt");
        if (renamed.exists()) {
            renamed.delete();
        }
        
        // Note: We'll keep the file for other demos
    }

    private static void demonstrateByteStreams() throws IOException {
        System.out.println("  Writing bytes...");
        
        // Write bytes
        try (FileOutputStream fos = new FileOutputStream(DEMO_BIN)) {
            byte[] data = {65, 66, 67, 68, 69}; // A, B, C, D, E
            fos.write(data);
            System.out.println("  ✓ Wrote " + data.length + " bytes");
        }
        
        // Read bytes
        System.out.println("  Reading bytes...");
        try (FileInputStream fis = new FileInputStream(DEMO_BIN)) {
            int byteData;
            System.out.print("  Data: ");
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData + " ");
            }
            System.out.println();
        }
        
        System.out.println("  ✓ Byte streams work with raw binary data");
    }

    private static void demonstrateCharacterStreams() throws IOException {
        String content = "Hello, File I/O!\nThis is line 2.\nThis is line 3.";
        
        System.out.println("  Writing text with FileWriter...");
        try (FileWriter writer = new FileWriter(DEMO_FILE)) {
            writer.write(content);
            System.out.println("  ✓ Wrote " + content.length() + " characters");
        }
        
        System.out.println("  Reading text with FileReader...");
        try (FileReader reader = new FileReader(DEMO_FILE)) {
            int charData;
            System.out.print("  Content: ");
            while ((charData = reader.read()) != -1) {
                System.out.print((char) charData);
            }
            System.out.println();
        }
        
        System.out.println("  ✓ Character streams handle text with proper encoding");
    }

    private static void demonstrateBufferedStreams() throws IOException {
        String[] lines = {
            "Line 1: Buffered streams are faster",
            "Line 2: They reduce system calls",
            "Line 3: Default buffer size is 8KB",
            "Line 4: Always use for file I/O"
        };
        
        // Buffered Writer (efficient)
        System.out.println("  Writing with BufferedWriter...");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DEMO_FILE))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Platform-independent line separator
            }
            System.out.println("  ✓ Wrote " + lines.length + " lines");
        }
        
        // Buffered Reader (efficient)
        System.out.println("  Reading with BufferedReader...");
        try (BufferedReader reader = new BufferedReader(new FileReader(DEMO_FILE))) {
            String line;
            int lineNum = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + lineNum++ + ": " + line);
            }
        }
        
        // Performance comparison
        System.out.println("\n  💡 Performance tip:");
        System.out.println("  - Unbuffered: 1 system call per read/write");
        System.out.println("  - Buffered: Batched operations (100x+ faster)");
        System.out.println("  - Always wrap FileReader/Writer with Buffered versions");
    }

    private static void demonstrateDataStreams() throws IOException {
        System.out.println("  Writing primitives with DataOutputStream...");
        
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(DEMO_BIN))) {
            dos.writeInt(42);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Hello, DataStream!");
            System.out.println("  ✓ Wrote int, double, boolean, and String");
        }
        
        System.out.println("  Reading primitives with DataInputStream...");
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(DEMO_BIN))) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean boolValue = dis.readBoolean();
            String strValue = dis.readUTF();
            
            System.out.println("  int: " + intValue);
            System.out.println("  double: " + doubleValue);
            System.out.println("  boolean: " + boolValue);
            System.out.println("  String: " + strValue);
        }
        
        System.out.println("  ✓ DataStreams preserve data types");
    }

    private static void demonstrateSerialization() throws IOException, ClassNotFoundException {
        // Create object
        Student student = new Student(1, "Alice", 85.5);
        System.out.println("  Original: " + student);
        
        // Serialize (write object)
        System.out.println("  Serializing object...");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DEMO_OBJ))) {
            oos.writeObject(student);
            System.out.println("  ✓ Object serialized");
        }
        
        // Deserialize (read object)
        System.out.println("  Deserializing object...");
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(DEMO_OBJ))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("  Deserialized: " + deserializedStudent);
            System.out.println("  ✓ Object restored successfully");
        }
        
        System.out.println("\n  💡 Serialization notes:");
        System.out.println("  - Class must implement Serializable");
        System.out.println("  - transient fields are not serialized");
        System.out.println("  - serialVersionUID for version control");
    }

    private static void demonstratePathAPI() throws IOException {
        System.out.println("  Path API (NIO.2):");
        
        // Create paths
        Path path1 = Paths.get(WORK_DIR, "demo.txt");
        Path path2 = Paths.get(DEMO_FILE);
        
        System.out.println("  Path: " + path1);
        System.out.println("  File name: " + path1.getFileName());
        System.out.println("  Parent: " + path1.getParent());
        System.out.println("  Root: " + path1.getRoot());
        System.out.println("  Absolute: " + path1.isAbsolute());
        
        // Path operations
        Path absolute = path1.toAbsolutePath();
        System.out.println("  Absolute path: " + absolute);
        
        Path normalized = Paths.get(WORK_DIR, ".", "demo.txt").normalize();
        System.out.println("  Normalized: " + normalized);
        
        // Relativize
        Path path3 = Paths.get(WORK_DIR);
        Path relative = path3.relativize(path1);
        System.out.println("  Relative: " + relative);
        
        System.out.println("  ✓ Path API is more flexible than File");
    }

    private static void demonstrateFilesAPI() throws IOException {
        Path path = Paths.get(DEMO_FILE);
        
        System.out.println("  Files API operations:");
        
        // Write all lines (convenient)
        List<String> lines = Arrays.asList(
            "Java NIO.2 is powerful",
            "Files class has many utilities",
            "Modern file operations made easy"
        );
        Files.write(path, lines, StandardCharsets.UTF_8);
        System.out.println("  ✓ Wrote " + lines.size() + " lines with Files.write()");
        
        // Read all lines (convenient)
        List<String> readLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println("  Read " + readLines.size() + " lines:");
        readLines.forEach(line -> System.out.println("    " + line));
        
        // File properties
        System.out.println("\n  File attributes:");
        System.out.println("  Size: " + Files.size(path) + " bytes");
        System.out.println("  Is regular file: " + Files.isRegularFile(path));
        System.out.println("  Is readable: " + Files.isReadable(path));
        System.out.println("  Is writable: " + Files.isWritable(path));
        
        // Copy file
        Path copyPath = Paths.get(WORK_DIR + "/demo_copy.txt");
        Files.copy(path, copyPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("  ✓ File copied to: " + copyPath.getFileName());
        
        // Delete copy
        Files.deleteIfExists(copyPath);
        System.out.println("  ✓ Copy deleted");
    }

    private static void demonstrateDirectoryOperations() throws IOException {
        Path dirPath = Paths.get(WORK_DIR, "demo_dir");
        
        // Create directory
        if (!Files.exists(dirPath)) {
            Files.createDirectory(dirPath);
            System.out.println("  ✓ Directory created: " + dirPath.getFileName());
        }
        
        // Create files in directory
        Path file1 = dirPath.resolve("file1.txt");
        Path file2 = dirPath.resolve("file2.txt");
        Files.write(file1, Arrays.asList("File 1 content"));
        Files.write(file2, Arrays.asList("File 2 content"));
        
        // List directory contents
        System.out.println("  Directory contents:");
        try (Stream<Path> paths = Files.list(dirPath)) {
            paths.forEach(p -> System.out.println("    - " + p.getFileName()));
        }
        
        // Walk directory tree
        System.out.println("  Walking directory tree:");
        try (Stream<Path> paths = Files.walk(dirPath)) {
            paths.filter(Files::isRegularFile)
                 .forEach(p -> System.out.println("    File: " + p.getFileName()));
        }
        
        // Cleanup directory
        Files.deleteIfExists(file1);
        Files.deleteIfExists(file2);
        Files.deleteIfExists(dirPath);
        System.out.println("  ✓ Directory cleaned up");
    }

    private static void demonstrateModernTechniques() throws IOException {
        Path path = Paths.get(DEMO_FILE);
        
        // Write with Files (modern)
        System.out.println("  Modern file writing:");
        Files.writeString(path, "Modern Java I/O is elegant!", StandardCharsets.UTF_8);
        System.out.println("  ✓ Wrote with Files.writeString()");
        
        // Read with Files (modern)
        String content = Files.readString(path, StandardCharsets.UTF_8);
        System.out.println("  Content: " + content);
        
        // Stream lines (efficient for large files)
        System.out.println("\n  Streaming lines:");
        Files.write(path, Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4", "Line 5"));
        try (Stream<String> lines = Files.lines(path)) {
            lines.filter(line -> line.contains("2") || line.contains("4"))
                 .forEach(line -> System.out.println("    " + line));
        }
        
        // Try-with-resources (auto-close)
        System.out.println("\n  💡 Always use try-with-resources:");
        System.out.println("  - Automatic resource cleanup");
        System.out.println("  - Prevents resource leaks");
        System.out.println("  - Cleaner code");
    }

    private static void cleanup() {
        try {
            Files.deleteIfExists(Paths.get(DEMO_FILE));
            Files.deleteIfExists(Paths.get(DEMO_BIN));
            Files.deleteIfExists(Paths.get(DEMO_OBJ));
            System.out.println("\n✓ Demo files cleaned up");
        } catch (IOException e) {
            System.err.println("Cleanup error: " + e.getMessage());
        }
    }
}

// ═══════════════════════════════════════════════════════════
// HELPER CLASSES
// ═══════════════════════════════════════════════════════════

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private transient double grade; // Not serialized
    
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', grade=" + grade + "}";
    }
}

// ═══════════════════════════════════════════════════════════
// INTERVIEW QUESTIONS
// ═══════════════════════════════════════════════════════════

class FileIOInterviewQuestions {
    
    static void printInterviewQuestions() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║         INTERVIEW QUESTIONS - FILE I/O                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String[][] questions = {
            {
                "1. Difference between byte stream and character stream?",
                "ANSWER:",
                "  Byte Stream:",
                "  - Works with raw bytes (8-bit)",
                "  - InputStream, OutputStream",
                "  - Use for: binary files, images, audio",
                "  - Example: FileInputStream, FileOutputStream",
                "  Character Stream:",
                "  - Works with characters (16-bit Unicode)",
                "  - Reader, Writer",
                "  - Handles encoding/decoding",
                "  - Use for: text files",
                "  - Example: FileReader, FileWriter",
                "  Rule: Use character streams for text, byte streams for binary"
            },
            {
                "2. Why use BufferedReader/BufferedWriter?",
                "ANSWER: Performance - reduces system calls",
                "  Without Buffer:",
                "  - Each read/write = 1 system call (slow)",
                "  - Example: 1000 reads = 1000 system calls",
                "  With Buffer:",
                "  - Batch operations in memory",
                "  - Default buffer: 8KB",
                "  - Example: 1000 reads = ~10 system calls",
                "  Performance: 10-100x faster",
                "  Always wrap FileReader/Writer with Buffered versions"
            },
            {
                "3. What is serialization?",
                "ANSWER: Converting object to byte stream for storage/transmission",
                "  Process:",
                "  1. Object → byte stream (serialization)",
                "  2. Byte stream → Object (deserialization)",
                "  Requirements:",
                "  - Class implements Serializable",
                "  - All fields serializable (or transient)",
                "  - serialVersionUID for version control",
                "  Use cases:",
                "  - Save objects to file",
                "  - Send objects over network",
                "  - Cache objects",
                "  Note: transient fields not serialized"
            },
            {
                "4. What is transient keyword?",
                "ANSWER: Excludes field from serialization",
                "  Example:",
                "    class User implements Serializable {",
                "        private String name;",
                "        private transient String password; // Not serialized",
                "    }",
                "  Use cases:",
                "  - Sensitive data (passwords)",
                "  - Derived/calculated fields",
                "  - Large objects to save space",
                "  On deserialization: transient fields get default values"
            },
            {
                "5. What is serialVersionUID?",
                "ANSWER: Version identifier for serialized class",
                "  Purpose:",
                "  - Ensures compatibility during deserialization",
                "  - Prevents InvalidClassException",
                "  Declaration:",
                "    private static final long serialVersionUID = 1L;",
                "  When version changes:",
                "  - If serialVersionUID same: OK",
                "  - If different: InvalidClassException",
                "  Best practice: Always declare explicitly"
            },
            {
                "6. Difference between File and Path?",
                "ANSWER:",
                "  File (legacy, java.io):",
                "  - Old API (Java 1.0)",
                "  - Limited functionality",
                "  - Poor error handling",
                "  - Performance issues",
                "  Path (modern, java.nio):",
                "  - New API (Java 7+)",
                "  - Rich functionality",
                "  - Better error messages",
                "  - Better performance",
                "  - Immutable",
                "  Recommendation: Use Path for new code"
            },
            {
                "7. What is NIO?",
                "ANSWER: New I/O - buffer-based, non-blocking I/O",
                "  Features:",
                "  - Buffers instead of streams",
                "  - Channels (bidirectional)",
                "  - Selectors (multiplexing)",
                "  - Non-blocking I/O",
                "  Versions:",
                "  - NIO (Java 1.4): Buffers, Channels",
                "  - NIO.2 (Java 7): Path, Files, better API",
                "  Benefits:",
                "  - Better performance",
                "  - Scalability",
                "  - Modern API"
            },
            {
                "8. How to read file line by line efficiently?",
                "ANSWER: Use BufferedReader or Files.lines()",
                "  Option 1: BufferedReader",
                "    try (BufferedReader br = new BufferedReader(new FileReader(file))) {",
                "        String line;",
                "        while ((line = br.readLine()) != null) {",
                "            // Process line",
                "        }",
                "    }",
                "  Option 2: Files.lines() (Java 8+)",
                "    try (Stream<String> lines = Files.lines(path)) {",
                "        lines.forEach(line -> /* process */);",
                "    }",
                "  Both auto-close with try-with-resources"
            },
            {
                "9. What is try-with-resources?",
                "ANSWER: Automatic resource management (Java 7+)",
                "  Syntax:",
                "    try (Resource r = new Resource()) {",
                "        // Use resource",
                "    } // Automatically closed",
                "  Requirements:",
                "  - Resource implements AutoCloseable",
                "  Benefits:",
                "  - Automatic close() call",
                "  - Even if exception occurs",
                "  - Cleaner code",
                "  - Prevents resource leaks",
                "  Old way: finally block for cleanup"
            },
            {
                "10. How to copy file in Java?",
                "ANSWER: Use Files.copy() (NIO.2)",
                "  Modern way:",
                "    Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);",
                "  Old way (manual):",
                "    try (InputStream in = new FileInputStream(source);",
                "         OutputStream out = new FileOutputStream(target)) {",
                "        byte[] buffer = new byte[1024];",
                "        int length;",
                "        while ((length = in.read(buffer)) > 0) {",
                "            out.write(buffer, 0, length);",
                "        }",
                "    }",
                "  Best practice: Use Files.copy()"
            },
            {
                "11. How to read entire file into String?",
                "ANSWER: Use Files.readString() (Java 11+)",
                "  Java 11+:",
                "    String content = Files.readString(path, StandardCharsets.UTF_8);",
                "  Java 7-10:",
                "    String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);",
                "  Old way:",
                "    StringBuilder sb = new StringBuilder();",
                "    try (BufferedReader br = new BufferedReader(new FileReader(file))) {",
                "        String line;",
                "        while ((line = br.readLine()) != null) {",
                "            sb.append(line).append(\"\\n\");",
                "        }",
                "    }",
                "  Note: Only for small files (loads entire file into memory)"
            },
            {
                "12. How to write to file in Java?",
                "ANSWER: Multiple ways, choose based on need",
                "  Simple text (Java 11+):",
                "    Files.writeString(path, \"content\", StandardCharsets.UTF_8);",
                "  Lines (Java 7+):",
                "    Files.write(path, lines, StandardCharsets.UTF_8);",
                "  Buffered (efficient for large data):",
                "    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {",
                "        writer.write(\"content\");",
                "    }",
                "  Append mode:",
                "    Files.write(path, data, StandardOpenOption.APPEND);"
            },
            {
                "13. What is the difference between FileReader and InputStreamReader?",
                "ANSWER:",
                "  FileReader:",
                "  - Convenience class",
                "  - Uses default encoding",
                "  - Less flexible",
                "  - Example: new FileReader(file)",
                "  InputStreamReader:",
                "  - More flexible",
                "  - Can specify encoding",
                "  - Works with any InputStream",
                "  - Example: new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)",
                "  Best practice: Use InputStreamReader with explicit encoding"
            },
            {
                "14. How to check if file exists?",
                "ANSWER: Use Files.exists() (NIO.2)",
                "  Modern (NIO.2):",
                "    boolean exists = Files.exists(path);",
                "  Old (File API):",
                "    boolean exists = file.exists();",
                "  Also useful:",
                "    Files.notExists(path)",
                "    Files.isRegularFile(path)",
                "    Files.isDirectory(path)",
                "    Files.isReadable(path)",
                "    Files.isWritable(path)"
            },
            {
                "15. How to delete file in Java?",
                "ANSWER: Use Files.delete() or Files.deleteIfExists()",
                "  Delete (throws exception if not exists):",
                "    Files.delete(path);",
                "  Delete if exists (no exception):",
                "    boolean deleted = Files.deleteIfExists(path);",
                "  Old way:",
                "    boolean deleted = file.delete();",
                "  Delete directory:",
                "    // Must be empty first",
                "    Files.delete(dirPath);"
            },
            {
                "16. How to list all files in directory?",
                "ANSWER: Use Files.list() or Files.walk()",
                "  List immediate children:",
                "    try (Stream<Path> paths = Files.list(dirPath)) {",
                "        paths.forEach(System.out::println);",
                "    }",
                "  Walk entire tree (recursive):",
                "    try (Stream<Path> paths = Files.walk(dirPath)) {",
                "        paths.filter(Files::isRegularFile)",
                "             .forEach(System.out::println);",
                "    }",
                "  Old way:",
                "    File[] files = directory.listFiles();"
            },
            {
                "17. What is the difference between absolute and canonical path?",
                "ANSWER:",
                "  Absolute path:",
                "  - Full path from root",
                "  - May contain . or ..",
                "  - Example: /home/user/../user/file.txt",
                "  Canonical path:",
                "  - Absolute path without . or ..",
                "  - Resolved symbolic links",
                "  - Unique for each file",
                "  - Example: /home/user/file.txt",
                "  Get canonical: file.getCanonicalPath()",
                "  Get absolute: file.getAbsolutePath()"
            },
            {
                "18. How to handle large files efficiently?",
                "ANSWER: Stream processing, don't load entire file",
                "  Bad (loads entire file):",
                "    List<String> lines = Files.readAllLines(path); // OutOfMemoryError!",
                "  Good (streams):",
                "    try (Stream<String> lines = Files.lines(path)) {",
                "        lines.forEach(line -> /* process */);",
                "    }",
                "  Also good:",
                "    try (BufferedReader reader = Files.newBufferedReader(path)) {",
                "        String line;",
                "        while ((line = reader.readLine()) != null) {",
                "            // Process line",
                "        }",
                "    }",
                "  Key: Process line-by-line, not all at once"
            },
            {
                "19. What is FileNotFoundException?",
                "ANSWER: Checked exception when file not found",
                "  Thrown by:",
                "  - FileInputStream, FileOutputStream",
                "  - FileReader, FileWriter",
                "  - When opening non-existent file",
                "  Prevention:",
                "    if (Files.exists(path)) {",
                "        // Open file",
                "    }",
                "  Or handle:",
                "    try {",
                "        // Open file",
                "    } catch (FileNotFoundException e) {",
                "        // Handle",
                "    }"
            },
            {
                "20. File I/O best practices?",
                "ANSWER:",
                "  DO:",
                "  - Use try-with-resources (auto-close)",
                "  - Use BufferedReader/Writer for text",
                "  - Use NIO.2 (Path, Files) for new code",
                "  - Specify encoding explicitly",
                "  - Stream large files (don't load all)",
                "  - Use Files.lines() for line-by-line",
                "  - Check file existence before operations",
                "  DON'T:",
                "  - Forget to close streams",
                "  - Use default encoding (platform-dependent)",
                "  - Load large files entirely into memory",
                "  - Use old File API for new projects",
                "  - Ignore IOException"
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
        System.out.println("✓ Use character streams for text, byte streams for binary");
        System.out.println("✓ Always use BufferedReader/Writer for performance");
        System.out.println("✓ Use try-with-resources for automatic cleanup");
        System.out.println("✓ Prefer NIO.2 (Path, Files) over legacy File API");
        System.out.println("✓ Specify charset explicitly (StandardCharsets.UTF_8)");
        System.out.println("✓ Stream large files, don't load entirely");
        System.out.println("✓ Use Files.lines() for efficient line processing");
        System.out.println("✓ Serializable interface for object persistence");
        System.out.println();
    }
}
