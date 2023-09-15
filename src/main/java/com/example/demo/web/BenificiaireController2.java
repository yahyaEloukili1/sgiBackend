package com.example.demo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.AnnexeRepository;
import com.example.demo.dao.BenificiaireRepository;
import com.example.demo.dao.BenificiaireRepository2;
import com.example.demo.entities.Annexe;
import com.example.demo.entities.Benificiaire;
import com.example.demo.entities.BenificiaireArchive;
import com.example.demo.services.ReportService;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin("*")
@RestController
public class BenificiaireController2 {

	@Autowired
	BenificiaireRepository ficheRepository;
	@Autowired
	BenificiaireRepository2 bennifBenificiaireRepository2;

	@Autowired
	AnnexeRepository annexeRepository;
	@Autowired
	ReportService reportService;
//	@GetMapping("/report/{format}")
//	public String generateReport(@PathVariable String format) throws JRException, IOException  {
//		return reportService.exportReport(format);
//	}c
	
	
	@GetMapping("/all2")
	public List<BenificiaireArchive> getAllBenificiaires(){
		return bennifBenificiaireRepository2.findAll();
	}
	
	
	@GetMapping("/doublons2")
	public List<BenificiaireArchive> getBenificiairesGroupedByCin() {
	    List<BenificiaireArchive> benificiaires = bennifBenificiaireRepository2.findAll();
	    Map<String, List<BenificiaireArchive>> groupedByCin = benificiaires.stream()
		        .collect(Collectors.groupingBy(BenificiaireArchive::getCin));



	    return groupedByCin.values().stream()
	        .filter(list -> list.size() > 1)
	        .flatMap(List::stream)
	        .collect(Collectors.toList());
	}



	 
}