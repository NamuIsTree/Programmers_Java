import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer> a[] = new ArrayList[n];
        ArrayList<Integer> v = new ArrayList<Integer> ();
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<Integer> ();
            v.add(-1);
        }
        
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0] - 1, b = edge[i][1] - 1;
            a[u].add(b);
            a[b].add(u);
        }
        
        Queue<Integer> q = new LinkedList<> ();
        q.add(0);
        v.set(0, 0);
        
        int max = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            max = v.get(now);
            for (int next : a[now]) {
                if (v.get(next) == -1) {
                    q.add(next);
                    v.set(next, v.get(now) + 1);
                }
            }
        }
        
        for (int i = 0; i < n; i++)
            if (max == v.get(i)) answer++;
        
        return answer;
    }
}