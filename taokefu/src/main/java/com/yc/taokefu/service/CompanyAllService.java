package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Job;

public interface CompanyAllService {

	List<CompanyAll> findCompenyName(String string);

	List<CompanyAll> findJobName(String string);


}
