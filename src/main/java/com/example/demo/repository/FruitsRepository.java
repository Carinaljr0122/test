package com.example.demo.repository;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Fruits;
@Repository
@Table(name="fruits")
@Qualifier("fruitsRepository")
public interface FruitsRepository extends CrudRepository<Fruits, Long > {

    public Fruits findOne(Long id);

    @SuppressWarnings("unchecked")
    public Fruits save(Fruits u);

    @Query("select t from Fruits t where t.name=:name")
    public Fruits findUserByName(@Param("name") String name);
}
