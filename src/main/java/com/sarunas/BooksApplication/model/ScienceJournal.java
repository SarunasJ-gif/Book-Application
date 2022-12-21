package com.sarunas.BooksApplication.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScienceJournal extends Book{

    //    @Max
    //    @Min
    private int rating;
}