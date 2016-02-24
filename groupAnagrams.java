public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) {
        	return null;
        }

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String s: strs) {
        	String sorted = countingSort(s);
        	if(!map.keySet().contains(sorted)) {
        		map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(s);
        }

        for(ArrayList a: map.values()) {
        	Collections.sort(a);
        }

        return new ArrayList<List<String>>(map.values());


    }

    //counting sort. a
    // returns a sorted verstion of a str    
    public String countingSort(String str) {
    	if(str == null || str.length() == 0) {
    		return "";
    	}
    	char[] output = new char[str.length()];
    	int[] count = new int[26]; // 26 chars
    	// fill up count array
    	for(int i = 0; i < str.length(); i++) {
    		count[str.charAt(i) - 'a'] += 1;
    	}

    	//add up positions in count.
    	int preTotal = 0;
    	for(int i = 0; i < count.length; i++) {
    		count[i] += preTotal;
    		preTotal = count[i];
    	}

    	for(int i = 0; i < str.length(); i++) {
    		output[count[str.charAt(i) - 'a'] -1] = str.charAt(i);
    		count[str.charAt(i) - 'a'] -= 1;
    	}

    	return new String(output);


    }
}