package zairastra.u5w1d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zairastra.u5w1d4.entities.Item;

//qui posso usare solo le query automatiche
//basta una repository solo per Item o ne serve una per concreta???
public interface ItemsRepository extends JpaRepository<Item, Long> {
}
