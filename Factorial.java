/**
 * Created by Administrator on 2016/10/16.
 */

import java.math.BigInteger;

public class Factorial {
    static void result(int input){
        BigInteger sum = new BigInteger("1");
        for(int i = input;i>0;i--){
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println("结果为："+sum.toString());
    }
    static  void subResult(int input,int start,int end){
        BigInteger sum = new BigInteger("1");
        for(int i = input;i>0;i--){
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println("结果为"+sum.toString().substring(start,end));
    }
}
