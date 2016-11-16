package com.easycode.validate;

import java.util.Map;

public interface Validate {

	public Map<String,Object> validateHandle(Map<?,?> object,Map<?,?> rules);

}
