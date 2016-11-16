package com.easycode.validate.intercepter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.easycode.validate.ValidateChain;
import com.easycode.validate.annotation.Rule;
import com.easycode.validate.annotation.RuleParameter;


@Aspect
@Component
public class ValidateAop { 
    
	@Resource
	private ValidateChain validateChain;
	
    @Around("@annotation(rule)")  
    public Object validate(final ProceedingJoinPoint pjp,Rule rule) throws Throwable { 
    	
          Map<String,Object> rs = new HashMap<String,Object>();
          
          Map<String,Object> rules = new HashMap<String,Object>();
          Map<String,Object> params = new HashMap<String,Object>();
          
          Object[] args=pjp.getArgs();  
          int count = 0;
          
          MethodSignature signature = (MethodSignature)pjp.getSignature();
          Method m  = signature.getMethod();
          
          Parameter [] pm= m.getParameters();
          
          for(Parameter _pm : pm){
        	  
        	  RuleParameter [] rp = _pm.getAnnotationsByType(RuleParameter.class);
        	  if(rp != null){
        		  for(RuleParameter _rp : rp){
        			  rules.put(_rp.value(), _rp);
        			  params.put(_rp.value(), args[count]);       			       		
            	  }
        	  }
        	  
        	  count++;
          }
          
          rs = validateChain.validateHandle(params, rules);
          if(rs.keySet().size() <= 0){
        	  Object value = pjp.proceed();
        	  return value;
          }
          return rs;
    }  

}
