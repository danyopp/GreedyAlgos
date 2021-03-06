import java.util.ArrayList;

public class ScheduleDeadline {
    //must complete a job by deadline in order to receive payoff
    //job has a time component and a deadline
    //want to maximize the payoff
    //want to maximize the number of jobs

    //sort based on payoff
    //take shortest jobs with earliest end time
    //take jobs with earliest start time
    //Not optimal but mostly optimal





    public static void main(String[] args) {
        ArrayList<Job> jList = new ArrayList<Job>();
        jList.add(new Job(3,2,5));
        jList.add(new Job(7,1,9));
        jList.add(new Job(1,4,6));
        jList.add(new Job(5,7,6));
        jList.add(new Job(5,4,7));
        jList.add(new Job(6,9,9));

        for(Job j : jList){
            j.print();
        }

        System.out.println("Greedy based on Start Time");
        startTimeSort greedyLength = new startTimeSort(jList);
        greedyLength.Greedy();

        System.out.println("Greedy based on End Time");
        endTimeSort greedyLength2 = new endTimeSort(jList);
        greedyLength2.Greedy();

        System.out.println("Greedy based on Max Payout");
        PayoffSort greedyLength3 = new PayoffSort(jList);
        greedyLength3.Greedy();


    }





}
