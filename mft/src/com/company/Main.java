package com.company;


import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // declaring variables
        int memSize, blockSize, numOfBlocks, ef, numOfProcess, tif = 0;
        int[] proMem = new int[10];
        int i, p = 0;

        // prompting user and accepting input
        System.out.print("Enter the total memory available (in Bytes) -- ");
        memSize = input.nextInt();

        // prompting user and accepting input
        System.out.print("Enter the block size (in Bytes) -- ");
        blockSize = input.nextInt();

        // calculating Number of Blocks
        numOfBlocks = memSize / blockSize;

        // Calculating for external Fragmentation
        ef = memSize - numOfBlocks * blockSize;

        // Prompting user and accepting input
        System.out.print("\nEnter the number of processes -- ");
        numOfProcess = input.nextInt();

        // Prompting user based to enter memory required based on number of processes
        for (i = 0; i < numOfProcess; i++) {
            System.out.print("Enter memory required for process " + (i + 1) + " (in Bytes)-- ");
            proMem[i] = input.nextInt();
        }

        // Displaying Number of Blocks available in memory
        System.out.print("\nNo. of Blocks available in memory -- " + numOfBlocks);

        // Displaying headers
        System.out.print("\n\nPROCESS\tMEMORY REQUIRED\t ALLOCATED\tINTERNAL FRAGMENTATION");

        // Displaying level of processes and memory required
        for (i = 0; i < numOfProcess && p < numOfBlocks; i++) {
            System.out.print("\n " + (i + 1) + "\t\t\t" + proMem[i]);

            // Checking if memory is allocated
            if (proMem[i] > blockSize) {
                System.out.print("\t\t\t\tNO\t\t\t\t---");
            } else {
                System.out.print("\t\t\t\tYES\t\t\t\t" + (blockSize - proMem[i]));

                // calculating for Total Internal Fragmentation
                tif = tif + blockSize - proMem[i];
                p++;
            }
        }

        // Checking for full memory
        if (i < numOfProcess) {
            System.out.print("\nMemory is Full, Remaining Processes cannot be accomodated");
        }

        // Diplaying values
        System.out.print("\n\nTotal Internal Fragmentation is " + tif);
        System.out.print("\nTotal External Fragmentation is " + ef);


    }
}
