<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.farmersupport.app.model.FertilizerSuggestion" %>

<%
    // The servlet or controller should set this attribute with a List<FertilizerSuggestion>
    List<FertilizerSuggestion> suggestions = (List<FertilizerSuggestion>) request.getAttribute("suggestions");
    String crop = (String) request.getAttribute("crop");
    String soilType = (String) request.getAttribute("soilType");
    Double landSize = (Double) request.getAttribute("landSize");
%>

<html>
<head>
    <title>Fertilizer Suggestions - Farmer Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #e6f2ff;
            margin: 40px;
        }
        h1 {
            color: #0073e6;
        }
        .info {
            margin-bottom: 20px;
            font-size: 16px;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #0073e6;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f0f8ff;
        }
        .no-data {
            margin-top: 20px;
            font-style: italic;
            color: #777;
        }
        a.back-link {
            display: inline-block;
            margin-top: 20px;
            color: #0073e6;
            text-decoration: none;
            font-weight: bold;
        }
        a.back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h1>Fertilizer Suggestions</h1>

<div class="info">
    <strong>Crop:</strong> <%= (crop != null) ? crop : "N/A" %><br>
    <strong>Soil Type:</strong> <%= (soilType != null) ? soilType : "N/A" %><br>
    <strong>Land Size (acres):</strong> <%= (landSize != null) ? landSize : "N/A" %>
</div>

<%
    if (suggestions != null && !suggestions.isEmpty()) {
%>
    <table>
        <thead>
            <tr>
                <th>Fertilizer Name</th>
                <th>Amount Required (kg)</th>
            </tr>
        </thead>
        <tbody>
        <% for (FertilizerSuggestion fs : suggestions) { %>
            <tr>
                <td><%= fs.getFertilizerName() %></td>
                <td><%= fs.getAmountRequired() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
<%
    } else {
%>
    <div class="no-data">No fertilizer suggestions available for the selected criteria.</div>
<%
    }
%>

<a class="back-link" href="fertilizer-form.jsp">← Back to Fertilizer Suggestion Form</a>

</body>
</html>
