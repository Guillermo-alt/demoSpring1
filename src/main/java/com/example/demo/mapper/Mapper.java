package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Profesor;
import com.example.demo.model.Mprofesor;

@Component("mapper")
public class Mapper {
	
	public static List<Mprofesor> convertirLista(List<Profesor> profesores){
		List <Mprofesor> mProfesores = new ArrayList<>();
		for (Profesor profesor : profesores) {
			mProfesores.add(new Mprofesor(profesor));
			
		}
		
		return mProfesores;
		
	}
}
