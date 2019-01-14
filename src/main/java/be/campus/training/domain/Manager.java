package be.campus.training.domain;

import java.util.Date;
import java.util.Set;

/**
 * Created by wvdbrand on 24/08/2017.
 */
public class Manager extends Worker {
    // every sub-class of worker has a hireDate, a worker doesn't
    private Date hireDate;

    private Set<EmployeeFile> subordinates;

    public Manager(Integer id, String name, Integer age, Gender gender, Date hireDate) {
        super(id, name, age, gender);
        this.hireDate = hireDate;
    }

    @Override
    public Float calculateSalary(Float... objects) {
        return null;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Set<EmployeeFile> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<EmployeeFile> subordinates) {
        this.subordinates = subordinates;
    }
}
