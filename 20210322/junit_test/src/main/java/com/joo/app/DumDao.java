package com.joo.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DumDao {
   
   @Autowired
   private SessionFactory sessionFactory;
   
   
   public void insertDummy(DumDto dto) {
      Session session = sessionFactory.getCurrentSession();
      Transaction trans = session.beginTransaction();
      
      session.save(dto);
      //session.delete(trans);
      //session.update(trans);
      trans.commit();
   }
   
   public DumDto selectDummy(DumDto dto) {
      Session session = sessionFactory.getCurrentSession();
      Transaction trans = session.beginTransaction();
      
      DumDto d=(DumDto) session.get(DumDto.class, dto.getIdx());
      
      
      trans.commit();
      return d;
   }
   public List<DumDto> selectDummy() {
      Session session = sessionFactory.getCurrentSession();
      Transaction trans = session.beginTransaction();
      
      List<DumDto> list= session.createCriteria(DumDto.class).list();
      
      trans.commit();
      return list;
   }
   
   
}





