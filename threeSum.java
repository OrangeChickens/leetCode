//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
import until.ArrayList;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> toReturn = new ArrayList<ArrayList<Integer>>();
    	if(nums.length < 3) {
    		return toReturn;
    	} else {
    		Arrays.sort(nums);
    		// nums.length - 2 since its 3 sum. so we need at least 3 numbers.
    		for(int i = 0; i < nums.length - 2; i++) {
    			// all positive numbers. Impossible to find 3 nums added to 0;
    			if(nums[0] > 0) {
    				return toReturn;
    			}
    			// since no dulplicates allowed, we just skip those dulplicates
    			if(i > 0 && nums[i] == nums[i-1]) {
    				continue;
    			}
    			int toFind = -nums[i];
    			int low = i + 1;
    			int high = nums.length - 1;
    			while(low < high) {
    				if(nums[low] + nums[high] == toFind) {
    					toReturn.add(Arrays.asList(-toFind, nums[low], nums[high]));
    					//since here again, we are not allowing dulplicates, we will skip some values 
    					while(low < high && nums[low] == nums[low + 1]) low++; // 1 2 2 2 3
    					low++; // let low points to 3.
    					while(low < high && nums[high] == nums[high - 1]) high--;
    					high--;
    				}else if(nums[low] + nums[high] <  toFind) {
    						while(low<high && nums[low]==nums[low+1]) low++;
                    		low++;
    				}else {
    					while(low<high && nums[high]==nums[high-1]) high--;
                    		high--;
    				}

    			}
    		}
    		return toReturn;
    	}


    }

}