package yfx.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {

	@RequestMapping("/uploadFile")
	public String upLoadFile(MultipartFile myfile, String describe, HttpServletRequest request) {
		System.out.println("进入上传文件后台。。。。。。。");
		System.out.println(myfile+"------"+describe);
		
		
		 String realpath = request.getServletContext()
                 .getRealPath("/uploadfiles");          //使用Maven Tomcat7插件运行的项目，文件会存在webapp下！！！！
         String fileName = myfile.getOriginalFilename();
         System.out.println(fileName);
         File targetFile = new File(realpath, fileName);
         if (!targetFile.exists()) {
             targetFile.mkdirs();
         }
         // 上传
         try {
        	 myfile.transferTo(targetFile);
        	 HttpSession session = request.getSession();
        	 session.setAttribute("fileName", fileName);
        	 session.setAttribute("describe", describe);
            System.out.println("success");
         } catch (Exception e) {
             e.printStackTrace();
         }
         
		/* 自定义存放上传文件的路径：
		  String realpath = request.getServletContext()
                 .getRealPath("/uploadfiles");          
         String fileName = myfile.getOriginalFilename();
         System.out.println(fileName);
         File targetFile = new File(realpath, fileName);
         if (!targetFile.exists()) {
             targetFile.mkdirs();
         }
         // 上传
         try {
        	 //自定义存放上传文件的位置， 此处就放在F:/uploadfiles/路径下
        	 myfile.transferTo(new File("F:\\uploadfiles"+File.separator+myfile.getOriginalFilename()));	
    		 System.out.println("F:\\uploadfiles"+File.separator+myfile.getOriginalFilename());
        	 HttpSession session = request.getSession();
        	 session.setAttribute("fileName", fileName);
        	 session.setAttribute("describe", describe);
            System.out.println("success");
         } catch (Exception e) {
             e.printStackTrace();
         }
		 * */
		return "yes";
	}
}

/*
 
 */

