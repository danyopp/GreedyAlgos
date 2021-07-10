import java.util.ArrayList;

public class PayoffSort {

    ArrayList<Job> joblist;
    boolean[] availability;


    PayoffSort(ArrayList<Job> joblist){
        this.joblist = new ArrayList<Job>();
        this.joblist = (ArrayList<Job>)joblist.clone();

        int startTime = -1;
        int stopTime = -1;
        for (Job j : this.joblist){
            if (startTime == -1){
                startTime = j.getStart();
            }
            else if(startTime > j.getStart()){
                startTime = j.getStart();
            }
            if (stopTime == -1){
                stopTime = j.getEnd();
            }
            else if(stopTime < j.getEnd()) {
                stopTime = j.getEnd();
            }
        }
        availability = new boolean[stopTime+1];
        for(int i = 0 ; i < startTime ; i++){
            availability[i] = true;
        }
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

    private boolean checkIfAvailable(int start, int end){

    }

    private void markAvailable(int start, int end){

    }

}
