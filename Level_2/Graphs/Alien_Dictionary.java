package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alien_Dictionary {
    public static String alienOrder(String[] words) {




        return null;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = br.readLine().split(" ");

        System.out.println(alienOrder(words));
    }
}
