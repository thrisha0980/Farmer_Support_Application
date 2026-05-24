<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product - Farmer Support</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #f0fdf4, #dbeafe);
            margin: 0;
            padding: 0;
        }

        .container {
            width: 500px;
            margin: 80px auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            color: #047857;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            background-color: #10b981;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #059669;
        }

        .success {
            text-align: center;
            color: green;
            margin-top: 15px;
        }

        .error {
            text-align: center;
            color: red;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Add New Product</h2>

    <form action="addProduct" method="post">
        <label for="name">Product Name:</label>
        <input type="text" name="name" id="name" required>

        <label for="category">Category:</label>
        <select name="category" id="category" required>
            <option value="">--Select Category--</option>
            <option value="Seed">Seed</option>
            <option value="Fertilizer">Fertilizer</option>
            <option value="Crop">Crop</option>
            <option value="Tool">Tool</option>
        </select>

        <label for="description">Description:</label>
        <textarea name="description" id="description" rows="4" required></textarea>

        <label for="price">Price (in ₹):</label>
        <input type="number" name="price" id="price" step="0.01" required>

        <label for="addedBy">Added By:</label>
        <input type="text" name="addedBy" id="addedBy" required>

        <button type="submit">Add Product</button>
    </form>

    <%
        String message = (String) request.getAttribute("message");
        String error = (String) request.getAttribute("error");
        if (message != null) {
    %>
        <div class="success"><%= message %></div>
    <%
        } else if (error != null) {
    %>
        <div class="error"><%= error %></div>
    <%
        }
    %>
</div>

</body>
</html>
