/**
 * Created by Administrator on 2016/10/16.
 */
public class Test {
    public static void main(String args[]){
        Human senior[] = new Human[6];
        senior[0] = new Human("曾名杨",18,"男");
        senior[1] = new Human("徐书展",18,"男");
        senior[2] = new Human("郑昱旋",18,"男");
        senior[3] = new Human("曹越",18,"男");
        senior[4] = new Human("饶东",18,"男");
        senior[5] = new Human("吴随",18,"女吧...");
        for(int i = 0;i<6;i++){
            senior[i].introduce();
        }
    }
}
