public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> toReturn = new ArrayList();
    	if(nums.length == 0) {
    		return toReturn;
    	}
    	if(nums == null) {
    		return null;
    	}
    	Arrays.sort(nums);
    	ArrayList<Integer> subset = new ArrayList<Integer>();
    	dfs(nums, subset, toReturn, 0);
    	return toReturn;

        
    }

    private void dfs(int[] nums, List<Integer> subset, List<List<Integer>> toReturn, int pos) {
    	toReturn.add(new ArrayList(subset));
    	for(int i = pos; i < nums.length; i++) {
    		subset.add(nums[i]);
    		dfs(nums, subset, toReturn, i+1);
    		subset.remove(subset.size() - 1);
    	}
    }
}