package com.sarunas.BooksApplication.repository;

import com.sarunas.BooksApplication.model.AntiqueBook;
import com.sarunas.BooksApplication.model.Book;
import com.sarunas.BooksApplication.model.ScienceJournal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book getByBarcode(String barcode);

    @Query(value = "SELECT barcode FROM Book GROUP BY quantity")
    List<Book> findAllBarcodeByGroupByQuantity();

    @Query(value = "SELECT barcode FROM Book ORDER BY quantity * price")
    List<Book> findAllBarcodeByOrderByPriceAndQuantity();

    @Query(value = "SELECT barcode FROM Book ORDER BY quantity * price * (YEAR(NOW()) - releaseYears) / 10")
    List<AntiqueBook> findAllBarcodeByOrderByPriceAndQuantityAndRelease_Years();

    @Query(value = "SELECT barcode FROM Book ORDER BY quantity * price * rating")
    List<ScienceJournal> findAllBarcodeByOrderByPriceAndQuantityAndRating();


}
