import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }

        return "";

        /**
         * [기록용]
         * 아래와 같이 removeAll() 사용하면, 컬렉션 안의 요소 개수와 상관없이 전부 삭제된다.
         * equals 비교를 통해 같은 값이면 전부 삭제함
         */
//        List<String> all = new ArrayList<>(Arrays.asList(participant));
//        List<String> clear = new ArrayList<>(Arrays.asList(completion));
//        all.removeAll(clear);
//        return all.get(0);
    }
}