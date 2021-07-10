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
        Job.sortJobListByPayoff(joblist);

        int nextAvailable = -1;
        for(int i = 0; i < joblist.size(); i++){
            Job j = joblist.get(i);
            if(checkIfAvailable(j.getStart(), j.getEnd())){
                markAvailable(j.getStart(),j.getEnd());
                results.add(j);
            }
        }

        for(Job j : results){
            j.print();
        }

//        int i = 0;
//        for(boolean b : availability){
//            System.out.println(i + ": " + b);
//            i++;
//        }
    }

    private boolean checkIfAvailable(int start, int end){
        if(availability.length < start || availability.length < end || start < 0 || end < 0){
            throw new IllegalStateException();
        }
        for (int i = start; i <= end; i++){
            if(availability[i]){
                return false;
            }
        }
        return true;
    }

    private void markAvailable(int start, int end){
        if(availability.length < start || availability.length < end || start < 0 || end < 0){
            throw new IllegalStateException();
        }
        for (int i = start; i <= end; i++){
            availability[i] = true;
        }
    }

}
