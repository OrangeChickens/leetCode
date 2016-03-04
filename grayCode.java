
/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

*/

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        if(n < 0) {
        	return sequence;
        }
        sequence.add(0);
        for(int i = 0; i < n; i++) {
        	for(int j = sequence.size() -1; j>= 0; j--) {
        		sequence.add(sequence.get(j) + (1 << i));
        	}
        }
        return sequence;
    }
}



000
001

011
010

110
111
101
100



