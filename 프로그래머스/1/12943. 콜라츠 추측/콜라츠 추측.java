class Solution {
    public int solution(int n) {
        if (n <= 1) return 0;

        long num = n;
        int flg = 0;
        
        while (num != 1) {
            if (flg == 500) return -1;
            flg++;
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
        }
        return flg;
    }
}