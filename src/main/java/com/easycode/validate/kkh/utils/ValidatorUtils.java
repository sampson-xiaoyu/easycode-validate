package com.easycode.validate.kkh.utils;

import java.util.regex.Pattern;

public class ValidatorUtils {
	
	//验证是否有SQL注入字符

    public static boolean ValidateQuery(String str)

    {
    	String tt=str.toLowerCase();
    	
    	 String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"  
                + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";  
      
    	 Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);  

		    if (sqlPattern.matcher(tt).find()) {  
		          
		    	return false;		
  
		    }  
		    return true;
    }
}
