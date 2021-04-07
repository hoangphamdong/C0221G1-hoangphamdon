package b4_OOP.Bai_tap;

import java.util.Arrays;

public class StopWatch {
    long startTime;
    long endTime;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public void startTime(){}
    public void start(){
        this.startTime=System.currentTimeMillis();
    }
    public void stop(){
        this.endTime=System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.endTime-this.startTime;
    }
    public static void main(String[] args) {
        int [] array=new int[100000];
        for (int i=0;i<100000;i++){
            array[i]=(int)Math.random()*1000000;
        }
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        Arrays.sort(array);
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime());
    }
}


