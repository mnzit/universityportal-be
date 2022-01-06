package com.nepalaya.up.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity<T extends User> implements Serializable {

    @Id
    @JsonIgnore
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate;

    @LastModifiedDate
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_DATE",insertable = false)
    private Date modifiedDate;

    @CreatedBy
    @JsonIgnore
    @JoinColumn(name = "CREATED_BY", referencedColumnName = "ID", updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private T createdBy;

    @LastModifiedBy
    @JsonIgnore
    @JoinColumn(name = "MODIFIED_BY", referencedColumnName = "ID", insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private T modifiedBy;

    @JsonIgnore
    @Generated(GenerationTime.INSERT)
    @Column(name = "STATUS", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean status;

    public BaseEntity(Long id) {
        this.id = id;
    }
}