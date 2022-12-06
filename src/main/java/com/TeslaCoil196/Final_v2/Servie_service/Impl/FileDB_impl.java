package com.TeslaCoil196.Final_v2.Servie_service.Impl;

import java.io.IOException;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.TeslaCoil196.Final_v2.Entities.Candidate;
import com.TeslaCoil196.Final_v2.Entities.FileDB;
import com.TeslaCoil196.Final_v2.Repos.Candidate_repo;
import com.TeslaCoil196.Final_v2.Repos.FileDB_repo;
import com.TeslaCoil196.Final_v2.Servie_service.FileDB_service;
import com.TeslaCoil196.Final_v2.payload.File_dto;

@Service
public class FileDB_impl implements FileDB_service {

	@Autowired
	FileDB_repo fro;
	
	@Autowired
	Candidate_repo crro;
	
	@Autowired
	ModelMapper model_mapper;
	
	@Override
	public File_dto store(File_dto fd ,String candidate_wgsid) throws IOException {
		
		
		Candidate ccc = crro.findById(candidate_wgsid).get();
		
		FileDB dd = this.model_mapper.map(fd, FileDB.class);
		
		dd.setCandidate_2(ccc);
		
		FileDB saved_file = fro.save(dd);
		

		return this.model_mapper.map(saved_file, File_dto.class);
	}

	@Override
	public FileDB getfile(String id) {
		
		return fro.findById(id).get();
	}

	@Override
	public Stream<FileDB> getAllFiles() {
		
		return fro.findAll().stream();
	}
	

	@Override
	public File_dto store__1(MultipartFile file,String Candidate_wgsid) throws IOException {
		Candidate candidate = crro.findById(Candidate_wgsid).get();
		System.out.println("candiadte found");
		
		
		String tep_filename = StringUtils.cleanPath(file.getOriginalFilename());
		File_dto filed = new File_dto(tep_filename,file.getContentType(),file.getBytes());
		
		//System.out.println("1. here ----------->");
		FileDB filedb = this.model_mapper.map(filed, FileDB.class);
		
		filedb.setCandidate_2(candidate);
		//System.out.println("2. here --------->");
		
//		System.out.println(filedb.getName());
//		System.out.println(filedb.getType());
//		System.out.println(filedb.getCandidate_2());
//		System.out.println(filedb.getData());
//		
		fro.save(filedb);
		
		System.out.println(" repo saved file ");
		return filed;
	}

}
