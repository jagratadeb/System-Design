# Liskov Substitution Principle (LSP)

## Definition

> Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

If `Child` inherits from `Parent`, then anywhere a `Parent` object is expected, a `Child` object should work without breaking the program.

---

# Rule 1: Signature Rule

## What is a Method Signature?

A method signature consists of:

1. Method Name
2. Number of Parameters
3. Parameter Types
4. Parameter Order

Example:

```java
void print(String name, int age)
```

Signature:

```java
print(String, int)
```

---

## What is NOT part of the Signature?

The following do NOT affect the signature:

- Return Type
- Parameter Names
- Access Modifiers
- Exceptions

Example:

```java
void print(String name, int age)
void print(String n, int a)
```

Both have the same signature:

```java
print(String, int)
```

Parameter names do not matter.

---

## Compatible Signatures for Overriding

### Parent

```java
class Animal {
    Animal create() {
        return new Animal();
    }
}
```

### Child (Exact Match)

```java
class Dog extends Animal {

    @Override
    Animal create() {
        return new Dog();
    }
}
```

✅ Valid Override

---

### Child (Covariant Return Type)

```java
class Animal {}

class Dog extends Animal {}

class AnimalFactory {
    Animal create() {
        return new Animal();
    }
}

class DogFactory extends AnimalFactory {

    @Override
    Dog create() {
        return new Dog();
    }
}
```

✅ Valid

Because:

```text
Dog IS-A Animal
```

---

### Child (Wider Access Modifier)

```java
class Parent {
    protected void show() {}
}

class Child extends Parent {

    @Override
    public void show() {}
}
```

✅ Valid

Visibility becomes less restrictive.

---

## Incompatible Examples

### Different Parameter Type

```java
class Parent {
    void print(Number n) {}
}

class Child extends Parent {
    void print(Integer n) {}
}
```

❌ Not overriding

---

### Extra Parameter

```java
class Parent {
    void print(String name) {}
}

class Child extends Parent {
    void print(String name, int age) {}
}
```

❌ Not overriding

---

### Different Parameter Order

```java
class Parent {
    void print(String name, int age) {}
}

class Child extends Parent {
    void print(int age, String name) {}
}
```

❌ Not overriding

---

### Narrower Access Modifier

```java
class Parent {
    public void display() {}
}

class Child extends Parent {

    @Override
    private void display() {}
}
```

❌ Not Allowed

---

## Interview Shortcut

For proper overriding:

```text
Method Name      → Same
Parameter Types  → Same
Parameter Order  → Same
Return Type      → Same or More Specific
Access Modifier  → Same or Less Restrictive
```

---

# Rule 2: Method Argument Rule (Precondition Rule)

## What is a Precondition?

A condition that must be true before a method executes.

Example:

```java
void withdraw(double amount)
```

Precondition:

```text
amount > 0
```

---

## LSP Requirement

A child class must not make input requirements stricter.

The child should accept at least everything the parent accepts.

---

### Parent

```java
class Bird {
    void eat(Food food) {
        System.out.println("Eating");
    }
}
```

---

### Bad Child

```java
class Sparrow extends Bird {

    @Override
    void eat(OrganicFood food) {
        System.out.println("Eating organic food");
    }
}
```

Parent accepts:

```text
Food
```

Child accepts:

```text
OrganicFood
```

The child is more restrictive.

❌ LSP Violation

---

### Good Child

```java
class Sparrow extends Bird {

    @Override
    void eat(Food food) {
        System.out.println("Eating food");
    }
}
```

✅ Valid

---

## Memory Trick

Parent says:

```text
Give me any Food.
```

Child says:

```text
No, I only want OrganicFood.
```

❌ LSP Broken

---

# Rule 3: Return Type Rule (Postcondition Rule)

## What is a Postcondition?

A guarantee after a method finishes execution.

Example:

```java
Animal createAnimal()
```

Guarantee:

```text
Returns an Animal.
```

---

## LSP Requirement

Child can return:

- Same Type ✅
- More Specific Type ✅
- More General Type ❌

This is called a **Covariant Return Type**.

---

### Parent

```java
class Animal {}

class Factory {

    Animal create() {
        return new Animal();
    }
}
```

---

### Child

```java
class Dog extends Animal {}

class DogFactory extends Factory {

    @Override
    Dog create() {
        return new Dog();
    }
}
```

✅ Valid

Because:

```text
Dog IS-A Animal
```

---

### Invalid Child

```java
class ObjectFactory extends Factory {

    @Override
    Object create() {
        return new Object();
    }
}
```

Parent promised:

```text
Animal
```

Child now promises:

```text
Object
```

❌ LSP Violation

---

## Memory Trick

Parent promises:

```text
Fruit
```

Child returns:

```text
Apple
```

✅ Fine

Because:

```text
Apple IS-A Fruit
```

Child returns:

```text
Object
```

❌ Not Fine

---

# Rule 4: Exception Rule

## Idea

Clients using the parent class already know which exceptions to handle.

---

### Parent

```java
class FileReader {

    void read() throws IOException {
    }
}
```

Client code:

```java
try {
    reader.read();
}
catch(IOException e) {
}
```

---

## LSP Requirement

Child cannot throw broader exceptions than the parent.

---

### Good Child

```java
class TextReader extends FileReader {

    @Override
    void read() throws FileNotFoundException {
    }
}
```

✅ Valid

Because:

```java
FileNotFoundException
```

is a subtype of:

```java
IOException
```

---

### Bad Child

```java
class TextReader extends FileReader {

    @Override
    void read() throws Exception {
    }
}
```

Parent says:

```text
May throw IOException
```

Child says:

```text
May throw any Exception
```

❌ LSP Violation

---

## Memory Trick

Parent promise:

```text
IOException
```

Child promise:

```text
FileNotFoundException
```

✅ Okay

Child promise:

```text
Exception
```

❌ Not Okay

---

# Rule 5: Property Rule (Invariant Rule)

## What is an Invariant?

A property that should always remain true.

---

## Rectangle Example

Expected Property:

```text
Width and Height are independent.
```

Changing width should not automatically change height.

---

### Parent

```java
class Rectangle {

    int width;
    int height;

    void setWidth(int w) {
        width = w;
    }

    void setHeight(int h) {
        height = h;
    }
}
```

Expected behavior:

```java
Rectangle r = new Rectangle();

r.setWidth(5);
r.setHeight(10);

area = 50;
```

---

### Child

```java
class Square extends Rectangle {

    @Override
    void setWidth(int w) {
        width = w;
        height = w;
    }

    @Override
    void setHeight(int h) {
        width = h;
        height = h;
    }
}
```

---

### Problem

```java
Rectangle r = new Square();

r.setWidth(5);
r.setHeight(10);

System.out.println(r.width);
```

Expected:

```text
5
```

Actual:

```text
10
```

The child changed the behavior.

---

### Parent Property

```text
Width and Height are independent
```

### Child Property

```text
Width and Height must always be equal
```

Different invariants.

❌ LSP Violation

---

## Memory Trick

The child must preserve the behavior expected from the parent.

If the parent guarantees:

```text
A → B
```

The child should not suddenly do:

```text
A → C
```

---

# Complete LSP Summary

| Rule | Meaning |
|--------|----------|
| Signature Rule | Child method must have a compatible signature |
| Argument Rule | Child cannot require stricter inputs |
| Return Type Rule | Child can return same or more specific type |
| Exception Rule | Child cannot throw broader exceptions |
| Property Rule | Child must preserve parent behavior and invariants |

---

# Ultimate Interview Definition

A subclass should:

- Accept at least what the superclass accepts.
- Return at least what the superclass promises.
- Throw no broader exceptions than the superclass.
- Preserve the behavior and invariants of the superclass.

Only then can the subclass truly replace the superclass without breaking the program.