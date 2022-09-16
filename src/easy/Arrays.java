package easy;

import java.util.*;

public class Arrays {

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
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

    // 20. Valid Paranthesis
    public boolean isValid(String s) {
        if(s.length()==0 || s.length()%2!=0)  return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            else {
                if(s.charAt(i) == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                }
                if(s.charAt(i) == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                }
                if(s.charAt(i) == '}') {
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 27. Remove Element
    public static int removeElement(int[] nums, int val) {
        int i=0;
        int j=0;
        int n=0;
        int status=0;
        for(int k=0;k<nums.length;k++) {
            if(nums[k]==val) {
                status=1;
            }
        }
        while(n<nums.length) {
            if(status==1) {
                if(nums[i]==val && nums[j]==val) {
                    j++;
                } else if(nums[i]==val && nums[j]!=val) {
                    nums[i]=nums[j];
                    nums[j]=val;
                    i++;
                    j++;
                } else {
                    i++;
                    j++;
                }
                n++;
            } else {
                return nums.length;
            }
        }
        return i;
    }

    // 58. Length of Last Word
    public static int lengthOfLastWord(String s) {
        String[] strArr=s.split(" ");
        return strArr[strArr.length-1].length();
    }

    public static String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        int sum=0;
        StringBuilder sb = new StringBuilder("");

        while(i>=0 || j>=0) {
            sum=carry;
            if(i>=0) sum+=a.charAt(i)-'0';
            if(j>=0) sum+=b.charAt(j)-'0';
            sb.append(sum%2);
            carry=sum/2;

            i--;
            j--;
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }

    // 70. Climbing Stairs
    static int climbStairs(int n) {
        if(n==1 || n==2 || n==3) return n;
        int i=1;
        int j=2;
        int k=2;
        int sum=0;


        while(k!=n) {
            sum=i+j;
            i=j;
            j=sum;
            k++;
        }
        return sum;
    }

}
