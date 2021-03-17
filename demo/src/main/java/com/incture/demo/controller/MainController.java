package com.incture.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.incture.demo.Service.StudentService;
import com.incture.demo.dto.ResponseDto;
import com.incture.demo.entity.Student;

@Controller
@RequestMapping("/incture")
public class MainController {

	@Autowired
	StudentService stdservice;

	ResponseDto rdto = new ResponseDto();

	@GetMapping("/testq")
	@ResponseBody
	public ResponseDto methodTest() {

		List<Student> rsE = stdservice.getAllstudents();

		System.out.println("data " + rsE);
		rdto.setData(rsE);
		return rdto;
	}

	@GetMapping("/testqa")
	@ResponseBody
	public String methodTes2t() {

		return "test";
	}

	@GetMapping("/string")
	@ResponseBody
	public ResponseDto methodTes() {

		List<String> s = new ArrayList<String>();
		s.add("Hello");
		rdto.setData(s);
		return rdto;
	}

	/*@GetMapping("/createxl")
	@ResponseBody
	public String createXl() throws IOException, FileNotFoundException {
		Workbook wb = new HSSFWorkbook();

		// An output stream accepts output b ytes and sends them to sink.
		OutputStream fileOut = new FileOutputStream(new File("d:/sjeet.xlsx"));
		
		Sheet sheet1= wb.createSheet("Students");
		Sheet sheet2= wb.createSheet("employees");
		
		wb.write(fileOut);
		fileOut.close();

		System.out.println("Sheets Has been Created successfully");

		return "Created Successfully";

	}*/
	
	/*@GetMapping("/readxl")
	@ResponseBody
	public String readXl() throws IOException, FileNotFoundException, InvalidFormatException {
		FileInputStream file = new FileInputStream(new File("D:/Mulesoft Migration/demo/sjeet.xlsx"));
		
		//OPCPackage pkg=OPCPackage.open(new File("D:/Mulesoft Migration/demo/sjeet.xlsx"));
		DataFormatter dataFormatter = new DataFormatter();
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		Sheet sheet=workbook.getSheetAt(0);
		for(int i=1;i<=sheet.getLastRowNum();i++){
			Row row=sheet.getRow(i);
			System.out.println(dataFormatter.formatCellValue(row.getCell(0)));
			System.out.println(dataFormatter.formatCellValue(row.getCell(1)));
		}
		workbook.close();
		return "Successfully Read";
	}
*/
	
}
