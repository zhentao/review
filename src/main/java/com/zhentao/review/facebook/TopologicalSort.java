package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有n个job, with id 1-n。每个job的prerequisite job
 * id都给出来了，只有当这个job的所有前置job都做完了，这个才可以开始，同时每个job有一个execution
 * time。现在假设有infinite个worker，问最快什么时候可以完成所有job。举例 job#1需要2秒，job #2需要3秒，job
 * #3需要4秒，同时#3的前置job是#1, 那么最快需要6s才能完成。 这个不难，topological sort 就秒了
 *
 * @author zhentao.li
 *
 */
public class TopologicalSort {
    public static void main(String[] args) {
        Job job1 = new Job(1, 2);
        Job job2 = new Job(2, 3);
        Job job3 = new Job(3, 4);
        job3.addDependencies(job1);
        job1.addDependencies(job2);
        List<Job> jobs = Arrays.asList(job1, job2, job3);
        System.out.println(new TopologicalSort().maxTime(jobs));
    }
    public int maxTime(List<Job> jobs) {
        Map<Job, Integer> memo = new HashMap<>();
        int max = 0;
        for (Job job : jobs) {
            max = Math.max(max, maxTime(job, memo));
        }
        return max;
    }

    int maxTime(Job job, Map<Job, Integer> memo) {
        if (memo.containsKey(job)) {
            return memo.get(job);
        }
        int max = 0;

        for (Job dep: job.dependencies) {
            max = Math.max(max, maxTime(dep, memo));
        }
        memo.put(job, job.time + max);
        return memo.get(job);
    }

     private static class Job {
        int jobId;
        int time;
        List<Job> dependencies;

        Job(int jobId, int time) {
            this.jobId = jobId;
            this.time = time;
            dependencies = new ArrayList<>();
        }

        void addDependencies(Job dep) {
            dependencies.add(dep);
        }

        @Override
        public int hashCode() {
            return jobId;
        }

        @Override
        public boolean equals(Object other) {
            return jobId == ((Job)other).jobId;
        }
    }
}
