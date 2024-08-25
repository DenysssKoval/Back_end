package de.ait.wordcard.card.service;

import de.ait.wordcard.card.dto.RequestCardDTO;
import de.ait.wordcard.card.dto.ResponseCardDTO;

import java.util.List;

public interface ServiceCard {
    List<ResponseCardDTO> findAllCards();
    ResponseCardDTO findCardById(Long id);
    ResponseCardDTO saveCard(RequestCardDTO dto);

}
