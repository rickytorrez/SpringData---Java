package com.project.Lookify.repositories;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.Lookify.models.*;

@Repository 												
public interface LookifyRepo extends CrudRepository<Lookify,Long>{
	// public ArrayList<Lookify> OrderByRatingDesc();
	public ArrayList<Lookify> findByArtistContaining(String search);
	List<Lookify> findTop10ByOrderByRatingDesc();
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
