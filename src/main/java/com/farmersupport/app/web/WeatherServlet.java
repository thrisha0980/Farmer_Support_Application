package com.farmersupport.app.web;

import com.farmersupport.app.dao.WeatherDao;
import com.farmersupport.app.model.WeatherInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private WeatherDao weatherDao;

    @Override
    public void init() throws ServletException {
        weatherDao = new WeatherDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String location = request.getParameter("location");

        List<WeatherInfo> weatherList = null;

        if (location != null && !location.trim().isEmpty()) {
            weatherList = weatherDao.getWeatherByLocation(location);
        }

        request.setAttribute("weatherList", weatherList);
        request.getRequestDispatcher("/view/weather.jsp").forward(request, response);
    }
}
