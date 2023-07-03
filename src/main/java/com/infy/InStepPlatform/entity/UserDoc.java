package com.infy.InStepPlatform.entity;

import jakarta.persistence.*;

@Entity(name = "user_documents")
public class UserDoc extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    private String doc_name;
    @Lob
    private byte[] doc;
}
