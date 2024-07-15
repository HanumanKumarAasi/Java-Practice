package concepts.greedy.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NonOverlappingIntervalsSolution {
	//TC: O(NlogN+N) SC: O(N)
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n<=1){//when no meeting return 0
            return 0;
        }        
        // add your code here
        //adding all the meeting details objs to the list
        ArrayList<MeetingOverlapps> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new MeetingOverlapps(intervals[i][0],intervals[i][1]));
        }
        
        
        //sorting the meeting details based on end time in ascending order
        
        Comparator<MeetingOverlapps> comparator = (a,b)->(a.endTime-b.endTime);
        
        //O(NlogN)
        Collections.sort(list,comparator);
        
        //at 0 time we start with minimum end time meeting first
        int meetingRoomFreeTime = list.get(0).endTime; //meeting room free time
        int count=1; //counter for meetings that held
        
        //O(N)
        for(int i=1;i<n;i++){
            
            MeetingOverlapps curr = list.get(i);//current meeting
            //>= in this condition is the only change from the n meetings in a room problem
            if(curr.startTime>=meetingRoomFreeTime){ //curr meeting start time can be >= prev meeting end time
                count++; //if condition matches incrementing the count
               
                meetingRoomFreeTime = curr.endTime; //curr meetingRoom free time will curr meeting end time
            }
            
        }
        
        return n-count; // returning number of overlappes occurred
    }
}
//class obj for storing the meeting details
class MeetingOverlapps{
    int startTime;
    int endTime;
    
    MeetingOverlapps(int s, int e){
        startTime = s;
        endTime = e;
    }
}
