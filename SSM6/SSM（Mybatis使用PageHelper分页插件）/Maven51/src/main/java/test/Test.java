package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		System.out.println("adsf");
		System.out.println(MyDate.dateString(new Date()));
	}
}

class MyDate{
	public static String dateString(Date date) {
		System.out.println(date);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
}