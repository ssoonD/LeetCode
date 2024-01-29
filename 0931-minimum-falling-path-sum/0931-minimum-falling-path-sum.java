class Solution {
    int[][] memo;
    
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        init(len);
        for(int i = 0; i < len; i++) {
            dp(matrix, len, 0, i, 0);
        }
        return solve(len);
    }
    
    public void init(int len) {
        memo = new int[len][len];
        for(int i = 0; i< len; i++) {
            for(int j = 0; j < len; j++) {
                memo[i][j] = 10001;
            }
        }
    }
    
    public void dp(int[][] matrix, int len, int row, int col, int sum) {
        // 범위 초과 시 종료
        if(row < 0 || row >= len || col < 0 || col >= len) {
            return;
        }
        
        // memo에 저장한 값보다 작은 경우 바꿔주기
        int minSum = sum + matrix[row][col];
        if(minSum < memo[row][col]) { // 작은 경우 저장
            memo[row][col] = minSum;
        } else { // 큰 경우 return
            return;
        }
        
        dp(matrix, len, row + 1, col - 1, memo[row][col]);
        dp(matrix, len, row + 1, col, memo[row][col]);
        dp(matrix, len, row + 1, col + 1, memo[row][col]);
    }
    
    public int solve(int len) {
        int result = 10001;
        for(int i = 0; i < len; i++) {
            if(memo[len-1][i] < result) {
                result = memo[len-1][i];
            }
        }
        return result;
    }
}