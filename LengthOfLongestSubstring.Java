class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> s = new HashSet<>();
        for(int i=0;i<s.length();i++){
            s.add(s.charAt(i));
        }
        return s.size();
    }

}