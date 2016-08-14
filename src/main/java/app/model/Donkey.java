package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donkey {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String temper;

    protected Donkey() {}

    public Donkey(String name, int age, String temper) {
        this.name = name;
        this.age = age;
        this.temper = temper;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTemper() {
        return temper;
    }

    @Override
    public String toString() {
        return "Donkey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", temper='" + temper + '\'' +
                '}';
    }
}
