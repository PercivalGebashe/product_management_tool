package service.imp;

import dao.ProductDao;
import entity.Product;
import service.HomeService;

import java.util.List;

public class HomeServiceImp implements HomeService {

    private final ProductDao productDao;

    public HomeServiceImp(ProductDao productDao){
        this.productDao = productDao;
    }
    @Override
    public List<Product> getProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public void uploadImage(){

    }


    @Override
    public ProductDao getProductDao(){
        return productDao;
    }
}
