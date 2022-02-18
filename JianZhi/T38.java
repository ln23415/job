package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class T38 {
	List<String> res = new ArrayList<String>();
	public String[] permutation(String s) {
		fun(s.toCharArray(), 0);
		return res.toArray(new String[res.size()]);
	}
	public void fun(char[] input, int i) {
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
					fun(swap(Arrays.copyOf(input, input.length), i, j), i+1);
				}
			}
		}
	}
	
	public char[] swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		return input;
	}
	public static void main(String[] args) {
		String[] strs = new T38().permutation("abb");
//		String[] strs = new T38().permutation("dkjphedy");
		for(String s : strs) {
			System.out.println(s);
		}
	}
}
