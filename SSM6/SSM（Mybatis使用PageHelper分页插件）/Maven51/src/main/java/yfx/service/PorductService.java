package yfx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import yfx.model.Params;
import yfx.model.Porduct;

public interface PorductService {

	//查询所有数据 
		public List<Porduct> findPorductAll();
		//删除
		public void delete(@Param("pid") int pid);
		//根据id查询
		public Porduct findByid(@Param("pid") int pid);
		//update
		public void update(Porduct porduct);
		//add
		public void add(Porduct porduct);
		
		 /**  * 分页查询所有博客  * @param params 分页参数 pageNo（页码），pageSize（每页查询数目）  * @return  */ 
		 //public PageInfo<Porduct> finds(Params params);
}
