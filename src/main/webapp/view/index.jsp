<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Farmer Support - Home</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7fafc;
            margin: 0;
            padding: 0;
            color: #333;
        }
        header {
            background-color: #2e8b57;
            padding: 20px;
            text-align: center;
            color: white;
        }
        header h1 {
            margin: 0;
            font-weight: 700;
        }
        nav {
            margin: 20px auto;
            text-align: center;
        }
        nav a {
            text-decoration: none;
            color: #2e8b57;
            font-weight: bold;
            margin: 0 15px;
            padding: 10px 20px;
            border: 2px solid #2e8b57;
            border-radius: 5px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }
        nav a:hover {
            background-color: #2e8b57;
            color: white;
        }
        main {
            max-width: 800px;
            margin: 40px auto;
            padding: 0 20px;
            text-align: center;
        }
        main h2 {
            color: #2e8b57;
            margin-bottom: 20px;
        }
        main p {
            font-size: 18px;
            line-height: 1.6;
        }
        footer {
            text-align: center;
            padding: 15px;
            background-color: #e8f5e9;
            color: #555;
            margin-top: 60px;
            font-size: 14px;
        }
    </style>
</head>
<body>

<header>
    <h1>Welcome to Farmer Support</h1>
</header>

<nav>
    <a href="login.jsp">Login</a>
    <a href="register.jsp">Register</a>
    <a href="dashboard.jsp">Dashboard</a>
    <a href="fertilizer-suggestion.jsp">Fertilizer Suggestions</a>
    <a href="disease-result.jsp">Disease Info</a>
    <a href="chat.jsp">Chat</a>
</nav>

<main>
    <h2>Your one-stop solution for modern farming</h2>
    <p>
        Empowering farmers with the latest agricultural techniques, disease diagnosis, fertilizer recommendations, 
        weather updates, and an interactive platform to connect with experts and fellow farmers. 
    </p>
    <p>
        Use the navigation above to get started. Whether you are looking to manage your farm, get expert advice, or simply stay updated with the latest in farming, Farmer Support is here to assist you every step of the way.
    </p>
</main>

<footer>
    &copy; 2025 Farmer Support. All rights reserved.
</footer>

</body>
</html>
