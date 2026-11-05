// Method Argument Rule (Precondition): Subtypes must accept the same arguments as the supertype

class Food {
    // Food class implementation
}

class OrganicFood extends Food {
    // OrganicFood class implementation
}

class Bird {
    public void eat(Food food) {
        System.out.println("Bird is eating food");
    }
}

class Sparrow extends Bird {
    // Same signature
    @Override
    public void eat(Food food) {
        if (food instanceof OrganicFood) {
            System.out.println("Sparrow is organic food");
        } else {
            throw new IllegalArgumentException("Sparrow can only eat organic food.");
        }
        System.out.println("Sparrow is eating food");
    }
}

class LSPRule2MethodArgument {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.eat(new Food()); // Valid

        Sparrow sparrow = new Sparrow();
        sparrow.eat(new OrganicFood()); // Valid
        sparrow.eat(new Food()); // Invalid, will throw an exception
    }
}