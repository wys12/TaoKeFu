package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Educationa;

public interface EducationaService {

	Integer educationaAdd(Educationa educationa);

	List<Educationa> educationaFind(Educationa educationa);

}
