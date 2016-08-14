package app.request_body_dtos;

public class SearchDonkeyDTO {

    private String name;
    private int age;
    private String temper;

    public SearchDonkeyDTO() {}

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

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }
}
