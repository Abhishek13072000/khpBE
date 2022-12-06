package com.TeslaCoil196.Final_v2.Servie_service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.TeslaCoil196.Final_v2.Entities.FileDB;
import com.TeslaCoil196.Final_v2.payload.File_dto;

public interface FileDB_service {
	
	
	File_dto store__1(MultipartFile file,String Candidate_wgsid ) throws IOException;
	
	File_dto store(File_dto file_dto,String Candidate_wgsid) throws IOException;
	
	FileDB getfile(String id);
	
	Stream<FileDB> getAllFiles();

}
