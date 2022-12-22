package com.sarunas.BooksApplication;

import com.sarunas.BooksApplication.model.AntiqueBook;
import com.sarunas.BooksApplication.model.Book;
import com.sarunas.BooksApplication.model.ScienceJournal;
import com.sarunas.BooksApplication.repository.AntiqueBookRepository;
import com.sarunas.BooksApplication.repository.BookRepository;
import com.sarunas.BooksApplication.repository.ScienceJournalRepository;
import com.sarunas.BooksApplication.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class BooksApplicationTests {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@MockBean
	private AntiqueBookRepository antiqueBookRepository;

	@MockBean
	private ScienceJournalRepository scienceJournalRepository;


	@Test
	public void getAllBooksTest() {
		when(bookRepository.findAll()).thenReturn(Stream
				.of(new Book(1L, "Fire and Blood", "G.R.R.Martin", "15788", 20, 25.99),
						new Book(2L, "Game of Thrones", "G.R.R.Martin", "758999", 14, 21.88)).
				collect(Collectors.toList()));
		assertEquals(2, bookService.findAllBooks().size());
	}

	@Test
	public void saveBooksTest() {
		Book book = new Book(3L, "Clash of Kings", "G.R.R.Martin", "95788", 21, 22.90);
		when(bookRepository.save(book)).thenReturn(book);
		assertEquals(book, bookService.addBook(book));
	}

	@Test
	public void saveAntiqueBooksTest() {
		AntiqueBook antiqueBook = new AntiqueBook(
				3L, "The Gallic Wars",
				"Julius Ceasar",
				"79988", 2,
				101.11, 125);
		when(antiqueBookRepository.save(antiqueBook)).thenReturn(antiqueBook);
		assertEquals(antiqueBook, bookService.addAntiqueBook(antiqueBook));
	}

	@Test
	public void saveScienceJournalTest() {
		ScienceJournal journal = new ScienceJournal(4L, "International Journal of Computer Vision",
				"Jean Ponce", "558799", 11, 12.55, 7);
		when(scienceJournalRepository.save(journal)).thenReturn(journal);
		assertEquals(journal, bookService.addScienceJournal(journal));
	}

}
