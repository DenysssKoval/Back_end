package de.ait.wordcard.card.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor //Генерирует конструктор, принимающий значения для всех полей класса. Это полезно для быстрого создания экземпляра с заданными значениями.
@NoArgsConstructor // Автоматически генерирует конструктор без аргументов. Это полезно, когда нужно создать объект без необходимости сразу инициализировать его поля.
@Getter //
@Setter
@Builder //Паттерн "Builder" помогает более удобно и читаемо создавать объекты, особенно когда у класса много полей или когда необходимо создать объект с определенными комбинациями полей.

@Entity //Указывает, что данный класс является сущностью, которую можно сохранять в базу данных. Hibernate или JPA будут использовать эту аннотацию для преобразования объекта в строку таблицы в базе данных.
@Table(name = "card") //Аннотация JPA, которая указывает, что этот класс сопоставляется с таблицей card в базе данных. Если имя таблицы в базе данных отличается от имени класса, эта аннотация позволяет явно указать, с какой таблицей работает класс.
public class Card {
    @Id // Обозначает, что это поле является первичным ключом таблицы.
    @GeneratedValue //Указывает, что значение этого поля будет генерироваться автоматически. Обычно используется для автогенерации первичных ключей.
    @Column(name = "id") //Указывает имя столбца в таблице базы данных, соответствующее этому полю. В данном случае поле id будет храниться в столбце id таблицы card.
    private Long id;

    @Column(name = "language")
    private String language;

    @Column(name = "word")
    private String word;

    @Column(name = "example")
    private String example;

    @Column(name = "translateLanguage")
    private String translateLanguage;

    @Column(name = "translation")
    private String translation;

    @Column(name = "group_name")
    private String groupName;
}
