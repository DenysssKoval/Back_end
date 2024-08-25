package de.ait.wordcard.card.controller;


import de.ait.wordcard.card.dto.RequestCardDTO;
import de.ait.wordcard.card.dto.ResponseCardDTO;
import de.ait.wordcard.card.service.ServiceCard;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardController {
    private final ServiceCard service;

    @GetMapping("/cards")
    public List<ResponseCardDTO> getCards() {
        return service.findAllCards();
    }

    @GetMapping("/cards/id")
    public ResponseCardDTO getCardById(@RequestParam Long id) {
        return service.findCardById(id);
    }


    @PostMapping("/cards")
    public ResponseCardDTO addCard(@RequestBody RequestCardDTO dto) {
        return service.saveCard(dto);
    }
}
