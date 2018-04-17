package application;

import domain.entity.Book;
import domain.entity.Writer;
import domain.repository.BookRepository;
import domain.repository.WriterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("domain.repository")
@EntityScan("domain.entity")
public class BibliotecaApplication {

    private static final Logger log = LoggerFactory.getLogger(BibliotecaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(BookRepository bookRepository, WriterRepository writerRepository) {
        return (args) -> {
            Writer arturo = writerRepository.save(new Writer("Arturo", "Perez Reverte"));
            Writer eduardo = writerRepository.save(new Writer("Eduardo", "Mendoza"));
            Writer carmen = writerRepository.save(new Writer("Carmen", "Martín Gaite"));

            bookRepository.save(new Book("Falcó", arturo));
            bookRepository.save(new Book("El asedio", arturo));
            bookRepository.save(new Book("La ciudad de los prodigios", eduardo));
            bookRepository.save(new Book("Riña de gatos", eduardo));
            bookRepository.save(new Book("Entre visillos", carmen));

            for (Book book : bookRepository.findAll()){
                log.info(book.toString());
            }
        };
    }
}
