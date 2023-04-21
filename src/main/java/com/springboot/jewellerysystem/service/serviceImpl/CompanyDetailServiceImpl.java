package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.CompanyDetailDAO; 
import com.springboot.jewellerysystem.entity.CompanyDetail; 
import com.springboot.jewellerysystem.service.CompanyDetailService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompanyDetailServiceImpl implements CompanyDetailService { 

@Autowired
 private CompanyDetailDAO companyDetailDao;
 
 @Override 
    public List<CompanyDetail> getAllCompanyDetail() { 
        return companyDetailDao.findAll(); 
    } 

@Override 
  public CompanyDetail loadCompanyDetailById(Integer id) {
 return companyDetailDao.findById(id).orElseThrow(() -> new EntityNotFoundException("CompanyDetail with ID " + id + " Not Found"));
 }

@Override 
    public CompanyDetail createOrUpdateCompanyDetail(CompanyDetail companyDetail) {
return companyDetailDao.save(companyDetail);
   }

  @Override
 	    public void removeCompanyDetail(Integer id) {
 	        companyDetailDao.deleteById(id);
 	    }

}
