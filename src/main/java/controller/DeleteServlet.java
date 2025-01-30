package controller;

import dao.ProductDao;
import dao.imp.ProductDaoImp;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.HibernateUtil;

import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    private final ProductDao productDao;

    public DeleteServlet(){
        this.productDao = new ProductDaoImp(HibernateUtil.getSessionFactory());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if(session != null){
            String id = req.getParameter("id");
            Product product = productDao.getProductById(id);
            productDao.deleteProduct(product);

            resp.sendRedirect("/home");
            return;
        }
    }
}
