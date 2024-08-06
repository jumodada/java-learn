package org.example;

public class Student {
    public Integer id;
    public String name;
    public String sex;
    public String province;
    public int age;
    public int height = 180;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void initStudent(String name, String sex, int age, String province, int height) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.province = province;
        this.height = height;
    }
}
