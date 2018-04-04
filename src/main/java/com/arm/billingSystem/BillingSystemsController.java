package com.arm.billingSystem;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping ("/billingSystem")
public class BillingSystemsController {
	
	@Autowired
	BillingSystemRepository billingSystems;
	
	@Autowired
	ControllerMethodsInvocationMap controllerMethodsInvocationMap;
	

	
	
	@RequestMapping (method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BillingSystem> getAllBillingSystems() {
		return billingSystems.getAllBillingSystems();
		
	}
	
	
	@RequestMapping (value = "{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BillingSystem getBillingSystemr(@PathVariable("id") Integer id) throws Exception {
		BillingSystem billingSystem = billingSystems.getBillingSystem(id);
		if (billingSystem != null)
			return billingSystem;
		
		throw new Exception("Billing System doesnt exist.");
	}
	
	
	@RequestMapping (value = "{billingId}/{customerId}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer(@PathVariable("billingId") Integer billingId, @PathVariable("customerId") Integer customerId) throws Exception {
		Customer customer = billingSystems.getBillingSystem(billingId).getCustomer(customerId);
		if (customer != null)
			return customer;
		
		throw new Exception("Customer doesn't exist.");
	}
	
	
	@RequestMapping (method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public BillingSystem updateBillingSystem(@RequestBody  BillingSystem billingSystem) throws Exception {
		if (billingSystems.updateBillingSystem(billingSystem) == 0)
			return billingSystem;
		
		throw new Exception("Billing System doesnt exist.");
	}
	
	
	@RequestMapping (value = "/{id}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@PathVariable("id") Integer id, @RequestBody  Customer customer) throws Exception {
		BillingSystem billingSystem = billingSystems.getBillingSystem(id);
		if (billingSystem != null) 
			if (billingSystem.updateCustomer(customer) == 0) {
				return customer;
			} else {
				throw new Exception("Customer doesn't exist.");
			}
		
		throw new Exception("Billing System doesnt exist.");
	}
	
	
	@RequestMapping (method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public BillingSystem addCustomer(@RequestBody  BillingSystem billingSystem) throws Exception {
		if (billingSystems.addBillingSystem(billingSystem) == 0)
			return billingSystem;
		
		throw new Exception("Billing System already exist.");
	}
	
	
	@RequestMapping (value = "/{id}", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Customer addCustomer(@PathVariable("id") Integer id, @RequestBody  Customer customer) throws Exception {
		BillingSystem billingSystem = billingSystems.getBillingSystem(id);
		if (billingSystem != null)
			if (billingSystem.addCustomer(customer) == 0) {
				return customer;
			} else {
				throw new Exception("Customer already exist.");
			}
		
		throw new Exception("Billing System doesnt exist.");
	}
	
	
	@RequestMapping (value = "/{id}", method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public String deleteBillingSystem(@PathVariable("id") Integer id) throws Exception {
		if (billingSystems.deleteBillingSystem(id) == 0)
			return "Billing System Deleted";
		
		throw new Exception("Billing System doesnt exist");
	}
	
	
	@RequestMapping (value = "/{billingId}/{customerId}", method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	public String deleteCustomer(@PathVariable("billingId") Integer billingId, @PathVariable("customerId") Integer customerId) throws Exception {
		BillingSystem billingSystem = billingSystems.getBillingSystem(billingId);
		if (billingSystem != null) 
			if (billingSystem.deleteCustomer(customerId) == 0) {
				return "Custoemr Deleted";
			} else {
				throw new Exception("Customer doesnt exists");
			}
		
		throw new Exception("Billing System doesn't exist");
	}
	
	
	// Will work only for methods that throw exception.
	@ExceptionHandler
	public String handleException(Exception ex ) {
		return "Exception Caught and Handled\n " + ex.getMessage();
	}
	
	
	@RequestMapping (value = "/method", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Integer> getMethodsInvokationNumber() {
		return controllerMethodsInvocationMap.getInvokationMap();
		
	}
}
