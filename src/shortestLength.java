import java.util.ArrayList;
import java.util.List;

public class shortestLength {

    ArrayList<Job> joblist;

    shortestLength(ArrayList<Job> joblist){
        this.joblist = new ArrayList<Job>();
        this.joblist = (ArrayList<Job>)joblist.clone();
    }

    public void Greedy(){

        ArrayList<Job> results = new ArrayList<Job>();
        Job.sortJobListByStart(joblist);

        int nextAvailable = -1;
        for(int i = 0; i < joblist.size(); i++){
            Job j = joblist.get(i);
            if(nextAvailable == -1){
               nextAvailable = j.getEnd() + 1;
               results.add(j);
            }
            else if(j.getStart() >= nextAvailable){
                nextAvailable = j.getEnd()+1;
                results.add(j);
            }
        }
        System.out.println("-----------------");
        for(Job j : results){
            j.print();
        }


    }

}
