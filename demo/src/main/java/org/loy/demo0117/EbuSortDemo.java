package org.loy.demo0117;

/***
 * 冒泡排序demo
 * 当第一次遍历时可以取出每个数组下标的值
 * 当第二次遍历时只要与数组下一位的数值对比，如果小就交换位置，如果大的话，则不进行交换
 *  排序模拟过程为
 *   7,44,3,45,65,9,6,8
 *   第一次取出7 分别与44,3,45,65,9,6,8进行对比，发现3比7小，则进行第一次交换，后面没有再比3小的值
 *   所以第一次排序的结果为3,44,7,45,65,9,6,8
 *   以此类推，第二次取出44 比较发现7比44小，则交换，再次发现6比7小，则再次进行交换
 *   所以第二次排序的结果为3,6,44,45,65,9,7,8
 */
public class EbuSortDemo {

    public static void main(String[] args) {

        int nums[] = new int[]{7,44,3,45,65,9,6,8};
        for(int i=0;i<nums.length;i++){
            System.out.print("排序前:" + nums[i] + ",");
        }
        System.out.println();

        for(int i =0 ;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++){
                int num1 = nums[i];
                int num2 = nums[j];
                if(num2 <num1){
                    // 交换位置
                    int temp = num1;
                    nums[i] = num2;
                    nums[j] = temp;
                }
            }
            System.out.println("第" + i +"次交换后结果");
            for(int k=0;k<nums.length;k++){
                System.out.print(nums[k] + ",");
            }
        }


        for(int i=0;i<nums.length;i++){
            System.out.print("排序后:" + nums[i] + ",");
        }

    }


}
