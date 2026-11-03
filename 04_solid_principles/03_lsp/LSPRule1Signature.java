// LSP Signature Rule 1: Child class must have the same method signature as the parent class.

class Parent {
    public void message(String msg) {
        System.out.println(msg);
    }
}

class Child extends Parent {
    // Same signature
    // Signature includes:
    // 1. method name
    // 2. number of parameters
    // 3. order of parameters
    // 4. parameter data types
    @Override
    public void message(String msg) {
        System.out.println("Child: " + msg);
    }
}

class LSPRule1Signature {
    public static void main(String[] args) {

        Parent parent = new Parent();
        parent.message("This is the parent.");

        Child child = new Child();
        child.message("This is the child.");

        Parent p = new Child();
        p.message("This is the child through parent reference.");
        System.out.println("Substitution is allowed: " + (p instanceof Child)); // true
        System.out.println("Substitution is allowed: " + (p instanceof Parent)); // true
        // It was epecting an object of type Parent, but it got an object of type Child.
        // This is allowed because Child is a subclass of Parent, and it can be substituted wherever a Parent object is expected.
    }
}