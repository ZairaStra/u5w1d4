package zairastra.u5w1d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zairastra.u5w1d4.entities.Pizza;

import java.util.List;

public interface PizzasRepository extends JpaRepository<Pizza, Long> {
    //chiamo le queries automatiche

    //cerca per nome
    List<Pizza> findByNameIgnoreCase(String name);
}
