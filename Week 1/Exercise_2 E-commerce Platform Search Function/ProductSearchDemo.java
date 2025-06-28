import java.util.Arrays;

public class ProductSearchDemo {
    public static void main(String[] args) {
        Product[] var1 = new Product[]{new Product(3, "Laptop", "Electronics"), new Product(1, "Shirt", "Clothing"), new Product(2, "Book", "Books"), new Product(5, "Phone", "Electronics"), new Product(4, "Shoes", "Footwear")};
        Product var2 = linearSearch(var1, 4);
        System.out.println("Linear Search Result: " + var2);
        Arrays.sort(var1);
        Product var3 = binarySearch(var1, 4);
        System.out.println("Binary Search Result: " + var3);
    }

    public static Product linearSearch(Product[] products, int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getId() == id) {
                return products[mid];
            }
            if (products[mid].getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

class Product implements Comparable<Product> {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "'}";
    }
}
