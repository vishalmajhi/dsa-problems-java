public class reversarray {
    public static void main(String args[]) {

        int arr[] = { 1, 2, 3, 4, 5 };

        int high;
        int low;

        for (int i = 0; i < arr.length / 2; i++) {
            high = arr.length - 1 - i;
            low = i;
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
