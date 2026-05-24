<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.farmersupport.app.model.Product" %>

<%
    List<Product> productList = (List<Product>) request.getAttribute("productList");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Product List - Farmer Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9fafd;
            margin: 20px;
            color: #333;
        }
        h1 {
            color: #2e8b57;
            text-align: center;
            margin-bottom: 25px;
        }
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #2e8b57;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f1f8f5;
        }
        tr:hover {
            background-color: #d4efdf;
        }
        .btn {
            padding: 6px 12px;
            color: white;
            background-color: #2e8b57;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            font-weight: bold;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #246b45;
        }
        .actions {
            display: flex;
            gap: 10px;
            justify-content: center;
        }
        .add-product {
            display: block;
            width: 150px;
            margin: 20px auto;
            padding: 10px;
            background-color: #2e8b57;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
        }
        .add-product:hover {
            background-color: #246b45;
        }
    </style>
</head>
<body>

<h1>Available Products</h1>

<a href="add-products.jsp" class="add-product">Add New Product</a>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Description</th>
            <th>Price (₹)</th>
            <th>Available Quantity</th>
            <th>Seller Username</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <%
        if (productList != null && !productList.isEmpty()) {
            for (Product product : productList) {
    %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td><%= product.getCategory() %></td>
            <td><%= product.getDescription() %></td>
            <td><%= String.format("%.2f", product.getPrice()) %></td>
            <td><%= product.getAvailableQuantity() %></td>
            <td><%= product.getSellerUsername() %></td>
            <td class="actions">
                <a href="ProductController?action=edit&id=<%= product.getId() %>" class="btn">Edit</a>
                <a href="ProductController?action=delete&id=<%= product.getId() %>" class="btn" 
                   onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
            </td>
        </tr>
    <%
            }
        } else {
    %>
        <tr>
            <td colspan="8">No products found.</td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
