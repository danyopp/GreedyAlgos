import java.util.ArrayList;
import java.util.Collections;

public class Job {

    int duration;
    int payoff;
    int jobID;
    static int curID = 0;

    Job(int d, int p){
        this.duration = d;
        this.payoff = p;
        this.jobID = curID;
        curID++;
    }

    public int getDuration() {
        return duration;
    }

    public int getPayoff() {
        return payoff;
    }

    public int getJobID() {
        return jobID;
    }

    public static void sortJobListByPayoff(ArrayList<Job> j){
        Collections.sort(j, (o1, o2) -> -Integer.compare(o1.getPayoff(), o2.getPayoff()));
    }

    public static void sortJobListByDuration(ArrayList<Job> j){
        Collections.sort(j, (o1, o2) -> -Integer.compare(o1.getDuration(), o2.getDuration()));
    }

}
