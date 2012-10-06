package com.umitunal.persistence;

import com.umitunal.model.Country;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: umitunal
 */
public aspect CountryPersistence {

    declare @type: com.umitunal.model.Country:@Configurable;

    declare @type: com.umitunal.model.Country:@Entity;

    @Autowired
    private transient SessionFactory Country.sessionFactory;

    @Transactional
    public void Country.persist() {
        sessionFactory.openSession().save(this);
    }

    @Transactional(readOnly = true)
    public static List<Country> Country.findAll() {
        return new Country().sessionFactory.openSession().createCriteria(Country.class).list();
    }

    @Transactional(readOnly = true)
    public static Country Country.findById(Long id) {
        return (Country) new Country().sessionFactory.openSession().get(Country.class, id);
    }

}