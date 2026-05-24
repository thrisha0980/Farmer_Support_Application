<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage == null || errorMessage.trim().isEmpty()) {
        errorMessage = "An unexpected error occurred. Please try again later.";
    }
%>

<html>
<head>
    <title>Error - Farmer Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fef2f2;
            color: #b91c1c;
            margin: 40px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }
        .error-container {
            background-color: #fee2e2;
            border: 1px solid #fca5a5;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(185, 28, 28, 0.2);
            max-width: 600px;
            text-align: center;
        }
        h1 {
            margin-bottom: 20px;
            font-size: 28px;
        }
        p {
            font-size: 18px;
            line-height: 1.5;
        }
        a {
            display: inline-block;
            margin-top: 25px;
            color: #b91c1c;
            text-decoration: none;
            font-weight: bold;
            border: 1px solid #b91c1c;
            padding: 8px 16px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #b91c1c;
            color: white;
        }
    </style>
</head>
<body>

<div class="error-container">
    <h1>Error Occurred</h1>
    <p><%= errorMessage %></p>
    <a href="index.jsp">Return to Home</a>
</div>

</body>
</html>
