package com.pucp.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "blog_post")
@Getter
@Setter
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 15)
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "autor")
    private String autor;

    @Column(name="fecha_publicacion")
    private String fechaPublicacion;

    @Column(name="categoria")
    private String categoria;

}
