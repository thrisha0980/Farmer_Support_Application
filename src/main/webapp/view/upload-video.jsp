<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Upload Video - Farmer Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef6f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 450px;
            margin: 50px auto;
            background: white;
            padding: 25px 30px;
            border-radius: 8px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.15);
        }
        h2 {
            color: #2c7a7b;
            text-align: center;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #444;
        }
        input[type="text"],
        select,
        textarea {
            width: 100%;
            padding: 8px 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
        }
        input[type="file"] {
            margin-top: 8px;
        }
        .btn {
            margin-top: 25px;
            width: 100%;
            background-color: #2c7a7b;
            color: white;
            font-weight: bold;
            font-size: 16px;
            padding: 12px 0;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn:hover {
            background-color: #1f5959;
        }
        .message {
            margin-top: 15px;
            text-align: center;
            font-weight: bold;
            color: green;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Upload Farming Video</h2>
    <form action="uploadVideo" method="post" enctype="multipart/form-data">
        <label for="title">Video Title</label>
        <input type="text" id="title" name="title" required maxlength="100"/>

        <label for="language">Language</label>
        <select id="language" name="language" required>
            <option value="" disabled selected>Select language</option>
            <option value="English">English</option>
            <option value="Hindi">Hindi</option>
            <option value="Tamil">Tamil</option>
            <option value="Telugu">Telugu</option>
            <option value="Kannada">Kannada</option>
            <option value="Malayalam">Malayalam</option>
            <option value="Other">Other</option>
        </select>

        <label for="description">Description</label>
        <textarea id="description" name="description" rows="4" maxlength="500" required></textarea>

        <label for="videoFile">Select Video File</label>
        <input type="file" id="videoFile" name="videoFile" accept="video/*" required/>

        <button type="submit" class="btn">Upload Video</button>
    </form>

    <%
        String message = (String) request.getAttribute("message");
        String error = (String) request.getAttribute("error");
        if (message != null) {
    %>
        <div class="message"><%= message %></div>
    <%
        } else if (error != null) {
    %>
        <div class="message error"><%= error %></div>
    <%
        }
    %>
</div>
</body>
</html>
