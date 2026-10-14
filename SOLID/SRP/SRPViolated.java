import java.util.ArrayList;
import java.util.List;

class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProduct() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    // Here we are violating SRP as this method is performing the job of a printer
    // class.
    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : products) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + calculateTotal());
    }

    // Here we are violating SRP as it saves data in DB which should be done by
    // other class.
    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

class SRPViolated {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        cart.printInvoice();
        cart.saveToDatabase();
    }
}