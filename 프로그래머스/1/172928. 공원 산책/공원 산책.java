import java.util.*;
class Solution {
        public int[] solution(String[] park, String[] routes) {
            int h = park.length;
            int w = park[0].length();

            Map<String, int[]> dir = new HashMap<>();
            dir.put("N", new int[]{-1, 0});
            dir.put("S", new int[]{1, 0});
            dir.put("W", new int[]{0, -1});
            dir.put("E", new int[]{0, 1});

            int[] pos = new int[2];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (park[i].charAt(j) == 'S') {
                        pos[0] = i;
                        pos[1] = j;
                    }
                }
            }

            for (String r : routes) {
                String[] parts = r.split(" ");
                String op = parts[0];
                int move = Integer.parseInt(parts[1]);

                int ny = pos[0];
                int nx = pos[1];
                boolean possible = true;

                for (int i = 0; i < move; i++) {
                    ny += dir.get(op)[0];
                    nx += dir.get(op)[1];
                    
                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                        possible = false;
                        break;
                    }
                    if (park[ny].charAt(nx) == 'X') {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    pos[0] = ny;
                    pos[1] = nx;
                }
            }
            return pos;
        }
    }