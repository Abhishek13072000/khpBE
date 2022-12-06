package com.TeslaCoil196.Final_v2.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TeslaCoil196.Final_v2.Entities.FileDB;

@Repository
public interface FileDB_repo extends JpaRepository<FileDB, String> {

}
