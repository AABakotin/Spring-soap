package ru.geekbrains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.CategoriesEntity;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long> {
    @Query("select c from CategoriesEntity c where c.title = ?1")
    Optional<CategoriesEntity> findByTitle(String title);
}