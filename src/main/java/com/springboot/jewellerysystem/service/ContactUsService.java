package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.ContactUs;
import java.util.List;

public interface ContactUsService {

	List<ContactUs> getAllContactUs();

	ContactUs loadContactUsById(Integer id);

	ContactUs createOrUpdateContactUs(ContactUs contactUs);

	void removeContactUs(Integer id);

}
