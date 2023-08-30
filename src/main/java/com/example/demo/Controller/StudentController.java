package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StudentService;
import com.example.demo.model.StudentEnitity;

@RestController
public class StudentController {

	@Autowired
	StudentService sser;
	
	@GetMapping("/showstu")
	public List<StudentEnitity> get()
	{
		return sser.showinfo();
	}
	
	@PostMapping("/post")
	public List<StudentEnitity> post(@RequestBody List<StudentEnitity> se)
	{
		return sser.putinfo(se);
	}
	
	@DeleteMapping("/delete")
	public String deleteinf(@RequestBody StudentEnitity se)
	{
		sser.delete(se);
		return "record is deleted";
	}
	
	@GetMapping("/showstu/{id}")
	public Optional<StudentEnitity> getbyid(@PathVariable int id)
	{
		return sser.showbyid(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletebyid(@PathVariable int id)
	{
		sser.deleteid(id);
		return "id : "+id+" is deleted";
	}
	
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<StudentEnitity> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return sser.getbypage(pageno, pagesize);
	}
	@GetMapping("paging/{name}/{pageno}/{pagesize}")
	public List<StudentEnitity> showpageinfosorted(@PathVariable String name,@PathVariable int pageno,@PathVariable int pagesize)
	{
		return sser.getbypagesorted(name,pageno, pagesize);
	}
	
}
