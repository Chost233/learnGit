/**
 * Created by Administrator on 2016/10/9.
 */
import java.util.Scanner;
import java.lang.String;

import static java.lang.System.*;

public class Texas {
    public static void main(String args[]){
        int[] poker = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
                24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
                35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
                46, 47, 48, 49, 50, 51, 52};//1~13:spade 14~26:diamond 27~39:heart 40~52:club
        int[] poketcard1 = new int[2];
        int[] poketcard2 = new int[2];

        out.println("输入规范\"花色|点值（两位）\"，如：红心8 输入样式应为 \"heart08\" ");
        int[] common = {1,2,3,4,5};                           //公共牌预设(注释此行，取消后面的注释，使用效果更佳)
        /*Scanner input = new Scanner(System.in);                //公共牌键盘输入(多动手益脑)
        int[] common = new int[5];
        for (int i = 1;i<=5;i++){
            int j = i-1;
            System.out.println("请输入第"+i+"张公共牌");
            String poke = input.next();
            if(poke.startsWith("spade")){
                common[i-1]=0;
            }
            else if(poke.startsWith("diamond")){
                common[i-1]=13;
            }
            else if(poke.startsWith("heart")){
                common[i-1]=26;
            }
            else if(poke.startsWith("club")){
                common[i-1]=39;
            }
            else{
                System.out.println("输入不规范");
                i = j;
            }
            try {
                if(Integer.parseInt(poke.substring(poke.length() - 2))>13||Integer.parseInt(poke.substring(poke.length() - 2))<=0){
                    System.out.println("输入不规范");
                    i = j;
                }
                common[i - 1] = common[i - 1] + Integer.parseInt(poke.substring(poke.length() - 2));
            }
            catch(Exception e){
                System.out.println("输入不规范");
                i = j;
            }
//            System.out.println(common[i-1]);
        }*/

        out.println("公共牌为：");                                  //公共牌打印
        for(int i=0;i<=4;i++){
            Poker p = new Poker(common[i]);
//            System.out.println(common[i]);
            p.putout();
        }
        while(true){                                              //随机选择两套底牌
            poketcard1[0] = (int) Math.round(Math.random() * 51) + 1;
            int j = 0;
            for(int i = 0;i <5;i++){
                if(poketcard1[0]!=common[i])j++;
            }
            if(j == 5)break;
        }
        while(true) {
            poketcard1[1] = (int) Math.round(Math.random() * 51) + 1;
            int j = 0;
            for (int i = 0; i < 5; i++) {
                if (poketcard1[1] != common[i]) j++;
            }
            if (poketcard1[1] != poketcard1[0]) j++;
            if (j == 6) break;
        }
        while(true){
            poketcard2[0] = (int) Math.round(Math.random() * 51) + 1;
            int j = 0;
            for(int i = 0;i <5;i++){
                if(poketcard2[0]!=common[i])j++;
            }
            if(poketcard2[0]!=poketcard1[0]&&poketcard2[0]!=poketcard1[1])j++;
            if(j == 6)break;
        }
        while(true) {
            poketcard2[1] = (int) Math.round(Math.random() * 51) + 1;
            int j = 0;
            for (int i = 0; i < 5; i++) {
                if (poketcard2[1] != common[i]) j++;
            }
            if (poketcard2[1] != poketcard1[0]&&poketcard2[1]!=poketcard1[1]&&poketcard2[1]!=poketcard1[0]) j++;
            if (j == 6) break;
        }
        /*System.out.println(poketcard1[0]);
        Poker p = new Poker(poketcard1[0]);
        p.putout();
        System.out.println(poketcard1[1]);
        p = new Poker(poketcard1[1]);
        p.putout();
        System.out.println(poketcard2[0]);
        p = new Poker(poketcard2[0]);
        p.putout();
        System.out.println(poketcard2[1]);
        p = new Poker(poketcard2[1]);
        p.putout();*/

        /*poketcard1[0] = 7;             //底牌预设(注释后为随机底牌)
        poketcard1[1] = 25;              //
        poketcard2[0] = 9;               //
        poketcard2[1] = 13;*/            //

        System.out.println("牌组一为：");//底牌打印
        Poker p1 = new Poker(poketcard1[0]);
        p1.putout();
        p1 = new Poker(poketcard1[1]);
        p1.putout();
        System.out.println("牌组二为：");
        Poker p2 = new Poker(poketcard2[0]);
        p2.putout();
        p2 = new Poker(poketcard2[1]);
        p2.putout();

        Style style1 = new Style(common,poketcard1);//牌型判断，类在第314行
        Style style2 = new Style(common,poketcard2);
        long poker1 = 0;                            //牌的分值(自己定义的分值，便于比较)
        long poker2 = 0;

        switch (compare(style1.royalflush,style2.royalflush)){//牌型比较加计算分值
            case 1:
                poker1 = poker1 + 512;
                break;
            case -1:
                poker2 = poker2 + 512;
                break;
        }
        /*System.out.println(compare(style1.royalflush,style2.royalflush));
        System.out.println(poker1+" "+poker2);*/
        switch (compare(style1.straightflush,style2.straightflush,style1.straightflush1,style2.straightflush1)){
            case 1:
                poker1 = poker1 + 256;
                break;
            case -1:
                poker2 = poker2 + 256;
                break;
        }
        /*System.out.println(compare(style1.straightflush,style2.straightflush,style1.straightflush1,style2.straightflush1));
        System.out.println(poker1+" "+poker2);*/
        switch (compare(style1.four,style2.four,style1.four1,style2.four1)){
            case 1:
                poker1 = poker1 + 128;
                break;
            case -1:
                poker2 = poker2 + 128;
                break;
        }
        /*System.out.println(compare(style1.four,style2.four,style1.four1,style2.four1));
        System.out.println(poker1+" "+poker2);*/
        switch (compare(style1.fullhouse,style2.fullhouse,style1.fullhouse1,style2.fullhouse1,style1.fullhouse2,style2.fullhouse2)){
            case 1:
                poker1 = poker1 + 64;
                break;
            case -1:
                poker2 = poker2 + 64;
                break;
        }
       /* System.out.println(compare(style1.fullhouse,style2.fullhouse,style1.fullhouse1,style2.fullhouse1,style1.fullhouse2,style2.fullhouse2));
        System.out.println(poker1+" "+poker2);*/
        switch (compare(style1.flush,style2.flush,style1.flush1,style2.flush1)){
            case 1:
                poker1 = poker1 + 32;
                break;
            case -1:
                poker2 = poker2 + 32;
                break;
        }
        /*System.out.println(style1.flush1+" "+style2.flush1);
        System.out.println(compare(style1.flush,style2.flush,style1.flush1,style2.flush1));
        System.out.println(poker1+" "+poker2);*/
        switch (compare(style1.straight,style2.straight,style1.straight1,style2.straight1)){
            case 1:
                poker1 = poker1 + 16;
                break;
            case -1:
                poker2 = poker2 + 16;
                break;
        }
        /*System.out.println(compare(style1.straight,style2.straight,style1.straight1,style2.straight1));
        System.out.println(poker1+" "+poker2);*/
        switch (compare(style1.three,style2.three,style1.three1,style2.three1)){
            case 1:
                poker1 = poker1 + 8;
                break;
            case -1:
                poker2 = poker2 + 8;
                break;
        }
        /*System.out.println(compare(style1.three,style2.three,style1.three1,style2.three1));
        System.out.println(poker1+" "+poker2);*/
        switch (compare(style1.twopair,style2.twopair,style1.twopair1,style2.twopair1)){
            case 1:
                poker1 = poker1 + 4;
                break;
            case -1:
                poker2 = poker2 + 4;
                break;
        }
        /*System.out.println(compare(style1.twopair,style2.twopair,style1.twopair1,style2.twopair1));
        System.out.println(poker1+" "+poker2);*/

        switch (compare(style1.onepair,style2.onepair,style1.onepair1,style2.onepair1)){
            case 1:
                poker1 = poker1 + 2;
                break;
            case -1:
                poker2 = poker2 + 2;
                break;
        }
        /*System.out.println(compare(style1.onepair,style2.onepair,style1.onepair1,style2.onepair1));
        System.out.println(poker1+" "+poker2);*/

        switch (compare(style1.high,style2.high,style1.high1,style2.high1)){
            case 1:
                poker1 = poker1 + 1;
                break;
            case -1:
                poker2 = poker2 + 1;
                break;
        }
        /*System.out.println(compare(style1.high,style2.high,style1.high1,style2.high1));
        System.out.println(poker1+" "+poker2);*/
        if(poker1 > poker2){
            System.out.println("牌组一大");
        }
        else if(poker1 < poker2){
            System.out.println("牌组二大");
        }
        else{
            System.out.println("平局");
        }
    }

    static int compare(boolean a,boolean b){                    //牌型比较静态方法
        if(a ==true && b == false){
            return  1;
        }
        else if (a==false&&b==true){
            return  -1;
        }
        else if(a==true&&b==true){
            return  2;
        }
        else{
            return  0;
        }
    }
    static int compare(boolean a,boolean b,int c,int d){
        if(a==true&&b==false){
            return  1;
        }
        else if (a==false&&b==true){
            return  -1;
        }
        else if(a==true&&b==true){
            if(c>d){
                return 1;
            }
            else if(c<d){
                return -1;
            }
            else{
                return  0;
            }
        }
        else{
            return  0;
        }
    }
    static int compare(boolean a,boolean b,int c,int d,int e,int f){
        if(a==true&&b==false){
            return  1;
        }
        else if (a==false&&b==true){
            return  -1;
        }
        else if(a==true&&b==true){
            if(c>d){
                return 1;
            }
            else if(c<d){
                return -1;
            }
            else {
                if(e>f){
                    return  1;
                }
                else if(e<f){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
        else{
            return  0;
        }
    }
}