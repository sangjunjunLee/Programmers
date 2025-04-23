import java.util.regex.Pattern;
class Solution {
   public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();

        // Step1: 모든 문자를 소문자로 변환
        String lower = new_id.toLowerCase();

        // Step2: 알파벳, 숫자를 제외한 모든 문자 제거
        Pattern pattern = Pattern.compile("[^a-z0-9._-]");
        String filter = pattern.matcher(lower).replaceAll("");

        // Step3
        sb.append(filter);
        while (sb.toString().contains("..")) {
            int idx = sb.indexOf("..");
            sb.replace(idx, idx + 2, ".");
        }

        // Step4: 문자열 양 끝에 '.'이 있으면 제거
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // Step5: 비어 있으면 a를 추가
        if (sb.length() == 0) {
            sb.append("a");
        }

        // Step6: 길이가 16 이상이면 15번째 인덱스까지 자르고, 끝에 '.'이 있으면 제거
        if (sb.length() > 15) {
            sb.delete(15, sb.length());
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // Step7: 길이가 3 미만이면 마지막 문자를 반복해서 길이를 맞춤
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }

}