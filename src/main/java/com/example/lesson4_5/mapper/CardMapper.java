package com.example.lesson4_5.mapper;

import com.example.lesson4_5.dao.entity.CardEntity;
import com.example.lesson4_5.model.dto.CardDto;

import java.util.ArrayList;
import java.util.List;

public class CardMapper {

    public static CardDto toCardDto(CardEntity cardEntity) {
        return CardDto.builder()
                .cardNumber(cardEntity.getCardNumber())
                .iban(cardEntity.getIban())
                .id(cardEntity.getId())
                .status(cardEntity.getStatus())
                .build();
    }

    public static List<CardDto> toCardDtoList(List<CardEntity> cardEntityList) {
        List<CardDto> cardDtoList = new ArrayList<>();

        for (CardEntity cardEntity : cardEntityList) {
            CardDto cardDto = toCardDto(cardEntity);
            cardDtoList.add(cardDto);
        }
        return cardDtoList;
    }

    public static CardEntity toCardEntity(CardDto cardDto) {
        return CardEntity.builder()
                .cardNumber(cardDto.getCardNumber())
                .iban(cardDto.getIban())
                .id(cardDto.getId())
                .status(cardDto.getStatus())
                .build();
    }

}
