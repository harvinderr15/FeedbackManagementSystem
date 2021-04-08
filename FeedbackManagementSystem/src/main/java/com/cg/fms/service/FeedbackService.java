package com.cg.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entites.Feedback;
import com.cg.fms.repository.FeedbackRepository;



@Service
public class FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public Feedback saveOrUpdate(Feedback feedback) {
		//TODO;
		return feedbackRepository.save(feedback);
		
	}
	public Iterable<Feedback> getAllFeedbacks(){
		return feedbackRepository.findAll();
	}

}
