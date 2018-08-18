package company.wangyi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class FindJobTest {

    @Test
    public void helper() {

        List<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job(2,200));
        jobs.add(new Job(6,800));
        jobs.add(new Job(7,700));
        jobs.add(new Job(9,900));
        jobs.add(new Job(10,1000));

        System.out.println(FindJob.helper(8, (ArrayList<Job>) jobs));

    }
}