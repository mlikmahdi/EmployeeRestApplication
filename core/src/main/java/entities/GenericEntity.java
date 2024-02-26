package entities;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class GenericEntity {
    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_at", insertable = false)
    private LocalDate updatedAt;

    @Column(name = "updated_by", insertable = false)
    private String updatedBy;
}
