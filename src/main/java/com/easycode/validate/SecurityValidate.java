package com.easycode.validate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.easycode.validate.annotation.RuleParameter;
import com.easycode.validate.annotation.RuleParameter.SqlInq;
import com.easycode.validate.kkh.utils.ValidatorConstant;
import com.easycode.validate.kkh.utils.ValidatorUtils;

@Component
public  class SecurityValidate implements Validate{

	public Map<String, Object> validateHandle(Map<?, ?> data,Map<?,?> rules) {
		// TODO Auto-generated method stub
		Map<String,Object> rs = new HashMap<String,Object>();
		
		Iterator<?> it = data.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			Object value = data.get(key);
			if(!StringUtils.isEmpty(String.valueOf(value))){
				
				RuleParameter rp = (RuleParameter) rules.get(key);

				if(rp.sqlInq().equals(SqlInq.YES)){
				
					if(!ValidatorUtils.ValidateQuery(value.toString())){
						rs.put(key.toString(), key+ValidatorConstant.SQL_INQ);
					}
					
				}
			}
			
		}
		
		return rs;
	}

	
	
}
