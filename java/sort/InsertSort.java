package sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = DataUtil.getRandomArr(20,9);
        System.out.println("before InsertSort sort:");
        DataUtil.showArr(arr);
        int[]arr1 = sort(arr);
        System.out.println("after InsertSort sort:");
        DataUtil.showArr(arr1);
        System.out.println(DataUtil.equalIgnoreOrder(arr,arr1));
    }
    private static int[] sort(int[] arr1) {
        int[] arr = arr1.clone();
        int len = arr.length;
        for (int i=1;i<len;i++){
            int temp = arr[i];
            int cursor = i;
            while (cursor>0 && arr[cursor-1] > temp){
                arr[cursor] = arr[cursor-1];
                cursor--;
            }
            arr[cursor] = temp;
        }
        return arr;
    }
}
