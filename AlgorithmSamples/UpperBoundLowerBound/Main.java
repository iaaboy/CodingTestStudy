package AlgorithmSamples.UpperBoundLowerBound;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 5, 6, 7, 10, 10, 10 };
        System.out.println(lowerBound(arr, 5));
        System.out.println(lowerBound(arr, 1));
        System.out.println(lowerBound(arr, 0));
        System.out.println(lowerBound(arr, 10));
        System.out.println(lowerBound(arr, 7));
        System.out.println(lowerBound(arr, 11));
        System.out.println();
        System.out.println(upperBound(arr, 5));
        System.out.println(upperBound(arr, 0));
        System.out.println(upperBound(arr, 1));
        System.out.println(upperBound(arr, 3));
        System.out.println(upperBound(arr, 10));
        System.out.println(upperBound(arr, 9));

        System.out.println(lowerBound(arr, 8));
        System.out.println(upperBound(arr, 8));
    }

    private static int upperBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            if (arr[center] <= key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return left;
    }

    private static int lowerBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            if (arr[center] < key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return right;
    }
}
