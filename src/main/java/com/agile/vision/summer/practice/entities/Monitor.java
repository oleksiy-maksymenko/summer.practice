package com.agile.vision.summer.practice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity(name = "monitor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@ToString(exclude = "place")
@EqualsAndHashCode(exclude = "place")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(Double displaySize) {
        this.displaySize = displaySize;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}