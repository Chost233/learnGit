/**
 * Created by Administrator on 2016/10/12.
 */

public class Style{               //检验牌型
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
