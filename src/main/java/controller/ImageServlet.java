package controller;

import dao.ProductDao;
import dao.imp.ProductDaoImp;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.HibernateUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class ImageServlet extends HttpServlet {
    private final ProductDao productDao;

    public ImageServlet(){
        this.productDao =  new ProductDaoImp(
                HibernateUtil.getSessionFactory()
        );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing product ID");
            return;
        }

        Long productId = Long.parseLong(idParam);
        Product product = productDao.getProductById(productId);

        if (product == null || product.getImage() == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found");
            return;
        }

        Blob imageBlob = product.getImage();
        try {
            InputStream inputStream = imageBlob.getBinaryStream();
            response.setContentType("image/jpeg");

            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
