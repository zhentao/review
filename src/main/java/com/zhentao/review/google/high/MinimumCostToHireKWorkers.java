package com.zhentao.review.google.high;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <b>857. Minimum Cost to Hire K Workers</b>
 * 
 * <pre>
 * There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 
 

Note:

1 <= K <= N <= 10000, where N = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10^-5 of the correct answer will be considered correct.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(final int[] quality, final int[] wage, final int K) {
        final int length = quality.length;
        final Worker[] workers = new Worker[length];
        final double[] price = new double[length];
        for (int i = 0; i < length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        double minPrice = Double.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            final double ratio = workers[i].wageQualityRatio;
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (ratio >= workers[j].wageQualityRatio) {
                    price[j] = ratio * workers[j].quality;
                    count++;
                } else {
                    price[j] = Double.MAX_VALUE;
                }
            }
            if (count >= K) {
                Arrays.sort(price);
                double temp = 0;
                for (int j = 0; j < K; j++) {
                    temp += price[j];
                }
                minPrice = Math.min(minPrice, temp);
            }
        }
        return minPrice;
    }

    public double mincostToHireWorkers2(final int[] quality, final int[] wage, final int K) {
        final int N = quality.length;
        final Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.wageQualityRatio, b.wageQualityRatio));

        double ans = Double.MAX_VALUE;
        int sumq = 0;
        final PriorityQueue<Integer> pool = new PriorityQueue<>((a,b) -> b -a);
        for (final Worker worker : workers) {
            pool.offer(worker.quality);
            sumq += worker.quality;
            if (pool.size() > K) {
                final int q = pool.poll();
                sumq -= q;
            }
            if (pool.size() == K) {
                //since workers are sorted, it discards the first k-1 lowest ratio
                ans = Math.min(ans, sumq * worker.wageQualityRatio);
            }
        }

        return ans;
    }

    class Worker {
        int quality;
        int wage;
        double wageQualityRatio;

        public Worker(final int quality, final int wage) {
            this.quality = quality;
            this.wage = wage;
            wageQualityRatio = wage * 1.0 / quality;
        }
    }
}
