package com.example.lesson4_5.dao.repository;

import com.example.lesson4_5.dao.entity.CardEntity;
import com.example.lesson4_5.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findByStatusAndCardNumber(Status status, String cardNumber);

    Optional<CardEntity> findByCardNumber(String cardNumber);

     void deleteById(Long id);
}
