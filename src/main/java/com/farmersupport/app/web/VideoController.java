package com.farmersupport.app.web;

import com.farmersupport.app.dao.VideoDao;
import com.farmersupport.app.model.Video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/video")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,    // 2MB
    maxFileSize = 1024 * 1024 * 10,         // 10MB
    maxRequestSize = 1024 * 1024 * 50       // 50MB
)
public class VideoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VideoDao videoDao;
    private final String UPLOAD_DIR = "uploads";

    @Override
    public void init() throws ServletException {
        videoDao = new VideoDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Video> videos = videoDao.getAllVideos();
        request.setAttribute("videos", videos);
        request.getRequestDispatcher("/view/view-videos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String language = request.getParameter("language");
        String description = request.getParameter("description");
        String uploadedBy = request.getParameter("uploadedBy");

        // Get the uploaded file
        Part filePart = request.getPart("videoFile");
        String fileName = getFileName(filePart);

        // Define path to store file
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // Save video info to DB
        Video video = new Video();
        video.setTitle(title);
        video.setLanguage(language);
        video.setDescription(description);
        video.setFilePath(UPLOAD_DIR + "/" + fileName);
        video.setUploadedBy(uploadedBy);
        video.setUploadDate(new Date());

        videoDao.addVideo(video);

        // Redirect to view page
        response.sendRedirect("video");
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return "";
    }
}
