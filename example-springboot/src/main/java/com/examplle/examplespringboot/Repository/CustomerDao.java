package com.examplle.examplespringboot.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.examplle.examplespringboot.CustomerRowMapper;
import com.examplle.examplespringboot.model.Customer;
import com.examplle.examplespringboot.model.course;
import com.examplle.examplespringboot.model.trainer;




@Repository
public class CustomerDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	private static final String SQL = "select * from login;";
	
	
	
	 public List<course> getdetails() {
		 String query = "select * from course;";
        List<course> customers = new ArrayList<course>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) 
        {
        	course customer = new course();
             
             customer.setC_name((String)row.get("c_name"));
             customer.setId((Integer)row.get("id"));
             customer.setTrainer_id((Integer)row.get("trainer_id"));
             
             
            
             
             
             customers.add(customer);
         }

       return customers;
   }
	 public List<trainer> gettrainer() {
		 String query = "select * from trainer;";
	        List<trainer> customers = new ArrayList<trainer>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	trainer customer = new trainer();
	             
	             customer.setT_name((String)row.get("t_name"));
	             customer.setId((Integer)row.get("id"));
	             customer.setCourse_name((String)row.get("course_name"));
	             customer.setMail_id((String)row.get("mail_id"));
	             customer.setCon_num((Integer)row.get("con_num"));
	             
	             
	            
	             
	             
	             customers.add(customer);
	         }

	       return customers;
		}
		 
	
	/*
	 public Customer getuserid(int id) {
	      String SQL = "select * from login where id = ?";
	      Customer user = jdbcTemplate.queryForObject(
	         SQL, new Object[]{id}, new CustomerRowMapper());
	      
	      return user;
	   }
	
	public void update(int id, String username,String emailId,String password){
	      String SQL = "update login set username = ?,emailId = ?,password = ? where id = ?";
	      jdbcTemplate.update(SQL, username,emailId,password,id);
	      
	   }
	
	public int add(int id,String username,String emailId,String password){
        String query = "insert into login values(?,?,?,?);";
        return jdbcTemplate.update(query,id,username,emailId,password);
    }
	
	public int delete(int id){
        String query = "delete from login where id=?;";
        return jdbcTemplate.update(query,id);
    }
	public String fetchByEmailId(String email) {
		String query="select username from login where emailId=?;";  
		String username = (String) jdbcTemplate.queryForObject(
	            query, new Object[] {email }, String.class);

	    return username;
	}
	public Customer check(String email,String pwd) {
		String SQL = "select * from login where emailId = ? && password = ?;";
	      Customer user = jdbcTemplate.queryForObject(
	         SQL, new Object[]{email,pwd}, new CustomerRowMapper());
	      
	      return user;
	}*/
	public List<String> checkGrad(String new_email, String new_password) {
		// TODO Auto-generated method stub
		List<String> gradList=new ArrayList<>();
		System.out.println("select email from login where email='"+new_email+"' and password='"+new_password+"'");
		gradList.addAll(jdbcTemplate.queryForList("select emailId from login where emailId='"+new_email+"' and password='"+new_password+"'",String.class));
		return gradList;
	}
	/*public List<String> check(String emailId,String password){
		String SQL = "select * from login where emailId = ? && password = ?;";
		List<String> g=new ArrayList<>();
		g.addAll(jdbcTemplate.queryForList(SQL);
		
	}*/


	public int add(int id,String username,String emailId,String password){
        String query = "insert into login values(?,?,?,?);";
        return jdbcTemplate.update(query,id,username,emailId,password);
    }

	
	 	}	
	

