package com.ibm.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.annotation.Target;


@Entity
//@Table(name = "wikimedia_recentchange")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;

}
