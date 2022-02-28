package utils;

import java.util.Scanner;

/**
 * @author JonnyOu
 * @date 2022/2/28 17:21
 * @email JonnyOu1012@gmail.com
 */
public class TestIntArr {
    
    /**
     * 根据输入获取数组类型用例
     * @return
     */
    public int[] getIntArrExample() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一行数字，以空格分开...");
        String line = sc.nextLine();
        String[] strArr= line.split("\\s+");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
    
    public static void main(String[] args) {
        int[] arr = new TestIntArr().getIntArrExample();
        for (int i : arr) {
            System.out.println(i);
        }        
    }
}
