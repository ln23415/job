package JianZhi;

import java.util.HashSet;
import java.util.Set;

public class T48{
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        Set<Character> set = new HashSet<Character>();
        int max_length = 0;
        while(i<s.length() && j<s.length()) {
        	if(!set.contains(s.charAt(j))) {
        		set.add(s.charAt(j));
        		max_length = max_length<(j-i+1)?(j-i+1):max_length;
        		j++;
        	}else {
				set.remove(s.charAt(i));
				i++;
			}
        }
        return max_length;
    }
    public static void main(String[] args) {
		String str = "pwwkew";
		System.out.println(lengthOfLongestSubstring(str));
	}
}
