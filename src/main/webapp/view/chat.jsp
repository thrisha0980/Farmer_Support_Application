<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.farmersupport.app.model.Message" %>
<%
    // Assume "messages" is a List<Message> set in request attribute by servlet
    List<Message> messages = (List<Message>) request.getAttribute("messages");

    String sender = (String) request.getAttribute("sender");
    String receiver = (String) request.getAttribute("receiver");
%>

<html>
<head>
    <title>Chat - Farmer Support</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e0f2fe;
            margin: 0;
            padding: 0;
        }

        .chat-container {
            width: 600px;
            margin: 40px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            display: flex;
            flex-direction: column;
            height: 80vh;
        }

        .messages {
            flex-grow: 1;
            overflow-y: auto;
            padding: 20px;
            border-bottom: 1px solid #ccc;
        }

        .message {
            margin-bottom: 15px;
            max-width: 70%;
            padding: 10px 15px;
            border-radius: 20px;
            clear: both;
        }

        .sender {
            background-color: #10b981;
            color: white;
            float: right;
            text-align: right;
        }

        .receiver {
            background-color: #f3f4f6;
            color: #333;
            float: left;
            text-align: left;
        }

        form {
            padding: 15px;
            background: #f9fafb;
            display: flex;
            gap: 10px;
        }

        input[type="text"] {
            flex-grow: 1;
            padding: 10px;
            font-size: 16px;
            border-radius: 20px;
            border: 1px solid #ccc;
        }

        button {
            padding: 0 20px;
            background-color: #10b981;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #059669;
        }

    </style>
</head>
<body>

<div class="chat-container">

    <div class="messages" id="chatMessages">
        <%
            if (messages != null && !messages.isEmpty()) {
                for (Message msg : messages) {
                    boolean isSender = sender.equals(msg.getSender());
        %>
                    <div class="message <%= isSender ? "sender" : "receiver" %>">
                        <strong><%= msg.getSender() %>:</strong> <%= msg.getContent() %><br>
                        <small><%= msg.getTimestamp() %></small>
                    </div>
        <%
                }
            } else {
        %>
            <p>No messages yet.</p>
        <%
            }
        %>
    </div>

    <form action="sendMessage" method="post">
        <input type="hidden" name="sender" value="<%= sender %>">
        <input type="hidden" name="receiver" value="<%= receiver %>">
        <input type="text" name="content" placeholder="Type your message..." autocomplete="off" required>
        <button type="submit">Send</button>
    </form>

</div>

<script>
    // Auto scroll to bottom of messages
    const messagesDiv = document.getElementById('chatMessages');
    messagesDiv.scrollTop = messagesDiv.scrollHeight;
</script>

</body>
</html>