/*Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
**/

// solution 1 brute force

public class Solution {
    public String longestPalindrome(String s) {
    	if(s == null) {
    		return null;
    	}
    	int max = 0;
    	int begin = 0;
    	int end = 0;
    	for(int i  = 0; i < s.length(); i++) {
    		if(isPalindrome(s, i - max - 1, i)){
    			begin = i - max - 1;
    			end = i;
    			max += 2;
    		}else if(isPalindrome(s, i - max, i)) {
    			begiin = i - max;
    			end  = i;
    			max += 1;
    		}
    	}
    	return s.substring(begin, end + 1); // substring(a,b) from a to b-1. so we + 1 for end.

    }

    public boolean isPalindrome(String s, int a , int b) {
    	if(a < 0) {
    		return false;
    	}
    	while(a < b) {
    		if(s.charAt(a++) != s.charAt(b--)) {
    			return false;
    		}
    	}
    	return true;
    }
}


// solution 2. dp. 
public class Solution {
	public String longestPalindrome(String s) {
		if(s == null) {
			return null;
		}
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		int max  = 0;
		int begin = 0;
		int end = 0;
		for(int i = 0; i < len; i ++) {
			for(int j = 0; j <= i; j++) {
				// j - i <= 2; aba, aa, a. 3 cases.
				if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])){
					dp[j][i] = true;
					if(i - j + 1 > max) {
						max = i - j + 1;
						begin = j;
						end  = i;
					}

				}else {
					dp[j][i] = false;
				}
			}
		}

		return s.substring(begin, end+1);

	}

}
