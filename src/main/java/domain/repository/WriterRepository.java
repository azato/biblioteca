package domain.repository;

import domain.entity.Writer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WriterRepository extends CrudRepository<Writer, Long> {

    List<Writer> findByLastName(String lastName);
}
