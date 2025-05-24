package sorting;

public class Sorting {

    public static void main(String[] args) {
        Sorting s = new Sorting();

        int[] arr = new int[]{5, 4, 3, 2, 1};
        s.bubbleSort(arr);

        arr = new int[]{5, 4, 3, 2, 1};
        s.insertionSort(arr);

        arr = new int[]{5, 4, 3, 2, 1};
        s.selectionSort(arr);
    }

    public void mergeSort(int[] arr) {

        mergeSort(arr, 0, arr.length);


    }

    public int[] mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            int[] left = mergeSort(arr, 0, mid);
            int[] right = mergeSort(arr, mid + 1, end);
        }
        return arr;

    }

    public void merge(int[] arr, int start, int end, int middle) {
        int[] left = new int[middle - start + 1];
        int[] right = new int[end - middle + 1];
        System.arraycopy(arr, start, left, 0, left.length);
        System.arraycopy(arr, middle, right, 0, right.length);

        int i = 0, j = 0;
        int k = start;

    }

    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
        print("Selection Sort : ", arr);

    }

    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        print("Insertion Sort : ", arr);
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        print("bubbleSort ", arr);
    }

    public void print(String sort, int[] arr) {
        System.out.println(" Sorting name " + sort);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("=========================");
    }
}
