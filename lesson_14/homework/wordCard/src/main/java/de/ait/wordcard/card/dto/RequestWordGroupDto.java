package de.ait.wordcard.card.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseWordGroupDto {
    private Long id;
    private String title;
    private List<ResponseCardDTO> cards;
}
