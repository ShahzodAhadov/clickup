package uz.pdp.clickup.entity;


import lombok.*;
import org.hibernate.Hibernate;
import uz.pdp.clickup.entity.template.AbstractUUIDEntity;

import javax.persistence.Entity;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Attachment extends AbstractUUIDEntity {
    private String name;

    private String originalName;

    private Long size;

    private String contentType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attachment that = (Attachment) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
