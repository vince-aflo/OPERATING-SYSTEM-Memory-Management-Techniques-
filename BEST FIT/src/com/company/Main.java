package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // declaring the constant maximum size assigning 25 to it
        final int MAX = 25;

        //
        int[] bf = new int[MAX], ff = new int[MAX];

        /*
         * DECLARING VARIABLES frag- fragment , block - identifies particular block file
         * - identifies particular file temp - temporal location in memory i - index of
         * list of data nb - number of blocks nf - number of files lowest -
         **/

        int[] frag = new int[MAX], block = new int[MAX], file = new int[MAX];
        int i, numOfBlocks, numOfFiles, temp, lowest = 10000;

        // creating scanner class
        Scanner input = new Scanner(System.in);

        // prompting
        System.out.print("\nEnter the number of blocks:");
        numOfBlocks = input.nextInt();

        System.out.print("Enter the number of files:");
        numOfFiles = input.nextInt();

        // prompting user to enter size of block based on number of blocks entered
        System.out.println("\nEnter the size of the blocks:-");
        for (i = 1; i <= numOfBlocks; i++) {
            System.out.print("Block " + i + ":");
        }
        block[i] = input.nextInt(); // accepting input

        // prompting user to enter size of file based on number of files entered
        System.out.println("Enter the size of the files :-");
        for (i = 1; i <= numOfFiles; i++) {
            System.out.print("File " + i + ":");
            file[i] = input.nextInt();
        }

        for (i = 1; i <= numOfFiles; i++) {
            for (int j = 1; j <= numOfBlocks; j++) {
                if (bf[j] != 1) {
                    temp = block[j] - file[i];
                    if (temp >= 0) {
                        if (lowest > temp) {
                            ff[i] = j;
                            lowest = temp;
                        }
                    }
                }
            }
            frag[i] = lowest;
            bf[ff[i]] = 1;
            lowest = 10000;
        }
        System.out.print("\nFile No\tFile Size \tBlock No\tBlock Size\tFragment");
        for (i = 1; i <= numOfFiles && ff[i] != 0; i++) {
            System.out.print("\n" + i + "\t\t" + file[i] + "\t\t" + ff[i] + "\t\t" + block[ff[i]] + "\t\t" + frag[i]);
        }
    }
    }

