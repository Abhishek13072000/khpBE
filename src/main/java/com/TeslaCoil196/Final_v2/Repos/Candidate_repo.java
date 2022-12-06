package com.TeslaCoil196.Final_v2.Repos;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TeslaCoil196.Final_v2.Entities.Candidate;

@Repository
public interface Candidate_repo extends JpaRepository<Candidate, String> {
	/*
	@Modifying
	@Query("update Candidate c set c.status=:new_status where c.wgsid=:iiid")
	public void changeStatus(@Param("new_status") String new_status,@Param("iiid")String iiid);
	*/
	@Transactional
	@Modifying
	@Query("UPDATE Candidate set status=:new_status where wgsid=:cid")
	public void changeStatus(@Param("new_status") String new_status,@Param("cid") String cid);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Candidate set due_date=:new_date where wgsid=:cid")
	public void changeDate____2(@Param("new_date") Date new_status,@Param("cid") String cid);
	
	/////
	//     "Select l from Login l WHERE l.usernmae=:userN and l.password=:pass"
	@Query("SELECT c From Candidate c WHERE c.wgsid=:Namme")
	public List<Candidate> specaial(@Param("Namme") String filer);
	
	
	@Query(value = "Select c from Candidate c WHERE c.wgsid=:val")
	public List<Candidate> FindBywgsid(@Param("val") String input);
	
	@Query(value ="Select c from Candidate c WHERE c.skill=:val")
	public List<Candidate> FindByskill(@Param("val") String input);

	@Query(value ="Select c from Candidate c WHERE c.name=:val")
	public List<Candidate> FindByname(@Param("val") String input);

	@Query(value ="Select c from Candidate c WHERE c.age=:val")
	public List<Candidate> FindByage(@Param("val") String input);
	
	@Query(value ="Select c from Candidate c WHERE c.location=:val")
	public List<Candidate> FindBylocation(@Param("val") String input);
	
	@Query(value ="Select c from Candidate c WHERE c.technology=:val")
	public List<Candidate> FindBytechnology(@Param("val") String input);
	
	
	@Query(value="Select c from Candidate c where month(c.due_date)=:dave")
	public List<Candidate> monthly(@Param("dave") Integer dave);
	

//	@Query(value="Select c from Candidate c where quarter(c.due_date)=:quarter")
//	public List<Candidate> quaterly(@Param("quarter") Integer da);
//	
	
	/////
	
	
}
