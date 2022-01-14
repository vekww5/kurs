package ru.rsatu.service;

import ru.rsatu.pojo.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SectionService {

    @Inject
    EntityManager em;

    //вставка данных
    @Transactional
    public Section insertSection(Section sc) {
        //em.merge(sc);
        em.persist(sc);
        em.flush();
        return sc;
    }

    //обновление данных
    @Transactional
    public Section updateSection(Section sc) {
        em.merge(sc);
        em.flush();
        return sc;
    }

    //удаление данных
    @Transactional
    public void deleteSection(Long id_section) {
        Section l = this.getSectionById(id_section);
        em.remove(l);
        em.flush();
    }

    // Получение списка
    public List<Section> getSections(){
        return em.createQuery("select s from Section s", Section.class).getResultList();
    }

    // Поиск по ID
    public Section getSectionById(Long id_section){
        Section sc = em.find(Section.class, id_section);
        return sc;
    }
}
