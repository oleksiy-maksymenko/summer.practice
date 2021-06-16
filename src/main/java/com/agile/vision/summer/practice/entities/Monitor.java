package com.agile.vision.summer.practice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(
        

        name = "monitor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monitor {
    @Id
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
    @Column(name = "display_size")
    private Double displaySize;

    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "place_id")
    private Place place;

}