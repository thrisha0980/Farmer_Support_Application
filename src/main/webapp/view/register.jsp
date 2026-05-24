<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Registration - Farmer Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e8f0f2;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 50px auto;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 3px 8px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            color: #2e8b57;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin: 12px 0 5px;
            font-weight: bold;
            color: #333;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        textarea,
        select {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
        }
        textarea {
            resize: vertical;
        }
        .btn {
            width: 100%;
            padding: 12px 0;
            margin-top: 20px;
            background-color: #2e8b57;
            color: white;
            border: none;
            font-weight: bold;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #246b45;
        }
        .message {
            text-align: center;
            margin-top: 15px;
            color: red;
            font-weight: bold;
        }
        .login-link {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #2e8b57;
            text-decoration: none;
            font-weight: bold;
        }
        .login-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>User Registration</h2>
        <form action="register" method="post">
            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" required maxlength="50" />

            <label for="username">Username</label>
            <input type="text" id="username" name="username" required maxlength="30" />

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required minlength="6" maxlength="20" />

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required maxlength="50" />

            <label for="contact">Contact Number</label>
            <input type="text" id="contact" name="contact" required maxlength="15" pattern="[0-9]+" title="Digits only" />

            <label for="address">Address</label>
            <textarea id="address" name="address" rows="3" required maxlength="255"></textarea>

            <label for="role">Role</label>
            <select id="role" name="role" required>
                <option value="" disabled selected>Select role</option>
                <option value="farmer">Farmer</option>
                <option value="seller">Seller</option>
                <option value="buyer">Buyer</option>
                <option value="admin">Admin</option>
            </select>

            <button type="submit" class="btn">Register</button>
        </form>

        <a href="login.jsp" class="login-link">Already have an account? Login here</a>

        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <div class="message"><%= message %></div>
        <%
            }
        %>
    </div>
</body>
</html>
