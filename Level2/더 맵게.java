import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        
        for (int i = 0; i < scoville.length; i++)
            pq.add(scoville[i]);
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            int sc1, sc2;
            sc1 = pq.poll();
            sc2 = pq.poll();
            pq.add(sc1 + 2 * sc2);
            answer++;
        }
        
        return answer;
    }
}