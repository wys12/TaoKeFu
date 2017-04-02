package com.yc.taokefu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.taokefu.entity.Educationa;

public interface EducationaMapper {

	Integer educationaAdd(Educationa educationa);

	List<Educationa> educationaFind(Educationa educationa);

}
