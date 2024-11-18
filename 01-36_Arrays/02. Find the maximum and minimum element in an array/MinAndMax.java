public class MinAndMax {
    public static void minandmax(int arr[]) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        int min, max;

        // Initialize min and max based on the first element
        if (arr.length == 1) {
            min = max = arr[0];
        } else {
            // Initialize min and max for arrays with at least two elements
            if (arr[0] > arr[1]) {
                min = arr[1];
                max = arr[0];
            } else {
                min = arr[0];
                max = arr[1];
            }

            // Start loop from index 2
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                } else if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }

        System.out.print("MINIMUM IS: " + min + " AND MAXIMUM IS: " + max);
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 10, 20, 2, 8, 6, 5, 100 };
        minandmax(arr);
    }
}
