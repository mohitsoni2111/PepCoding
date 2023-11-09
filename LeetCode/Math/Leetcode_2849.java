package LeetCode.Math;

public class Leetcode_2849 {
    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);
        if (width == 0 && height == 0 && t == 1) {
            return false;
        }
        return t >= Math.max(width, height);
    }
    public static void main(String[] args){
        int sx = 1, sy = 1, fx = 2, fy = 2, t = 1;
        boolean ans = isReachableAtTime(sx, sy, fx, fy, t);
        System.out.println(ans);
    }
}
