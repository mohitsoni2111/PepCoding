// https://www.youtube.com/watch?v=7IbWTFOUP1U&list=PL-Jc9J83PIiFj7YSPl2ulcpwy-mwj1SSk&index=34

package DSA_Level_1;

import java.util.Scanner;

public class Benjamin_bulbs {

    public static void benjaminBulbs(int nthFluctuation){
        for(int i = 1; i<= Math.sqrt(nthFluctuation); i++){
            System.out.println(i*i);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nthFluctuation = sc.nextInt();
        benjaminBulbs(nthFluctuation);
    }
}
