package test;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {

	private static List<Person> lists = null;
	
	static {
		lists = new ArrayList<Person>();
		lists.add(new Person(1, "里斯", "男", 34, "河南省郑州市"));
		lists.add(new Person(2, "往往", "男", 32, "河南省郑州市"));
		lists.add(new Person(3, "丽丽", "女", 33, "河南省北京市"));
		lists.add(new Person(4, "食物", "男", 32, "河南省洛阳市"));
		lists.add(new Person(5, "红红", "女", 31, "河南省上海市"));
		lists.add(new Person(6, "呵呵", "男", 33, "河南省郑州市"));
	}
	
	public List<Person> getAll(){
		
		return lists;
	}
	
}
