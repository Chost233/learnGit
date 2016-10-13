/**
 * Created by Administrator on 2016/10/12.
 */

public class Poker{//poker类
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
            System.out.println("不符合要求");
        }
    }
    public void putout(){
        System.out.println(this.Suit+this.Point);
    } //打印花色和点数
}
