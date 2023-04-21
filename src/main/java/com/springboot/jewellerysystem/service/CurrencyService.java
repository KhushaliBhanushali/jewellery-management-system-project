package com.springboot.jewellerysystem.service;

import com.springboot.jewellerysystem.entity.Currency;
import java.util.List;

public interface CurrencyService { 

  List<Currency> getAllCurrency();

Currency loadCurrencyById(Integer id );

Currency createOrUpdateCurrency(Currency currency);

void removeCurrency(Integer id);

} 
