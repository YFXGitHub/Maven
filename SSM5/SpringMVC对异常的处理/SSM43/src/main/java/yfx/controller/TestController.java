package yfx.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yfx.myexception.HandlesException;

@Controller
public class TestController extends HandlesException{
// 继承定义的HandlesException  实现SpringMVC 对异常的处理 
	
	/*
		定义的局部异常
	 @ExceptionHandler({ArithmeticException.class})
	public ModelAndView handlerArithmeticException(Exception ex){
	    System.out.println("出异常了："+ ex);
	    ModelAndView mv = new ModelAndView("error");
	    mv.addObject("exception",ex);
	    return mv;
	}
	 * */
	
	@RequestMapping("/test1")
	public String Test1(int i) {
		
		int s = 10/i;
		return "yes";
	}

	@RequestMapping("/test2")
	public String Test2() {
		List<String> list = null;
		for (String string : list) {
			System.out.println(string);
		}
		return "yes";
	}
}
