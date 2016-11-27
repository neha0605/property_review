package com.property.feedback.repository.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by hojha on 19/10/16.
 */
@MappedSuperclass
public class BaseEntity {

    @Column(name = "createdon", nullable = false)
    protected Date createdOn;

    @Column(name = "updatedon")
    protected Date updatedOn;

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @PrePersist
    protected void onPrePersist() {
        createdOn = new Date();
    }

    @PreUpdate
    protected void onPostUpdate() {
        updatedOn = new Date();
    }
}
