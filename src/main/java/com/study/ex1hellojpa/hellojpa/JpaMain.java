package com.study.ex1hellojpa.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

//            Member member = em.find(Member.class, 1L);
//            member.setName("HelloJPA");
            List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
//            result.forEach(member -> {
//                System.out.println(member.getId()+ ":"+ member.getName());
//            });
//            for (Member member : result) {
//                System.out.println("meber.name : "+member.getName());
//            }

            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).getName());
            }



            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
