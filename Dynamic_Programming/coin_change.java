package Dynamic_Programming;

public class coin_change {
    static int minCoins(int[] C, int m, int V) {
        int[] table = new int[V + 1];

        table[0] = 0;

        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all values from 1 to V
        for (int i = 1; i <= V; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++){
                if (C[j] <= i) {
                    int sub_res = table[i - C[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
            }
        }

        if(table[V]==Integer.MAX_VALUE)
            return -1;

        return table[V];

    }
    public static void main (String[] args) {
        int[] coins = {1,2,3};
        int m = coins.length;
        int V = 5;
        System.out.println ( "Minimum coins required is "
                + minCoins(coins, m, V));
    }
}
