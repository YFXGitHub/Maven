package com.yfx.spring.boot.dao;

import com.yfx.spring.boot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookDAO extends JpaRepository<Book, Integer> {

   // @Query("select b.id, b.name,b.publish_id, p.name from book b inner join publisher p on b.publish_id=p.id and b.name = ?1")
    Book findByName(String name);

    Book getById(Integer id);

}
