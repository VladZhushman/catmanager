package com.cats.model;

import javax.persistence.*;

@Entity
@Table(name = "CATS")
public class Cat {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CAT_NAME")
    private String catName;

    @Column(name = "CAT_OWNER")
    private String catOwner;

    @Column(name = "CAT_COLOR")
    private String catColor;

    @Column(name = "CAT_PHOTO")
    private String photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatOwner() {
        return catOwner;
    }

    public void setCatOwner(String catOwner) {
        this.catOwner = catOwner;
    }

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", catName='" + catName + '\'' +
                ", catOwner='" + catOwner + '\'' +
                ", catColor='" + catColor + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
