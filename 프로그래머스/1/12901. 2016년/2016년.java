import java.time.LocalDate;
class Solution {
    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        return String.valueOf(date.getDayOfWeek()).substring(0, 3);
    }
}