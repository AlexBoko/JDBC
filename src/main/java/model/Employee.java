package model;

import hibernate.model.City;
import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private hibernate.model.City city;

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

    public hibernate.model.City getCity() {
        return (hibernate.model.City) city;
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

        public void setCity(City city) {
            this.city = city;
            }

    public Employee(int id, String first_name, String last_name, String gender, int age, City city) {
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
                            + "  Город проживания: " + city.toString();
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;
                    Employee employee = (Employee) o;
                    return id == employee.id && age == employee.age && city == employee.city && Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(gender, employee.gender);
                }
                @Override
                public int hashCode() {
                    return Objects.hash(id, first_name, last_name, gender, age, city);
                }
            }