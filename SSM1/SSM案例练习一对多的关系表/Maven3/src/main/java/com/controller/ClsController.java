package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Cls;
import com.service.ClsService;

@Controller
@RequestMapping("/cls")
public class ClsController {

	@Autowired
	private ClsService clsService;
	
	@RequestMapping("/findAllCls")
	public String FindAllCls(Model model) {
		System.out.println("findAllCls");
		List<Cls> findAllCls = clsService.findAllCls();
//		for (Cls cls : findAllCls) {
//			System.out.println(cls);
//		}
		model.addAttribute("clsList", findAllCls);
		return "clsList";
	}
	
	@RequestMapping("/updatePre")
	public String UpdatePre(int cid, Model model) {
		System.out.println("updatePre:"+cid);
		Cls findClsByid = clsService.findClsByid(cid);
		model.addAttribute("cls", findClsByid);
		System.out.println(findClsByid);
		return "clsUpdate";
	}
	
	@RequestMapping("/update")
	public String Update(Cls cls) {
		System.out.println("udpate:"+cls);
		clsService.update(cls);
		return "forward:findAllCls";
	}
	
	@RequestMapping("/delete")
	public String Delete(int cid) {
		System.out.println("delete:"+cid);
		try {	// 当主表中的主键下拥有子数据 删除时会抛出异常！									
			clsService.delete(cid);
		} catch (Exception e) {
			System.out.println("出现异常！！！删除失败");
			return "forward:findAllCls";
		}
		
		return "forward:findAllCls";
	}
}
