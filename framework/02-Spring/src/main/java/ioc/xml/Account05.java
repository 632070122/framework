package ioc.xml;
import java.util.Date;

public class Account05 {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void person(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(birthday);
    }
}
