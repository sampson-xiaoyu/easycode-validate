package com.easycode.validate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.easycode.validate.annotation.RuleParameter;
import com.easycode.validate.annotation.RuleParameter.NullType;
import com.easycode.validate.kkh.utils.ValidatorConstant;


/**
 * 
 * @author kongkonghu
 *
 */
@Component
public class FormatValidate implements Validate{

	public Map<String, Object> validateHandle(Map<?, ?> data,Map<?,?> rules) {
		// TODO Auto-generated method stub
		Map<String,Object> rs = new HashMap<String,Object>();
		
		Iterator<?> it = data.keySet().iterator();
		while(it.hasNext()){
			
			Object key = it.next();
			Object value = data.get(key);
			
			
			RuleParameter rp = (RuleParameter) rules.get(key);
			
			if(rp.nullType().equals(NullType.NOTNULL)){
				
				if(StringUtils.isEmpty(String.valueOf(value))){
					if(StringUtils.isEmpty(value.toString())){
						rs.put(key.toString(), key+ValidatorConstant.NOT_NULL);
						continue;
					}
				}
				
			}
			if(rp.lenghtMin() != -1){
				if(value instanceof String){
					if(String.valueOf(value).length() < rp.lenghtMin() ){
						rs.put(key.toString(), key + ValidatorConstant.LENGTH_MIN_LIMIT + rp.lenghtMin());
						continue;
					}
				}else if(value instanceof Integer){
					if((Integer)value < rp.lenghtMin()){
						rs.put(key.toString(), key + ValidatorConstant.VALUE_MIN_LIMIT + rp.lenghtMin());
						continue;
					}
				}else if(value instanceof Long){
					if((Long)value < rp.lenghtMin()){
						rs.put(key.toString(), key + ValidatorConstant.VALUE_MIN_LIMIT + rp.lenghtMin());
						continue;
					}
				}else if(value instanceof Byte){
					if((Byte)value < rp.lenghtMin()){
						rs.put(key.toString(), key + ValidatorConstant.VALUE_MIN_LIMIT + rp.lenghtMin());
						continue;
					}
				}
				
			}
			if(rp.lengthMax() != -1){
				if(value instanceof String){
					if(String.valueOf(value).length() > rp.lengthMax() ){
						rs.put(key.toString(), key + ValidatorConstant.LENGTH_MAX_LIMIT + rp.lengthMax());
						continue;
					}
				}else if(value instanceof Integer){
					if((Integer)value > rp.lenghtMin()){
						rs.put(key.toString(), key + ValidatorConstant.VALUE_MAX_LIMIT + rp.lengthMax());
						continue;
					}
				}else if(value instanceof Long){
					if((Long)value > rp.lenghtMin()){
						rs.put(key.toString(), key + ValidatorConstant.VALUE_MAX_LIMIT + rp.lengthMax());
						continue;
					}
				}else if(value instanceof Byte){
					if((Byte)value > rp.lenghtMin()){
						rs.put(key.toString(), key + ValidatorConstant.VALUE_MAX_LIMIT + rp.lengthMax());
						continue;
					}
				}	
			}
			
		}
		
		return rs;
	}



}
