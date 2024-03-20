import java.io.*;

class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        // Serialization
        Product product = new Product(1, "Laptop", "Electronics", 999.99);
        serializeProduct(product, "product.ser");
        
        // Deserialization
        Product deserializedProduct = deserializeProduct("product.ser");
        System.out.println("Deserialized Product: " + deserializedProduct);
    }
    
    public static void serializeProduct(Product product, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(product);
            System.out.println("Product serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Product deserializeProduct(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Product product = (Product) inputStream.readObject();
            System.out.println("Product deserialized successfully.");
            return product;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}