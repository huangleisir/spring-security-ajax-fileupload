/**
 * 
 */
package org.asn.fileupload;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Abhishek
 * 
 */
@Controller
public class FileUploadController {

	static {
		System.out.println("file upload controller class loaded..");
	}
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;
 
	}
 
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
 
		return model;
 
	}
	
	@RequestMapping(value = "/upload-file", method = RequestMethod.POST)
	public @ResponseBody
	String upload(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("file uploading..");
		// 1. get the files from the request object
		Iterator<String> itr = request.getFileNames();
		if(!itr.hasNext()){
			return "no file,please check and upload file";
		}

		MultipartFile mpf = request.getFile(itr.next());
		System.out.println(mpf.getOriginalFilename() + " uploaded!");

		try {
			// just temporary save file info into ufile
			int length = mpf.getBytes().length;
			byte[] bytes = mpf.getBytes();
			String type = mpf.getContentType();
			String name = mpf.getOriginalFilename();
			System.out.println("name: "+name);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "upload completed,http status="+HttpServletResponse.SC_OK;

	}
	
	@RequestMapping(value = "/postMethod", method = RequestMethod.POST)
	public @ResponseBody
	String postMethod(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("postMethod..");
		
		System.out.println("--------debugging------------");
		// 1. get the files from the request object
		/*Iterator<String> itr = request.getFileNames();

		MultipartFile mpf = request.getFile(itr.next());
		System.out.println(mpf.getOriginalFilename() + " uploaded!");*/

	/*	try {
			// just temporary save file info into ufile
			int length = mpf.getBytes().length;
			byte[] bytes = mpf.getBytes();
			String type = mpf.getContentType();
			String name = mpf.getOriginalFilename();
			System.out.println("name: "+name);

		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		return "postMethod..";

	}
	
	
}
