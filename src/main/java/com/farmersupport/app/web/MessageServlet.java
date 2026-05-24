package com.farmersupport.app.web;

import com.farmersupport.app.dao.MessageDao;
import com.farmersupport.app.model.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/chat")
public class MessageServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageDao messageDao;

    @Override
    public void init() throws ServletException {
        messageDao = new MessageDao();
    }

    // 📨 Handle sending messages
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        String content = request.getParameter("content");

        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setTimestamp(new Date());

        boolean success = messageDao.sendMessage(message);

        if (success) {
            // ✅ Redirect back to chat view with both usernames preserved
            response.sendRedirect("chat.jsp?sender=" + sender + "&receiver=" + receiver);
        } else {
            request.setAttribute("error", "Failed to send message.");
            request.getRequestDispatcher("view/chat.jsp").forward(request, response);
        }
    }

    // 📩 Handle viewing chat messages
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");

        if (sender != null && receiver != null) {
            List<Message> messages = messageDao.getMessagesBetweenUsers(sender, receiver);
            request.setAttribute("messages", messages);
            request.setAttribute("sender", sender);
            request.setAttribute("receiver", receiver);
        }

        request.getRequestDispatcher("view/chat.jsp").forward(request, response);
    }
}
