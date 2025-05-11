package AlgorithmSamples.UpperBoundLowerBound;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5, 5, 5, 6, 7, 10, 10, 10 };
        System.out.println(lastLEQ(arr, 5));
        System.out.println(myUnderBound(arr, 5));
        System.out.println(lowerBound(arr, 5));
        System.out.println(upperBound(arr, 5));
        // System.out.println(myUnderBound(arr, 1));
        // System.out.println(myUnderBound(arr, 0));
        // System.out.println(myUnderBound(arr, 10));
        // System.out.println(myUnderBound(arr, 7));
        // System.out.println(myUnderBound(arr, 12));
        // System.out.println(upperBound(arr, 5));
        // System.out.println(upperBound(arr, 0));
        // System.out.println(upperBound(arr, 1));
        // System.out.println(upperBound(arr, 3));
        // System.out.println(upperBound(arr, 10));
        // System.out.println(upperBound(arr, 9));

        // System.out.println(lowerBound(arr, 8));
        // System.out.println(upperBound(arr, 8));
    }
    private static int lastLEQ(Integer[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int result = -1; // 결과가 없을 경우 -1
    
        while (left <= right) {
            int mid = (left + right) / 2;
    
            if (arr[mid] <= x) {
                result = mid;       // 후보 저장
                left = mid + 1;     // 오른쪽을 더 탐색
            } else {
                right = mid - 1;
            }
        }
    
        return result;
    }
    
    private static int myUnderBound(Integer[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int center = (left + right) / 2;
            // if (b[arr[center]] < key) {
            if (arr[center] < key) {
                left = center + 1;
            } else {
                right = center;
            }
        }
        return right - 1;
    }

    private static int upperBound(Integer[] arr, int key) { // 특정 target보다 큰 첫번째 원소의 인덱스
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

    private static int lowerBound(Integer[] arr, int key) { //target보다 크거나 같은 첫번째 원소의 인덱스
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
