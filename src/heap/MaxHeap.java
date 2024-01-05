package heap;

public class MaxHeap {
    int arr[];
    int maxSize;
    int heapSize;

    MaxHeap(int size){
        maxSize=size;
        arr = new int[size];
        heapSize=0;
    }

    void maxHeapify(int i){
        int right= rChild(i);
        int left = lChild(i);
        int largest = i;
        if(left<heapSize && arr[i]<arr[left])
            largest= left;
        if (right<heapSize && arr[i]<arr[right])
            largest=right;
        if(i!=largest){
            int temp= arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            maxHeapify(largest);
        }
    }
    int parent(int i){
        return (i-1)/2;
    }
    int lChild(int i){
        return 2*i +1;
    }
    int rChild(int i){
        return  2*1 +2;
    }

    int removeMax(){
        if(heapSize<0)
            return Integer.MIN_VALUE;
        if(heapSize==1)
        {
            heapSize--;
            return arr[0];
        }
        int root= arr[0];
        arr[0]= arr[heapSize];
        heapSize--;
        maxHeapify(0);
        return root;
    }

    void increaseKey(int i, int newVal){
        arr[i] = newVal;
        while(i!=0 && arr[parent(i)]< arr[i])
        {
            int temp = arr[i];
            arr[i]= arr[parent(i)];
            arr[parent(i)]=temp;
            i = parent(i);
        }
    }
    int getMax(){
        return arr[0];
    }
    int curSize(){
        return heapSize;
    }

    void deleteKey(int i){
        increaseKey(i,Integer.MIN_VALUE);
        removeMax();
    }

    void insertKey(int x){
        if(heapSize==maxSize)
            throw new RuntimeException("heap is full");
        heapSize++;
        int i= heapSize-1;
        arr[i]=x;
        heapSize++;
        while(i!=0 && arr[i]>arr[parent(i)]){
            int temp = arr[i];
            arr[i]= arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
        }
    }

    public static void main(String[] args) {
        // Assuming the maximum size of the heap to be 15.
        MaxHeap h = new MaxHeap(15);

        // Asking the user to input the keys:
        int k, i, n = 6;
        System.out.println("Entered 6 keys:- 3, 10, 12, 8, 2, 14 \n");
        h.insertKey(3);
        h.insertKey(10);
        h.insertKey(12);
        h.insertKey(8);
        h.insertKey(2);
        h.insertKey(14);

        // Printing the current size
        // of the heap.
        System.out.println("The current size of the heap is "
                + h.curSize() + "\n");

        // Printing the root element which is
        // actually the maximum element.
        System.out.println("The current maximum element is " + h.getMax()
                + "\n");

        // Deleting key at index 2.
        h.deleteKey(2);

        // Printing the size of the heap
        // after deletion.
        System.out.println("The current size of the heap is "
                + h.curSize() + "\n");

        // Inserting 2 new keys into the heap.
        h.insertKey(15);
        h.insertKey(5);
        System.out.println("The current size of the heap is "
                + h.curSize() + "\n");
        System.out.println("The current maximum element is " + h.getMax()
                + "\n");
    }
}
