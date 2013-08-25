package org.mael.blog.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mael.blog.dao.NewsDao;
import org.mael.blog.model.NewsEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private SessionFactory factory;

    public NewsDaoImpl() {
    }

    @Override
    @Transactional
    public List<NewsEntry> loadNews() {
        return this.createQuery("from NewsEntry");
    }

    @Override
    @Transactional
    public void createNew(NewsEntry entry) {
        this.currentSession().persist(entry);
    }

    private Session currentSession() {
        return this.factory.getCurrentSession();
    }

    public SessionFactory getFactory() {
        return this.factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> createQuery(final String hql) {
        return (List<T>) this.currentSession().createQuery(hql).list();
    }

}
