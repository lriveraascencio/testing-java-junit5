package fauxspring;

import java.util.HashMap;
import java.util.Map;

import guru.springframework.sfgpetclinic.fauxspring.Model;

public class ModelMapImpl implements Model {

	
	Map<String, Object> map = new HashMap<>();
	
	@Override
	public void addAttribute(String key, Object o) {
		// TODO Auto-generated method stub
		map.put(key,o);
	}

	@Override
	public void addAttribute(Object o) {
		// TODO Auto-generated method stub
		//do nothing
	}
	
	public Map<String, Object> getMap() {
		return map;
	}

}
