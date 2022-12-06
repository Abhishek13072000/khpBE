package com.TeslaCoil196.Final_v2.Controller_rest;

import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.TeslaCoil196.Final_v2.Entities.Candidate;
import com.TeslaCoil196.Final_v2.Entities.FileDB;
import com.TeslaCoil196.Final_v2.ForFileDB.ResponseFile;
import com.TeslaCoil196.Final_v2.ForFileDB.ResponseMessage;
import com.TeslaCoil196.Final_v2.Repos.Candidate_repo;
import com.TeslaCoil196.Final_v2.Servie_service.FileDB_service;

@Controller
@RequestMapping("/Candidate/files")
@CrossOrigin("http://localhost:4200/")
//@CrossOrigin("http://localhost:8081")
public class FileDB_Controller {

	@Autowired
	FileDB_service storageService;
	
	@Autowired
	Candidate_repo cddf; 
	
	
	
	@PostMapping("/{wgsid}/uploads")
	public ResponseEntity<ResponseMessage> filefile(@RequestParam("file") MultipartFile file,@PathVariable("wgsid")String wgsid){
		String tempp="";
		try {
			storageService.store__1(file, wgsid);
			tempp = "Uploaded file successfully :"+file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(tempp));
		}catch (Exception e) {
			tempp = "Could not upload file :"+file.getOriginalFilename() +"!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(tempp));
			
		}
		
	}
	

	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	



	
	
	@GetMapping("one_file/{id}")
	public ResponseEntity<ResponseFile> get_one_File(@PathVariable("id")String id) {
		System.out.println("Url hit ");
		
		FileDB getfile = storageService.getfile(id);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(id)
				.toUriString();
		System.out.println("In middle");
		ResponseFile rrr = new ResponseFile(getfile.getName(), fileDownloadUri , getfile.getType(), getfile.getData().length);
		System.out.println("Done");
		return  ResponseEntity.status(HttpStatus.OK).body(rrr);
	}
	

	@GetMapping("/files/{wgsid}")
	public ResponseEntity<byte[]> getFile(@PathVariable("wgsid") String wgsid) {
		
		
		
		Iterator<FileDB> iterator = cddf.findById(wgsid).get().getFiledb().iterator();
		
		FileDB fileDB2 = iterator.next();
		String id = fileDB2.getId();
		
		FileDB fileDB = storageService.getfile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}
	
}
