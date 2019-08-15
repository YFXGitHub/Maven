package yfx.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yfx.model.Orderss;
import yfx.model.Porduct;
import yfx.service.OrderssService;
import yfx.service.PorductService;

@Controller
@RequestMapping("/orderss")
public class OrderssController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OrderssService orderssService;
	@Autowired
	private PorductService porductService;
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Orderss> findAll = orderssService.findAll();
		System.out.println(findAll);
		model.addAttribute("orderss", findAll);
	//	logger.info("使用Logger 日志输出： findAll() -----"+findAll());
		return "orderssList";
	}
	
	@RequestMapping("/delete")
	public String delete(int oid) {
		//@RequestParam(defaultValue=1) int id  设置默认值！
		
		System.out.println("进入删除后台。。。。"+oid);
		orderssService.delete(oid);
		System.out.println("删除成功！");
		return "redirect:findAll";
	}

	@RequestMapping("/updatePre")
	public String updatePre(int oid, Model model) {
		System.out.println("进入修改后台。。。。"+oid);
		Orderss findByid = orderssService.findByid(oid);
		System.out.println(findByid);
		model.addAttribute("orderss", findByid);
		List<Porduct> findPorductAll = porductService.findPorductAll();
		model.addAttribute("porduct", findPorductAll);
		
		return "orderssUpdate";
	}
	
	//修改
	@RequestMapping("/update")
	public String update(Orderss orderss) throws ParseException {
		
		orderss.setOtime(new SimpleDateFormat("yyyy-MM-dd").parse(orderss.getOtimeString()));
		orderssService.update(orderss);
		return "redirect:findAll";
	}
}
