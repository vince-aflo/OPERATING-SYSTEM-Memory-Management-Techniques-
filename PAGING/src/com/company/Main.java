package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int memSize, pageSize, numOfPages, np, rempages, i, x, y, pa, offset;
        int[] s = new int[10];
        int[][] fno = new int[10][20];

        System.out.print("\nEnter the memory size -- ");
        memSize = input.nextInt();
        System.out.print("\nEnter the page size -- ");
        pageSize = input.nextInt();

        numOfPages = memSize / pageSize;

        System.out.print("\nThe no. of pages available in memory are -- " + numOfPages + " ");
        System.out.print("\nEnter number of processes -- ");
        np = input.nextInt();
        rempages = numOfPages;
        for(i = 1; i <= np; i++) {
            System.out.print("\nEnter no. of pages required for p[" + i + "]-- ");
            s[i] = input.nextInt();
            if(s[i] > rempages) {
                System.out.print("\nMemory is Full");
                break;
            }
            rempages = rempages - s[i];
            System.out.print("\nEnter page table for p[" + i + "] --- ");
            for(int j = 0; j < s[i]; j++) {
                fno[i][j] = input.nextInt();
            }
        }
        System.out.print("\nEnter Logical Address to find Physical Address ");
        System.out.print("\nEnter process no. ");
        x = input.nextInt();

        System.out.print("\nEnter  page number ");
        y = input.nextInt();

        System.out.print("\nEnter offset -- ");
        offset = input.nextInt();

        if(x > np || y >= s[i] || offset >= pageSize) {
            System.out.print("\nInvalid Process or Page Number or offset");
        } else {
            pa = fno[x][y] * pageSize + offset;
            System.out.print("\nThe Physical Address is -- " + pa);
        }
    }
}
