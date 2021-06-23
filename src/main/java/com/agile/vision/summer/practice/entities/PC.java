package com.agile.vision.summer.practice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pc")
@EqualsAndHashCode(exclude = "place")
public class PC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_at")
    private String updatedAt;
    private Double length;
    private Double height;
    private Double width;
    @Column(name = "hdd_size")
    private Integer hddSize;
    @Column(name = "cpu_count")
    private Integer cpuCount;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Place place;

    @Override
    public String toString() {
        return id.toString();
    }

}

