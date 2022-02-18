package test;

import java.util.ArrayList;
import java.util.List;

public class T38_backup {
	List<String> res = new ArrayList<String>();
	public String[] permutation(String s) {
		fun(s, 0);
		return res.toArray(new String[res.size()]);
	}
	public void fun(String input, int i) {
		if(input.length() - 1 == i) {
			if(!res.contains(input)) res.add(input);
		}else {
			while(true) {
				int j = i;
				for(; j<input.length(); j++) {
					fun(swap(input, i, j), i+1);
				}
				if(j == input.length()) break;
			}
		}
	}
	
	public String swap(String str, int i, int j) {
		StringBuilder s = new StringBuilder(str);
		char temp = s.charAt(i);
		s.setCharAt(i, s.charAt(j));
		s.setCharAt(j, temp);
		return s.toString();
	}
	public static void main(String[] args) {
		String[] strs = new T38_backup().permutation("abb");
		for(String s : strs) {
			System.out.println(s);
		}
//		System.out.println(strs.length);
	}
}
