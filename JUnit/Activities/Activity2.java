package activities;

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args) {
        //Declare and initialize the number array
        int[] intArr= {10, 77, 10, 54, -11, 10};
        //Displays the elements of original array
        System.out.println("The original elements in Array:"+ Arrays.toString(intArr));
        //Declare the variable for element to search intNum(10) in intArr and the expected intSum (30) and initialize
        int intNum=10;
        int intSum=30;
        //Displays the elements of original array
        System.out.println("The Result:" + result(intArr,intNum,intSum));
    }
    public static boolean result(int[] numbers,int intNum,int intSum){
        int intTotal=0;
        for (int number :numbers){
            // check the element of array value is 10 then add to intTotal
            if(number==intNum) {
                //If number is 10 then add into intTotal
                intTotal += number;
            }
            if ( intTotal>intSum){
                break;
            }
        }
        //Return true if condition satisfies
        return intTotal == intSum;
    }
}
