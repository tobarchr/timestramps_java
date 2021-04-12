package com.codingdojo.ct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootApplication
@Controller

public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}

		    @RequestMapping("/")
		    public String index() {
		        return "index.jsp";
		    }
		    
		    @RequestMapping("/time")
		    public String time(Model model) {
				Date currentDate=new java.util.Date();
				SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
				String stringDate = formatter.format(currentDate);
		    	model.addAttribute("current_time",stringDate);
		        return "time.jsp";
		    }
		    
		    @RequestMapping("/date")
		    public String date(Model model) {
				Date currentDate=new java.util.Date();
				String message = new SimpleDateFormat("EEEE").format(currentDate) + ", the " +
				new SimpleDateFormat("dd").format(currentDate) + " of " + 
				new SimpleDateFormat("MMMM").format(currentDate) + ", " +
				new SimpleDateFormat("YYYY").format(currentDate)
				;
		    	model.addAttribute("message",message);
		        return "date.jsp";
		    }
	}

