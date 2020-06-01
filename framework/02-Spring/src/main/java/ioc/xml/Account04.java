package ioc.xml;
import java.util.Date;

public class Account04 {

    private String name;
    private Integer age;
    private Date birthday;

    public Account04(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void person(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(birthday);
    }
}
