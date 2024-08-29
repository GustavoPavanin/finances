package com.personal.finances.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class AuditableEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
        this.updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
