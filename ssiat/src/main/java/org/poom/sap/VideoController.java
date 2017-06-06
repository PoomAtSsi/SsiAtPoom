package org.poom.sap;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
 
@Controller
public class VideoController {
	
	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
	
	@RequestMapping(value = "testvideo.do", method = RequestMethod.GET)
	public String testvideo(Locale locale, Model model) {
		logger.info("VideoController testvideo start");
		
		return "testvideo/testvideo1";
	}
	
	
	
	
}
