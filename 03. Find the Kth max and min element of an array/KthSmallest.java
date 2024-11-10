import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 2, 8, -1, 4, 10, 12};
        int k = 3;  // Example: finding the 3rd smallest element

        int kthSmallest = findKthSmallest(array, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallest);
    }

    public static int findKthSmallest(int[] array, int k) {
        // Min heap to store all elements of the array
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elements to the min heap
        for (int num : array) {
            minHeap.add(num);
        }

        // Extract the smallest element k times
        int kthSmallest = -1;
        for (int i = 0; i < k; i++) {
            kthSmallest = minHeap.poll();
        }

        return kthSmallest;
    }
}
