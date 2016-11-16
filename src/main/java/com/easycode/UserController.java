package com.easycode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.easycode.validate.annotation.Rule;
import com.easycode.validate.annotation.RuleParameter;
import com.easycode.validate.annotation.RuleParameter.NullType;
import com.easycode.validate.annotation.RuleParameter.SqlInq;


@Component
public class UserController {
	
	@Rule
	public Map<String,Object> addUsers(
			@RuleParameter(value = "userName", nullType = NullType.NOTNULL,lenghtMin = 1,lengthMax = 2,sqlInq = SqlInq.YES) String userName,
			@RuleParameter(value = "password", nullType = NullType.NOTNULL,lengthMax = 2)String password,
			@RuleParameter(value = "age", nullType = NullType.NOTNULL,lenghtMin = 1,lengthMax = 1000) int age){
		System.out.println("added");
		return new HashMap<String,Object>();
	}
	
}
