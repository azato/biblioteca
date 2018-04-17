package domain.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne
    private Writer writer;

    Book() {
    }

    public Book(String title, Writer writer) {
        this.title = title;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public Writer getWriter() {
        return writer;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
