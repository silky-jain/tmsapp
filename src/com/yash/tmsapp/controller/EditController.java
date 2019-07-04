package com.yash.tmsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainingService trainingService = new TrainingServiceImpl();
		Training training = new Training();
		HttpSession session = request.getSession();
		training.setId(Integer.parseInt(request.getParameter("id")));
		training.setUser((User) session.getAttribute("loggedInUser"));
		training.setTitle(request.getParameter("title"));
		training.setObjective(request.getParameter("objective"));
		training.setCourse(request.getParameter("course"));
		String mode = request.getParameter("mode");
		if (mode.equals("2")) {
			training.setMode(trainingService.MODE_ONLINE);
		}
		else {
			training.setMode(trainingService.MODE_CLASSROOM);
			
		}
		training.setBatchsize(Integer.parseInt(request.getParameter("batchsize")));
		training.setExpectation(request.getParameter("expectation"));
		training.setDuration(Integer.parseInt(request.getParameter("duration")));
		trainingService.edit(training);
		response.sendRedirect("User-Dashboard.jsp?msg=Training Updated Successfully");
	}

	}


