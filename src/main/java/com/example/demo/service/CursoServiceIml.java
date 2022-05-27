package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ICursoDao;
import com.example.demo.entity.Curso;

@Service
public class CursoServiceIml implements ICursoService{
	
	@Autowired
	private ICursoDao cursoDao; 
	
	@Override
	@Transactional(readOnly=true)
	public List<Curso> findAll() {
		return ( List<Curso> ) cursoDao.findAll();
	}

	@Override
	@Transactional
	public void saveCurso(Curso curso) {
		cursoDao.save(curso);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Curso> getCursosProfesor(Long id) {
		// TODO Auto-generated method stub
		return ( List<Curso> ) cursoDao.findByprofesorId(id);
	}

}
