<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management Tool</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
    <body>
        <div class="container mt-4">
            <div class="d-flex justify-content-between align-items-center">
                <h2>Product Management Tool</h2>
                <div>
                    <form action="/login" method="get">
                        <span>Hi, <%= username %></span>
                        <button class="btn btn-danger btn-sm">Logout</button>
                    </form>
                </div>
            </div>
            <hr>

            <h4>Please enter product details to add to stock</h4>
            <form id="productForm" class="mb-4" method="post" enctype="multipart/form-data" action="/home">
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control" id="title" name="title" placeholder="Title" required>
                    </div>
                    <div class="form-group col-md-2">
                        <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Quantity" required>
                    </div>
                    <div class="form-group col-md-2">
                        <input type="text" class="form-control" id="size" name="size" placeholder="Size" required>
                    </div>
                    <div class="form-group col-md-3">
                        <input type="file" class="form-control" id="image" name="image" required>
                    </div>
                    <div class="form-group col-md-2">
                        <button type="submit" class="btn btn-primary btn-block">Add</button>
                    </div>
                </div>
            </form>

            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>S. No.</th>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Size</th>
                        <th>Image</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody id="productTableBody">
                    <!-- Product rows will be inserted dynamically -->
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.title}</td>
                            <td>${product.quantity}</td>
                            <td>${product.size}</td>
                            <td>
                                <img src="/image?id=${product.id}" width="50" height="50" />
                            </td>
                            <td>
                                <button class="btn btn-sm btn-info">✏</button>
                                <button class="btn btn-sm btn-danger">✖</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>