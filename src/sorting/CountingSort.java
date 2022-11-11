package sorting;

public class CountingSort {
    // Driver method
    public static void main(String[] args) {
        CountingSort ob = new CountingSort();
        int[] arr = {1, 4, 1, 2, 7, 5, 2};

        ob.sort(arr);

        System.out.print("Sorted character array is ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i]);
    }

    void sort(int[] arr) {
        int n = arr.length;

        // The output character array that will have sorted arr
        int[] output = new int[n];

        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int[] count = new int[10];
        for (int i = 0; i < 10; ++i)
            count[i] = 0;

        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i < 10; ++i)
            count[i] += count[i - 1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        System.arraycopy(output, 0, arr, 0, n);
    }
}
