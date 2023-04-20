package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.State;
import java.util.List;

public interface StateService { 

  List<State> getAllState();

State loadStateById(Integer id );

State createOrUpdateState(State state);

void removeState(Integer id);

} 
