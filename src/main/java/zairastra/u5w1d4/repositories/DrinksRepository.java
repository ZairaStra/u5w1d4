package zairastra.u5w1d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zairastra.u5w1d4.entities.Drink;

import java.util.List;

public interface DrinksRepository extends JpaRepository<Drink, Long> {

    //chiamo le queries automatiche

    //cerca per nome
    List<Drink> findByNameIgnoreCase(String name);


}
