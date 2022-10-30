package com.jeffs.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffs.dojosAndNinjas.models.Ninja;
import com.jeffs.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public List<Ninja> findAllNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}

}
