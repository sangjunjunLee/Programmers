class Solution {
public int solution(int n, int m, int[] section) {
    int count = 0;
    int idx = 0;
    int length = section.length;

    while (idx < length) {
        int start = section[idx];
        count++;                   
        while (idx < length && section[idx] < start + m) {
            idx++;
        }
    }
    return count;
}
}