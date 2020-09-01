/**
 * 
 */
package com.flipped.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipped.repository.AppRepository;
import com.flipped.services.AppService;

/**
 * @author zz6unp
 *
 */
@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppRepository repository;
	
	@Override
	public void indexData() {
		repository.indexData();

	}

}
