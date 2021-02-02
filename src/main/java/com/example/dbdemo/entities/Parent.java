package com.example.dbdemo.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.INCREMENT_PARAM;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.OPT_PARAM;

@Entity
@Table
@Getter
@Setter
public class Parent {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "pg_id_seq")
    @GenericGenerator(
            name = "pg_id_seq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, value = "_id_seq"),
                    @Parameter(name = CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true"),
                    @Parameter(name = INCREMENT_PARAM, value = "50"),
                    @Parameter(name = OPT_PARAM, value = "hilo")
            }
    )
    private Long id;

    private String name;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Child> children;


}
