package by.it_academy.jd2.mk_jd2_103_23.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "doc", schema = "doclesson")
public class DocEntity {
    @Id
    private UUID id;
    private String name;
    private String description;

    private LocalDateTime dtupdate;

    @Version
    public LocalDateTime getDtUpdate() {
        return dtupdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtupdate = dtUpdate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
