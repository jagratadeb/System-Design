import java.util.ArrayList;
import java.util.List;

// Product class representing any item in eCommerce.
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// 1. ShoppingCart: Only responsible for Cart related business logic.
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }

    List<Product> getProducts() {
        return products;
    }

    double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

// 2. ShoppingCartPrinter: Only responsible for printing invoices
class ShoppingCartPrinter {
    private ShoppingCart cart;

    ShoppingCartPrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

// We now have an INTERFACE which has a method save()
interface DBPersistence {
    void save(ShoppingCart cart);
}

class SQLPersistence implements DBPersistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saved to SQL DB!");
    }
}

class MongoPersistence implements DBPersistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saved to MongoDB!");
    }
}

class FilePersistence implements DBPersistence {
    @Override
    public void save(ShoppingCart cart) {
        System.out.println("Saved to File!");
    }
}

public class OCPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));
        cart.addProduct(new Product("Keyboard", 2500));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        DBPersistence db = new SQLPersistence();
        DBPersistence mongodb = new MongoPersistence();
        DBPersistence file = new FilePersistence();
        db.save(cart);
        mongodb.save(cart);
        file.save(cart);
    }
}