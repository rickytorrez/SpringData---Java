package com.project.Lookify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Lookify.models.*;
import com.project.Lookify.repositories.*;

@Service
public class LookifyService {
	private LookifyRepo lookifyRepo;
		
	public LookifyService(LookifyRepo lookifyRepo){
		this.lookifyRepo = lookifyRepo;
	}

	//Shit that connects JAVA to MySQL

	public void create(Lookify lookify){
		lookifyRepo.save(lookify);
	}
	
	public void edit(Lookify lookify){
		lookifyRepo.save(lookify);
	}
	
	public void delete(long id){
		lookifyRepo.delete(id);
	}
	

	public ArrayList<Lookify> all(){
		return (ArrayList<Lookify>)lookifyRepo.findAll();
	}

	public Lookify findById(long id){
		return lookifyRepo.findOne(id);
	}

	public List<Lookify> findTopTen() {
		return lookifyRepo.findTop10ByOrderByRatingDesc();
	}
	
	// public ArrayList<Lookify> top10(){
	// 	ArrayList<Lookify> songs = (ArrayList<Lookify>) lookifyRepo.OrderByRatingDesc();

	// 	for (int i =0; i < songs.size(); i++){
	// 		System.out.println(String.valueOf(i));
	// 		if (i >= 7){
	// 			songs.remove(i);
	// 		}
	// 	}
	// 	return songs;
	// }

	public ArrayList<Lookify> findByArtist(String lookify){
		return (ArrayList<Lookify>) lookifyRepo.findByArtistContaining(lookify);
	}

}
