import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = 99;
        int luy = 99;
        int rux = -1;
        int ruy = -1;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rux = Math.max(rux, i);
                    ruy = Math.max(ruy, j);
                }
            }
        }
        return new int[]{lux, luy, rux + 1, ruy + 1};
    }
}