import java.util.ArrayList;
import java.util.Collections;

public class Job {

    int start;
    int end;
    int duration;
    int payoff;
    int jobID;
    static int curID = 0;

    Job(int s, int p){
        this.start = s;
        this.payoff = p;
        this.jobID = curID;
        curID++;
    }

    Job( int s, int p, int e){
        this(s, p);
        this.duration = e - s;
        this.end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
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

    public static void sortJobListByStart(ArrayList<Job> j){
        Collections.sort(j, (o1, o2) -> Integer.compare(o1.getStart(), o2.getStart()));
    }

    public static void sortJobListByEnd(ArrayList<Job> j){
        Collections.sort(j, (o1, o2) -> Integer.compare(o1.getEnd(), o2.getEnd()));
    }

    public void print(){
        System.out.println("Start: " + this.start + " | End: " + this.end + " | Duration: " + this.duration + " | Payout: " + this.payoff);
    }

}
