package be.campus.training.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by wvdbrand on 6/09/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@MappedSuperclass
public class DatabaseEntity implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;


    public DatabaseEntity() {
    }

    public DatabaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatabaseEntity)) return false;

        DatabaseEntity databaseEntity = (DatabaseEntity) o;

        return id.equals(databaseEntity.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}