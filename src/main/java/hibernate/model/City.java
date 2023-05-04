package hibernate.model;
import lombok.Builder;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int city_id;
    @Column(name = "city_name")
    private String city_name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employee> employees;


    public int getCity_id() {
        return city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


    public City() {
    }

    public City(int city_id, String city_name, List<Employee> employees) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.employees = employees;
    }


    public String toString() {
        return city_id + city_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return city_id == city.city_id && city_name.equals(city.city_name) && employees.equals(city.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id, city_name, employees);
    }
}