package com.example.lesson4_5.controller;

import com.example.lesson4_5.model.dto.CardDto;
import com.example.lesson4_5.model.enums.Status;
import com.example.lesson4_5.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("cards/")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;


    @GetMapping
    // @RequestMapping(name = "card", method = RequestMethod.GET, path = "card")
    public ResponseEntity<List<CardDto>> getCardList() {
        return ResponseEntity.ok(cardService.getCardList());
    }

    @GetMapping("{id}")
    public ResponseEntity<CardDto> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCard(@RequestBody CardDto cardDto) {
        cardService.createCard(cardDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCard(@PathVariable Long id,
                                           @RequestParam Status status) {
        cardService.updateCard(id, status);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.removeCard(id);
        return ResponseEntity.ok().build();
    }
}
