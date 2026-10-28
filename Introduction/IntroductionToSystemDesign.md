# Introduction to System Design

When we build software, we are not only writing code. We are also deciding:

- What the system should do
- How its parts should work together
- How it should handle more users and data
- How it should remain easy to change and maintain

This is where **DSA**, **HLD**, and **LLD** are useful.

## What is DSA?

**DSA** stands for **Data Structures and Algorithms**.

- A **data structure** is a way to store and organize data.
- An **algorithm** is a step-by-step method for solving a problem.

For example, imagine that you need to find a student's name in a list:

- You could check every name one by one. This is a simple algorithm.
- If the names are sorted, you could use **binary search** to find the name
  much faster.
- You could store names in a **hash table** to find them quickly using a key.

DSA mainly helps us write code that is efficient in terms of:

- **Time complexity:** How long the code takes to run
- **Space complexity:** How much memory the code uses

Common data structures include arrays, linked lists, stacks, queues, trees,
graphs, heaps, and hash tables. Common algorithms include searching, sorting,
recursion, traversal, and dynamic programming.

## What is HLD?

**HLD** stands for **High-Level Design**.

HLD describes the system from a broad, architectural point of view. It focuses
on the major components and how they communicate, rather than the details of
individual classes or methods.

For example, for a food delivery application, an HLD may identify:

- A mobile or web client
- An API gateway
- User and restaurant services
- An order service
- A payment service
- A notification service
- Databases and a cache
- A message queue for background work

At this level, we discuss questions such as:

- Which services are needed?
- How will services communicate?
- Where will data be stored?
- How will the system handle millions of users?
- What happens if one service is temporarily unavailable?

HLD is similar to drawing a map of a city. The map shows the important roads,
buildings, and connections, but not every room inside every building.

## What is LLD?

**LLD** stands for **Low-Level Design**.

LLD describes the internal design of each component in more detail. It focuses
on classes, objects, interfaces, methods, relationships, and the flow of
logic.

For the order service in a food delivery application, an LLD may define:

- An `Order` class with order ID, items, amount, and status
- An `OrderItem` class for each item in the order
- An `OrderStatus` enum such as `PLACED`, `CONFIRMED`, and `DELIVERED`
- Methods such as `placeOrder()`, `cancelOrder()`, and `updateStatus()`
- Interfaces such as `PaymentProcessor` and `NotificationSender`
- Rules that decide when an order can be cancelled

LLD is similar to the detailed blueprint of one building. It explains the
rooms, doors, wiring, and internal layout.

## HLD vs. LLD vs. DSA

| Aspect | DSA | HLD | LLD |
| :--- | :--- | :--- | :--- |
| Full form | Data Structures and Algorithms | High-Level Design | Low-Level Design |
| Main focus | Solving computational problems efficiently | Designing the overall system architecture | Designing the internal details of components |
| Typical questions | Which algorithm and data structure should be used? | Which services, databases, and communication methods are needed? | Which classes, interfaces, methods, and relationships are needed? |
| Level of detail | Problem-solving detail | Broad architectural detail | Detailed object and code-level design |
| Common artifacts | Code, pseudocode, complexity analysis | Architecture diagrams, service diagrams, data-flow diagrams | Class diagrams, sequence diagrams, interface and class definitions |
| Main concerns | Correctness, time complexity, and space complexity | Scalability, availability, reliability, and performance | Maintainability, extensibility, reusability, and clean code |
| Example | Finding a restaurant using a hash table or sorting algorithm | Separating users, orders, payments, and delivery into services | Designing `Order`, `Payment`, and `Delivery` classes |
| Usual audience | Developers and interviewers | Architects, senior engineers, and development teams | Developers and technical leads |

## One Simple Example: Designing a Food Delivery App

Suppose we want to build a food delivery app.

### 1. DSA perspective

We need to find restaurants near a customer's location. We might use:

- A graph algorithm to calculate routes
- A sorting algorithm to order restaurants by rating or distance
- A hash table to look up a restaurant by its ID

The focus is on selecting an efficient way to solve each individual problem.

### 2. HLD perspective

We decide that the application will have:

```text
Customer App
     |
 API Gateway
     |
 +---+----------+------------+-------------+
 |              |            |             |
User Service  Order Service  Payment     Delivery
                              Service     Service
```

We also decide where data is stored, how services communicate, and how the
system handles high traffic. The focus is on the complete system.

### 3. LLD perspective

Inside the order service, we design classes such as:

```text
Order
 ├── orderId
 ├── customer
 ├── items
 ├── totalAmount
 └── status

Order
 ├── placeOrder()
 ├── cancelOrder()
 └── updateStatus()
```

We then decide how `Order` interacts with `PaymentProcessor`,
`RestaurantService`, and `NotificationSender`. The focus is on the internal
working of one part of the system.

## How They Work Together

DSA, HLD, and LLD are not competing subjects. They work together:

1. **DSA** helps us solve individual problems efficiently.
2. **HLD** helps us arrange the major parts of a complete system.
3. **LLD** helps us design the internal implementation of those parts.

A strong software engineer uses all three. For example, an engineer may use
DSA to select an efficient search algorithm, HLD to decide where the search
service belongs, and LLD to design the classes that implement that service.

> [!NOTE]
> **Easy way to remember:**  
> **DSA solves the problem. HLD structures the system. LLD designs the parts.**