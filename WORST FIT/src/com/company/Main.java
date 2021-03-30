package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {




        Scanner input = new Scanner(System.in);

        /**declaring varibles*
         *
         * MAX - maximum
         * br- block of files
         * frag - fragmentation
         * nb-  number of blocks
         * nf-  number of files temp
         *
         */

        int MAX = 25;
        int[] bf = new int[MAX], ff = new int[MAX];
        int[] frag = new int[MAX], b = new int[MAX], f = new int[MAX];
        int nb, nf, temp, highest = 0;

        //prompts user
        System.out.print("\n\tMemory Management Scheme - Worst Fit");
        System.out.print("\nEnter the number of blocks:");
        nb = input.nextInt();       //accepting input

        System.out.print("Enter the number of files:");
        nf = input.nextInt();

        System.out.println("\nEnter the size of the blocks:-");


        //loop to interate and key in block size for various blocks
        for(int i = 1; i <= nb; i++) {
            System.out.print("Block " + i + ":");
            b[i] = input.nextInt();
        }

        System.out.println("Enter the size of the files :-");

        //loop to interate and key in files size for various files
        for(int i = 1; i <= nf; i++) {
            System.out.print("File " + i + ":");
            f[i] = input.nextInt();
        }

        //interates and allocates various blocks
        for(int i = 1; i <= nf; i++) {
            for(int j = 1; j <= nb; j++) {
                if(bf[j] != 1 /* if bf[j] is not allocated */) {
                    temp = b[j] - f[i];
                    if(temp >= 0) {
                        if(highest < temp) {
                            ff[i] = j;
                            highest = temp;
                        }
                    }
                }
            }
            frag[i] = highest;
            bf[ff[i]] = 1;
            highest = 0;
        }

        //FINAL DISPLAY
        System.out.print("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragement");
        for(int i = 1; i <= nf; i++) {
            System.out.print("\n" + i + "\t\t" + f[i] + "\t\t" + ff[i] + "\t\t" + b[ff[i]] + "\t\t" + frag[i]);
        }

    }
}
