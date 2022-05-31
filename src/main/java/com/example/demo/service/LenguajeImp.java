package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ILenguajeDao;
import com.example.demo.entity.Lenguaje;

public class LenguajeImp implements ILenguajeService{
	
	@Autowired
	private ILenguajeDao lenguajeDao;

	@Transactional(readOnly=true)
	public List<Lenguaje> findAll() {
		return (List<Lenguaje>)lenguajeDao.findAll();
	}

	@Override
	@Transactional
	public void saveLenguaje(Lenguaje lenguaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public Lenguaje findLenguajeByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
