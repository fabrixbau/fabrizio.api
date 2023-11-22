package edteam.fabrizio.models;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", updatable = false, nullable=false)
    private long id;

    @Column(columnDefinition="DATETIME", updatable = false, nullable = false)
    protected Date createDate;

    @Column(columnDefinition="DATETIME", updatable = false, nullable = false)
    protected Date updateDate;

    @PrePersist
    protected void onCreate(){
        updateDate = new Date();
        if (createDate == null){
            createDate= new Date();
        }
    }
}