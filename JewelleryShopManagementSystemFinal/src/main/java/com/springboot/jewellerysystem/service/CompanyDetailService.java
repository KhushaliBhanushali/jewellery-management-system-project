package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.CompanyDetail;
import java.util.List;

public interface CompanyDetailService { 

  List<CompanyDetail> getAllCompanyDetail();

CompanyDetail loadCompanyDetailById(Integer id );

CompanyDetail createOrUpdateCompanyDetail(CompanyDetail companyDetail);

void removeCompanyDetail(Integer id);

} 
