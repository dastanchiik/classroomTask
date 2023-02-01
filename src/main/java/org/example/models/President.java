package org.example.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;

@Getter
@Setter
@ToString
public class President {
    private Long id;

    private String name;

    private int age;

    public President() {
    }

    public President(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
