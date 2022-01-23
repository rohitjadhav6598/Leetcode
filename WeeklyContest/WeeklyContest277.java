package youtube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeeklyContest277 {
	public int countElements(int[] nums) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,count=0;
        for(int i:nums) {
        	if(i<=min) min=i;
        	if(i>=max) max=i;
        }
        for(int i:nums) if(i==min || i==max) count++;
        return nums.length-count;
    }
	
	public int[] rearrangeArray(int[] nums) {
		int[] pos = new int[nums.length/2];
		int[] neg = new int[nums.length/2];
		int pi=0,ni=0;
		for(int i: nums) {
			if(i>0) {
				pos[pi]=i;
				pi++;
			}
			else {
				neg[ni]=i;
				ni++;
			}
		}
		for(int i=0;i<nums.length;i++) {
			if(i%2==0) nums[i]=pos[i/2];
			else nums[i]=neg[i/2];
		}
		return nums;
    }
	
	public List<Integer> findLonely(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		HashMap<Integer,Integer> m = new HashMap<>();
		for(int i : nums) {
			if(m.containsKey(i)) m.put(i, m.get(i)+1);
			else m.put(i, 1);
		}
		for(int i : nums) {
			if(m.get(i)==1 && !m.containsKey(i-1) && !m.containsKey(i+1)) ans.add(i);
		}
		return ans;        
    }
	
	//wrong answer
	public int maximumGood(int[][] statements) {
		int n=statements.length;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<Integer>());
			for(int j=0;j<n;j++) {
				if(statements[i][j]==1) adj.get(i).add(j);
			}
		}
		int ans=1;
		for(int i=0;i<n;i++) {
			ArrayList<Integer> storeDfs = new ArrayList<>();
			boolean vis[] = new boolean[n+1];
			dfs(i,vis,adj,storeDfs);
			if(storeDfs.size()>ans) ans=storeDfs.size();
		}
		
		return ans;
    }
	public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs){
		storeDfs.add(node);
		vis[node] = true;
		for(Integer it:adj.get(node)){
			if(!vis[it]){
				dfs(it,vis,adj,storeDfs);
			}
		}
	}
	
}
