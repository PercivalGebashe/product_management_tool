package service.imp;

import dao.ProductDao;
import dao.imp.ProductDaoImp;
import entity.Product;
import service.ProductService;
import util.HibernateUtil;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = new ProductDaoImp(HibernateUtil.getSessionFactory());
    }

    @Override
    public void createProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public Product getProduct(String id) {
        return  productDao.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}
