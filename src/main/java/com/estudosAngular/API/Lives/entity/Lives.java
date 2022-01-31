package com.estudosAngular.API.Lives.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Data @Table(name = "tb_live")
public class Lives {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String canal;
    private LocalDateTime data;
    private String link;
    private LocalDateTime registro;
}
