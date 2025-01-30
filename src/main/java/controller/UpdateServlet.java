package controller;

import dao.ProductDao;
import dao.imp.ProductDaoImp;
import entity.Product;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.HibernateUtil;

import java.io.IOException;

public class UpdateServlet extends HttpServlet {

    private final ProductDao productDao;

    public UpdateServlet(){
        this.productDao = new ProductDaoImp(HibernateUtil.getSessionFactory());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if(session != null){
            String id = request.getParameter("id");
            String title = request.getParameter("title");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int size = Integer.parseInt(request.getParameter("size"));

            Product product = productDao.getProductById(id);

            product.setTitle(title);
            product.setQuantity(quantity);
            product.setSize(size);

            System.out.println(product);

            productDao.updateProduct(product);

            response.sendRedirect("/home");
        }else {
            response.sendRedirect("/login");
        }
    }
}
