package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.LinkDAO; 
import com.springboot.jewellerysystem.entity.Link; 
import com.springboot.jewellerysystem.service.LinkService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LinkServiceImpl implements LinkService { 

@Autowired
 private LinkDAO linkDao;
 
 @Override 
    public List<Link> getAllLink() { 
        return linkDao.findAll(); 
    } 

@Override 
  public Link loadLinkById(Integer id) {
 return linkDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Link with ID " + id + " Not Found"));
 }

@Override 
    public Link createOrUpdateLink(Link link) {
return linkDao.save(link);
   }

  @Override
 	    public void removeLink(Integer id) {
 	        linkDao.deleteById(id);
 	    }

}
