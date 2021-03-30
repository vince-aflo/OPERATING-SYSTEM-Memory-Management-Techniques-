package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**
         * lenRef - length of reference string
         * noFrames - number of frames
         * pf - number of page faults using LRU
         * count - temporal space in memory
         * flag-   a signal variable
         * */


        int  min, lenRef, noFrames, pf = 0, next = 1;
        int[] refStr = new int[10], m = new int[10], count = new int[10], flag = new int[25];

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter the length of reference string -- ");
        lenRef = input.nextInt();

        //Generate random reference strings
        for(int i = 0; i < lenRef; i++) {
            refStr[i] = rand.nextInt(10);
            flag[i] = 0;
        }


        System.out.print("Enter the number of frames -- ");
        noFrames = input.nextInt();
        for(int i = 0; i < noFrames; i++) {
            count[i] = 0;
            m[i] = -1;
        }
        System.out.println("\nThe Page Replacement process is -- ");
        for(int i = 0; i < lenRef; i++) {
            for(int j = 0; j < noFrames; j++) {
                if(m[j] == refStr[i]) {
                    flag[i] = 1;
                    count[j] = next;
                    next++;
                }
            }
            if(flag[i] == 0) {
                if(i < noFrames) {
                    m[i] = refStr[i];
                    count[i] = next;
                    next++;
                } else {
                    min = 0;
                    for(int j = 1; j < noFrames; j++) {
                        if(count[min] > count[j]) {
                            min = j;
                        }
                    }
                    m[min] = refStr[i];
                    count[min] = next;
                    next++;
                }
                pf++;
            }
            for(int j = 0; j < noFrames; j++) {
                System.out.print(m[j] + "\t");
            }
            if(flag[i] == 0) {
                System.out.print("PF No. -- " + pf);
            }
            System.out.println();
        }
        System.out.print("\nThe number of page faults using LRU are " + pf);

    }
}
