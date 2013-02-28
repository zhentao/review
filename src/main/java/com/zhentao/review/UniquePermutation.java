package com.zhentao.review;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniquePermutation {
    public static void main(String[] args) {

      int Nr[] = {1,1, 2 };
      ArrayList<ArrayList<Integer>> list = permute(Nr);
      System.out.println(list.size());
      for (ArrayList<Integer> subList : list) {
          System.out.println(subList);
      }
  }
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        int[] n = new int[num.length];
        Set<ArrayList<Integer>> list = new LinkedHashSet<ArrayList<Integer>>();
        permute(n, num, 0, list);
        return new ArrayList<ArrayList<Integer>> (list);

    }
    private static void permute(int[] n, int[] num, int idx, Set<ArrayList<Integer>> list) {
        if (idx == n.length) {  //stop condition for the recursion [base clause]
            //System.out.println(Arrays.toString(n));
            ArrayList<Integer> subList = new ArrayList<Integer>();
            for (int element : n) {
                subList.add(element);
            }
            list.add(subList);
        }
        for (int i = 0; i < num.length; i++) {
            n[idx] = num[i];
            int [] a = new int[num.length -1];
            System.arraycopy(num, 0, a, 0, i);
            System.arraycopy(num, i+1, a, i, num.length - i -1);
            permute(n, a, idx+1, list); //recursive invokation, for next elements
        }
    }
}
