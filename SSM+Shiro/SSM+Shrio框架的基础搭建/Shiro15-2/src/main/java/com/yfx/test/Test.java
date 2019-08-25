package com.yfx.test;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

//MD5 加密测试
public class Test {

	  public static void main(String[] args) {
	        String password = "321";
	      /*
	         //没有加盐的  加密
	        String encodedPassword = new Md5Hash(password).toString();
	        System.out.println(encodedPassword);
	       */
	        
	        //随机加盐
	        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
	        int times = 2;
	        String algorithmName = "md5";
	         
	        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
	        System.out.println(salt); //1iD3PWgaT6FJOIzPjxx6Yw==      一定要知道加密有加盐的密码中的 加盐是？
	         
	        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ",password,salt,times,encodedPassword);
	        
	    }
}
