public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0 || str == null) {
            return 0;
        }
        str = str.trim();
        int length = str.length();
        if(length == 0) {
        	return 0;
        }
        int sign = 1;
        int index = 0;
        if(str.charAt(index) == '+') {
        	index++;
        }else if(str.charAt(index) == '-') {
        	sign = -1;
        	index++;
        }
        long inte = 0;
        for(; index < length; index++) {
        	char a = str.charAt(index);
        	if(a < '0' || a > '9') {
        		break;
        	}
        	inte = inte * 10 + (a - '0');
            if(inte > Integer.MAX_VALUE){
                break;
            }
        }
        
        if(inte * sign > Integer.MAX_VALUE) {
        		return Integer.MAX_VALUE;
        	}
        	if(inte * sign < Integer.MIN_VALUE) {
        		return Integer.MIN_VALUE;
        	}
        return (int)inte * sign;
    }
}