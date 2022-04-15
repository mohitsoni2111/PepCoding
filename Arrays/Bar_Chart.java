package Arrays;

import java.util.Scanner;

public class Bar_Chart {

    static void barChart(int arr[]){
        int size = arr.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<size; i++){
            max = Math.max(max, arr[i]);
        }
        for(int floor = max; floor >= 1 ; floor--){
            for(int i = 0; i < size; i++){
                if(arr[i] >= floor)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        barChart(arr);
    }
}
