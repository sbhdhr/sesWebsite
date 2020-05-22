package ses.proj.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler(Exception.class)
	public String noHandlerFound(Exception e) {
		System.out.println("Error :" + e.getMessage());
		return "index";
	}

}
