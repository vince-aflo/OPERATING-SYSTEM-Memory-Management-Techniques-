package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        int[] p = new int[20], bt = new int[20], wt = new int[20], tat = new int[20];
        int n, temp;
        float wtavg, tatavg;

        System.out.print("\nEnter the number of processes -- ");
        n = input.nextInt();
        for(int i = 0; i < n; i++) {
            p[i] = i;
            System.out.print("Enter Burst Time for Process " + i + " -- ");
            bt[i] = input.nextInt();
        }
        for(int i = 0; i < n; i++) {
            for(int k = i + 1; k < n; k++) {
                if(bt[i] > bt[k]) {
                    temp = bt[i];
                    bt[i] = bt[k];
                    bt[k] = temp;
                    temp = p[i];
                    p[i] = p[k];
                    p[k] = temp;
                }
            }
        }
        wt[0] = (int)(wtavg = 0);
        tat[0] = (int)(tatavg = bt[0]);
        for(int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
            tat[i] = tat[i - 1] + bt[i];
            wtavg = wtavg + wt[i];
            tatavg = tatavg + tat[i];
        }
        System.out.println("\n\t PROCESS \tBURST TIME \t WAITING TIME\t TURNAROUND TIME");
        for(int i = 0; i < n; i++) {
            System.out.print("\n\t P" + p[i] + " \t\t " + bt[i] + " \t\t " + wt[i] + " \t\t " + tat[i]);
        }
        System.out.printf("\nAverage Waiting Time -- %f", wtavg / n);
        System.out.printf("\nAverage Turnaround Time -- %f", tatavg / n);

    }
}
