package DSA_Level_1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Pythgorean_triplet_in_array {

    public static boolean isTriplet_using_Sorting(int arr[]){
        int n = arr.length;

        // Squaring
        for (int i= 0; i< n; i++)
            arr[i] = arr[i] * arr[i];

        Arrays.sort(arr);

        // Two pointers from either ends of array
        for(int i = n-1; i>=2 ; i++){
            int left = 0;
            int right = i-1;
            while (left < right){
                if(arr[left] + arr[right] == arr[i])
                    return true;

                if(arr[left] + arr[right] < arr[i])
                    left++;
                else
                    right--;
            }
        }
        return false;
    }

    public static boolean isTriplet_using_Hashing(int arr[]){
        int max = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i<n; i++){
            max = Math.max(max, arr[i]);
        }

        // Hashing array
        int[] hash = new int[max+1];
                                                                    //   i   i i i
        // Increase the count of array elements in hash table // Make [0,1,0,1,1,1,0] -> hash
        for (int i=0; i<n; i++)                                     //   j j j j j j
            hash[arr[i]]++;

        for (int i=1; i<max+1; i++){
            if (hash[i]==0)
                continue;

            for (int j=1; j<max+1; j++){

                // If a and b are same and there is only one a || there is no b in original array
                if((i==j && hash[i] == 1) || hash[j]==0)
                    continue;

                // Find c
                int val = (int)Math.sqrt(i*i + j*j);

                // If c2 is not a perfect square
                if((val*val) != (i*i + j*j))
                    continue;

                // If c exceeds the max value
                if(val > max)
                    continue;

                if(hash[val] == 1)
                    return true;
            }
        }
        return false;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 6, 5 };

        System.out.println(isTriplet_using_Sorting(arr));
        System.out.println(isTriplet_using_Hashing(arr));
    }
}
