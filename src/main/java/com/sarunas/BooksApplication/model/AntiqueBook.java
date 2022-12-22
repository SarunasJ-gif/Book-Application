package com.sarunas.BooksApplication.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AntiqueBook extends Book{


    @Max(value = 1900, message = "must be equal or less than 1900")
    private int releaseYears;
}
