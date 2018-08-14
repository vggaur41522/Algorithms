package mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

class Interval{
  public int start;
  public int end;
  
  public Interval(int start, int end){
    this.start = start;
    this.end = end;
  }
  
  public String toString(){
    return this.start + ":" + this.end;
  }
}
public class MergeInterval {

  public static void main(String...strings){
    MergeInterval mProb = new MergeInterval();  
    List<Interval> intervals = mProb.createInterval();
    List<Interval> mergeInterval = mProb.mergeInterval(intervals);
    List<Interval> addedInt = mProb.insertInterval(intervals, new Interval(4,9));
    mergeInterval.add(new Interval(9,11));
    int numOfRooms = mProb.meetingRooms(mergeInterval);
  }
  
  private List<Interval> insertInterval(List<Interval> intervals, Interval newInterval){
    List<Interval> result = new ArrayList<>();
    for(Interval current: intervals){
      if(current.end < newInterval.start){
        result.add(current);
      }
      else if(newInterval.end < current.start){
        result.add(newInterval);
        newInterval = current;
      }
      else if(current.end >= newInterval.start || current.start <= newInterval.end){
        newInterval = new Interval(Math.min(newInterval.start, current.start), Math.max(current.end, newInterval.end));
      }
    }
    result.add(newInterval);
    System.out.println(result);
    return result;
  }
  
  private int meetingRooms(List<Interval> intervals){
    Queue<Integer> queue = new PriorityQueue<>();
    queue.offer(intervals.get(0).end);
    
    Collections.sort(intervals, (a,b)-> a.start - b.start);
    int count = 1;
    for(int i=1; i<intervals.size(); i++){
      if(intervals.get(i).start < queue.peek()){
        count++;
      }
      else{
        queue.poll();
      }
      queue.offer(intervals.get(i).end);
    }
    System.out.print("Number of rooms-->"+count);
    return count;
  }
  
  private int netMovieWatched(List<Interval> intervals){
    Collections.sort(intervals, (a,b) -> a.start - b.start);
    Interval pre = intervals.get(0);
    int sum = 0;
    for(Interval current : intervals){
      if(current.start < pre.end){
        //Merge
        sum = pre.end - pre.start;
        pre = new Interval(pre.start, Math.max(pre.end,current.end));
      }
      else{
        pre = current;
      }
    }
    sum = pre.end - pre.start;
    return sum;
  }
  
  private List<Interval> mergeInterval(List<Interval> intervals) {
    List<Interval> result = new ArrayList<>();
    System.out.println(intervals);
    
    Collections.sort(intervals, (a,b) -> (a.start == b.start)? a.end - b.end : a.start - b.start );
    Interval pre = intervals.get(0);
  
    int sum =0;
    for(int i=1; i<intervals.size();i++){
      Interval current = intervals.get(i);
      if(current.start < pre.end ){
        // Merge
        Interval merged = new Interval(pre.start, Math.max(pre.end, current.end));
        pre = merged;
      }
      else{
        result.add(pre);
        sum+= pre.end-pre.start;
        pre = current;
      }
    }
    sum+=pre.end - pre.start;
    result.add(pre);    
    System.out.println("Merged Interval --> "+result);
    
    return result;
  }

  public List<Interval> createInterval(){
    return Arrays.asList(
      new Interval(1,2),
      new Interval(2,5),
      new Interval(6,7),
      new Interval(8,10),
      new Interval(12,16)
    );
  }
}
