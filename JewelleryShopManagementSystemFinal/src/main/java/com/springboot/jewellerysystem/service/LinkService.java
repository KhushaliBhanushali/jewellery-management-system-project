package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Link;
import java.util.List;

public interface LinkService { 

  List<Link> getAllLink();

Link loadLinkById(Integer id );

Link createOrUpdateLink(Link link);

void removeLink(Integer id);

} 
