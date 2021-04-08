package com.cg.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.fms.entites.Employee;
@Repository
public interface ITrainerManagementRepository extends JpaRepository<Employee, Integer> {

    
    @Query("SELECT e FROM Employee e WHERE e.skills=?1")
    public List<Employee> viewAllTrainers(String skill);
  

}
