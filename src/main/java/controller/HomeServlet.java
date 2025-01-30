package controller;

import dao.imp.ProductDaoImp;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import service.HomeService;
import service.imp.HomeServiceImp;
import util.HibernateUtil;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;


@MultipartConfig(maxFileSize = 16177215) // 16MB limit for image upload
public class HomeServlet extends HttpServlet {

    private HomeService homeService;

    public HomeServlet(){
        this.homeService = new HomeServiceImp(
                new ProductDaoImp(HibernateUtil.getSessionFactory())
        );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null) {
            try {
                List<Product> productList = homeService.getProducts();

                request.setAttribute("products", productList);
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } catch (Exception e) {
                System.err.println("Error fetching products: " + e.getMessage());
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to fetch products");
                return;
            }
        }else {
            response.sendRedirect("/login");
            return;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            String title = request.getParameter("title");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int size = Integer.parseInt(request.getParameter("size"));
            Part filePart = request.getPart("image"); // Get uploaded file

            byte[] imageData = null;
            if (filePart != null && filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                imageData = inputStream.readAllBytes();
            }

            Product product = new Product();
            product.setTitle(title);
            product.setQuantity(quantity);
            product.setSize(size);

            if (imageData != null) {
                Blob imageBlob = new SerialBlob(imageData);
                product.setImage(imageBlob);
            }

            homeService.getProductDao().saveProduct(product);
            response.sendRedirect("/home"); // Redirect back to home
            return;

        }catch (Exception e){

        }
    }
}
