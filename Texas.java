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

class Style{               //检验牌型
    boolean royalflush = false;                //皇家同花顺
    boolean straightflush = false;             //同花顺
    int straightflush1 = 0;                    //同花顺最大牌点数
    boolean four = false;                      //四条
    int four1 = 0;                             //四条最大牌点数
    boolean fullhouse = false;                 //葫芦
    int fullhouse1 = 0;                        //三张牌的点数
    int fullhouse2 = 0;                        //两张牌的点数
    boolean flush = false;                     //同花
    int flush1 = 0;                            //最大牌点数
    boolean straight = false;                  //顺子
    int straight1 = 0;                         //最大牌点数
    boolean three = false;                     //三条
    int three1 = 0;                            //点数
    boolean twopair = false;                   //两对
    int twopair1 = 0;                          //点数
    boolean onepair = false;                   //一对
    int onepair1 = 0;                          //点数
    boolean high = false;                      //高牌
    int high1 = 0;                             //最大牌点数

    Style(int[] a,int[] b) {                   //判断牌型
        int[] c = new int[7];
        for (int i = 0; i < 5; i++) {
            c[i] = a[i];
        }
        c[5] = b[0];
        c[6] = b[1];
        for (int i = 0; i < 7; i++) {                        //皇家同花顺判断
            if (c[i] == 1) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == 10) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == 11) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == 12) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == 13) {
                                                royalflush = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            if (c[i] == 14) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == 23) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == 24) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == 25) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == 26) {
                                                royalflush = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            if (c[i] == 27) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == 36) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == 37) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == 38) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == 39) {
                                                royalflush = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            if (c[i] == 40) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == 49) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == 50) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == 51) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == 52) {
                                                royalflush = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) {                             //同花顺判断
            if (c[i] >= 2 && c[i] <= 10) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] + 1) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] + 1) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == c[k] + 1) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == c[l] + 1) {
                                                straightflush = true;
                                                straightflush1 = c[m];
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            if (c[i] >= 15 && c[i] <= 23) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] + 1) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] + 1) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == c[k] + 1) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == c[l] + 1) {
                                                straightflush = true;
                                                straightflush1 = c[m];
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            if (c[i] >= 28 && c[i] <= 38) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] + 1) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] + 1) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == c[k] + 1) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == c[l] + 1) {
                                                straightflush = true;
                                                straightflush1 = c[m];
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            if (c[i] >= 41 && c[i] <= 49) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] + 1) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] + 1) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == c[k] + 1) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == c[l] + 1) {
                                                straightflush = true;
                                                straightflush1 = c[m];
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) {                       //四条判断
            if (c[i] >= 1 && c[i] <= 13) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] + 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] + 13) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == c[k] + 13) {
                                        four = true;
                                        four1 = c[i];
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (c[i] >= 14 && c[i] <= 26) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[i] + 13) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == c[k] + 13) {
                                        four = true;
                                        four1 = c[i]-13;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (c[i] >= 27 && c[i] <= 39) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] - 13) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == c[i] + 13) {
                                        four = true;
                                        four1 = c[i]-26;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (c[i] >= 40 && c[i] <= 52) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] - 13) {
                                for (int l = 0; l < 7; l++) {
                                    if (c[l] == c[k] - 13) {
                                        four = true;
                                        four1 = c[i]-39;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) {                       //葫芦判断
            if (c[i] >= 1 && c[i] <= 13) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] + 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] + 13) {
                                for (int l = 0; l < 7; l++) {
                                    if (l != i && l != j && l != k && c[l] >= 1 && c[l] <= 13) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == c[l] + 13 || c[m] == c[l] + 26 || c[m] == c[l] + 39) {
                                                if (m != i && m != j && m != k) {
                                                    fullhouse = true;
                                                    fullhouse1 = c[i];
                                                    fullhouse2 = c[l];
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (c[i] >= 14 && c[i] <= 26) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[i] + 13) {
                                for (int l = 0; l < 7; l++) {
                                    if (l != i && l != j && l != k && c[l] >= 14 && c[l] <= 26) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == c[l] - 13 || c[m] == c[l] + 13 || c[m] == c[l] + 26) {
                                                if (m != i && m != j && m != k) {
                                                    fullhouse = true;
                                                    fullhouse1 = c[i]-13;
                                                    fullhouse2 = c[l]-13;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (c[i] >= 27 && c[i] <= 39) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] - 13) {
                                for (int l = 0; l < 7; l++) {
                                    if (l != i && l != j && l != k && c[l] >= 27 && c[l] <= 39) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == c[l] - 13 || c[m] == c[l] - 26 || c[m] == c[l] + 13) {
                                                if (m != i && m != j && m != k) {
                                                    fullhouse = true;
                                                    fullhouse1 = c[i]-26;
                                                    fullhouse2 = c[l]-26;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (c[i] >= 40 && c[i] <= 52) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] - 13) {
                                for (int l = 0; l < 7; l++) {
                                    if (l != i && l != j && l != k && c[l] >= 40 && c[l] <= 52) {
                                        for (int m = 0; m < 7; m++) {
                                            if (c[m] == c[l] - 13 || c[m] == c[l] - 26 || c[m] == c[l] - 39) {
                                                if (m != i && m != j && m != k) {
                                                    fullhouse = true;
                                                    fullhouse1 = c[i]-39;
                                                    fullhouse2 = c[l]-39;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        int ss,dd,hh,cc;                   //同花判断
        ss = 0;dd = 0;hh = 0;cc = 0;       //各花色牌张数
        for(int i = 0; i<7;i++){
            if(c[i]>=1&&c[i]<=13){
                ss++;
            }
            else if(c[i]>=14&&c[i]<=26){
                dd++;
            }
            else if(c[i]>=27&&c[i]<=39){
                hh++;
            }
            else if(c[i]>=40&&c[i]<=52){
                cc++;
            }
            if(ss>=5||dd>=5||hh>=5||cc>=5){
                flush = true;
                if(ss>=5){                //找最大点数
                    int ii = 0;
                    for(int j = 0;j<7;j++){
                        if(c[j]>=1&&c[j]<=13){
                            for(int k = 0;k<7;k++){
                                if(c[k]>=1&&c[k]<=13&&c[k]<=c[j]){
                                    ii++;
                                }
                            }
                            if(ii >= 5){
                                flush1 = c[j];
                            }
                        }
                    }
                }
                else if(dd>=5){
                    int ii = 0;
                    for(int j = 0;j<7;j++){
                        if(c[j]>=14&&c[j]<=26){
                            for(int k = 0;k<7;k++){
                                if(c[k]>=14&&c[k]<=26&&c[k]<=c[j]){
                                    ii++;
                                }
                            }
                            if(ii >= 5){
                                flush1 = c[j]-13;
                            }
                        }
                    }
                }
                else if(hh>=5){
                    int ii = 0;
                    for(int j = 0;j<7;j++){
                        if(c[j]>=27&&c[j]<=39){
                            for(int k = 0;k<7;k++){
                                if(c[k]>=27&&c[k]<=39&&c[k]<=c[j]){
                                    ii++;
                                }
                            }
                            if(ii >= 5){
                                flush1 = c[j]-26;
                            }
                        }
                    }
                }
                else if(cc>=5){
                    int ii = 0;
                    for(int j = 0;j<7;j++){
                        if(c[j]>=40&&c[j]<=52){
                            for(int k = 0;k<7;k++){
                                if(c[k]>=40&&c[k]<=52&&c[k]<=c[j]){
                                    ii++;
                                }
                            }
                            if(ii >= 5){
                                flush1 = c[j]-39;
                            }
                        }
                    }
                }
                break;
            }
        }

        Poker pi,pj,pk,pl,pm;                //顺子判断
        for (int i = 0; i < 7; i++) {
            pi = new Poker(c[i]);
            if (pi.point >= 2 && pi.point <= 10) {
                for (int j = 0; j < 7; j++) {
                    pj = new Poker(c[j]);
                    if (pj.point == pi.point + 1) {
                        for (int k = 0; k < 7; k++) {
                            pk = new Poker(c[k]);
                            if (pk.point == pj.point + 1) {
                                for (int l = 0; l < 7; l++) {
                                    pl = new Poker(c[l]);
                                    if (pl.point == pk.point + 1) {
                                        for (int m = 0; m < 7; m++) {
                                            pm = new Poker(c[m]);
                                            if (pm.point == pl.point + 1) {
                                                straight = true;
                                                straight1 = pm.point;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 7; i++) {                       //三条判断
            if (c[i] >= 1 && c[i] <= 13) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] + 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] + 13||c[k] == c[j]+26){
                                three = true;
                                three1 = c[i];
                                break;
                            }
                        }
                    }
                }
            } else if (c[i] >= 14 && c[i] <= 26) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[i] + 13||c[k] == c[i]+26) {
                                three = true;
                                three1 = c[j];
                                break;
                            }
                        }
                    }
                }
            } else if (c[i] >= 27 && c[i] <= 39) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] - 13||c[k] == c[i]+13) {
                                three = true;
                                three1 = c[i]-26;
                                break;
                            }
                        }
                    }
                }
            } else if (c[i] >= 40 && c[i] <= 52) {
                for (int j = 0; j < 7; j++) {
                    if (c[j] == c[i] - 13) {
                        for (int k = 0; k < 7; k++) {
                            if (c[k] == c[j] - 13|| c[k] == c[j] - 26) {
                                three = true;
                                three1 = c[i]-39;
                                break;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0;i<7;i++){                       //两对||一对判断
            Poker pp = new Poker(c[i]);
            for(int j = 0;j<7;j++){
                if(j!=i){
                Poker pp2 = new Poker(c[j]);
                    if(pp2.point == pp.point){
                        onepair = true;
                        onepair1 = pp.point;
                        for(int k = 0;k<7;k++){
                            if(k!=i&&k!=j){
                                Poker pp3 = new Poker(c[j]);
                                for(int l = 0;l<7;l++){
                                    if(l!=i&&l!=j&&l!=k){
                                        Poker pp4 = new Poker(c[l]);
                                        if(pp4.point == pp3.point){
                                            twopair = true;
                                            if(pp.point>pp3.point){
                                                twopair1 = pp.point;
                                            }
                                            else if(pp.point<pp3.point){
                                                twopair1 = pp3.point;
                                            }
                                            else{
                                                twopair1 = pp.point;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        high = true;
        for(int i = 0;i<7;i++){
            int ii = 0;
            for(int k = 0;k<7;k++){
                if (c[i]>=c[k]){
                    ii++;
                }
            }
            if(ii == 7){
                high1 = c[i];
            }
        }

        /*System.out.println("皇家同花顺"+royalflush);
        System.out.println("同花顺"+straightflush);
        System.out.println("四条"+four);
        System.out.println("葫芦"+fullhouse);
        System.out.println("同花"+flush);
        System.out.println("顺子"+straight);
        System.out.println("三条"+three);
        System.out.println("两对"+twopair);
        System.out.println("一对"+onepair);
        System.out.println("高牌"+high);   //结果打印便于调试*/

    }
}

class Poker{//poker类
    String Suit;
    String Point;
    int suit;
    int point;
    Poker(int a){         //输入值转化为花色与点数
        if(a>=1&&a<=13){
            this.Suit = "spade    ";
            this.Point = String.valueOf(a);
            this.suit = 1;
            this.point = a;
        }
        else if(a<=26){
            this.Suit = "diamond  ";
            this.Point = String.valueOf(a-13);
            this.suit = 1;
            this.point = a-13;
        }
        else if(a<=39){
            this.Suit = "heart    ";
            this.Point = String.valueOf(a-26);
            this.suit = 3;
            this.point = a-26;
        }
        else if(a<=52){
            this.Suit = "club     ";
            this.Point = String.valueOf(a-39);
            this.suit = 4;
            this.point = a-39;
        }
        else if(a<=54){
            if(a==53){
                this.Suit = "black";
                this.Point = " joker";
            }
            else if(a==54){
                this.Suit = "red";
                this.Point = "  joker";
            }
        }
        else{
            out.println("不符合要求");
        }
    }
    public void putout(){
        out.println(this.Suit+this.Point);
    } //打印花色和点数
}