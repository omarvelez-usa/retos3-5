package com.sergioarboleda.reto5.Crudrepository;

import com.sergioarboleda.reto5.Model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GamesCrudRepository extends CrudRepository<Game,Integer> {
}
