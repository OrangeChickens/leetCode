/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [6, 30],[5, 10],[15, 20]],
return 2
*/
public class Solution {
	public int minMeetingRooms(Interval[] intervals) {
		int length = intervals.length;
		if(length == 0) {
			return 0;
		}
		if(length == 1) {
			return 1;
		}
		int[] start = new int[length];
		int[] end = new int[length];
		int count  = 0;
		int ptr = 0;
		for(int i = 0; i < length; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		for(int i = 0; i < length; i++) {
			if(start[i] < end[ptr]) {
				count++;
			} else {
				ptr++;
			}
		}
		return count;

	}
}

//Solution 2 Greedy. 
//5 10, 6 30 , 15 20
public class Solution {
	public int minMeetingRooms(Interval[] intervals) {
		int length = intervals.length;
		if(length == 0) {
			return 0;
		}
		if(length == 1) {
			return 1;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;			
			}
		});
		return helper(new ArrayList(Arrays.asList(intervals)));

	}
	private int helper(List<Interval> list) {
		if(list.size() == 0) {
			return 0;
		}
		ArrayList<Interval> a  = new ArrayList();
		Interval pre = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			Interval now = list.get(i);
			if(now.start < pre.end) {
				a.add(now);
			} else {
				pre = now;
			}
		}
		return 1 + helper(a);
	}
}