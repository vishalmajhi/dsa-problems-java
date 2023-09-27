public class Programtocyclicallyrotateanarray {
    public static void main(String args[]) {

        int arr[] = { -1, 2, -3, 4, 0, -5 };
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;

            left++; // Increment left index
            right--; // Decrement right index
        }

        // Print the modified array
        for (int i = 0; i < arr.length; i++) { // Change the loop condition here
            System.out.print(arr[i] + " ");
        }
    }
}
