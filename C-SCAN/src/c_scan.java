// C-SCAN Disk Scheduling algorithm
import java.util.*;

public class c_scan {

    static int size = 8;
    static int disk_size = 200;

    public static void CSCAN(int arr[], int head)
    {
        int seek_count = 0;
        int distance, cur_track;

        Vector<Integer> left = new Vector<Integer>();
        Vector<Integer> right = new Vector<Integer>();
        Vector<Integer> seek_sequence
                = new Vector<Integer>();

        // Appending end values which has
        // to be visited before reversing
        // the direction
        left.add(0);
        right.add(disk_size - 1);

        // Tracks on the left of the
        // head will be serviced when
        // once the head comes back
        // to the beggining (left end).
        for (int i = 0; i < size; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }

        // Sorting left and right vectors
        Collections.sort(left);
        Collections.sort(right);

        // First service the requests
        // on the right side of the
        // head.
        for (int i = 0; i < right.size(); i++) {
            cur_track = right.get(i);

            // Appending current track to seek sequence
            seek_sequence.add(cur_track);

            // Calculate absolute distance
            distance = Math.abs(cur_track - head);

            // Increase the total count
            seek_count += distance;

            // Accessed track is now new head
            head = cur_track;
        }

        // Once reached the right end
        // jump to the beggining.
        head = 0;

        // adding seek count for head returning from 199 to
        // 0
        seek_count += (disk_size - 1);

        // Now service the requests again
        // which are left.
        for (int i = 0; i < left.size(); i++) {
            cur_track = left.get(i);

            // Appending current track to
            // seek sequence
            seek_sequence.add(cur_track);

            // Calculate absolute distance
            distance = Math.abs(cur_track - head);

            // Increase the total count
            seek_count += distance;

            // Accessed track is now the new head
            head = cur_track;
        }

        System.out.println("\nTOTAL NUMBER OF SEEK "
                + "OPERATIONS \n" + seek_count);

        System.out.println("\nSEEK SEQUENCE");

        System.out.print("{");
        for (int i = 0; i < seek_sequence.size(); i++) {
            System.out.print(seek_sequence.get(i) );

            if (i<seek_sequence.size()-1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    // Driver code
    public static void main(String[] args) throws Exception
    {

        // Request array
        int arr[] = { 176, 79, 34, 60, 92, 11, 41, 114 };
        int head = 50;

        System.out.println("-----------------------------------");
        System.out.println("C-SCAN Disk Scheduling algorithm");
        System.out.println("-----------------------------------\n");


        System.out.println("INITIAL POSITION OF HEAD: " + head);

        CSCAN(arr, head);
    }
}
