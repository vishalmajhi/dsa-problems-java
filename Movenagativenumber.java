public class Movenagativenumber {
    public static void main(String args[]) {

        int arr[] = { -1, 2, -3, 4, 0, -5 };
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (arr[left] < 0) {
                left++;
            } else if (arr[left] > 0 && arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (arr[left] >= 0 && arr[right] >= 0) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
