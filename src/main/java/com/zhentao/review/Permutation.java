package com.zhentao.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4};
//        ArrayList<ArrayList<Integer>> list = permArray(array);
//        System.out.println(list.size());

        int Nr[] = {1,2,3,4 };
        List<int[]> list = permuteArray(Nr);
        System.out.println(list.size());
//        for (ArrayList<Integer> subList : list) {
//            System.out.println(subList);
//        }
    }

    public static void perm1(String s) {
        Set<String> set = new LinkedHashSet<String>();
        perm1("", s, set);
        for (String str : set) {
            System.out.println(str);
        }
    }

    private static void perm1(String prefix, String s, Set<String> set) {
        int N = s.length();
        if (N == 0) {
            //System.out.println(prefix);
            set.add(prefix);
        }
        else {
            for (int i = 0; i < N; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N), set);
        }

    }



    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        int[] output = new int[num.length];
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        permute(output, num, 0, list);
        return list;

    }
    private static void permute(int[] output, int[] num, int idx, ArrayList<ArrayList<Integer>> list) {
        if (idx == output.length) {  //stop condition for the recursion [base clause]
            System.out.println(Arrays.toString(output));
            ArrayList<Integer> subList = new ArrayList<Integer>();
            for (int element : output) {
                subList.add(element);
            }
            list.add(subList);
        }
        for (int i = 0; i < num.length; i++) {
            output[idx] = num[i];
            int [] a = new int[num.length -1];
            System.arraycopy(num, 0, a, 0, i);
            System.arraycopy(num, i+1, a, i, num.length - i -1);
            permute(output, a, idx+1, list); //recursive invokation, for next elements
        }
    }

    public static List<int[]> permuteArray(int[] num) {
        int[] output = new int[num.length];
        List<int[]> list = new ArrayList<int[]>();
        permute(output, num, 0, list);
        return list;

    }
    private static void permute(int[] output, int[] num, int idx, List<int[]> list) {
        if (idx == output.length) {  //stop condition for the recursion [base clause]
            //System.out.println(Arrays.toString(output));
            int[] result = Arrays.copyOf(output, output.length);
            list.add(result);
        }
        for (int i = 0; i < num.length; i++) {
            output[idx] = num[i];
            int [] a = new int[num.length -1];
            System.arraycopy(num, 0, a, 0, i);
            System.arraycopy(num, i+1, a, i, num.length - i -1);
            permute(output, a, idx+1, list); //recursive invokation, for next elements
        }
    }
}
