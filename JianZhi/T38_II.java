package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T38_II {
	List<String> res = new ArrayList<String>();
	char[] input;
	public String[] permutation(String s) {
		input = s.toCharArray();
		fun(0);
		return res.toArray(new String[res.size()]);
	}
	public void fun(int i) {
		if(input.length - 1 == i) {
			res.add(String.valueOf(input));
		}else {
			HashSet<Character> set = new HashSet<Character>();
			for(int j = i; j<input.length; j++) {
				for(; j<input.length; j++) {
					if(set.contains(input[j])) {
						continue;
					}
					set.add(input[j]);
					swap(i, j);
					fun(i+1);
					swap(i, j);
				}
			}
		}
	}
	
	public void swap(int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	public static void main(String[] args) {
		String[] strs = new T38().permutation("abc");
//		String[] strs = new T38().permutation("dkjphedy");
		for(String s : strs) {
			System.out.println(s);
		}
	}
}
