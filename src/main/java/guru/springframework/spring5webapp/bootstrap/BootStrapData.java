package guru.springframework.spring5webapp.bootstrap;

import ch.qos.logback.core.net.SyslogOutputStream;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... arg) throws Exception {
        Author a=  new Author("Neeraj","Kumar");
        Book b= new Book("Legandary","legend123456");
        Publisher c = new Publisher("XYZ","South Delhi","New Delhi","Delhi","India","12346");
        publisherRepository.save(c);
        a.getBooks().add(b);
        b.getAuthor().add(a);
        b.setPublishers(c);
        c.getBooks().add(b);
        authorRepository.save(a);
        bookRepository.save(b);
        publisherRepository.save(c);

        Author a1=  new Author("Neeraj1","Kumar1");
        Book b1= new Book("Legandary111","legend12345611");
       // Publisher c1 = new Publisher("XYZ","South Delhi","New Delhi","Delhi","India","12346");

        a1.getBooks().add(b1);
        b1.getAuthor().add(a1);
        b1.setPublishers(c);
        c.getBooks().add(b1);


        authorRepository.save(a1);
        bookRepository.save(b1);
        publisherRepository.save(c);


        System.out.println("Bootstraping books");
        System.out.println("No of books"+bookRepository.count());
        System.out.println("authos"+publisherRepository.count());

    }
}
