package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * <b>721. Accounts Merge</b>
 * 
 * <pre>
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] 
 * is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is 
some email that is common to both accounts. Note that even if two accounts have the same name, they may belong 
to different people as people could have the same name. A person can have any number of accounts initially, 
but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is 
the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in 
any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 * </pre>
 * 
 * @author zhentao
 *
 */
public class AccountMerge {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> graph = new HashMap<>();
        String email = "test";
        graph.computeIfAbsent(email, x -> new ArrayList<String>()).add("test2");
        graph.computeIfAbsent(email, x -> new ArrayList<String>()).add("test2");
        System.out.println(graph);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, HashSet<TreeSet<String>>> maps = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            List<String> newEmails = account.subList(1, account.size());
            if (!maps.containsKey(name)) {
                HashSet<TreeSet<String>> accountSet = new HashSet<>();
                accountSet.add(new TreeSet<String>(newEmails));
                maps.put(name, accountSet);

                // maps.computeIfAbsent(name, k -> new HashSet<TreeSet<String>>()).add(new
                // TreeSet<String>(newEmails));
            } else {
                HashSet<TreeSet<String>> accountSet = maps.get(name);
                merge(accountSet, newEmails);
            }
        }
        return convertMaptoList(maps);
    }

    private void merge(HashSet<TreeSet<String>> accountSet, List<String> newEmails) {
        ArrayList<TreeSet<String>> toBeMerged = new ArrayList<>();
        for (String newEmail : newEmails) {
            for (TreeSet<String> emails : accountSet) {
                if (emails.contains(newEmail)) {
                    toBeMerged.add(emails);
                }
            }
        }
        TreeSet<String> newAccount = new TreeSet<String>(newEmails);

        for (TreeSet<String> set : toBeMerged) {
            newAccount.addAll(set);
            accountSet.remove(set);
        }
        accountSet.add(newAccount);
    }

    private List<List<String>> convertMaptoList(HashMap<String, HashSet<TreeSet<String>>> maps) {
        List<List<String>> accounts = new ArrayList<>();
        for (String name : maps.keySet()) {
            for (TreeSet<String> emails : maps.get(name)) {
                ArrayList<String> account = new ArrayList<>();
                accounts.add(account);
                account.add(name);
                for (String email : emails) {
                    account.add(email);
                }
            }
        }
        return accounts;
    }

    /**
     * DFS
     * 
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x -> new HashSet<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x -> new HashSet<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> component = new ArrayList<>();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei : graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

    /**
     * union find
     * 
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge3(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        // Key is the parent's email
        Map<String, TreeSet<String>> unions = new HashMap<>();

        // set parent as itself for each email
        for (List<String> a : accounts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                emailToName.put(a.get(i), a.get(0));
            }
        }

        // set parent as first email's parent for all emails in the same account
        // if an email already has the parent (not itself)
        for (List<String> a : accounts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++) {
                String email = a.get(i);
                String parent = find(email, parents);
                parents.put(parent, p);
            }
        }

        // group by parent for all emails. The first email is most likely the parent
        // because it is used as parent initially.
        for (List<String> a : accounts) {
            String p = find(a.get(1), parents);
            for (int i = 1; i < a.size(); i++) {
                unions.computeIfAbsent(p, k -> new TreeSet<>()).add(a.get(i));
            }
        }
        
        //generate the result in required format
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList<>();
            emails.add(0, emailToName.get(p));
            emails.addAll(unions.get(p));
            res.add(emails);
        }
        return res;
    }

    private String find(String s, Map<String, String> p) {
        String parent = p.get(s);
        return parent == s ? s : find(parent, p);
    }
}
