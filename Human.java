/**
 * Created by Administrator on 2016/10/16.
 */
public class Human {
    private String name;
    private int age;
    private String sex;

    Human(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void introduce(){
        System.out.println("姓名："+this.name+"\n年龄："+this.age+"\n性别："+this.sex);
    }
}
