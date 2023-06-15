package model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = false)
    @JoinColumn(name = "city_id")
    private Set<Employee> employee;

    public City() {
    }

    public City(Integer city_id, String city_name) {
        this.cityId = city_id;
        this.cityName = city_name;
    }

    public City(String city_name) {
        this.cityName = city_name;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer city_id) {
        this.cityId = city_id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String city_name) {
        this.cityName = city_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId.equals(city.cityId) && cityName.equals(city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName);
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + cityId +
                ", city_name='" + cityName + '\'' +
                '}';
    }
}
