// Exception Rule: A subclass should not throw new or broader checked exceptions than the ones declared by the parent class method. This rule is about the exceptions that a method can throw. If a method in a subclass throws a checked exception that is not declared in the superclass method, it violates the Liskov Substitution Principle.

class FileReader {
    public void readFile(String filePath) throws java.io.IOException {
        // Read file implementation
    }
}

class CustomFileReader extends FileReader {
    // This method throws a broader checked exception (Exception) than the superclass method (IOException)
    @Override
    public void readFile(String filePath) throws Exception {
        // Read file implementation
    }
}

class LSPRule4Exception {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile("path/to/file.txt"); // Valid
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        CustomFileReader customFileReader = new CustomFileReader();
        try {
            customFileReader.readFile("path/to/file.txt"); // Invalid, will throw a broader exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}