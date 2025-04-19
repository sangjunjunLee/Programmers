import java.util.stream.LongStream;
class Solution {
    public long[] solution(int x, int n) {
        return LongStream.iterate(x, current -> current + x).limit(n).toArray();
    }
}