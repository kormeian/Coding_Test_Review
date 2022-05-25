class Solution {
  /* 2의 지수 승으로 들어오는 n라운드, a 선수의 번호, b 선수의 번호*/
    public int solution(int n, int a, int b) {
        int answer = 0;
        while (true) {
          /*
            a나 b가 짝수가 아니면서 b - a나 a - b가 1이면
            붙어있는 수면서 겨루기가 가능한 상태이기에 answer (라운드) 변수++
            => break를 통해 while 탈출
            ex: a가 5이고 b가 6일 때 a는 홀수이고 b - a는 1 => 조건에 부합 > 탈출
                a가 4이고 b가 5일 때 a는 짝수이고 b - a는 1 => 조건 부적합 > else
          */
            if ((a % 2 != 0 && b - a == 1) || (b % 2 != 0 && a - b == 1)) {
                answer++;
                break;
            } else {
              /*
                문제에서 서로 붙기 전까지 계속 이긴다고 했기 때문에
                해당 대결의 짝수 / 2가 다음 번호가 됨
                삼항 연산자로 a나 b의 현재 값이 홀수면 +1하여 처리
                a, b => /2
                ex: a가 4이고 b가 5일 때
                    a는 짝수기 때문에 다음 라운드는 /2한 값인 2
                    b는 홀수기 때문에 다음 라운드는 +1한 값인 6의 /2인 3
                    다시 a가 2이고 b가 3일 때
                    a는 짝수기 때문에 다음 라운드는 /2한 값인 1
                    b는 홀수기 때문에 다음 라운드는 +1한 값인 4의 /2인 2
                    =>  1,2 > 연속되면서 대결이 가능한 상태이므로
                        다시 위의 if 조건문으로 넘어갔을 때 break됨
               */
                a = a % 2 == 0 ? a : a + 1;
                b = b % 2 == 0 ? b : b + 1;
                a /= 2;
                b /= 2;
                answer++;
            }
        }
        return answer;
    }
}
