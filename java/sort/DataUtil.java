package sort;

import java.util.Arrays;
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
    public static void showArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void split(){
        System.out.println("-----------------------------");
    }
}
