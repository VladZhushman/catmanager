package com.cats.service;


import com.cats.model.Cat;

import java.util.List;

public interface CatService {

    public void addCat(Cat cat);

    public void updateCat(Cat cat);

    public void removeCat(int id);

    public Cat getCatById(int id);

    public List<Cat> listCats();

}
