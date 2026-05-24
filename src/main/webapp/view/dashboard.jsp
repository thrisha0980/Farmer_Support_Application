<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.farmersupport.app.model.User" %>
<%
    User user = (User) session.getAttribute("loggedInUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Dashboard - Farmer Support</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e0f2fe;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 900px;
            margin: 40px auto;
            padding: 20px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0,0,0,0.1);
        }
        h1 {
            color: #047857;
            margin-bottom: 30px;
        }
        .welcome {
            font-size: 20px;
            margin-bottom: 30px;
        }
        .nav-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit,minmax(200px,1fr));
            gap: 20px;
        }
        .nav-card {
            background-color: #10b981;
            color: white;
            padding: 25px;
            text-align: center;
            border-radius: 10px;
            text-decoration: none;
            font-weight: bold;
            font-size: 18px;
            box-shadow: 0 4px 15px rgba(16,185,129,0.4);
            transition: background-color 0.3s ease;
        }
        .nav-card:hover {
            background-color: #059669;
            box-shadow: 0 6px 25px rgba(5,150,105,0.6);
        }
        .logout-btn {
            margin-top: 30px;
            display: inline-block;
            background-color: #ef4444;
            color: white;
            padding: 12px 25px;
            border-radius: 10px;
            font-weight: bold;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .logout-btn:hover {
            background-color: #b91c1c;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Farmer Support Dashboard</h1>

    <div class="welcome">
        Welcome, <strong><%= user.getName() %></strong>!
    </div>

    <div class="nav-grid">
        <a class="nav-card" href="diseases">Plant Diseases</a>
        <a class="nav-card" href="fertilizerSuggestions">Fertilizer Suggestions</a>
        <a class="nav-card" href="products">Marketplace</a>
        <a class="nav-card" href="videos">Farming Videos</a>
        <a class="nav-card" href="weather">Weather Info</a>
        <a class="nav-card" href="chat">Chat</a>
    </div>

    <a href="logout" class="logout-btn">Logout</a>
</div>
</body>
</html>
