package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.UserDAO; 
import com.springboot.jewellerysystem.entity.User; 
import com.springboot.jewellerysystem.service.UserService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService { 

@Autowired
 private UserDAO userDao;


 
 @Override 
    public List<User> getAllUser() { 
        return userDao.findAll(); 
    } 

@Override 
  public User loadUserById(Integer id) {
 return userDao.findById(id).orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " Not Found"));
 }

@Override 
    public User createOrUpdateUser(User user) {
return userDao.save(user);
   }

  @Override
 	    public void removeUser(Integer id) {
 	        userDao.deleteById(id);
 	    }

}
