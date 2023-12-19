public class MaxPointsRemovalMemoization {
    public static int maxPoints(int[] A) {
        int n = A.length;
        int[] extendedA = new int[n + 2];
        extendedA[0] = 1;
        extendedA[n + 1] = 1;
        System.arraycopy(A, 0, extendedA, 1, n);

        // Create a memoization table to store calculated values
        int[][] memo = new int[n + 2][n + 2];

        // Initialize memo table with -1 to indicate that values are not calculated yet
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }

        return memoizedDP(1, n, extendedA, memo);
    }

    private static int memoizedDP(int i, int j, int[] A, int[][] memo) {
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int maxPoints = 0;
        for (int k = i; k <= j; k++) {
            maxPoints = Math.max(maxPoints, memoizedDP(i, k - 1, A, memo) + A[i - 1] * A[k] * A[j + 1] + memoizedDP(k + 1, j, A, memo));
        }

        memo[i][j] = maxPoints;
        return maxPoints;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 5, 8};
        int result = maxPoints(A);
        System.out.println(result); // Output will be the maximum total number of points
    }
}
