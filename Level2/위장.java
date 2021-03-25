import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<> ();
        
        for (int i = 0; i < clothes.length; i++) {
            if (map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);
            }
            else {
                int count = map.get(clothes[i][1]);
                map.remove(clothes[i][1], count);
                map.put(clothes[i][1], count + 1);
            }
        }
        
        for (String key : map.keySet()) {
            int value = map.get(key);
            answer = answer * (value + 1);
        }
        
        return answer - 1;
    }
}