/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.repositories;

import com.slavasokolov.employeemanager.entities.Post;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sokolov@ivc.org
 */
@Transactional
@Repository("jpaPostRepository")
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Post> findAll() {
        return em.createNamedQuery("Post.findAll").getResultList();
    }

    public Post create(Post post) {
        em.persist(post);
        return post;
    }

    public Post update(Post post) {
        int version = em.find(Post.class, post.getId()).getVersion();
        post.setVersion(version);
        return em.merge(post);
    }

    public Post find(Post post) {
        return em.find(Post.class, post.getId());
    }

    public void delete(Post post) {
        Post delPost = em.find(Post.class, post.getId());
        em.remove(delPost);
    }

}
