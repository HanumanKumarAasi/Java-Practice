package concepts.greedy.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NmeetingsInOneRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
	
	//TC: O(NlogN+N) SC:O(N)
    public static int maxMeetings(int start[], int end[], int n)
    {
        
        if(n<1){//when no meeting return 0
            return 0;
        }else if(n==1){//when one meeting return 1
            return 1;
        }
        
        // add your code here
        //adding all the meeting details objs to the list
        ArrayList<MeetingDetails> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new MeetingDetails(start[i],end[i],i));
        }
        
        
        //sorting the meeting details based on end time in ascending order
        
        Comparator<MeetingDetails> comparator = (a,b)->(a.endTime-b.endTime);
        
        //O(NlogN)
        Collections.sort(list,comparator);
        
        //list to store what meetings held
        ArrayList<Integer> meetingsHeld = new ArrayList<>();
        
        //at 0 time we start with minimum end time meeting first
        int meetingRoomFreeTime = list.get(0).endTime; //meeting room free time
        int count=1; //counter for meetings that held
        meetingsHeld.add(list.get(0).meetingNumber);
        
        //O(N)
        for(int i=1;i<n;i++){
            
            MeetingDetails curr = list.get(i);//current meeting
            
            if(curr.startTime>meetingRoomFreeTime){ //curr meeting start time is > prev meeting end time
                count++; //if condition matches incrementing the count
                meetingsHeld.add(list.get(i).meetingNumber); //adding meeting position meeting completed list
                meetingRoomFreeTime = curr.endTime; //curr meetingRoom free time will curr meeting end time
            }
            
        }
        
        return count; // returning count
    }
}
//class obj for storing the meeting details
class MeetingDetails{
    int startTime;
    int endTime;
    int meetingNumber;
    
    MeetingDetails(int s, int e, int m){
        startTime = s;
        endTime = e;
        meetingNumber = m;
    }
}
