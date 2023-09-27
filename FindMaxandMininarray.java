public class FindMaxandMininarray {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };

        if (arr.length == 0) {
            System.out.println("The array is empty.");
            return;
        }

        int max = arr[0]; // Initialize max with the first element
        int min = arr[0]; // Initialize min with the first element

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}
