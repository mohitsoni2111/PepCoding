package Level_2.Bit_Manipulation;

/*
Input: pref = [5,2,0,3,1]
Output: [5,7,2,3,2]
Explanation: From the array [5,7,2,3,2] we have the following:
- pref[0] = 5.
- pref[1] = 5 ^ 7 = 2.
- pref[2] = 5 ^ 7 ^ 2 = 0.
- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
 */

public class Find_The_Original_Array_of_Prefix_Xor_2433 {
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        for (int i = 1; i < pref.length; i++){
            ans[i] = pref[i-1]^pref[i];
        }
        return ans;
    }
}
