package com.sarunas.BooksApplication.controller;

import com.sarunas.BooksApplication.model.AntiqueBook;
import com.sarunas.BooksApplication.model.Book;
import com.sarunas.BooksApplication.model.ScienceJournal;
import com.sarunas.BooksApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAllBooks")
    public ResponseEntity<?> getAllBooks() {
        try {
            List<Book> allBooks = new ArrayList<>(bookService.findAllBooks());
            if(allBooks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(allBooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookByBarcode/{barcode}")
    public ResponseEntity<?> getBookByBarcode(@PathVariable String barcode) {
        Optional<Book> optionalBook = Optional.ofNullable(bookService.findBookByBarcode(barcode));
        return optionalBook.map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAntiqueBookByBarcode/{barcode}")
    public ResponseEntity<?> getAntiqueBookByBarcode(@PathVariable String barcode) {
        Optional<AntiqueBook> optionalBook = Optional.ofNullable(bookService.findAntiqueBookByBarcode(barcode));
        return optionalBook.map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getScienceJournalByBarcode/{barcode}")
    public ResponseEntity<?> getScienceJournalByBarcode(@PathVariable String barcode) {
        Optional<ScienceJournal> optionalBook = Optional.ofNullable(bookService.findScienceJournalByBarcode(barcode));
        return optionalBook.map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @PostMapping("/addAntiqueBook")
    public ResponseEntity<?> addAntiqueBook(@RequestBody AntiqueBook book) {
        AntiqueBook newBook = bookService.addAntiqueBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }

    @PostMapping("/addScienceJournal")
    public ResponseEntity<?> addScienceJournal(@RequestBody ScienceJournal journal) {
        ScienceJournal newJournal = bookService.addScienceJournal(journal);
        return new ResponseEntity<>(newJournal, HttpStatus.OK);
    }

    @PutMapping("/updateBook/{barcode}")
    public ResponseEntity<?> updateBook(@RequestParam String barcode, @RequestBody Book newBook) {
        Optional<Book> optionalBook = Optional.ofNullable(bookService.findBookByBarcode(barcode));
        if (optionalBook.isPresent()) {
            Book bookToUpdate = optionalBook.get();
            bookToUpdate.setName(newBook.getName());
            bookToUpdate.setAuthor(newBook.getAuthor());
            bookToUpdate.setPrice(newBook.getPrice());
            bookToUpdate.setBarcode(newBook.getBarcode());
            bookToUpdate.setQuantity(newBook.getQuantity());

            Book updateBook = bookService.addBook(bookToUpdate);
            return new ResponseEntity<>(updateBook, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getTotalPrice/{barcode}")
    public ResponseEntity<?> getTotalPrice(@RequestParam String barcode) {
        Optional<?> optionalBook = Optional.ofNullable(bookService.findBookByBarcode(barcode));
        if (optionalBook.isPresent()) {
            Book book = (Book) optionalBook.get();
            double totalPrice = book.getPrice() * book.getQuantity();
            return new ResponseEntity<>(totalPrice, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/allBarcodes")
    public ResponseEntity<?> getAllBarcodes() {
        try {
            List<Book> allBarcodes = new ArrayList<>();
            bookService.findAllBarcode().forEach(allBarcodes::add);

            if (allBarcodes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(allBarcodes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allBarcodes/orderByTotalPrice/{bookType}")
    public ResponseEntity<?> getBooksAllBarcodesSort(@PathVariable String bookType) {
        try {
            List<Book> allSortBarcodes = new ArrayList<>();
            if ("Book".equals(bookType)) {
                allSortBarcodes.addAll(bookService.findBookAllBarcodeSort());
            } else if ("AntiqueBook".equals(bookType))
                allSortBarcodes.addAll(bookService.findAntiqueBookAllBarcodeSort());
             else if ("ScienceJournal".equals(bookType)) {
                allSortBarcodes.addAll(bookService.findJournalAllBarcodeSort());
            }
            if (allSortBarcodes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(allSortBarcodes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
