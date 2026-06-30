import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {

        for (Product product : products) {

            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(name);

            if (compare == 0)
                return products[mid];

            else if (compare < 0)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Mobile", "Electronics"),
                new Product(104, "Watch", "Accessories")
        };

        String searchItem = "Mobile";

        // Linear Search
        Product result = linearSearch(products, searchItem);

        System.out.println("Linear Search");

        if (result != null) {
            System.out.println(result.productId + " " + result.productName + " " + result.category);
        } else {
            System.out.println("Product Not Found");
        }

        // Sort array before Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        // Binary Search
        result = binarySearch(products, searchItem);

        System.out.println("\nBinary Search");

        if (result != null) {
            System.out.println(result.productId + " " + result.productName + " " + result.category);
        } else {
            System.out.println("Product Not Found");
        }
    }
}
