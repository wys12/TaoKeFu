package com.yc.taokefu.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.Educationa;
import com.yc.taokefu.mapper.EducationaMapper;
import com.yc.taokefu.service.EducationaService;
@Service("educationaService")
public class EducationaServiceImpl implements EducationaService{
	@Autowired
	private EducationaMapper educationaMapper;
	
	@Override
	public Integer educationaAdd(Educationa educationa) {
		return educationaMapper.educationaAdd(educationa);
	}
	@Override
	public List<Educationa> educationaFind(Educationa educationa) {
		LogManager.getLogger().debug("educationa === >"+educationa);
		return educationaMapper.educationaFind(educationa);
	}

}
