package Dynamic_Programming;

import java.util.Scanner;

public class Arrange_Buildings {

    private static long arrangeBuildings(int n) {
        int OldCountBuilding = 1;
        int OldCountSpace = 1;

        for (int i = 2; i <= n; i++){
            int newCountZeros = OldCountSpace;
            int newCountOnes = OldCountBuilding + OldCountSpace;
            OldCountBuilding = newCountZeros;
            OldCountSpace = newCountOnes;
        }
        long total = OldCountBuilding + OldCountSpace;
        return total * total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = arrangeBuildings(n);
        System.out.println(ans);
    }
}
