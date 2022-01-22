package youtube;

import java.util.ArrayList;
import java.util.HashMap;

public class BiWeeklyContest69 {
	public String capitalizeTitle(String title) {
        title = title.toLowerCase();
        String[] words = title.split(" ");
        String res = "";
        for(int i = 0; i < words.length; i++){
            if(words[i].length() > 2){
                res += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1) + " ";
                
            } else {
                res += words[i] + " ";
            }
            
        }
        
        return res.trim();
    }
	
	public int pairSum(ListNode head) {
        ArrayList<Integer> a = new ArrayList<>();
        while(head!=null){
            a.add(head.val);
            head=head.next;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.size()/2;i++) max=Math.max(max, a.get(i)+a.get(a.size()-i-1));
		return max;
        
    }
	
	public int longestPalindrome(String[] words) {
		int ans=0;
		HashMap<String,Integer> m = new HashMap<>();
		for(String w:words) {
			String rev = ""+w.charAt(1)+w.charAt(0);
			if(m.containsKey(rev)&&m.get(rev)>0) {
				ans+=4;
				m.put(rev, m.get(rev)-1);
			}
			else {
				if(m.containsKey(w))m.put(w, m.get(w)+1);
				else m.put(w, 1);
			}
		}
		for(String w:words) if(w.charAt(0)==w.charAt(1)&&m.containsKey(w)&&m.get(w)>0) {
			ans+=2;
			break;
		}
		return ans;
        
    }
}
