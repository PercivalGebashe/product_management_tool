package dao;

import entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();
    void saveProduct(Product product);
    void saveAllProducts(List<Product> productList);
    Product getProductById(Long id);

}