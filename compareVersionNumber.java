public class Solution {
    public int compareVersion(String version1, String version2) {
    	String[] v1 = version1.split("\\.");
    	String[] v2 = version2.split("\\.");
        int length = Math.min(v1.length, v2.length);
        int i = 0; 
        for(; i < length; i++) {
        	int x  = Integer.parseInt(v1[i]);
        	int y = Integer.parseInt(v2[i]);
        	if(x < y) {
        		return -1;
        	} 
        	if(x > y) {
        		return 1;
        	}
        }
        if(v1.length == length && !sumToZero(v2, i)) {
        	return -1;
        }
        if(v2.length == length && !sumToZero(v1, i)) {
        	return 1;
        } else {
        	return 0;
        }
    }
	private boolean sumToZero(String[] in, int index) {
		int sum = 0;
		for(; index < in.length; index++) {
			sum +=  Integer.parseInt(in[index]);
		}
		return sum == 0;
	}
}