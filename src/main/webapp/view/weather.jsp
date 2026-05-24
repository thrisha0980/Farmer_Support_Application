<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.farmersupport.app.model.WeatherInfo" %>

<!DOCTYPE html>
<html>
<head>
    <title>Weather Information - Farmer Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f9ff;
            margin: 20px;
        }
        h2 {
            color: #31708f;
            text-align: center;
            margin-bottom: 25px;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 18px;
            border: 1px solid #ddd;
            text-align: center;
            color: #333;
        }
        th {
            background-color: #5bc0de;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .no-data {
            text-align: center;
            color: #666;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h2>Weather Information</h2>

<%
    List<WeatherInfo> weatherList = (List<WeatherInfo>) request.getAttribute("weatherList");
    if (weatherList == null || weatherList.isEmpty()) {
%>
    <p class="no-data">No weather information available for the selected location.</p>
<%
    } else {
%>
    <table>
        <thead>
            <tr>
                <th>Date</th>
                <th>Location</th>
                <th>Temperature (&deg;C)</th>
                <th>Humidity (%)</th>
                <th>Condition</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (WeatherInfo info : weatherList) {
            %>
            <tr>
                <td><%= info.getDate() %></td>
                <td><%= info.getLocation() %></td>
                <td><%= info.getTemperature() %></td>
                <td><%= info.getHumidity() %></td>
                <td><%= info.getCondition() %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
<%
    }
%>

</body>
</html>
