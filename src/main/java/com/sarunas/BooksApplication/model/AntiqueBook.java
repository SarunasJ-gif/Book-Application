package com.sarunas.BooksApplication.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AntiqueBook extends Book {


    @Max(value = 1900, message = "must be equal or less than 1900")
    private int releaseYears;

    public AntiqueBook(Long id, String name, String author, String barcode,
                       int quantity, double price, int releaseYears) {
        super(id, name, author, barcode, quantity, price);
        this.releaseYears = releaseYears;
    }
}
