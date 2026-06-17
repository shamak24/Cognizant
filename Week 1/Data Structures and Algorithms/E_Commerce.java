import java.util.*;
class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(){}
    public void setProduct(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getCategory() {
        return category;
    }
}

public class E_Commerce {
    public static ArrayList<Product> sorted(ArrayList<Product> products) {
        ArrayList<Product> sortedProducts = new ArrayList<>(products);
        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getProductName().compareToIgnoreCase(p2.getProductName());
            }
        });
        return sortedProducts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i<10; i++){
            Product product = new Product();
            String productId = "P" + (i+1);
            System.out.print("Enter Product Name: ");
            String productName = sc.nextLine();
            System.out.print("Enter Category: ");
            String category = sc.nextLine();
            product.setProduct(productId, productName, category);
            products.add(product);
        }
        ArrayList<Product> sortedProducts = sorted(products);

        //lINEAR SEARCH
        System.out.print("Enter Product Name or Category to search: ");
        String searchName = sc.nextLine();
        boolean found = false;
        for(Product product : products){
            if(product.getProductName().equalsIgnoreCase(searchName) || product.getCategory().equalsIgnoreCase(searchName)){
                System.out.println("Product ID: " + product.getProductId());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Category: " + product.getCategory());
                found = true;
            }
        }
        if(!found){
            System.out.println("Product not found.");
        }

        //BINARY SEARCH
        int left = 0, right = sortedProducts.size() - 1;
        found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = sortedProducts.get(mid);
            if (midProduct.getProductName().equalsIgnoreCase(searchName)) {
                System.out.println("Product ID: " + midProduct.getProductId());
                System.out.println("Product Name: " + midProduct.getProductName());
                System.out.println("Category: " + midProduct.getCategory());
                found = true;
                break;
            } else if (midProduct.getProductName().compareToIgnoreCase(searchName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(!found){
            System.out.println("Product not found.");
        }

        sc.close();
    }
}
