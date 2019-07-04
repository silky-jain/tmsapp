package com.yash.tmsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

/**
 * Servlet implementation class DeleteSelectedController
 */
@WebServlet("/DeleteSelectedController")
public class DeleteSelectedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSelectedController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainingService trainingService=new TrainingServiceImpl();
		String [] checkboxes=request.getParameterValues("select");
		if(checkboxes!=null) {
			int i=0;
			int[] checkboxesInteger= new int[checkboxes.length];
			for (String string : checkboxes) {
				checkboxesInteger[i]=Integer.parseInt(checkboxes[i]);
				i++;
			}
			
			for (int j = 0; j < checkboxesInteger.length; j++) {
				Training training=new Training();
				training.setId(checkboxesInteger[j]);
				trainingService.delete(training);
			}
			
		}
		response.sendRedirect("User-Dashboard.jsp");
	}

}
