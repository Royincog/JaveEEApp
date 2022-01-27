package com.airhacks.utils;

import java.io.IOException;

import javax.servlet.ServletContext;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ServletContextTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

public class HandleBarsRender {

	public Template handleBarsRenderFile(String fileString,ServletContext servletContext) throws IOException {
		TemplateLoader loader = new ServletContextTemplateLoader(servletContext,"/WEB-INF/templates",".html");
		Handlebars handlebars = new Handlebars(loader);
		Template template = handlebars.compile(fileString);
		return template;
	}
}
