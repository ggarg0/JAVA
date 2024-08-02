package Arrays.BinarySearch;

// https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/next-letter-medium

import java.util.Arrays;
import java.util.List;

public class BinarySearchNextLetterArray {

    public static char searchLetterOrNextLetter(char[] letters, char key) {

        if (letters[letters.length - 1] < key) {
            return letters[0];
        }

        int start = 0, end = letters.length - 1, mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (letters[mid] == key) {
                return letters[mid];
            } else if (letters[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start];
    }

    public static char searchNextLetter(char[] arr, char key) {
        if (key >= arr[arr.length - 1]) {
            return arr[0];
        }

        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == key) {
                return arr[mid + 1];
            }

            if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr[start];
    }


    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'f', 'h'};
        List<Character> keys = Arrays.asList('f', 'b', 'm', 'h', 'g');
        for (char key : keys) {
            System.out.println("searchNextLetter array : " + Arrays.toString(arr) + " and key : " + key + " => " + searchNextLetter(arr, key));
            System.out.println("searchLetterOrNextLetter array : " + Arrays.toString(arr) + " and key : " + key + " => " + searchLetterOrNextLetter(arr, key));
        }
    }
}
