package activities;
import java.util.Arrays;

class Activity4 {

    public static void main(String args[]) {
        int[] intArr = { 4, 3, 2, 10, 12,1,5,6 };
        System.out.println("Array Before sorting: ");
        System.out.println(Arrays.toString(intArr));
        sortingArrayInAscending(intArr);
        System.out.println("Array after sorting in ascending Order: ");
        System.out.println(Arrays.toString(intArr));
    }
    public static void sortingArrayInAscending(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            // store the current value at current in key
            int key = arr[i];
            // pointer to index just before the key's index
            int j = i - 1;

            //move values in arr[0...i-1] greater than key one position to their right
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // store the key just before the last shifted element or after the element just smaller than or equal to the key
            arr[j + 1] = key;
        }
    }
}