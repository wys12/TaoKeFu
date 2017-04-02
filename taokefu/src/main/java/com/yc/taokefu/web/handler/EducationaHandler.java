package com.yc.taokefu.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.taokefu.entity.Educationa;
import com.yc.taokefu.service.EducationaService;
import com.yc.taokefu.util.ServletUtil;

@Controller("educationaHandler")
@RequestMapping("educationa")
public class EducationaHandler {
	@Autowired
	private EducationaService educationaService;
	
	@RequestMapping("educationaAdd")
	public void educationaAdd(Educationa educationa) {
		educationaService.educationaAdd(educationa);
		ServletUtil.userMap.get("");
	}
}
