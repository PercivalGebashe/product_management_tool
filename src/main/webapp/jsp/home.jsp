<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management Tool</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/homePage.css" type="text/css" />
    <link rel="stylesheet" href="css/updateModal.css" type="text/css">
</head>
<body>
    <div class="container mt-5">
        <!-- Header -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="fw-bold text-primary">Product Management</h2>
            <div class="d-flex align-items-center">
                <span class="me-3 text-muted">Hi, <strong><%= (username != null) ? username : "Guest" %></strong>!</span>
                <form action="/login" method="get" class="m-0">
                    <button class="btn btn-outline-danger px-4">Logout</button>
                </form>
            </div>
        </div>

        <!-- Form Card -->
        <div class="card p-4 mb-4">
            <h5 class="fw-bold text-secondary">Enter Product Details</h5>
            <form id="productForm" method="post" enctype="multipart/form-data" action="/home">
                <div class="row g-3">
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="title" name="title" placeholder="Title" required>
                    </div>
                    <div class="col-md-2">
                        <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Qty" required>
                    </div>
                    <div class="col-md-2">
                        <input type="text" class="form-control" id="size" name="size" placeholder="Size" required>
                    </div>
                    <div class="col-md-3">
                        <input type="file" class="form-control" id="image" name="image" required>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-primary w-100 btn-custom">Add</button>
                    </div>
                </div>
            </form>
        </div>

        <!-- Product Table -->
        <div class="table-responsive">
            <table class="table table-striped table-hover bg-white shadow-sm">
                <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Size</th>
                        <th>Image</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.title}</td>
                            <td>${product.quantity}</td>
                            <td>${product.size}</td>
                            <td>
                                <img src="/image?id=${product.id}" width="60" height="60">
                            </td>
                            <td>
                                <div class="d-flex gap-2">
                                    <!-- Update Button -->
                                    <button type="button" class="btn btn-sm btn-outline-info btn-custom"
                                            data-bs-toggle="modal" data-bs-target="#editModal"
                                            onclick="openEditModal('${product.id}', '${product.title}', ${product.quantity}, '${product.size}')">
                                        ✏ Update
                                    </button>

                                    <!-- Delete Form -->
                                    <form id="deleteProductForm" action="/delete?id=${product.id}" method="post">
                                        <button type="submit" class="btn btn-sm btn-outline-danger btn-custom">✖ Delete</button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Edit Product</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="editProductForm" method="POST" action="/update">
                        <input type="hidden" id="productId" name="id"/>
                        <div class="mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="modalTitle" name="title"/>
                        </div>
                        <div class="mb-3">
                            <label for="quantity" class="form-label">Quantity</label>
                            <input type="number" class="form-control" id="modalQuantity" name="quantity"/>
                        </div>
                        <div class="mb-3">
                            <label for="size" class="form-label">Size</label>
                            <input type="text" class="form-control" id="modalSize" name="size"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Update Product</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>
