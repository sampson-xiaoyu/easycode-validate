package com.easycode.validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ValidateChain implements Validate{

	private List<Validate> validates;
	

	public Map<String, Object> validateHandle(Map<?,?> object,Map<?,?> rules) {
		// TODO Auto-generated method stub
		Map<String,Object> result = new HashMap<String,Object>();
		for(Validate v : validates){
			result.putAll(v.validateHandle(object,rules));
			if(result.keySet().size() > 0){
				return result;
			}
		}
		return result;
	}

	public List<Validate> getValidates() {
		return validates;
	}

	public void setValidates(List<Validate> validates) {
		this.validates = validates;
	}
	
	
}
