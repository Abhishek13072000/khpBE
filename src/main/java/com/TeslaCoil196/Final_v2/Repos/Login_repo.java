package com.TeslaCoil196.Final_v2.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TeslaCoil196.Final_v2.Entities.Login;

@Repository
public interface Login_repo extends JpaRepository<Login,String> {
	
	@Query("Select l from Login l WHERE l.email=:emailid and l.password=:pass")
	public Login getUserByemailAndpassword(@Param("emailid") String emailid, @Param("pass") String pass);

	@Query("Select l from Login l WHERE l.usernmae=:userN and l.password=:pass")
	public Login getUserByusernameAndpassword(@Param("userN") String emailid, @Param("pass") String pass);
	
	public Login findByemail(String emailid);

}
