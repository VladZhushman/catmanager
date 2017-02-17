package com.cats.service;


import com.cats.dao.CatDao;
import com.cats.model.Cat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    private CatDao catDao;

    public void setCatDao(CatDao catDao) {
        this.catDao = catDao;
    }


    @Override
    @Transactional
    public void addCat(Cat cat) {
        this.catDao.addCat(cat);
    }

    @Override
    @Transactional
    public void updateCat(Cat cat) {
        this.catDao.updateCat(cat);
    }

    @Override
    @Transactional
    public void removeCat(int id) {
        this.catDao.removeCat(id);
    }

    @Override
    @Transactional
    public Cat getCatById(int id) {
        return this.catDao.getCatById(id);
    }

    @Override
    @Transactional
    public List<Cat> listCats() {
        return this.catDao.listCats();
    }
}
