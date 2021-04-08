package com.cg.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entites.Feedback;



@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

	@Query("Select f from Feedback f where f.trainer.employeeId=?1")
	List<Feedback> findbyTrainerId(int id);
	
	@Query("Select f from Feedback f where f.program.programId=?1")
	List<Feedback> findbyProgramId(String id);
	

}
