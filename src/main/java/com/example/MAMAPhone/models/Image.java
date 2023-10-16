package com.example.MAMAPhone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id; // foreign key здесь
    @Column(name = "size")
    private Long size;
    @Column(name = "name")
    private String name;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;
    @Lob
    //@Column(name="bytes", columnDefinition = "longblob") //для разрешения проблемы малости массива байтов - вылетает 500
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Rate rate;
}