package structures;

@SuppressWarnings("unchecked")
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private float[] scores;
    private int size;

    public Heap(int capacity) {
        heap = (T[]) new Comparable[capacity];
        scores = new float[capacity];
        size = 0;
    }

    public void add(T item, float score) {
        //if the array is full, make a bigger array before adding the new item
        if (size == heap.length) {
            resize();
        }
        heap[size] = item;
        scores[size] = score;

        //move the new value upwards until the heap order is correct
        bubbleUp(size);
        size++;
    }

    public T removeMax() {
        if (size == 0) {
            return null;
        }
        //the largest item is always stored at index 0
        T max = heap[0];
        size--;
        //move the last item in the heap to the root position
        heap[0] = heap[size];
        scores[0] = scores[size];

        //move the new root downwards until the heap order is correct again
        bubbleDown(0);
        return max;
    }

    public int size() {
        return size;
    }

    private boolean isChildBigger(int first, int second){
        if (scores[first] > scores[second]){
            return true;
        }
        else if (scores[first] < scores[second]){
            return false;
        }
        else{
            //compares object value if the scores are the same
            return heap[first].compareTo(heap[second]) >= 0;
        }
    }

    private void bubbleUp(int index) {

        //keep going while the item is not already at the root
        while (index > 0) {
            //find parent node using parent of index i is at (i - 1) / 2
            int parent = (index - 1) / 2;
            //if the child score is less than or equal to the parent
            if (!isChildBigger(index, parent)) {
                //the heap is in a correct order
                return;
            }
            //if the child is bigger than the parent, swap them
            swap(index, parent);
            //update index to its new position
            index = parent;
        }
    }

    private void bubbleDown(int index) {

        while (true) {
            int largest = index;
            //left child of i is 2 * i + 1.
            int left = index * 2 + 1;
            //right child of i is 2 * i + 2.
            int right = index * 2 + 2;

            //if the left child exists and is larger mark the left child as the largest
            if (left < size && isChildBigger(left, index)) {
                largest = left;
            }
            //if the right child exists and is larger mark the right child as the largest
            if (right < size && isChildBigger(right, index)) {
                largest = right;
            }
            //if largest is index heap is in correct order
            if (largest == index) {
                return;
            }
            //swap the current item with the larger child
            swap(index, largest);
            //update index to its new position
            index = largest;
        }
    }

    private void swap(int first, int second) {
        T temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;

        float tempScore = scores[first];
        scores[first] = scores[second];
        scores[second] = tempScore;
    }

    private void resize() {
        T[] bigger = (T[]) new Comparable[heap.length * 2 + 1];
        float[] biggerScores = new float[scores.length * 2 + 1];

        for (int i = 0; i < heap.length; i++) {
            bigger[i] = heap[i];
            biggerScores[i] =scores[i];
        }
        heap = bigger;
        scores = biggerScores;
    }
}