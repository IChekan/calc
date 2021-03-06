package module3.week1;

/**
 * Created by Ihar_Chekan on 3/18/2015.
 */
public class Task2Sorting {

    public static String[] sortArrayNumbers (String[] arrayInput) {
        sortArray(arrayInput);
        return arrayInput;
    }

    private static void sortArray(String[] arr) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i=0; i < arr.length - 1; i += 1) {
                if (arr[i].length() > arr[i + 1].length()) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void swap(String[] arr, int index0, int index1) {
        String temp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = temp;
    }
}
