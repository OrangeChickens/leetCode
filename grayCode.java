public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        if(n < 0) {
        	return sequence;
        }
        sequence.add(0);
        for(int i = 0; i < n; i++) {
        	for(int j = sequence.size() -1; j>= 0; j--) {
        		sequence.add(sequence.get(j) + 1 << i);
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



