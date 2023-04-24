package model;
public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private model.City city;


    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public model.City getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(model.City city) {
        this.city = city;
    }

    public Employee(int id, String first_name, String last_name, String gender, int age, model.City city) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee() {
    }


    @Override
    public String toString() {
        return "id: " + getId() + "  Имя: " + getFirst_name() + "  Фамилия: "
                + getLast_name() + "  Пол: " + getGender() + "  Возраст: " + getAge()
                + "  Город проживания: " + getCity().toString();
    }
}
