package guru.springframework.spring5webapp.domain;

import sun.rmi.runtime.Log;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String gstn;
    @ManyToMany
    @JoinTable(name="author_book",joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name = "author_id") )
    private Set<Author> author = new HashSet<>();



    @ManyToOne
    private Publisher publishers;
    public Book() {
    }


    public Book(String title, String gstn) {
        this.title = title;
        this.gstn = gstn;
       // this.author=author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGstn() {
        return gstn;
    }

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    public Publisher getPublishers() {
        return publishers;
    }

    public void setPublishers(Publisher publishers) {
        this.publishers = publishers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", gstn='" + gstn + '\'' +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
