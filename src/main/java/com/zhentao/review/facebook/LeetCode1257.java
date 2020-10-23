package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <b>LeetCode 1257. Smallest Common Region</b> You are given some lists of
 * regions where the first region of each list includes all other regions in
 * that list.
 *
 * Naturally, if a region X contains another region Y then X is bigger than Y.
 * Also by definition a region X contains itself.
 *
 * Given two regions region1, region2, find out the smallest region that
 * contains both of them.
 *
 * If you are given regions r1, r2 and r3 such that r1 includes r3, it is
 * guaranteed there is no r2 such that r2 includes r3.
 *
 * It's guaranteed the smallest region exists.
 *
 * <pre>
Example 1:

Input:
regions = [["Earth","North America","South America"],
["North America","United States","Canada"],
["United States","New York","Boston"],
["Canada","Ontario","Quebec"],
["South America","Brazil"]],
region1 = "Quebec",
region2 = "New York"
Output: "North America"

Constraints:

    2 <= regions.length <= 10^4
    region1 != region2
    All strings consist of English letters and spaces with at most 20 letters.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1257 {
    public static void main(String[] args) {
        List<List<String>> regions = new ArrayList<>();
        regions.add(Arrays.asList("Earth","North America","South America"));
        regions.add(Arrays.asList("North America","United States","Canada"));
        regions.add(Arrays.asList("United States","New York","Boston"));
        regions.add(Arrays.asList("Canada","Ontario","Quebec"));
        regions.add(Arrays.asList("South America","Brazil"));
        LeetCode1257 lc = new LeetCode1257();
        System.out.println(lc.findSmallestRegion(regions, "Quebec", "New York"));
    }
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> childToParent = new HashMap<>();
        for (List<String> subList : regions) {
            String parent = subList.get(0);
            for (int i = 1; i < subList.size(); i++) {
                childToParent.put(subList.get(i), parent);
            }
        }

        Set<String> region1Parents = new HashSet<>();
        String p1 = region1;
        while(p1 != null) {
            region1Parents.add(p1);
            p1 = childToParent.get(p1);
        }

        String p2 = region2;
        while(!region1Parents.contains(p2)) {
            p2 = childToParent.get(p2);
        }
        return p2;
    }

}
