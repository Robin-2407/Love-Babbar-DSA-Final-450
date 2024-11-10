import java.util.PriorityQueue;
import java.util.Collections;

public class KthSmallest {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 2, 8, -1, 4, 10, 12};
        int k = 3;  // Example: finding the 3rd smallest element

        int kthSmallest = findKthSmallest(array, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallest);
    }

    public static int findKthSmallest(int[] array, int k) {
        // Max heap with a comparator to reverse the order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add first k elements to the max heap
        for (int i = 0; i < k; i++) {
            maxHeap.add(array[i]);
        }

        // For the remaining elements in the array
        for (int i = k; i < array.length; i++) {
            // If the current element is smaller than the root of the max heap
            if (array[i] < maxHeap.peek()) {
                maxHeap.poll();          // Remove the largest element in the heap
                maxHeap.add(array[i]);   // Add the current element
            }
        }

        // The root of the heap is the k-th smallest element
        return maxHeap.peek();
    }
}
