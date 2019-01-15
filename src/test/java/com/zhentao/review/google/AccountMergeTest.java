package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AccountMergeTest {
    private AccountMerge merge;

    @Before
    public void setup() {
        merge = new AccountMerge();
    }

    @Test
    public void test() {
        String[][] input = { { "John", "johnsmith@mail.com", "john00@mail.com" }, { "John", "johnnybravo@mail.com" },
                { "John", "johnsmith@mail.com", "john_newyork@mail.com" }, { "Mary", "mary@mail.com" } };
        List<List<String>> lists = fromArray(input);

        System.out.println(merge.accountsMerge(lists));
        System.out.println(merge.accountsMerge2(lists));
        System.out.println(merge.accountsMerge3(lists));
        System.out.println();
    }

    @Test
    public void test2() {
        String[][] input = { { "Ethan", "Ethan1@m.co", "Ethan2@m.co", "Ethan0@m.co" },
                { "David", "David1@m.co", "David2@m.co", "David0@m.co" },
                { "Lily", "Lily0@m.co", "Lily0@m.co", "Lily4@m.co" },
                { "Gabe", "Gabe1@m.co", "Gabe4@m.co", "Gabe0@m.co" },
                { "Ethan", "Ethan2@m.co", "Ethan1@m.co", "Ethan0@m.co" } };

        System.out.println(merge.accountsMerge(fromArray(input)));
        System.out.println(merge.accountsMerge2(fromArray(input)));
        System.out.println(merge.accountsMerge3(fromArray(input)));
        System.out.println();
    }

    @Test
    public void test3() {
        String[][] input = { { "Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co" },
                { "Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co" },
                { "Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co" },
                { "Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co" },
                { "Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co" } };

        System.out.println(merge.accountsMerge(fromArray(input)));
        System.out.println(merge.accountsMerge2(fromArray(input)));
        System.out.println(merge.accountsMerge3(fromArray(input)));
        System.out.println();
    }

    @Test
    public void test4() {
        String[][] input = { { "David", "David0@m.co", "David4@m.co", "David3@m.co" },
                { "David", "David5@m.co", "David5@m.co", "David0@m.co" },
                { "David", "David1@m.co", "David4@m.co", "David0@m.co" },
                { "David", "David0@m.co", "David1@m.co", "David3@m.co" },
                { "David", "David4@m.co", "David1@m.co", "David3@m.co" } };

        System.out.println(merge.accountsMerge(fromArray(input)));
        System.out.println(merge.accountsMerge2(fromArray(input)));
        System.out.println(merge.accountsMerge3(fromArray(input)));
        System.out.println();
    }

    private List<List<String>> fromArray(String[][] array) {
        List<List<String>> lists = new ArrayList<>();
        for (String[] account : array) {
            List<String> list = new ArrayList<>();
            lists.add(list);
            list.add(account[0]);
            for (int i = 1; i < account.length; i++) {
                list.add(account[i]);
            }
        }

        return lists;
    }

}
