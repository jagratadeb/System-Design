// Return Type Rule (Postcondition): Subtypes must return the same type as the supertype

class Animal {
    // Animal class implementation
}

class Factory {
    public Animal createAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    // Dog class implementation
}

class DogFactory extends Factory {
    // Same return type
    @Override
    public Dog createAnimal() {
        return new Dog();
    }
}

class LSPRule3ReturnType {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Animal animal = factory.createAnimal(); // Valid

        DogFactory dogFactory = new DogFactory();
        Dog dog = dogFactory.createAnimal(); // Valid
    }
}