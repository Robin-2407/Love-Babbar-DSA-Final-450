import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int findKthSmallest(int[] arr, int k) {
        // Initialize max heap with a comparator for reverse order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add the first k elements to the max heap
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        // Process the remaining elements in the array
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();  // Remove the largest element
                maxHeap.add(arr[i]);  // Add the new element
            }
        }

        // The root of the max heap is the k-th smallest element
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("The " + k + "th smallest element is " + findKthSmallest(arr, k));
    }
}
