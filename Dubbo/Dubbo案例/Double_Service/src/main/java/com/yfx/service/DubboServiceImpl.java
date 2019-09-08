package com.yfx.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class DubboServiceImpl implements DubboService {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "zhangSan";
	}

}
