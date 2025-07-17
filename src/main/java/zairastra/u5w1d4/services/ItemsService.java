package zairastra.u5w1d4.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zairastra.u5w1d4.repositories.ItemsRepository;

//qui scrivo i metodi personalizzati e le query non standard
@Service
@Slf4j
public class ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;


}
