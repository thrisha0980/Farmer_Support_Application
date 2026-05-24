package com.farmersupport.app.web;

import com.farmersupport.app.dao.FertilizerDao;
import com.farmersupport.app.model.FertilizerSuggestion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/suggestion")
public class SuggestionServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FertilizerDao fertilizerDao;

    @Override
    public void init() {
        fertilizerDao = new FertilizerDao(); // Uses JDBC
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String crop = request.getParameter("crop");
        String soilType = request.getParameter("soilType");
        String landSizeStr = request.getParameter("landSize");

        double landSize = 0.0;
        try {
            landSize = Double.parseDouble(landSizeStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", "Invalid land size value.");
            request.getRequestDispatcher("view/fertilizer-suggestion.jsp").forward(request, response);
            return;
        }

        List<FertilizerSuggestion> suggestions = fertilizerDao.getSuggestions(crop, soilType, landSize);

        request.setAttribute("suggestions", suggestions);
        request.setAttribute("crop", crop);
        request.setAttribute("soilType", soilType);
        request.setAttribute("landSize", landSize);

        request.getRequestDispatcher("view/fertilizer-suggestion.jsp").forward(request, response);
    }
}
