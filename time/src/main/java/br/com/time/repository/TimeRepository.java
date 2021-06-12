package br.com.time.repository;

import br.com.time.model.Time;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author leocr
 */
public interface TimeRepository extends CrudRepository<Time,Long>{
    
}
// Da Acesso ao banco já c as operações CRUD.