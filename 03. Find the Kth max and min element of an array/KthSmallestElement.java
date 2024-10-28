import java.util.PriorityQueue;
public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all elements to the min-heap
        for (int num : arr) {
            minHeap.add(num);
        }

        // Extract the minimum element k-1 times to get the k-th smallest
        for (int i = 1; i < k; i++) {
            minHeap.poll();
        }
        
        return minHeap.poll(); // k-th smallest element
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("K-th smallest element is: " + kthSmallest(arr, k));
    }
}
