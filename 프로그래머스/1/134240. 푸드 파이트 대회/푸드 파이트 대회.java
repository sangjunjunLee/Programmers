class Solution {
   public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int value = food[i] / 2;
            sb.append(String.valueOf(i).repeat(value));
        }
        return result.append(sb).append("0").append(sb.reverse()).toString();
    }
}