package sort;

import java.util.Arrays;

public class MergeSort {
    private static int[] theArr;

    public MergeSort(int maxSize) {
        theArr = new int[maxSize];
    }

    public MergeSort() {
        theArr = new int[100];
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * len);
        }
        show(arr);
        sort1(arr);
        System.out.println("-----------------------------------");
        show(arr);
        sort2(arr);


    }

    private static void sort2(int[] arr) {
        int[] arr1 = arr.clone();
        MergeSort sort = new MergeSort();
//
        sort.mergeSort1(arr, 0, arr.length - 1);
        show(arr);
        Arrays.sort(arr1);
        show(arr1);
    }

    private static void sort1(int[] arr) {
        int[] arr1 = arr.clone();
        Arrays.sort(arr1);
        show(arr1);
        show(mergeSort(arr, 0, arr.length - 1));
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            int[] arrs = {arr[end]};
            return arrs;
        }
        int mid = (start + end) / 2;
        int[] arr1 = mergeSort(arr, start, mid);
        int[] arr2 = mergeSort(arr, mid + 1, end);
        return merge(arr1, arr2);
    }

    private static int[] merge(int[] arrA, int[] arrB) {
        int indexA = 0, indexB = 0;
        int lenA = arrA.length;
        int lenB = arrB.length;
        int[] arrC = new int[lenA + lenB];
        int indexC = 0;
        while (indexA < lenA && indexB < lenB) {
            if (arrA[indexA] >= arrB[indexB]) {
                arrC[indexC++] = arrB[indexB++];
            } else {
                arrC[indexC++] = arrA[indexA++];
            }
        }
        while (indexA < lenA) {
            arrC[indexC++] = arrA[indexA++];
        }
        while (indexB < lenB) {
            arrC[indexC++] = arrB[indexB++];
        }
        return arrC;
    }


    private static void mergeSort1(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort1(arr, start, mid);
        mergeSort1(arr, mid + 1, end);
        merge1(arr, start, mid, end);
    }

    private static void merge1(int[] arrA, int startPtr, int hightPtr, int endPrt) {
        int i = 0, mid = hightPtr ,bight = hightPtr+1;
        int startBound = startPtr;
        while (startPtr <= mid && bight <= endPrt) {
            if (arrA[startPtr] >= arrA[bight]) {
                theArr[i++] = arrA[bight++];
            } else {
                theArr[i++] = arrA[startPtr++];
            }
        }
        while (startPtr <= mid) {
            theArr[i++] = arrA[startPtr++];
        }
        while (bight <= endPrt) {
            theArr[i++] = arrA[bight++];
        }
        i = 0;
        for (int j = startBound; j <= endPrt; j++) {
            arrA[j] = theArr[i++];
        }
    }

    private static void show(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
