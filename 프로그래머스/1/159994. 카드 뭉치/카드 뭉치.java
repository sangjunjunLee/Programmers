class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int leftIdx = 0;
        int rightIdx = 0;

        for (String word : goal) {
            if (leftIdx < cards1.length && word.equals(cards1[leftIdx])) {
                leftIdx++;
            } else if (rightIdx < cards2.length && word.equals(cards2[rightIdx])) {
                rightIdx++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}