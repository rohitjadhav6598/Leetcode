package WeeklyContest;

import java.util.Arrays;

public class WeeklyContest275 {
	//working
	public boolean checkValid(int[][] matrix) {
		int n=matrix.length;
		int sumExp=n*(n+1)/2;
		
		int[] h = new int[n+1];
		Arrays.fill(h, 0);
		for(int i=0;i<n;i++) {
			int sh=0,sv=0;
			for(int j=0;j<n;j++) {
				h[matrix[i][j]]++;
				sh+=matrix[i][j];
				sv+=matrix[j][i];
			}
			if(sh!=sumExp||sv!=sumExp) {
				return false;
			}
		}
		for (int i = 1; i < h.length; i++) {
			if(h[i]!=n) {
				return false;
			}
		}
		return true;
    }
	
	//working
	public int minSwaps(int[] nums) {
		int ones=0,onesInWindow=0,temp=0;
		for (int i : nums) if(i==1) ones++;
		int[] nums2=new int[nums.length*2];
		for(int i=0;i<nums2.length;i++) nums2[i] = nums[i%nums.length];
		for (int i = 0; i < nums2.length; i++) {
			if(i>=ones && nums2[i-ones]==1) temp--;
			if(nums2[i]==1) temp++;
			onesInWindow = Math.max(temp, onesInWindow);
		}
		return ones-onesInWindow;

    }
	
	//wrong answer
	public int wordCount(String[] startWords, String[] targetWords) {
		int[] startWordsInt = new int[startWords.length];
		int[] targetWordsInt = new int[targetWords.length];
		for (int i=0;i<startWords.length;i++) {
			startWordsInt[i]=0;
			for (int j = 0; j < startWords[i].length(); j++) {
				startWordsInt[i]+=startWords[i].charAt(j);
			}
		}
		for (int i=0;i<targetWords.length;i++) {
			targetWordsInt[i]=0;
			for (int j = 0; j < targetWords[i].length(); j++) {
				targetWordsInt[i]+=targetWords[i].charAt(j);
			}
		}
		int ans=0;
		for(int i=0;i<targetWords.length;i++) {
			for(int j=0;j<startWords.length;j++) {
				int diff = targetWordsInt[i]-startWordsInt[j];
				if(diff > 96 && diff < 123 && startWords[j].length()+1==targetWords[i].length()) {
					ans++;
					i++;
					break;
				}
			}
		}
		return ans;
    }
	
	public int earliestFullBloom(int[] plantTime, int[] growTime) {
		System.out.println("Not implemented");
		return 0;
        
    }
    
}
