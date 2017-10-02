package com.coreJava;

import java.util.HashMap;
import java.util.Map;

public class FindNonRepeatedChar {
	public static void main(String[] args) {
		System.out.println(getNonRepeatedChar(""));
	}
	
	private static Character getNonRepeatedChar(String characters){
		Character result = null;
		Map<Character, Integer> charCountMapper = new HashMap<>();
		if(characters != null && characters.length() > 0){
			for(Character ch : characters.toCharArray()){
				if(charCountMapper.containsKey(ch)){
					charCountMapper.put(ch, charCountMapper.get(ch)+1);
					
				}else{
					charCountMapper.put(ch, 1);
				}
			}
		}
		
		for(Map.Entry<Character, Integer> m : charCountMapper.entrySet()){
			if(m.getValue() == 1)
				result = m.getKey();
		}
		return result;
	}

}
