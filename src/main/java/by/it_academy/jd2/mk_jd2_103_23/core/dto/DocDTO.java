package by.it_academy.jd2.mk_jd2_103_23.core.dto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class DocDTO {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime dtupdate;

    public LocalDateTime getDtupdate() {
        return dtupdate;
    }

    public void setDtupdate(LocalDateTime dtupdate) {
        this.dtupdate = dtupdate;
    }

    public DocDTO() {
    }

    public DocDTO(UUID id, String name, String description, LocalDateTime dtupdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dtupdate = dtupdate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocDTO docDTO = (DocDTO) o;

        if (!Objects.equals(id, docDTO.id)) return false;
        if (!Objects.equals(name, docDTO.name)) return false;
        if (!Objects.equals(description, docDTO.description)) return false;
        return Objects.equals(dtupdate, docDTO.dtupdate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dtupdate != null ? dtupdate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DocDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dtupdate=" + dtupdate +
                '}';
    }
}
