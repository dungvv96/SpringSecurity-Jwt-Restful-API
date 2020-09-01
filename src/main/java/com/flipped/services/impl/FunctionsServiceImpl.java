/**
 * 
 */
package com.flipped.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flipped.entity.Functions;
import com.flipped.model.FunctionsDTO;
import com.flipped.repository.FunctionsRepository;
import com.flipped.services.FunctionsService;

/**
 * @author zz6unp
 *
 */
@Service
@Transactional
public class FunctionsServiceImpl implements FunctionsService {

	@Autowired
	private FunctionsRepository repository;
	
	@Override
	public void create(FunctionsDTO functionsDTO) {
		Functions function = new Functions();
		function.setId(functionsDTO.getId());
		function.setFunctionCode(functionsDTO.getFunctionCode());
		function.setFunctionName(functionsDTO.getFunctionName());
		function.setLinkApi(functionsDTO.getLinkApi());
		function.setDescriptions(functionsDTO.getDescriptions());
		function.setStatus(functionsDTO.getStatus());
		function.setNumbers(functionsDTO.getNumbers());
		repository.create(function);

	}

	@Override
	public void update(FunctionsDTO functionsDTO) {
		Functions function = repository.findById(functionsDTO.getId());
		function.setFunctionCode(functionsDTO.getFunctionCode());
		function.setFunctionName(functionsDTO.getFunctionName());
		function.setLinkApi(functionsDTO.getLinkApi());
		function.setDescriptions(functionsDTO.getDescriptions());
		function.setStatus(functionsDTO.getStatus());
		function.setNumbers(functionsDTO.getNumbers());
		repository.update(function);

	}

	@Override
	public void delete(Long id) {
		repository.delete(id);

	}

	@Override
	public FunctionsDTO findById(Long id) {
		Functions function = repository.findById(id);
		FunctionsDTO functionsDTO = null;
		if(function != null) {
			functionsDTO = new FunctionsDTO();			
			functionsDTO.setId(function.getId());
			functionsDTO.setFunctionCode(function.getFunctionCode());
			functionsDTO.setFunctionName(function.getFunctionName());
			functionsDTO.setLinkApi(function.getLinkApi());
			functionsDTO.setDescriptions(function.getDescriptions());
			functionsDTO.setStatus(function.getStatus());
			functionsDTO.setNumbers(function.getNumbers());
			/*
			 * ModelMapper modelMapper = new ModelMapper(); functionsDTO =
			 * modelMapper.map(function, FunctionsDTO.class);
			 */
		}		
		return functionsDTO;
	}

	@Override
	public FunctionsDTO findByFunctionCode(String functionCode) {
		Functions function = repository.findByFunctionCode(functionCode);
		FunctionsDTO functionsDTO = null;
		if(function != null) {
			functionsDTO = new FunctionsDTO();
			functionsDTO.setId(function.getId());
			functionsDTO.setFunctionCode(function.getFunctionCode());
			functionsDTO.setFunctionName(function.getFunctionName());
			functionsDTO.setLinkApi(function.getLinkApi());
			functionsDTO.setDescriptions(function.getDescriptions());
			functionsDTO.setStatus(function.getStatus());
			functionsDTO.setNumbers(function.getNumbers());
		}		
		return functionsDTO;
	}

	@Override
	public List<FunctionsDTO> findAll() {
		return null;
	}

	@Override
	public List<FunctionsDTO> find(String keyword) {
		List<Functions> functions = repository.find(keyword);
		List<FunctionsDTO> functionsDTOs = new ArrayList<>();
		if(!functions.isEmpty()) {
			for(Functions function: functions) {
				FunctionsDTO functionsDTO = new FunctionsDTO();
				functionsDTO.setId(function.getId());
				functionsDTO.setFunctionCode(function.getFunctionCode());
				functionsDTO.setFunctionName(function.getFunctionName());
				functionsDTO.setLinkApi(function.getLinkApi());
				functionsDTO.setDescriptions(function.getDescriptions());
				functionsDTO.setStatus(function.getStatus());
				functionsDTO.setNumbers(function.getNumbers());
				functionsDTOs.add(functionsDTO);
			}
		}
		return functionsDTOs;
	}

}
