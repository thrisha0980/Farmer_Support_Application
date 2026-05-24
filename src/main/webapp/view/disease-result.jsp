<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.farmersupport.app.model.Disease" %>
<%
    Disease disease = (Disease) request.getAttribute("disease");
%>

<html>
<head>
    <title>Disease Result - Farmer Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f3f4f6;
            margin: 40px;
        }
        .container {
            max-width: 700px;
            background: white;
            padding: 25px 30px;
            border-radius: 10px;
            box-shadow: 0 8px 15px rgba(0,0,0,0.1);
            margin: auto;
        }
        h2 {
            color: #2563eb;
            margin-bottom: 20px;
        }
        .info-label {
            font-weight: bold;
            color: #374151;
            margin-top: 15px;
        }
        .info-text {
            margin-left: 10px;
            color: #4b5563;
        }
        .no-result {
            color: #dc2626;
            font-size: 18px;
            text-align: center;
            padding: 40px 0;
        }
        .back-link {
            display: inline-block;
            margin-top: 30px;
            color: #2563eb;
            text-decoration: none;
            font-weight: bold;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Plant Disease Details</h2>

    <%
        if (disease != null) {
    %>
        <div>
            <div class="info-label">Plant Name:</div>
            <div class="info-text"><%= disease.getPlantName() %></div>
        </div>
        <div>
            <div class="info-label">Disease Name:</div>
            <div class="info-text"><%= disease.getDiseaseName() %></div>
        </div>
        <div>
            <div class="info-label">Symptoms:</div>
            <div class="info-text"><pre><%= disease.getSymptoms() %></pre></div>
        </div>
        <div>
            <div class="info-label">Solution:</div>
            <div class="info-text"><pre><%= disease.getSolution() %></pre></div>
        </div>
    <%
        } else {
    %>
        <div class="no-result">
            No disease information found for the given symptoms.
        </div>
    <%
        }
    %>

    <a href="disease-search.jsp" class="back-link">&larr; Back to Search</a>
</div>

</body>
</html>
