package com.sergioarboleda.reto5.Crudrepository;

import com.sergioarboleda.reto5.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
