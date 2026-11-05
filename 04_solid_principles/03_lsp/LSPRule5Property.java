// Property Rule (Invariant): Subtypes must maintain the same properties as the supertype

class Rectangle {
    int width;
    int length;

    void setWidth(int width) {
        this.width = width;
    }

    void setLength(int length) {
        this.length = length;
    }
}

class Square extends Rectangle {
    @Override
    void setWidth(int width) {
        this.width = width;
        this.length = width; // Maintain the invariant that width and length are equal
    }

    @Override
    void setLength(int length) {
        this.length = length;
        this.width = length; // Maintain the invariant that width and length are equal
    }
}

class LSPRule5Property {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setLength(10);
        System.out.println("Rectangle: Width = " + rectangle.width + ", Length = " + rectangle.length); // Valid

        Square square = new Square();
        square.setWidth(5);
        System.out.println("Square: Width = " + square.width + ", Length = " + square.length); // Valid, maintains                                                                                     // invariant
    }
}