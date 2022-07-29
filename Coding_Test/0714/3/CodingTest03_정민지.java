/*
  저는 이 문제를 처음보고 아 이거는..?! 진짜 어디서 풀어봤는데..? 했는데요.
  생각해보니 프로그래머스에서 풀어본 적이 있었던 문제랑 똑같았습니다.
  원형.. 인접하지 않은..? => 아하, 이거 스티커 모으기 같은데 (레벨 3)

  아무튼 풀어본 적이 있던 문제라서 차근 차근 풀이를 진행했는데
  처음에는 좀 1번 이후 마음이 조급해진 상태에서 막 풀다가 조금 이상하게
  흘러갈 뻔 했는데 금방 정신차려를 외치며 어떻게 풀었습니다.

  정확성 효울성 모두 통과했습니다.

  풀이는 아래 주석으로 함께 진행할게요!
 */
class Solution {
    public int solution(int N, int[] rewards) {
        int answer = 0;
        // 만약 성이 하나밖에 없으면 바로 반환을 합니다..!
        if (N == 1) return rewards[0];
        /*
          dp 배열인데 원형이라고 했으니 첫번째 성에서 암살을 하면
          인접한 마지막 성은 접근할 수 없습니다. 따라서
          첫번째 성에서 암살을 한 경우와 하지 않은 경우로 나누어
          배열을 채워나갈 거에오.

          1번 dp 배열은 첫번째 성에서 암살을 한 경우고
          2번 dp 배열은 첫번째 성에서 암살을 하지 않은 경우, 즉 마지막 성에 접근이 가능하고
          아마 2번째 성부터 암살을 시작하겠죠?
         */
        int[] dp = new int[N], dp2 = new int[N];

        /*
          근데 그리하여 1번 dp 배열은 첫번째 성에서 암살하면 두번쨰 성으로 접근을 못하니까
          dp[1]도 rewards[0]으로 초기화를 해줍니다.
          그리고 2번 dp는 첫번째 성을 접근하지 못하니까 [0] = 0으로 초기화를 합니다.
         */
        dp[0] = rewards[0];
        dp2[0] = 0;
        dp[1] = rewards[0];
        dp2[1] = rewards[1];

        /*
          for문을 돌면서 dp를 채워나가는데 조건문으로 i != N - 1을 걸어둔 이유는
          1번 dp 배열은 마지막 성에 접근을 할 수 없기 때문입니다.

          dp[i - 1]과 dp[i - 2] + rewards[i] 중에 더 큰 값을 dp[i]에 삽입합니다.

          현재 성과 인접한 성은 접근을 할 수 없으니 현재 성에서 한 칸 건너뛴 이전 성에서
          암살을 하고 현재 성에서 암살을 한 경우가 큰지, 현재 성에서 암살하지 않는 경우. 즉,
          i - 1의 경우가 큰지 비교해서 i를 채웁니다.
         */
        for (int i = 2; i < N; i++) {
            if (i != N - 1) dp[i] = Math.max(dp[i - 1], dp[i - 2] + rewards[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + rewards[i]);
        }
        // 1번 dp는 마지막 성을 방문하지 않았으니 -2, 2번 dp는 방문했으니 -1로하여
        // 둘 중에 더 큰 값을 반환합니다.
        return Math.max(dp[N - 2], dp2[N - 1]);
    }
}
