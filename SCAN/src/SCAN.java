

import java.util.*;

public class SCAN {

    static int size = 6;
    static int disk_size = 300;

    static void SCAN(int arr[], int head, String direction)
    {
        //total number of seek
        int total_seek = 0;

        //distance- distance to travel
        //currentT -  current track
        int distance, currentT;
        Vector<Integer> left = new Vector<Integer>(),
                right = new Vector<Integer>();
        Vector<Integer> seek_sequence = new Vector<Integer>();

        // appending end values which has to be  before reversing the direction
        if (direction == "left")
            left.add(0);
        else if (direction == "right")
            right.add(disk_size - 1);

        for (int i = 0; i < size; i++)
        {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }

        // sorting left and right vectors
        Collections.sort(left);
        Collections.sort(right);

        // run the while loop two times.
        // one by one scanning right
        // and left of the head
        int run = 2;
        while (run-- >0)
        {
            if (direction == "left")
            {
                for (int i = left.size() - 1; i >= 0; i--)
                {
                    currentT = left.get(i);

                    // appending current track to seek sequence
                    seek_sequence.add(currentT);

                    // calculate absolute distance
                    distance = Math.abs(currentT - head);

                    // increase the total count
                    total_seek += distance;

                    // accessed track is now the new head
                    head = currentT;
                }
                direction = "right";
            }
            else if (direction == "right")
            {
                for (int i = 0; i < right.size(); i++)
                {
                    currentT = right.get(i);

                    // appending current track to seek sequence
                    seek_sequence.add(currentT);

                    // calculate absolute distance
                    distance = Math.abs(currentT - head);

                    // increase the total count
                    total_seek += distance;

                    // accessed track is now new head
                    head = currentT;
                }
                direction = "left";
            }
        }


        //displaying
        System.out.print("TOTAL NUMBER OF SEEK OPERATIONS = " + total_seek + "\n");

        System.out.print("\nSEEK SEQUENCE: " + "\n");

        System.out.print("{");
        for (int i = 0; i < seek_sequence.size(); i++)
        {
            System.out.print(seek_sequence.get(i));

            if(i<seek_sequence.size()-1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    // Driver code
    public static void main(String[] args)
    {
        System.out.println("----------------------------------");
        System.out.println( "SCAN DISK SCHEDULING ALGORITHM");
        System.out.println("----------------------------------\n");

        // request array
        int arr[] = { 222, 56, 23, 56,
                52, 57, 13, 795 };
        int head = 50;
        String direction = "left";

        SCAN(arr, head, direction);
    }
}
