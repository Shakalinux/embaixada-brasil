package br.com.embaixada.repository;

import br.com.embaixada.model.Profile;
import br.com.embaixada.model.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends CrudRepository<Service, Long> {

}
