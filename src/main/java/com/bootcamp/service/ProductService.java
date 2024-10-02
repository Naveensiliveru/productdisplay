package com.bootcamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.entity.Product;
import com.bootcamp.repo.ProductRepo;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;

@Service
public class ProductService {
	@Autowired
	 ProductRepo  prepo;
	 public  List<Product> findAll(){
		return (List<Product>)prepo.findAll();
		 
	 }
	  public Product findByName(String pname) {
		return prepo.findByPname(pname)
				.orElseThrow(()-> new RuntimeException("Product not Found"));
		  
	  }
	 
	
	   public  Product SaveProduct( Product p) {
		   return prepo.save(p);
	   }
	    
	    public  Product updateProduct(int pid ,Product pr ) {
	    	Product  existing = prepo.findById(pid)
	    			.orElseThrow(()->new RuntimeException("No product avilable"));
	    	
	    	 if(pr.getPname()!=null)
	    		 existing.setPname(pr.getPname());
	    	 if(pr.getPrice()!=null)
	    		 existing.setPrice(pr.getPrice());
	    	 if(pr.getQuantity()!=null)
	    		 existing.setQuantity(pr.getQuantity());
	    	 return   prepo.save(existing);
	    }
	     public String  deleteProduct(int pid) {
	    	 Product  existing = prepo.findById(pid)
		    			.orElseThrow(()->new RuntimeException("No product avilable"+pid));
	    	 prepo.deleteById(pid);
	    	  return "Product Deleted";
	     }
	      
	     

}
