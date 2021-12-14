package JianZhi;

public class T58 {
    public static String reverseWords(String s) {
    	String strs[] = s.split(" ");
    	StringBuilder re = new StringBuilder();
    	for(int i=strs.length-1; i>=0; i--) {
    		if(strs[i].trim().equals("")) {
    			re.append(strs[i].trim() + " ");
    		}
    	}
    	return re.toString().trim();
    }
	public static void main(String[] args) {
		String a = "a good   example";
		System.out.println(reverseWords(a));
	}
}
