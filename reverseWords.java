/*Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

//"eulb si yks eht"
//'blue is sky the'


Could you do it in-place without allocating extra space?

*/

// The idea is to reverse each word first, then reverse the whole string.
public class Solution {
    public void reverseWords(char[] s) {
    	// input check
    	if(s.length == 0 || s == null) {
    		return; // or we can throw exceptions here.
    	} 
    	int start = 0;
    	int end = 0;
    	for(int i = 0; i < s.length; i++) {
    		if(s[i] == ' ' || i == s.length - 1) { // here is they key point, since there is no trailing space at the end.
    			end = (i == s.length - 1) ? i : i -1;  // so we need to consider when the string ends it might also produces a new word.
    			reverseWord(s, start, end);
    			start = i + 1;
    		}
    	}

    	reverseWord(s, 0, s.length -1);

    }

    private void reverseWord(char[] s, int start, int end) {
    	while(start < end) {
    		char temp = s[start];
    		s[start++] = s[end];
    		s[end--] = temp;
    	}

    }
}