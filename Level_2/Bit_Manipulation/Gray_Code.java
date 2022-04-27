package Level_2.Bit_Manipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Gray_Code {
    public static List<String> grayCode(int n) {
        if (n <= 0) {
            return new ArrayList<String>(){{add("0");}};
        }
        if (n == 1){
            return new ArrayList<String>(){{add("0");add("1");}};
        }

        List<String> rres = grayCode(n - 1);
        List<String> mres = new ArrayList<>();

        for (int i = 0; i < rres.size(); i++){
            String rstr = rres.get(i);
            mres.add("0" + rstr);
        }
        for (int i = rres.size() - 1; i >= 0 ; i--){
            String rstr = rres.get(i);
            mres.add("1" + rstr);
        }
        return mres;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<String> ans = grayCode(n);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
