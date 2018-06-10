package puretoy.Sort;

import java.util.Random;

/**
 * Created by kingb on 2018/6/10.
 * 归并排序实现
 * 原理：
 * 1.产生数组，并将数组采用二分法的形式分别递归排序（分）
 * 2.合并各个有序数据完成最终有序数组（治）
 */
public class Sort4GB {

    //递归执行
    private static void Sort(int left, int[] sortArray, int right, int[] tempArray, boolean isAsc) {
        if (left < right) {
            int mid = (left + right) / 2;
            //二分法左右拆分
            Sort(left, sortArray, mid, tempArray, isAsc);
            Sort(mid + 1, sortArray, right, tempArray, isAsc);
            //拆后归并
            Merge(sortArray, left, right, mid, tempArray, isAsc);
        }
    }

    private static void Merge(int[] array, int left, int right, int mid, int[] tempArray, boolean isAsc) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if ((array[i] < array[j]) && isAsc) {
                tempArray[t++] = array[i++];
            } else {
                tempArray[t++] = array[j++];
            }
        }

        while (i <= mid) {
            tempArray[t++] = array[i++];
        }
        while (j <= right) {
            tempArray[t++] = array[j++];
        }
        t = 0;
        while (left <= right) {
            array[left++] = tempArray[t++];
        }

    }

    public static void main(String[] args){
        int[]  sortArray=new int[10000];
        for(int i=0;i<10000;i++){
            Random r=new Random();
            sortArray[i]=r.nextInt(100000);
        }
        Long st=System.currentTimeMillis();
        System.out.println("Sorting……");
        Sort(0,sortArray,9999,new int[10000],true);
        Long ed=System.currentTimeMillis();
        System.out.println("End Sort,Need time:"+(ed-st)/1000+"s");
        System.out.println("The result is:");
        for(int i=0;i<10000;i++){
            System.out.print(" "+sortArray[i]+",");
        }


    }


}
