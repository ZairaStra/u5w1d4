package zairastra.u5w1d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zairastra.u5w1d4.entities.Topping;

import java.util.List;

public interface ToppingsRepository extends JpaRepository<Topping, Long> {
    //chiamo le queries automatiche

    //cerca per nome
    List<Topping> findByNameIgnoreCase(String name);

    List<Topping> findByNameInIgnoreCase(List<String> names);

}
