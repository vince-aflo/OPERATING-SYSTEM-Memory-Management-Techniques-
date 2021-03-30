package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args) {

         Scanner input = new Scanner(System.in);
        // declaring variables
        int memAv, temp, n = 0; // memAv= memory Available //temp= temporal storage holder //n = temporal

        // storage holder
        int[] memProcess = new int[10]; // memprocess = memory required for processes
        String decision;


        // declaring and initializing character variable
        char ch = 'y'; // ch - character

        // prompting user and accepting input
        System.out.print("\nEnter the total memory available (in Bytes)-- ");
        memAv = input.nextInt();

        // assigning total memory available to temp variable
        temp = memAv;

        for (int i = 0; ch == 'y'; i++, n++) {
            System.out.print("\nEnter memory required for process " + (i + 1) + " (in Bytes) -- ");
            memProcess[i] = input.nextInt();

            if (memProcess[i] <= temp) {
                System.out.print("\nMemory is allocated for Process " + (i + 1) + " ");
                temp = temp - memProcess[i];
            } else {
                System.out.print("\nMemory is Full");
                break;
            }

            // prompting user to either continue or quit
            System.out.print("\nDo you want to continue(y/n) -- ");
            // accepting input
            decision = input.next();
            // assigning decision value to ch variable
            ch = decision.charAt(0);
        }

        // Displaying
        System.out.print("\n\nTotal Memory Available -- " + memAv);
        System.out.print("\n\n\tPROCESS\t\t MEMORY ALLOCATED ");

        // i - temporal storage in memory
        for (int i = 0; i < n; i++) {
            System.out.print("\n \t" + (i + 1) + "\t\t\t\t" + memProcess[i]);
        }
        System.out.print("\n\nTotal Memory Allocated is " + (memAv - temp));
        System.out.print("\nTotal External Fragmentation is " + temp);

    }
}
