package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = DataUtil.getRandomArr(20,9);
        System.out.println("before bubble sort:");
        DataUtil.showArr(arr);
        arr = sort(arr);
        System.out.println("after bubble sort:");
        DataUtil.showArr(arr);
    }
    private static int[] sort(int[] arr){
        int len = arr.length;
        int temp = 0;
        for (int i=len;i>0;i--){
            for (int j=0;j<i-1;j++){
                if(arr[j]>arr[j+1]){
                   temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
