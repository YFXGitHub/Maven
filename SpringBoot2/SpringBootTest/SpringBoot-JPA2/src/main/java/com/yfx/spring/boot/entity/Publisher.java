package com.yfx.spring.boot.entity;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)  //fetch = FetchType.EAGER  |  fetch = FetchType.LAZY
    @JoinColumn(name="publishId",referencedColumnName = "id")
    private Set<Book> books;

    //特别注意：onetomany标识这是级联1对多的关系。cascade={CascadeType.ALL}表示主表的增查删改都会直接通过关联字段对从表进行相应操作。
    //例如删除主表的一个user实例，从表与user相关联roles将被删除。
    //而fetch=FetchType.EAGER表示急加载，即指一旦主表进行了相应操作，则从表也将立即进行相应的级联操作。
    //例如，一旦读取了user表的某一个实例，则user会立即加载Roles；而fetch=FetchType.LAZY为懒加载，当需要使用到getRolelist()方法时，才会读取相关联的级联表数据

    /**
     //CascadeType属性有四个值，其中REMOVE属性是实现级联删除，要实现级联删除
         //在父栏必需添加CascadeType.REMOVE标注，这是级联删除的关键
         @OneToMany(cascade={CascadeType.REMOVE},mappedBy="garage")  
     */

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
