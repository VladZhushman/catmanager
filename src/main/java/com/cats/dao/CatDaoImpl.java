package com.cats.dao;

import com.cats.model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatDaoImpl implements CatDao {

    private static final Logger logger = LoggerFactory.getLogger(CatDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCat(Cat cat) {

        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cat);
        logger.info("Cat successfully saved. Cat details: " + cat);

    }

    @Override
    public void updateCat(Cat cat) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(cat);
        logger.info("Cat successfully updated. Cat details: "+ cat);
    }

    @Override
    public void removeCat(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Cat cat  = (Cat) session.load(Cat.class, id);

        if (cat != null){
            session.delete(cat);
        }

        logger.info("Cat successfully removed. Cat details: "+ cat);
    }

    @Override
    public Cat getCatById(int id) {

        Session session = sessionFactory.getCurrentSession();
        Cat cat = (Cat)session.load(Cat.class, id);
        logger.info("Cat successfully load. Cat details: "+ cat);
        return  cat;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cat> listCats() {
        Session session = sessionFactory.getCurrentSession();
        List<Cat> catList = session.createQuery("from Cat").list();

        for (Cat cat : catList){
            logger.info("Cat list: " + cat);
        }

        return catList;
    }
}
