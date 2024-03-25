package com.neostore.domain.repositories;

import com.neostore.domain.model.Supplier;
import com.neostore.core.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class SupplierRepository {

     public List<Supplier> GetAll(int page, int size){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Supplier> query = em.createQuery("SELECT s FROM Supplier s", Supplier.class);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Supplier Get(final int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Supplier.class, id);
        } finally {
            em.close();
        }
    }

    public Supplier findByCnpj(String cnpj) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Supplier> query = em.createQuery("SELECT s FROM Supplier s WHERE s.cnpj = :cnpj", Supplier.class);
            query.setParameter("cnpj", cnpj);
            return query.getResultList().stream().findFirst().orElse(null);
        } finally {
            em.close();
        }
    }
    
    public Supplier findByEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Supplier> query = em.createQuery("SELECT s FROM Supplier s WHERE s.email = :email", Supplier.class);
            query.setParameter("email", email);
            return query.getResultList().stream().findFirst().orElse(null);
        } finally {
            em.close();
        }
    }

    public Supplier Add(final Supplier supplier) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(supplier);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return supplier;
    }

    public Supplier Edit(final Supplier supplier) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(supplier);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return supplier;
    }

    public void Delete(final int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Supplier supplier = em.find(Supplier.class, id);
            if (supplier != null) {
                em.remove(supplier);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
