package JianZhi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class T50 {
    public char firstUniqChar(String s) {
    	Map<Character, Boolean> map = new LinkedHashMap<Character, Boolean>();
    	for(char c : s.toCharArray()) {
    		map.put(c, map.containsKey(c));
    	}
    	for(Map.Entry<Character, Boolean> element :map.entrySet()) {
    		if(!element.getValue()){
    			return element.getKey();
    		}
    	}
    	return ' ';
    }
}
