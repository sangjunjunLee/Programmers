class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardLeftIdx = 0;
        int cardRightIdx = 0;

        for (String word : goal) {
            if (cardLeftIdx < cards1.length && word.equals(cards1[cardLeftIdx])) {
                cardLeftIdx++;
            } else if (cardRightIdx < cards2.length && word.equals(cards2[cardRightIdx])) {
                cardRightIdx++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}