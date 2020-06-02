package com.examplle.examplespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.examplle.examplespringboot.Repository.CustomerDao;
import com.examplle.examplespringboot.model.Customer;
import com.examplle.examplespringboot.model.course;
import com.examplle.examplespringboot.model.trainer;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/enter")
public class controller {
	Customer repo=null;
	@Autowired
    public CustomerDao dao; 
	@PostMapping(path="/authenticate")
	public String checkGrad(@RequestBody Customer gradLogin)
	{
		List<String> repocheck=dao.checkGrad(gradLogin.emailId,gradLogin.password);
		boolean repoCheck=repocheck.isEmpty();
		if(repoCheck==true)
			return "Invalid Credentials";
		else
			return "Authenticated";
	}
	@PostMapping(path="/add")
	public String addUser(@RequestBody Customer reg) {
		int ans=dao.add(reg.id,reg.username,reg.emailId,reg.password);
		if(ans >= 1){
            return "User Added Successfully";
        }else{
            return "Something went wrong !";
        }
		
	}
	
	@GetMapping(path="/getcourses")
	public List<course> getcourse() {
		
        List<course> cou = dao.getdetails(); 
       
        return cou;
    }
	@GetMapping(path="/gettrainers")
	public List<trainer> gettrainers() {
		
        List<trainer> cou = dao.gettrainer(); 
       
        return cou;
    }
/*	@PostMapping("/login1")
	public String check(@RequestBody Customer grad) {
		repo=dao.check(grad.emailId,grad.password);
		
		if(repo==null)
			return "Invalid";
		else
			return "valid";
		
	}
	@RequestMapping("/login")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Customer login(@RequestParam("emailId") String emailId,@RequestParam("password") String pwd) throws Exception{
        String tempmail=emailId;
        String temppwd=pwd;
        Customer cus = null;
        if(tempmail != null && temppwd != null) {
        	cus=dao.check(tempmail,temppwd);
        }
        	if(cus == null) {
        		throw new Exception("Bad credentials");
     
        	}
        	return cus;
	}
	*/
	/*@RequestMapping("/getusers")
	 @CrossOrigin(origins = "http://localhost:4200")
    public List<Customer> customerInformation() {
	
        List<Customer> customers = dao.getdetails(); 
       
        return customers;
    }
	
	

	@RequestMapping("/getuserid")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Customer getid(@RequestParam("id") int id){
        return dao.getuserid(id);
    }
	
	
	
	
	
	@RequestMapping("/update")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public String updateuser(@RequestParam("id") int id,@RequestParam("username") String username,@RequestParam("emailId") String emailId,@RequestParam("password") String pwd){
        dao.update(id,username,emailId,pwd);
        return "User Updated Successfully";
    }
	@RequestMapping("/login")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Customer login(@RequestParam("emailId") String emailId,@RequestParam("password") String pwd) throws Exception{
        String tempmail=emailId;
        String temppwd=pwd;
        Customer cus = null;
        if(tempmail != null && temppwd != null) {
        	cus=dao.fetchByEmailPwd(tempmail,temppwd);
        }
        	if(cus == null) {
        		throw new Exception("Bad credentials");
     
        	}
        	return cus;
	}
	@RequestMapping("/logi")
	public String check(@RequestBody Customer cust) {
		
		String tempmail=(String)cust.getEmailId();
        String temppwd=(String)cust.getPassword();
        System.out.println(tempmail);
        Customer cus = null;
        if(tempmail != null && temppwd != null) {
        	cus=dao.fetchByEmailPwd(tempmail,temppwd);
        }
        	if(cus == null) {
        		return "Bad credentials";
     
        	}
        	else
        	return "authenticated";
	}
		
	
        
	
	@RequestMapping("/add")
    @ResponseBody
   @CrossOrigin(origins = "http://localhost:4200")
    public String adduser(@RequestParam("id") int id,@RequestParam("username") String username,@RequestParam("emailId") String emailId,@RequestParam("password") String pwd){
        if(dao.add(id,username,emailId,pwd) >= 1){
            return "User Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
	
	
	
	
	@RequestMapping("/delete")
    @ResponseBody
    public String deteteuser(@RequestParam("id") int id){
        if(dao.delete(id) >= 1){
            return "User Deleted Successfully";
        }else{
            return "Something went wrong !";
      
        }
        */
    }
	

	
	
	
	
	
	 
	

