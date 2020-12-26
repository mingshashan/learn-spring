package com.mingshashan.learn.integration.test;

/**
 * User
 *
 * @author xufj
 */
public class Student {
    private long id;
    private String name;
    private String major;
    private Integer age;

    public Student(long id, String name, String major, int age) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", major='").append(major).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }
}
