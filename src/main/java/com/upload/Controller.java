package com.upload;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/upload")
	public String upload() {
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	@ResponseBody
	public String form(@RequestParam("file") MultipartFile file) {
		
		String filePath = "d:/upload/" + file.getOriginalFilename();
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(file.getOriginalFilename());
		return "success";
	}
}
