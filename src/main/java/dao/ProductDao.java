package dao;

import entity.Product;
import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();
    void saveProduct(Product product);
    void saveAllProducts(List<Product> products);
    void updateProduct(Product product);
    void deleteProduct(Product productId);
    Product getProductById(String id);
}
