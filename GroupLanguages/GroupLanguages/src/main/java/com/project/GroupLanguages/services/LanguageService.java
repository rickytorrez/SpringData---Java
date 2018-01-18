package com.project.GroupLanguages.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.GroupLanguages.repositories.*;
import com.project.GroupLanguages.models.*;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
		
	public LanguageService(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}
	

	public void create(Languages language){
		languageRepository.save(language);
	}
	
	public void edit(Languages language){
		languageRepository.save(language);
	}
	
	public void delete(long id){
		languageRepository.delete(id);
	}
	

	public ArrayList<Languages> all(){
		return (ArrayList<Languages>)languageRepository.findAll();
	}

	public Languages findById(long id){
		return languageRepository.findOne(id);
	}
}
