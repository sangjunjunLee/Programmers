import java.util.*;
import java.util.stream.*;

class Solution {
  public int[] solution(String[] id_list, String[] report, int k) {
    // 1) 중복 신고 제거
    Set<String> unique = new HashSet<>(Arrays.asList(report));

    // 2) 신고받은 사람 -> 신고한 사람들 / 신고한 사람 -> 신고받은 사람들
    Map<String, Set<String>> reportedBy = new HashMap<>(); // key: 피신고자, value: 신고자 set
    Map<String, Set<String>> reportsOf  = new HashMap<>(); // key: 신고자,   value: 피신고자 set

    for (String line : unique) {
      String[] p = line.split(" ");
      String from = p[0], to = p[1];
      if (from.equals(to)) continue; // 안전장치 (문제 조건상 필요 없지만 방어적으로)
      reportedBy.computeIfAbsent(to,   s -> new HashSet<>()).add(from);
      reportsOf .computeIfAbsent(from, s -> new HashSet<>()).add(to);
    }

    // 3) 정지 대상 선정(신고자 수 >= k)
    Set<String> banned = reportedBy.entrySet().stream()
        .filter(e -> e.getValue().size() >= k)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());

    // 4) 메일 수 집계: 각 유저가 신고한 ID 중 '정지 대상'의 수
    int[] answer = new int[id_list.length];
    for (int i = 0; i < id_list.length; i++) {
      Set<String> targets = reportsOf.getOrDefault(id_list[i], Collections.emptySet());
      int cnt = 0;
      for (String t : targets) if (banned.contains(t)) cnt++;
      answer[i] = cnt;
    }
    return answer;
  }
}
