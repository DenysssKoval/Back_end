package de.ait.wordcard.card.service;

import de.ait.wordcard.card.dto.RequestCardDTO;
import de.ait.wordcard.card.dto.ResponseCardDTO;
import de.ait.wordcard.card.entity.Card;
import de.ait.wordcard.card.repository.RepositoryCard;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceCardImp implements ServiceCard {

    private final RepositoryCard repository; //подключаем репозиторий
    private final ModelMapper mapper; //подключаем mapper

    @Override
    public List<ResponseCardDTO> findAllCards() {
        return repository.findAll().stream()
                .map(e-> mapper.map(e, ResponseCardDTO.class))
                .toList();

    }

    @Override
    public ResponseCardDTO findCardById(Long id) {
        Card card = repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Card not found with id " + id));
        return mapper.map(card, ResponseCardDTO.class);
    }

    @Override
    public ResponseCardDTO saveCard(RequestCardDTO dto) {
        Card entity = mapper.map(dto, Card.class);
        Card newCard = repository.save(entity);
        return mapper.map(newCard, ResponseCardDTO.class);
    }
}
