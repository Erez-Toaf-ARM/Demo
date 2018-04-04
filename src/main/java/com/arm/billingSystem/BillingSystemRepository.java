package com.arm.billingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BillingSystemRepository {
	
	HashMap<Integer,BillingSystem> billingSystemMap = new HashMap<Integer, BillingSystem>();
	
	
	public BillingSystemRepository() {
		BillingSystem billingSystem1 = new BillingSystem(1, "Bank Leumi");
		BillingSystem billingSystem2 = new BillingSystem(2, "Bank Hapoalim");
		billingSystemMap.put(1, billingSystem1);
		billingSystemMap.put(2, billingSystem2);
	}


	public HashMap<Integer, BillingSystem> getBillingSystemMap() {
		return billingSystemMap;
	}


	public void setBillingSystemMap(HashMap<Integer, BillingSystem> billingSystemMap) {
		this.billingSystemMap = billingSystemMap;
	}
	
	
	public BillingSystem getBillingSystem(Integer id) {
		return billingSystemMap.get(id);
	}
	
	
	public List<BillingSystem> getAllBillingSystems() {
		List<BillingSystem> billingSystemList = new ArrayList<BillingSystem>(); 
		for (Integer id : billingSystemMap.keySet()) 
			billingSystemList.add(billingSystemMap.get(id));
		 
		return billingSystemList;
	}
	
	
	public int updateBillingSystem(BillingSystem billingSystem) {
		if (isBillingSystemExist(billingSystem.getId())) {
			billingSystemMap.put(billingSystem.getId(), billingSystem);
			return 0;
		}
		
		return -1;
	}	
	
	public int addBillingSystem(BillingSystem billingSystem) {
		if (!isBillingSystemExist(billingSystem.getId())) {
			billingSystemMap.put(billingSystem.getId(), billingSystem);
			return 0;
		}
		
		return -1;
	}
	
	public int deleteBillingSystem(Integer id) {
		if (isBillingSystemExist(id)) {
			billingSystemMap.remove(id);
			return 0;
		}
		
		return -1;
	}
	
	
	private boolean isBillingSystemExist(Integer id) {
		BillingSystem billingSystem = billingSystemMap.get(id);
		if (billingSystem != null)
			return true;
		else 
			return false;
	}


	@Override
	public String toString() {
		return "BillingSystemRepository [billingSystemMap=" + billingSystemMap + "]";
	}
}
