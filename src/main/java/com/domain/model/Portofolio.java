package com.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "portofolio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Portofolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String project;
    private String description;
    private String date;
    private String user;
    private String program;
    private String github;
    private String image1;
    private String image2;
    private String video;
}
