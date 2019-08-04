package yfx.myexception;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandlesException{

	
	 @ExceptionHandler
	    public ModelAndView handlerArithmeticException(Exception e){
	        System.out.println("---->出异常了："+ e);
	        ModelAndView mv = new ModelAndView();
	        // 根据不同错误转向不同页面，即异常与view的对应关系
            if(e instanceof ArithmeticException) {
            	  mv.setViewName("error");
             	  mv.addObject("exception",e);
            }else if (e instanceof SQLException) {
	          	  mv.setViewName("error");
	          	  mv.addObject("exception",e);
            }else if (e instanceof NullPointerException) {
				 mv.setViewName("error");
				 mv.addObject("exception",e);
			} 
	        return mv;
	    }
}
//NullPointerException         ArithmeticException