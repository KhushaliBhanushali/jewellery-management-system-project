package com.springboot.jewellerysystem.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.jewellerysystem.dao.StateDAO; 
import com.springboot.jewellerysystem.entity.State; 
import com.springboot.jewellerysystem.service.StateService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StateServiceImpl implements StateService { 

@Autowired
 private StateDAO stateDao;
 
 @Override 
    public List<State> getAllState() { 
        return stateDao.findAll(); 
    } 

@Override 
  public State loadStateById(Integer id) {
 return stateDao.findById(id).orElseThrow(() -> new EntityNotFoundException("State with ID " + id + " Not Found"));
 }

@Override 
    public State createOrUpdateState(State state) {
return stateDao.save(state);
   }

  @Override
 	    public void removeState(Integer id) {
 	        stateDao.deleteById(id);
 	    }

}
