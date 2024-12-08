class Solution {
    public int solution(String s) {
        int answer = 1000;
        int len = s.length();
        int maxSlice = len / 2 == 0 ? 1 : len / 2;

        // 압축 단위를 1부터 s.length / 2까지 늘려가며 반복
        for (int sliceNum = 1; sliceNum <= maxSlice; sliceNum++) {
            StringBuilder result = new StringBuilder();
            int count = 1;

            for (int i = 0; i < len; i += sliceNum) {
                // 문자열을 제일 앞부터 압축단위만큼 잘라 뒤의 문자열과 비교
                String str = s.substring(i, Math.min(i + sliceNum, len));
                String nextStr = i + sliceNum < len ? s.substring(i + sliceNum, Math.min(i + 2 * sliceNum, len)) : "";

                if (!str.equals(nextStr)) { // 동일하지 않은 문자열이면
                    // 반복횟수가 여러번이면 반복숫자 + 문자열
                    // 반복횟수가 한번이면 문자열만 저장
                    if (count == 1) {
                        result.append(str);
                    } else {
                        result.append(count).append(str);
                    }
                    count = 1;
                } else { // 문자열이 동일한 경우 반복횟수 증가
                    count++;
                }
            }
            // answer에는 압축 후 가장 길이가 짧았을 때를 저장
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}