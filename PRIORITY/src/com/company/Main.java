package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner (System.in);

        /**
         * declaring variables
         * p-  number of processes
         * bt-  burst time
         * pri- priority of process
         * wt- waiting time
         * tat- turn around time
         * wtavg-  average waiting time
         * tatavg - Average Turnaround Time
         *
         * */
        int[] p = new int[20], bt = new int[20], pri = new int[20], wt = new int[20], tat = new int[20];
        int n, temp;
        float wtavg, tatavg;

        //accepting input
        System.out.print("Enter the number of processes --- ");
        n = input.nextInt();


        for(int i = 0; i < n; i++) {
            p[i] = i;
            System.out.print("Enter the Burst Time & Priority of Process " + i + " --- ");
            bt[i] = input.nextInt();
            pri[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++) {
            for(int k = i + 1; k < n; k++) {
                if(pri[i] > pri[k]) {
                    temp = p[i];
                    p[i] = p[k];
                    p[k] = temp;
                    temp = bt[i];
                    bt[i] = bt[k];
                    bt[k] = temp;
                    temp = pri[i];
                    pri[i] = pri[k];
                    pri[k] = temp;
                }
            }
        }
        wtavg = (wt[0] = 0);
        tatavg = (tat[0] = bt[0]);

        //working wiating time
        for(int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
            tat[i] = tat[i - 1] + bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }

        //final display
        System.out.print("\nPROCESS\t\tPRIORITY\tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
        for(int i = 0; i < n; i++) {
            System.out.print("\n" + p[i] + " \t\t " + pri[i] + " \t\t " + bt[i] + " \t\t " + wt[i] + " \t\t " + tat[i] + " ");
        }
        System.out.printf("\nAverage Waiting Time is --- %f", wtavg / n);
        System.out.printf("\nAverage Turnaround Time is --- %f", tatavg / n);


    }
}
