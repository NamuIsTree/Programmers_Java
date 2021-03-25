import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, sum = 0;
        Queue<Integer> q = new LinkedList<> ();
        
        for (int i = 0; i < bridge_length; i++)
            q.add(0);
        
        for (int i = 0; i < truck_weights.length; i++) {
            sum -= q.peek(); answer++;
            q.remove();
            
            if (sum + truck_weights[i] > weight) {
                q.add(0);
                i--;
            }
            else {
                q.add(truck_weights[i]);
                sum += truck_weights[i];
            }
        }
        
        while (sum > 0) {
            sum -= q.peek();
            q.remove();
            answer++;
        }
        
        return answer;
    }
}