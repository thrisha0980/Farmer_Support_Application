<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.farmersupport.app.model.Video" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Videos - Farmer Support</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef6f9;
            margin: 20px;
        }
        h2 {
            color: #2c7a7b;
            text-align: center;
            margin-bottom: 25px;
        }
        .video-list {
            max-width: 900px;
            margin: auto;
            display: grid;
            grid-template-columns: repeat(auto-fit,minmax(300px,1fr));
            gap: 20px;
        }
        .video-card {
            background: white;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.15);
        }
        .video-title {
            font-weight: bold;
            font-size: 18px;
            color: #2c7a7b;
            margin-bottom: 8px;
        }
        .video-language {
            font-size: 14px;
            font-style: italic;
            color: #555;
            margin-bottom: 12px;
        }
        .video-description {
            font-size: 14px;
            margin-bottom: 12px;
            color: #333;
            min-height: 60px;
        }
        video {
            width: 100%;
            border-radius: 5px;
            background-color: #000;
        }
        .uploaded-by {
            font-size: 12px;
            color: #777;
            margin-top: 8px;
            text-align: right;
        }
    </style>
</head>
<body>

<h2>Uploaded Farming Videos</h2>

<div class="video-list">
    <%
        List<Video> videos = (List<Video>) request.getAttribute("videos");
        if (videos == null || videos.isEmpty()) {
    %>
        <p style="text-align:center; color:#555;">No videos available.</p>
    <%
        } else {
            for (Video video : videos) {
    %>
    <div class="video-card">
        <div class="video-title"><%= video.getTitle() %></div>
        <div class="video-language">Language: <%= video.getLanguage() %></div>
        <video controls preload="metadata">
            <source src="<%= request.getContextPath() + "/" + video.getFilePath() %>" type="video/mp4" />
            Your browser does not support the video tag.
        </video>
        <div class="video-description"><%= video.getDescription() %></div>
        <div class="uploaded-by">Uploaded by: <%= video.getUploadedBy() %></div>
    </div>
    <%
            }
        }
    %>
</div>

</body>
</html>
