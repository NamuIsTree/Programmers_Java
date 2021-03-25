class Solution {
    boolean solution(String s) {
        int pcnt = 0, ycnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') pcnt++;
            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') ycnt++;
        }
        
        return pcnt == ycnt;
    }
}