interface TwoDimensionalShape {
    double area();
}

interface ThreeDimensionalShape{
    double area();
    double volume();
}

class Rectangle implements TwoDimensionalShape {
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
}

class Square implements TwoDimensionalShape {
    private double side;

    public Square(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class Cube implements ThreeDimensionalShape {
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

class ISPFollowed {
    public static void main(String[] args) {
        TwoDimensionalShape square = new Square(5);
        TwoDimensionalShape rectangle = new Rectangle(10, 5);
        ThreeDimensionalShape cube = new Cube(5);

        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Square Area: " + square.area());
        System.out.println("Cube Area: " + cube.area());
        System.out.println("Cube Volume: " + cube.volume());
    }
}