package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataUtil {
    public static int[] getRandomArr(int maxNum,int length){
        Random r = new Random();
        int[] arr = new int[length];
        for (int i=0;i<length;i++){
            arr[i] = r.nextInt(maxNum);
        }
        return arr;
    }
    public static int[] getDefaultArr(){
        return getRandomArr(20,15);
    }
    public static  void showArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void split(){
        System.out.println("-----------------------------");
    }

    /**
     * 不区分先后顺序，只比较数组里面数字包含的内容相同
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean equalIgnoreOrder(int[] arr1, int[] arr2) {

        List list1 = new ArrayList(Arrays.asList(change2IntegerArr(arr1)));
        List list2 = new ArrayList(Arrays.asList(change2IntegerArr(arr2)));
        list1.removeAll(list2);
        return list1.isEmpty();
    }



    private static Integer[] change2IntegerArr(int[] arr){
        Integer[] arrs = new Integer[arr.length];
        int i=0;
        for (;i<arr.length;i++){
            arrs[i] = arr[i];
        }
        return arrs;
    }
}
