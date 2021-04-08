package com.cg.fms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entites.Feedback;



@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

}
