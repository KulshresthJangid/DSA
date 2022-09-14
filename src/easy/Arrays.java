package easy;

import com.sun.jdi.IntegerType;

import java.util.*;

public class Arrays {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
    // 1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        // goal is to find the indexes of two numbers that add up to the target
        int[] ans = new int[2];
        int rest=0;
        // convert to arrayList
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        for (int i=0;i<nums.length;i++) {
            rest=target-nums[i];
            if(list.contains(rest) && list.indexOf(rest)!=i) {
                ans[0]=i;
                ans[1]=list.indexOf(rest);
            }
        }
        return ans;
    }

    // 53. Maximum Subarray
    public static int maxSubArray(int[] nums) {
        return 1;
    }

    // 13. Roman to integer
    public static int romanToString(String s) {
        int sum = 0;
        int previous = 0;
        int current = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char letter = s.charAt(i);
            switch (letter) {
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
            }
            sum = current >= previous ? sum + current : sum - current;
            previous = current;
        }
        return sum;
    }

    // 14. Longest common prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

}
