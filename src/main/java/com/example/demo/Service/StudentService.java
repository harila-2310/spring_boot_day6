package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentEnitity;
import com.example.demo.model.Repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo sr;
	
	public List<StudentEnitity> showinfo()
	{
		return sr.findAll();
	}
	
	public List<StudentEnitity> putinfo(List<StudentEnitity> se)
	{
		return sr.saveAll(se);
	}
	
	public void delete(StudentEnitity se)
	{
		sr.delete(se);
	}
	
	public Optional<StudentEnitity> showbyid(int id)
	{
	       return sr.findById(id);
	}
	
	public void deleteid(int id)
	{
		sr.deleteById(id);
	}
	public List<StudentEnitity> getbypage(int pgno,int pgsize)
	{
		Page<StudentEnitity> p=sr.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
	public List<StudentEnitity> getbypagesorted(String name,int pgno,int pgsize)
	{
		Page<StudentEnitity> pg=sr.findAll(PageRequest.of(pgno, pgsize,Sort.DEFAULT_DIRECTION,name));
		return pg.getContent();
	}
}
