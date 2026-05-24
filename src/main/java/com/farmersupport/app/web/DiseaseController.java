package com.farmersupport.app.web;

import com.farmersupport.app.dao.DiseaseDao;
import com.farmersupport.app.model.Disease;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/disease")
public class DiseaseController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DiseaseDao diseaseDao;

    @Override
    public void init() throws ServletException {
        diseaseDao = new DiseaseDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String symptoms = request.getParameter("symptoms");
        if (symptoms != null && !symptoms.isEmpty()) {
            Disease disease = diseaseDao.getDiseaseBySymptoms(symptoms);
            request.setAttribute("disease", disease);
        } else {
            List<Disease> diseaseList = diseaseDao.getAllDiseases();
            request.setAttribute("diseases", diseaseList);
        }

        request.getRequestDispatcher("/view/disease-result.jsp").forward(request, response);
    }
}
