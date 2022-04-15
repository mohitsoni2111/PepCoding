package DSA_Level_1;

public class GCD_or_HCF {

    // Euclidean's algo
    static int gcd_Euclidean(int a, int b){
        if(a==0) return b;
        if(b==0) return a;

        // Base case
        if(a==b) return a;

        // a is greater
        if(a>b)
            return gcd_Euclidean(a-b, b);

        return gcd_Euclidean(a, b-a);
    }

    // Efficient Euclidean
    static int gcd_Adv_Euclidean(int a, int b){
        if(b==0) return a;
        return gcd_Adv_Euclidean(a, a % b);
    }

    // Dynamic Programming Approach (Top Down Using Memoization) :
    static int[][] dp = new int[1001][1001];

    static int gcd_dynamic(int a, int b){
        if(a==0) return b;
        if(b==0) return a;

        // Base case
        if(a==b) return a;

        // If a value is already presented in dp
        if(dp[a][b] != -1)
            return dp[a][b];

        // a is greater
        if(a>b)
            dp[a][b] = gcd_dynamic(a-b, b);
        else
            dp[a][b] = gcd_dynamic(a, b-a);

        return dp[a][b];
    }


    // Driver method
    public static void main(String[] args){
        int a = 98, b = 56;
        System.out.println("GCD of " + a +" and " + b + " is " + gcd_Euclidean(a, b));
        System.out.println("GCD of " + a +" and " + b + " is " + gcd_Adv_Euclidean(a, b));

        for(int i= 0; i<a; i++){
            for(int j=0; j<b; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("GCD of " + a +" and " + b + " is " + gcd_dynamic(a, b));
    }
}
