package com.example.lesson4_5.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bank_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "iban", nullable = false)
    private String iban;

    @OneToMany(mappedBy = "bankAccountEntity",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CardEntity> cardEntityList;


}
