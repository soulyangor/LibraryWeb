/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slavasokolov.employeemanager.repositories;

import com.slavasokolov.employeemanager.entities.Post;
import java.util.List;

/**
 *
 * @author Sokolov@ivc.org
 */
public interface PostRepository {

    List<Post> findAll();

    Post create(Post post);

    Post update(Post post);

    Post find(Post post);

    void delete(Post post);

}
