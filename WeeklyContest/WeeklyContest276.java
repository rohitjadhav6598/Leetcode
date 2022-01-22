package youtube;

import java.util.Arrays;

public class WeeklyContest276 {
	public String[] divideString(String s, int k, char fill) {
		int n = s.length()/k;
		if(s.length()%k!=0) n++;
		String[] ans = new String[n];
		for(int i=0;i<n;i++) {
			if((i*k)+k>s.length()-1) {
				ans[i]=s.substring(i*k);
				while(ans[i].length()<k) ans[i]+=fill;
			}
			else ans[i]=s.substring(i*k, (i*k)+k);
		}
		return ans;
    }
	
	public int minMoves(int target, int maxDoubles) {
		int steps = 0;
        while(target>1&&maxDoubles>0){
            if(target%2==0){
                target/=2;
                maxDoubles--;
            }
            else target--;
            steps++;
        }
        steps+=target-1;
        return steps;
    }
	
	public long mostPoints(int[][] questions) {
		long[] dp = new long[questions.length];
		Arrays.fill(dp, -1);
		int n = questions.length;
		dp[n-1] = questions[n-1][0];
		for(int i = n-2;i>=0;i--) {
			long take = questions[i][0];
			if(questions[i][1]+i+1<n) take+=dp[questions[i][1]+i+1];
			long notTake = dp[i+1];
			dp[i] = Math.max(take, notTake);
		}
		return dp[0];
		
    }
	
}
