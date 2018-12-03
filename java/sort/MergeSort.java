package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        int len = arr.length;
        for (int i=0;i<len; i++){
            arr[i] = (int)(Math.random()*len);
        }
        show(arr);
        int[] arr1 = arr.clone();
        Arrays.sort(arr1);
        show(arr1);
        show(mergeSort(arr,0,arr.length-1));

    }
    private static int[] mergeSort(int[] arr,int start,int end){
        if(start >= end){
            int[] arrs =  {arr[end]};
            return arrs;
        }
        int mid = (start+end)/2;
        int[] arr1 = mergeSort(arr,start,mid);
        int[] arr2 = mergeSort(arr,mid+1,end);
       return merge(arr1,arr2);
    }

    private static int[] merge(int[] arrA,int[] arrB){
        int indexA=0,indexB=0;
        int lenA = arrA.length;
        int lenB = arrB.length;
        int[] arrC = new int[lenA+lenB];
        int indexC = 0;
        while (indexA<lenA && indexB<lenB){
            if(arrA[indexA] >= arrB[indexB]){
                arrC[indexC++] = arrB[indexB++];
            }else {
                arrC[indexC++] = arrA[indexA++];
            }
        }
        while (indexA < lenA){
            arrC[indexC++] = arrA[indexA++];
        }
        while (indexB < lenB){
            arrC[indexC++] = arrB[indexB++];
        }
        return arrC;
    }
    private static void show(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
