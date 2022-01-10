package test;

import java.util.HashMap;
import java.util.Map;

public class T20 {
	public boolean isNumber(String s) {
		Map[] states = {
				new HashMap<>(){{
					put(' ', 0);
					put('d', 2);
					put('s', 1);
					put('.', 4);
				}},
				
				new HashMap<>() {{
					put('d', 2);
					put('.', 4);
				}},
				new HashMap<>() {{
					put('d', 2);
					put(' ', 8);
					put('e', 5);
					put('.', 3); 
					// 为什么是put('.', 3);而不是put('.', 4)，
					// 因为从而2后接'.'和从1或0接'.'得到的新状态是不一样的，
					// 2后接'.'，如"2." "34."可以直接到8返回true，而1或0后接是"." "-."不能直接到8
					// 那2后接'.'，到了新的状态后可以继续接'd', 'e'或' '，与3后能接的字符一致
					// 因此2后接'.'可以的新状态要直接指向3，因此是put('.', 3); 
				}},
				new HashMap<>() {{
					put('d', 3);
					put('e', 5);
					put(' ', 8);
				}},
				new HashMap<>() {{
					put('d', 3);
				}},
				new HashMap<>() {{
					put('s', 6);
					put('d', 7);
				}},
				new HashMap<>() {{
					put('d', 7);
				}},
				new HashMap<>() {{
					put('d', 7);
					put(' ', 8);
				}},
				new HashMap<>() {{
					put(' ', 8);
				}}
				
		};
		int p = 0;
		char t;
		for (char c : s.toCharArray()) {
			if(c >= '0' && c <= '9') t = 'd';
			else if(c == '+' || c == '-') t = 's';
			else if(c == 'e' || c == 'E') t = 'e';
			else if(c == '.' || c == ' ') t = c;
			else t = '?';
			if(!states[p].containsKey(t)) 
				return false;
			p = (int)states[p].get(t);
		}
		return p==2 || p==3 || p==7 || p==8;
	}
	public static void main(String[] args) {
		T20 tt = new T20();
		
		String str = "10.3e3";
		System.out.println(tt.isNumber(str));
		
	}
}
