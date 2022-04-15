package Dynamic_Programming;

import java.util.Scanner;

public class Paint_Fence {

    private static long paintFence(long n, long k) {
        long same = k * 1;
        long diff = k * (k - 1);
        long total = same + diff;

        for (int i = 3; i <=n; i++){
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long k = sc.nextInt();
        long ans = paintFence(n, k);
        System.out.println(ans);
    }
}

