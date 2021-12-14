package JianZhi;

public class T46 {
    public int translateNum(int num) {
	 return translateNum(String.valueOf(num));
     
     
    }
    public static int translateNum(String num) {
        if(num.length()<=1) {
        	return 1;
        }
        String s = num.substring(num.length()-2, num.length());
        if ((s.compareTo("10")>=0) && (s.compareTo("25")<=0)) {
			return translateNum(num.substring(0, num.length()-1)) + 
					translateNum(num.substring(0, num.length()-2));
		}
        else {
        	return translateNum(num.substring(0, num.length()-1));
        }
        
        
    }
    public static void main(String[] args) {
    	int a = 4561;
    	String num = "hello";
//		System.out.println(num.substring(num.length()-2, num.length()));
    	System.out.println(translateNum(""));
	}	
}
