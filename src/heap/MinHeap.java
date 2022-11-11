package heap;

public class MinHeap {
    private final int[] arr;
    private final int capacity;
    private int heapSize;

    public MinHeap(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        heapSize = 0;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return (2 * i + 1);

    }

    public int right(int i) {
        return (2 * i + 2);
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void insert(int element) {
        if (heapSize == capacity) {

            throw new RuntimeException("heap size full");
        }
        heapSize++;
        int i = heapSize - 1;
        arr[i] = element;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMin() {
        if (heapSize <= 0)
            return Integer.MAX_VALUE;
        if (heapSize == 1) {
            heapSize--;
            return arr[0];
        }
        int root = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        minHeapify(0);
        return root;
    }

    public void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heapSize && arr[l] < arr[i])
            smallest = l;
        if (r < heapSize && arr[r] < arr[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }

    }
}
