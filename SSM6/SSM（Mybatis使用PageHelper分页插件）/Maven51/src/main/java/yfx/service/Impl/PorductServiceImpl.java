package yfx.service.Impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yfx.dao.PorductMapper;
import yfx.model.Params;
import yfx.model.Porduct;
import yfx.service.PorductService;

@Service
public class PorductServiceImpl implements PorductService {

	@Autowired
	private PorductMapper porductMapper;
	
	//查询所有数据
	@Override
	public List<Porduct> findPorductAll() {

		return porductMapper.findPorductAll();
	}

	//删除
	@Override
	public void delete(int pid) {

		porductMapper.delete(pid);
	}

	//根据id查询
	@Override
	public Porduct findByid(int pid) {

		return porductMapper.findByid(pid);
	}

	//update
	@Override
	public void update(Porduct porduct) {

		porductMapper.update(porduct);
	}

	@Override
	public void add(Porduct porduct) {

		porductMapper.add(porduct);
	}

//	@Override
//	public PageInfo<Porduct> finds(Params params) {
//		 //查询  
//		 int pageNo = params.getPageNo(); 
//		 int pageSize = params.getPageSize();    
//		 PageHelper.startPage(pageNo, pageSize); 
//		 List<Porduct> blogs = porductMapper.findPorductAll();
//		 //用PageInfo对结果进行包装 
//		 PageInfo<Porduct> pageInfo = new PageInfo<Porduct>(blogs);   
//		 return pageInfo;
//	}

	
	
	

	


}
