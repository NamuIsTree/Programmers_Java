import java.util.*;

class Solution {
    HashMap<String, Integer> count;
    
    public class Album implements Comparable<Album> {
        String genre;
        int play, i;
        
        Album (String G, int P, int I) {
            this.genre = G;
            this.play = P;
            this.i = I;
        }
        
        @Override
        public int compareTo (Album rhs) {
            int lcnt = count.get(genre);
            int rcnt = count.get(rhs.genre);
            if (lcnt == rcnt) {
                if (play == rhs.play) {
                    if (i < rhs.i) return -1;
                    else return 1;
                }
                else {
                    if (play > rhs.play) return -1;
                    else return 1;
                }
            }
            else {
                if (lcnt > rcnt) return -1;
                else return 1;
            }
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        count = new HashMap<String, Integer> ();
        for (int i = 0; i < genres.length; i++) {
            if (count.get(genres[i]) == null) {
                count.put(genres[i], plays[i]);
            }
            else {
                int pcnt = count.get(genres[i]);
                count.put(genres[i], pcnt + plays[i]);
            }
        }
        
        ArrayList<Album> arr = new ArrayList<Album> ();
        for (int i = 0; i < genres.length; i++) {
            Album t = new Album(genres[i], plays[i], i);
            arr.add(t);
        }
        Collections.sort(arr);
        
        HashMap<String, Integer> cnt = new HashMap<> ();
        List<Integer> ans = new ArrayList<> ();
        for (Album it : arr) {
            if (cnt.get(it.genre) == null)
                cnt.put(it.genre, 0);
            
            int pcnt = cnt.get(it.genre);
            if (pcnt == 2) continue;
            
            cnt.remove(it.genre, pcnt);
            cnt.put(it.genre, pcnt + 1);
            ans.add(it.i);
            //System.out.println(it.i + " : " + it.genre + ", " + it.play);
        }
        
        answer = new int[ans.size()];
        
        for (int i = 0; i < answer.length; i++)
            answer[i] = ans.get(i);
        
        return answer;
    }
}