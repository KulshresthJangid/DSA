package easy;

import java.util.*;

public class Arrays {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
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

    // Add two binary strings
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

    // 136. Single Number
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0;
        int ans=-1;
        while(i<nums.length) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            i++;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) {
                ans=entry.getKey();
            }
        }
        System.out.println(ans);
        return ans;
    }

    // 168. Excel Sheet Column Title(column number)
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0) {
            int rem=columnNumber%26;
            if(rem==0) {
                sb.append("Z");
                columnNumber=(columnNumber/26)-1;
            } else {
                sb.append((char)(rem-1+'A'));
                columnNumber=columnNumber/26;
            }
        }
        return sb.reverse().toString();
    }

    // 171. Excel Sheet Column Number
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++)
        {
            result *= 26;
            result += columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }

    // 202. Happy Number
    public static boolean isHappy(int n) {
//        String temp = String.valueOf(n);
//        int square=0;
//        while(!temp.equals("1")) {
//            for (int i=0;i<temp.length();i++) {
//                int value=Character.getNumericValue(temp.charAt(i))*Character.getNumericValue(temp.charAt(i));
//                square+=value;
//            }
//            temp=String.valueOf(square);
//            square=0;
//        }
//        if(temp.equals("1")) {
//            return true;
//        }
//        return false;
        int sum=0;
        while(n>0)
        {
            sum+=(n%10)*(n%10);
            n/=10;
            if(sum>9&&n==0)
            {
                n=sum;
                sum=0;
            }
        }
        if(sum==1||sum==7)
            return true;
        else
            return false;
    }

}
