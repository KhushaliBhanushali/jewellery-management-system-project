package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Faq;
import java.util.List;

public interface FaqService { 

  List<Faq> getAllFaq();

Faq loadFaqById(Integer id );

Faq createOrUpdateFaq(Faq faq);

void removeFaq(Integer id);

} 
