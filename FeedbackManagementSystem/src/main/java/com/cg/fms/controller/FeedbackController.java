package com.cg.fms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entites.Feedback;
import com.cg.fms.exception.ProgramNotFoundException;
import com.cg.fms.exception.TrainerNotFoundException;
import com.cg.fms.service.FeedbackService;


@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("")
	
	public ResponseEntity<?> createNewFeedback(@Valid @RequestBody Feedback feedback,BindingResult result){
		if(result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError fieldError : result.getFieldErrors()) {
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
				
			}
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
	}
		Feedback feed = feedbackService.saveOrUpdate(feedback);
		return new ResponseEntity<Feedback>(feed, HttpStatus.OK);
	}
	@GetMapping("/all")
	public List<Feedback> getAllFeedbacks(){
		List<Feedback> list=new ArrayList<>();
		Iterable<Feedback> it=feedbackService.getAllFeedbacks();
		for(Feedback i:it)
			list.add(i);
		return list;
	}
	@GetMapping("/list/trainerid/{id}")
	public List<Feedback> viewAllFbbyTrainerId(@PathVariable String id) throws TrainerNotFoundException
	{
		int i=Integer.parseInt(id);
		return feedbackService.viewFeedbackbyTrainerId(i);
	}
	@GetMapping("/list/programid/{id}")
	public List<Feedback> viewAllFbbyProgramId(@PathVariable String id) throws ProgramNotFoundException
	{
		return feedbackService.viewFeedbackbyProgramId((id));
	}
}

