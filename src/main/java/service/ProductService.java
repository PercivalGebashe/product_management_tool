package service;

import entity.Product;
import java.util.List;

public interface ProductService {

    void createProduct(Product product);
    Product getProduct(String id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Product product);
}
