package com.spe.ClassroomManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spe.ClassroomManagementSystem.Models.ClassTiming;
import com.spe.ClassroomManagementSystem.Models.Classroom;
import com.spe.ClassroomManagementSystem.Models.Internship;

public interface InternshipRepository extends JpaRepository<Internship,Long> {
	
	 List<Internship> findAll();
	 
	 void deleteAll();

}
