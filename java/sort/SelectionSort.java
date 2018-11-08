package sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = DataUtil.getDefaultArr();
        System.out.println("before sort:");
        DataUtil.showArr(arr);
        System.out.println("after sort:");
        DataUtil.showArr(sort(arr));
    }
    private static int[] sort(int[] arr){
        int len = arr.length;
        for (int i=len -1;i>=0;i--){
            int indx = 0;
            int max = 0;
            for (int j=0;j<=i;j++){
                if(arr[j]>arr[indx]){
                    indx = j;
                }
            }
            max = arr[indx];
            arr[indx] = arr[i];
            arr[i] = max;
        }
        return arr;
    }
}
