package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Newsletter;
import java.util.List;

public interface NewsletterService { 

  List<Newsletter> getAllNewsletter();

Newsletter loadNewsletterById(Integer id );

Newsletter createOrUpdateNewsletter(Newsletter newsletter);

void removeNewsletter(Integer id);

} 
