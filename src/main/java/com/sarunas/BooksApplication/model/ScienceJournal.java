package com.sarunas.BooksApplication.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScienceJournal extends Book{

    @Min(value = 1, message = "must be equal or greater than 1")
    @Max(value = 10, message = "must be equal or less than 10")
    private int rating;
}
