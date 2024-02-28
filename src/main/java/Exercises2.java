import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int temp;

        int [] arr = new int [2];
        for(int i = 0; i < nums.length - 1; i++)
        {
            for(int j = 1; j + i < nums.length; j++)
            {
                temp = nums[i] + nums[i + j];
                if(temp == target)
                {
                    arr[0] = i;
                    arr[1] = i + j;
                    break;
                }
            }
        }
        return arr;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int num = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = romanMap.get(s.charAt(i));
            if (currValue < prevValue) {
                num -= currValue;
            } else {
                num += currValue;
            }
            prevValue = currValue;
        }

        return num;
    }
    /*

    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        f(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void f(int[] nums, List<Integer> currPermutation, List<List<Integer>> permutations) {
        if (currPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currPermutation));
            return;
        }
        for (int num : nums) {
            if (!currPermutation.contains(num)) {
                currPermutation.add(num);
                f(nums, currPermutation, permutations);
                currPermutation.remove(currPermutation.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}