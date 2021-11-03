package com.sergioarboleda.reto5.Crudrepository;

import com.sergioarboleda.reto5.Model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository <Client, Integer> {
}
