package zairastra.u5w1d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zairastra.u5w1d4.entities.Drink;

public interface DrinksRepository extends JpaRepository<Drink, Long> {
}
