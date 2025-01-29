package service;

import dao.ProductDao;
import entity.Product;

import java.util.List;

public interface HomeService {
    List<Product> getProducts();
    void uploadImage();
    ProductDao getProductDao();
}
