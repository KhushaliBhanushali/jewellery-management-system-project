package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Language;
import java.util.List;

public interface LanguageService { 

  List<Language> getAllLanguage();

Language loadLanguageById(Integer id );

Language createOrUpdateLanguage(Language language);

void removeLanguage(Integer id);

} 
