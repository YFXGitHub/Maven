package yfx.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yfx.model.Params;
import yfx.model.Porduct;
import yfx.service.PorductService;

@Controller
@RequestMapping("/porduct")
public class PorductConroller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PorductService porductService;
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		System.out.println("进入Porduct后台");
		List<Porduct> findPorductAll = porductService.findPorductAll();
		//System.out.println(findPorductAll);
		/*
		  slf4j的日志级别分为五种
		　 info、debug、error、warn、trane     
		  logger.trace("trace..............."); trace 的级别最低且不会输出！ 
		  */
		logger.info("info...............");
		logger.debug("debug...............");
		logger.error("error...............");
		logger.warn("warn................");
		
		for (Porduct porduct : findPorductAll) {
			//porduct.getPdate().substring(0, porduct.getPdate().length()-2);  截取字符串后两位！
			//System.out.println(porduct.getPdate().substring(0, porduct.getPdate().length()-2));
			porduct.setPdate(porduct.getPdate().substring(0, porduct.getPdate().length()-2));
		}
		model.addAttribute("findPorductAll", findPorductAll);
		return "porductList";
	}
	
	@RequestMapping("/updatePre")
	public String updatePre(int pid, Model model) {
		//System.out.println("进入修改："+pid);
		Porduct findByid = porductService.findByid(pid);
		findByid.setPdate(findByid.getPdate().substring(0, findByid.getPdate().length()-2));
		model.addAttribute("porduct", findByid);
		return "porductUpdate";
	}
	
	@RequestMapping("/update")
	public String update(Porduct porduct) {
		//System.out.println(porduct);
		porductService.update(porduct);
		
		return "redirect:findAll";
	}
	
	@RequestMapping("/delete")
	public String delete(int pid) {
		//System.out.println("进入删除："+pid);
		porductService.delete(pid);
		//System.out.println("删除成功！");
		return "redirect:findAll";
	}
	
	@RequestMapping("/add")
	public String add(Porduct porduct) {
		
		System.out.println(porduct);
		porductService.add(porduct);
		return "redirect:findAll";
	}
	
	@RequestMapping("/findPagebean")
	public void toPagebean(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("asdf");
		response.getWriter().write("yes");
	}
	
	@RequestMapping("/findpage")
	public String tofindPage(Params params) {
		System.out.println("进入分页vchajian。。。");
		
        List<Porduct> findPorductAll = porductService.findPorductAll();
        System.out.println(findPorductAll);
        // 第三页 每页5条 此处使用mybatis 的分页插件
        PageHelper.startPage(2, 5); // 从1，开始！ ，
        PageInfo pageInfo = new PageInfo(porductService.findPorductAll());
        List<Porduct> clist =(List<Porduct>) pageInfo.getList();
		for (Porduct porduct : clist) {
			System.out.println(porduct);
		}
		return "pageHandler";
	}
	

}
