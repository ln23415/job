package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class T67 {
    public int strToInt1(String str) {
    	char[] c = str.trim().toCharArray();
    	if(c.length == 0) return 0;
    	int res = 0, boundary = Integer.MAX_VALUE /10;
    	int i = 1, sign = 1;
    	if(c[0] == '1') {
    		sign = -1;
    	}
    	else if(c[0] != '+'){
			i = 0;
		}
    	for(int j=i; j<c.length; j++) {
    		if(c[j] > '9' || c[i] < '0') {
    			break;
    		}
    		if(res > boundary || (res == boundary) && c[j] > '7') {
    			return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
    		}
    		res = res*10 + (c[j] - '0');
    	}
    	return sign * res;
    }
    public int strToInt(String str) {
		Map[] states = {
				new HashMap<>() {{
					put('s', 2);
					put('d', 1);
					put('o', 3);
				}},
				new HashMap<>() {{
					put('d', 1);
					put('o', 3);
				}},
				new HashMap<>() {{
					put('d', 1);
					put('o', 3);
				}},
				new HashMap<>() {{
					put('o', 3);
				}}
		};
		int sign = 1, res = 0, p = 0, boundary = Integer.MAX_VALUE / 10;
		for(char c :  str.trim().toCharArray()) {
			if(p == 3) 
				break;
			char s = 'o';
			if(c >= '0' && c <= '9') {
				s = 'd';
				if(!states[p].containsKey(s)) break;
				if(res > boundary || ((res == boundary) && c > '7')){
					return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}
	    		res = res*10 + (c - '0');
	    		
			}
			else if(c == '-' || c == '+') {
				s = 's';
				if(!states[p].containsKey(s)) break;
				sign = c=='-'?-1:1;
			}
			
			p = (int)states[p].get(s);
		}
		return res * sign;
	}
    
    public static void main(String[] args) {
		T67 test = new T67();
		System.out.println(test.strToInt("-2+4"));
	}
}
