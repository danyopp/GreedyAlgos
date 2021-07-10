import java.util.ArrayList;

public class endTimeSort {

    ArrayList<Job> joblist;

    endTimeSort(ArrayList<Job> joblist){
        this.joblist = new ArrayList<Job>();
        this.joblist = (ArrayList<Job>)joblist.clone();
    }

    public void Greedy(){

        ArrayList<Job> results = new ArrayList<Job>();
        Job.sortJobListByStart(joblist); // to maximize schedule
        Job.sortJobListByEnd(joblist);

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

        for(Job j : results){
            j.print();
        }


    }

}
