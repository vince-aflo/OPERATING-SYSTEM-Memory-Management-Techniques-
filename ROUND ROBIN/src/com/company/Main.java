package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);



        /**
         * Declaring Variables
         * n- number of processes
         * t- size of time slice
         * max-  maximu
         * bu-  burst time
         * wa- waiting time
         * tat- turn around time
         * awt- average waiting time
         *
         *
         * */
        int n, t, max;
        int[] bu = new int[10], wa = new int[10], tat = new int[10], ct = new int[10];
        float awt = 0, att = 0, temp = 0;

        System.out.print("Enter the no of processes -- ");
        n = input.nextInt();

        for(int i = 0; i < n; i++) {
            System.out.print("\nEnter Burst Time for process " + (i + 1) + " -- ");
            bu[i] = input.nextInt();
            ct[i] = bu[i];
        }

        System.out.print("\nEnter the size of time slice -- ");
        t = input.nextInt();
        max = bu[0];


        for(int i = 1; i < n; i++) {
            if(max < bu[i]) {
                max = bu[i];
            }
        }
        for(int j = 0; j < max / t + 1; j++) {
            for(int i = 0; i < n; i++) {
                if(bu[i] != 0) {
                    if(bu[i] <= t) {
                        tat[i] = (int)(temp + bu[i]);
                        temp = temp + bu[i];
                        bu[i] = 0;
                    } else {
                        bu[i] = bu[i] - t;
                        temp = temp + t;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            wa[i] = tat[i] - ct[i];
            att += tat[i];

            awt += wa[i];
        }
        System.out.printf("\nThe Average Turnaround time is -- %f", att / n);
        System.out.printf("\nThe Average Waiting time is -- %f ", awt / n);
        System.out.println("\n\tPROCESS\t BURST TIME \t WAITING TIME\tTURNAROUND TIME");
        for(int i = 0; i < n; i++) {
            System.out.println("\t" + (i + 1) + " \t " + ct[i] + " \t\t " + wa[i] + " \t\t " + tat[i] + " ");
        }


    }
}
