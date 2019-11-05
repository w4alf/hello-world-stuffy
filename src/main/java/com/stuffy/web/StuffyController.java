package com.stuffy.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.stuffy.business.Stuffy;
import com.stuffy.db.StuffyRepository;

@CrossOrigin
@RestController
@RequestMapping("/stuffies")

public class StuffyController {

	@Autowired
	private StuffyRepository stuffyRepo;
	
	
	//list - Return all Stuffies
	@GetMapping("/")
	public JsonResponse listStuffies() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(stuffyRepo.findAll());
		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		
		return jr;
	}

	
	//get - return one stuffy for a give naid
	@GetMapping("/{id}")
	public JsonResponse get(@PathVariable int id) {
		JsonResponse jr = null;
		try {
		jr = JsonResponse.getInstance(stuffyRepo.findById(id));
		}catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	
	//Add - Adds a new stuffy
	@PostMapping("/")
	public JsonResponse addStuffy(@RequestBody Stuffy s) {
		JsonResponse jr = null;
		
		try {
			jr = JsonResponse.getInstance(stuffyRepo.save(s));
			}catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
		
	}
	
	
	//Update - update a new stuffy
	@PutMapping("/")
	public JsonResponse updateStuffy(@RequestBody Stuffy s) {
		JsonResponse jr = null;
		//update a stuffy
		
		try {
			if (stuffyRepo.existsById(s.getId())) {
				jr = JsonResponse.getInstance(stuffyRepo.save(s));
			} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error updating stuffy. id: " + s.getId() + "doesn't exist.");
			}
			
			}catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
		
	}
		
	
	
	
	//Delete - delete a stuffy
	@DeleteMapping("/{id}")
	public JsonResponse deleteStuffy(@PathVariable int id) {
		JsonResponse jr = null;
		
		try {
			if (stuffyRepo.existsById(id)) {
				stuffyRepo .deleteById(id);
				
				jr = JsonResponse.getInstance("Delete Successful!");
				
			} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error deleting stuffy. id: " + id + "doesn't exist.");
			}
			
			}catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
			return jr;
	}
	
	
	
	//demo of request parameters
	// http://localhost:8080/stuffies/?id=10&type=fish&color=pink&size=small&limbs=0
//	@GetMapping("")
//	public Stuffy createAStuffy(@RequestParam int id, @RequestParam String type, @RequestParam String color, @RequestParam String size, @RequestParam int limbs) {
//		
//		Stuffy s = new Stuffy(id,type,color,size,limbs);
//				return s;
//	}
	
}
	
	

