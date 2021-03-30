package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int MAX = 25;

        int[] bf = new int[MAX], ff = new int[MAX];
        int[] frag = new int[MAX], b = new int[MAX], f = new int[MAX];
        int nb, nf, temp = 0;


        System.out.print("\n\tMemory Management Scheme - First Fit");
        System.out.print("\nEnter the number of blocks:");
        nb = input.nextInt();
        System.out.print("Enter the number of files:");
        nf = input.nextInt();
        System.out.println("\nEnter the size of the blocks:-");
        for (int i = 1; i <= nb; i++) {
            System.out.print("Block " + i + ":");
            b[i] = input.nextInt();
        }
        System.out.println("Enter the size of the files :-");
        for (int i = 1; i <= nf; i++) {
            System.out.print("File " + i + ":");
            f[i] = input.nextInt();
        }
        for (int i = 1; i <= nf; i++) {
            for (int j = 1; j <= nb; j++) {
                if (bf[j] != 1) {
                    temp = b[j] - f[i];
                    if (temp >= 0) {
                        ff[i] = j;
                        break;
                    }
                }
            }

            frag[i] = temp;
            bf[ff[i]] = 1;
        }
        System.out.print("\nFile_no:\tFile_size :\tBlock_no:\tBlock_size:\tFragment");
        for (int i = 1; i <= nf; i++) {
            System.out.print("\n" + i + "\t\t" + f[i] + "\t\t" + ff[i] + "\t\t" + b[ff[i]] + "\t\t" + frag[i]);
        }
    }
    }

