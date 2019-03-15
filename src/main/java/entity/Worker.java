package entity;

import enums.Availability;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Worker")
@EqualsAndHashCode
public class Worker {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "age")
    private int age;

    @Enumerated(value = EnumType.STRING)
    private Availability availability;

    @Column(name = "full_Name")
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public Worker() {
    }

    public Worker(int age, Availability availability, String fullName) {
        this.age = age;
        this.availability = availability;
        this.fullName = fullName;
    }

    public <T> Worker(int i, Availability fullTime, String taras_tkhir, T load) {
    }

    public Department getDepartment() {
        return department;
    }

    public Availability getAvailability() {
        return availability;
    }

    public String getFullName() {
        return fullName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "age=" + age +
                ", availability=" + availability +
                ", fullName='" + fullName + '\'' +
                '}';
    }


}
