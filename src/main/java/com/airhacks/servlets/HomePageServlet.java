package com.airhacks.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.airhacks.beans.HelloWorld;
import com.airhacks.utils.HandleBarsRender;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ServletContextTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;


public class HomePageServlet extends HttpServlet{
	@Inject
	private HelloWorld helloWorld;
	@Inject
	private HandleBarsRender handleRender;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		ServletContext servletContext = getServletContext();
		//req.setAttribute("message", helloWorld.sayHelloWorld());
//		TemplateLoader loader = new ServletContextTemplateLoader(servletContext,"/",".html");
//		
//		logger.info("Theinfo about context servlet " + servletContext.getContextPath());
//		
//		Handlebars handlebars = new Handlebars(loader);
//		
		Template template = handleRender.handleBarsRenderFile("index", servletContext);
		logger.info("Theinfo about template " + template.filename());
		Map<String, String> parameterMap = new HashMap<>();
	    parameterMap.put("message", "Implementing a HandleBars Template");
	
		String templateString = template.apply(parameterMap);
		logger.info("About something " + templateString);
		resp.setContentType("text/html");
		resp.getWriter().write(templateString);
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("index.html");
//		dispatcher.forward(req, resp);
	}
}
