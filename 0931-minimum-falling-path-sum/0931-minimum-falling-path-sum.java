class Solution {
    public static final int MAX = 10001;
    int[][] memo;
    
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        init(len);
        for(int i = 0; i < len; i++) {
            dp(matrix, len, 0, i, 0);
        }
        return solve(len);
    }
    
    // 초기화
    public void init(int len) {
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], MAX);
        }
    }
    
    // dp
    public void dp(int[][] matrix, int len, int row, int col, int sum) {
        // 범위 초과 시 종료
        if(row < 0 || row >= len || col < 0 || col >= len) {
            return;
        }
        
        // memo에 저장한 값보다 작은 경우 바꿔주기
        int checkSum = sum + matrix[row][col];
        if(checkSum < memo[row][col]) { // 작은 경우 저장
            memo[row][col] = checkSum;
        } else { // 큰 경우 return
            return;
        }
        
        dp(matrix, len, row + 1, col - 1, memo[row][col]);
        dp(matrix, len, row + 1, col, memo[row][col]);
        dp(matrix, len, row + 1, col + 1, memo[row][col]);
    }
    
    // 최소값 찾기
    public int solve(int len) {
        int result = MAX;
        for(int i = 0; i < len; i++) {
            if(memo[len-1][i] < result) {
                result = memo[len-1][i];
            }
        }
        return result;
    }
}