package com.sarunas.BooksApplication.service;

import com.sarunas.BooksApplication.model.AntiqueBook;
import com.sarunas.BooksApplication.model.Book;
import com.sarunas.BooksApplication.model.ScienceJournal;
import com.sarunas.BooksApplication.repository.AntiqueBookRepository;
import com.sarunas.BooksApplication.repository.BookRepository;
import com.sarunas.BooksApplication.repository.ScienceJournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AntiqueBookRepository antiqueBookRepository;

    @Autowired
    ScienceJournalRepository scienceJournalRepository;


    public List<Book> findAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Iterable<Book> findAllAntiqueBooks() {
        return antiqueBookRepository.findAll();
    }

    public Iterable<Book> findAllScienceJournal() {
        return  scienceJournalRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public AntiqueBook addAntiqueBook(AntiqueBook book) {
        return antiqueBookRepository.save(book);
    }

    public ScienceJournal addScienceJournal(ScienceJournal journal) {
        return scienceJournalRepository.save(journal);
    }

    public Book findBookByBarcode(String barcode) {
        return bookRepository.getByBarcode(barcode);
    }

    public AntiqueBook findAntiqueBookByBarcode(String barcode) {
        return (AntiqueBook) antiqueBookRepository.getByBarcode(barcode);
    }

    public ScienceJournal findScienceJournalByBarcode(String barcode) {
        return (ScienceJournal) antiqueBookRepository.getByBarcode(barcode);
    }

    public Iterable<Book> findAllBarcode() {
        return bookRepository.findAllBarcodeByGroupByQuantity();
    }

    public List<Book> findBookAllBarcodeSort() {
        return bookRepository.findAllBarcodeByOrderByPriceAndQuantity();
    }

    public List<AntiqueBook> findAntiqueBookAllBarcodeSort() {
        return antiqueBookRepository.findAllBarcodeByOrderByPriceAndQuantityAndRelease_Years();
    }

    public List<ScienceJournal> findJournalAllBarcodeSort() {
        return scienceJournalRepository.findAllBarcodeByOrderByPriceAndQuantityAndRating();
    }

}
