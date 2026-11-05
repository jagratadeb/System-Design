interface Shape {
    double area();

    double volume();
}

class Rectangle implements Shape {
    private double length;
    private double breadth;

    public Rectangle(double l, double b) {
        this.length = l;
        this.breadth = b;
    }

    @Override
    public double area() {
        return length * breadth;
    }

    // Rectangle is a 2D shape and does not require volume()
    @Override
    public double volume() {
        throw new UnsupportedOperationException("A rectangle cannot have volume.");
    }
}

class Square implements Shape {
    private double side;

    public Square(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }

    // Square is a 2D shape and does not require volume()
    @Override
    public double volume() {
        throw new UnsupportedOperationException("A square cannot have volume.");
    }
}

class Cube implements Shape {
    private double side;

    public Cube(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

class ISPViolated {
    public static void main(String[] args) {
        Shape square = new Square(5);
        Shape rectangle = new Rectangle(10, 5);
        Shape cube = new Cube(5);

        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Square Area: " + square.area());
        System.out.println("Cube Area: " + cube.area());
        System.out.println("Cube Volume: " + cube.volume());

        try {
            System.out.println("Rectangle's Volume: " + rectangle.volume());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}