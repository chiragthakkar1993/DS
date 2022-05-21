package company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

/*
        For example, the period [10-3800] (in seconds) would be partitioned into the following time chunks with these frequencies:
        Minute (60 second chunks): [10-69], [70-129].....[3790-3800]
        Hour (60*60 second chunks): [10-3609], [3610-3800]
        Day (60*60*24 second chunks): [10-3800]

        You have to design and implement the following API:
        Class: PingFrequency
        Function: void recordPing(<string> userId, <integer> Time)
        Function: List<Integer> getUserPingsPerFrequency(<string> userId, <string> freq, <integer> startTime, <integer> endTime)

        Example:

        [user_id, timestamp(seconds)]
        """
        Map<String,Treeset<Integer>>
        User1 -> 5, 90, 110,

        ["user_1", 5]
        ["user_2", 15]
        ["user_2", 20]
        ["user_1", 90]
        ["user_3", 100]
        ["user_1", 110]
        ["user_3", 120]
        ["user_3", 170]
        ["user_2", 2500]
        ["user_3", 3600]
        ["user_3", 3800]
        """
        INPUT - getUserPingsPerFrequency("user_1", "minute", 60, 150)
        OUTPUT - [1, 0]
        Explanation: This is partitioned into [0-59, 60-119, 120-150] => Within the 0-59 window, the user pinged once, and within the 60-119 window, the user pinged twice in that window. They made no request in the last window, leading to final result of: [1, 2, 0]

        INPUT - getUserPingsPerFrequency("user_3", "hour", 10, 4000)
        OUTPUT - [4, 1]
        Explanation: This is partitioned into [10-3609, 3610-4000] => Within the 10-3609 window, the user pinged 4 times, and within the 3610-400 window, they made pinged once, leading to the final result of: [4, 1]

        class PingFrequency {
        public void recordPing(String userId, int time) {
        }

        getUserPingsPerFrequency(String userId, String freq, int startTime, int endTime) {
        }



 */
public class FindPingsPerFrequency {
    private HashMap<String, TreeSet<Integer>> pingsPerUser = new HashMap<>();
    private HashMap<String, Integer> freqToSeconds;
    public FindPingsPerFrequency() {
        freqToSeconds = new HashMap<>();
        freqToSeconds.put("hour",60 * 60);
        freqToSeconds.put("minute",60);
    }

    public  void recordPing(String userId, int time) {
        if(Objects.isNull(pingsPerUser.get(userId))) {
            TreeSet pingTime = new TreeSet<>();
            pingTime.add(time);
            pingsPerUser.put(userId, pingTime);
        }
        else
            pingsPerUser.get(userId).add(time);
    }

   public  int[] getUserPingsPerFrequency(String userId, String freq, int startTime, int endTime) {

        int pingCount[] = new int[(int) (Math.ceil( (double) (endTime-startTime)/freqToSeconds.get(freq)))];

       for (Integer pingTime:
            pingsPerUser.get(userId).subSet(startTime,true,endTime,true)) {
           int index = 0;
//           if(startTime >= freqToSeconds.get(freq))
//               index  = (pingTime > (startTime + freqToSeconds.get(freq))) ?
//                       (pingTime) / (freqToSeconds.get(freq)+ startTime  )  : 0;
//            else
               index  = (pingTime >  (freqToSeconds.get(freq) + startTime)) ?
                       pingTime  / (freqToSeconds.get(freq) + startTime )  : 0;//

           pingCount[index]++;
       }

        return pingCount;
    }

    public static void main(String[] args) {
        FindPingsPerFrequency obj = new FindPingsPerFrequency();
//          obj.recordPing("user_1", 5);
        obj.recordPing("user_2", 15);
        obj.recordPing("user_2", 20);
        obj.recordPing("user_1", 90);
        obj.recordPing("user_3", 100);
        obj.recordPing("user_1", 110);
        obj.recordPing("user_1", 125);
        obj.recordPing("user_3", 120);
        obj.recordPing("user_3", 170);
        obj.recordPing("user_2", 2500);
        obj.recordPing("user_3", 3600);
        obj.recordPing("user_3", 3609);

        Arrays.stream(obj.getUserPingsPerFrequency("user_1", "minute", 0, 200))
                .forEach(it -> System.out.print(it+" "));
        System.out.println();
        Arrays.stream(obj.getUserPingsPerFrequency("user_3", "hour", 10, 4000))
                .forEach(it -> System.out.print(it+" "));;

    }
}
