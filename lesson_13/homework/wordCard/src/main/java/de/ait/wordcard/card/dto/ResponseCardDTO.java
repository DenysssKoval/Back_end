package de.ait.wordcard.card.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseCardDTO {
    private Long id;
    private String language;
    private String word;
    private String example;
    private String translateLanguage;
    private String translation;
    private String groupName;
}
