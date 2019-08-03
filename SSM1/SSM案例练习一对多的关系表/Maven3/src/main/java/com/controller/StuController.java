package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Cls;
import com.model.Stu;
import com.service.ClsService;
import com.service.StuService;

@Controller
@RequestMapping("/stu")
public class StuController {

	@Autowired
	private StuService stuService;
	@Autowired
	private ClsService clsService;
	
	@RequestMapping("/findAll")
	public String FindAll(Model model) {
		System.out.println("findAll......");
		List<Stu> findAllStu = stuService.findAllStu();
		for (Stu stu : findAllStu) {
			System.out.println(stu);
		}
		model.addAttribute("stuList", findAllStu);
		return "stuList";
	}
	
	@RequestMapping("/updatePre")
	public String UpdatePre(int sid, Model model) {
		System.out.println("updatePre:"+sid);
		Stu findAllByid = stuService.findAllByid(sid);
		System.out.println(findAllByid);
		model.addAttribute("stu", findAllByid);
		
		//查询所有的班级
		List<Cls> findAllCls = clsService.findAllCls();
		for (Cls cls : findAllCls) {
			System.out.println(cls);
		}
		model.addAttribute("clsList", findAllCls);
		return "stuUpdate";
	}
	
	@RequestMapping("/update")
	public String Update(Stu stu) {
		System.out.println("update:"+stu);
		stuService.update(stu);
		
		return "forward:findAll";
	}
	
	@RequestMapping("/delete")
	public String Delete(int sid) {
		stuService.delete(sid);
		
		return "forward:findAll";
	}
}
