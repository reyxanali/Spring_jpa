package com.example.lesson4_5.service;

import com.example.lesson4_5.dao.entity.CardEntity;
import com.example.lesson4_5.dao.repository.CardRepository;
import com.example.lesson4_5.mapper.CardMapper;
import com.example.lesson4_5.model.dto.CardDto;
import com.example.lesson4_5.model.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public List<CardDto> getCardList() {
        List<CardEntity> cardEntityList = cardRepository.findAll();
        return CardMapper.toCardDtoList(cardEntityList);
    }

    public CardDto getCardById(Long cardId) {
        Optional<CardEntity> cardEntity = cardRepository.findById(cardId);
        if (cardEntity.isPresent()) {
            return CardMapper.toCardDto(cardEntity.get());
        }
        return new CardDto();
    }

    public void createCard(CardDto cardDto) {
        CardEntity newCard = CardMapper.toCardEntity(cardDto);
        cardRepository.save(newCard);
    }

    public void updateCard(Long id, Status newStatus) {
        Optional<CardEntity> cardEntity = cardRepository.findById(id);
        if (cardEntity.isPresent()) {
            cardEntity.get().setStatus(newStatus);
            cardRepository.save(cardEntity.get());
        }
    }

    public void removeCard(Long id) {
        Optional<CardEntity> cardEntity = cardRepository.findById(id);
        cardEntity.ifPresent(cardRepository::delete);
    }

}
