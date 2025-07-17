package zairastra.u5w1d4.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zairastra.u5w1d4.entities.Topping;
import zairastra.u5w1d4.exceptions.DuplicatedException;
import zairastra.u5w1d4.exceptions.NotFoundException;
import zairastra.u5w1d4.exceptions.ValidationException;
import zairastra.u5w1d4.repositories.ToppingsRepository;

import java.util.List;

//qui scrivo i metodi personalizzati e le query non standard
@Service
@Slf4j
public class ToppingsService {
    @Autowired
    private ToppingsRepository toppingsRepository;

    public Topping saveTopping(Topping newTopping) {
        List<Topping> saved = toppingsRepository.findByNameIgnoreCase(newTopping.getName());

        if (!saved.isEmpty()) {
            throw new DuplicatedException("The topping " + newTopping.getName() + " is already on the menu");
        }

        return toppingsRepository.save(newTopping);
    }

    public void saveManyToppings(List<Topping> newToppings) {
        for (Topping topping : newToppings) {
            try {
                this.saveTopping(topping);
            } catch (ValidationException exception) {
                log.error(exception.getMessage());
            }
        }
    }

    public List<Topping> findToppingByName(String name) {
        List<Topping> toppings = toppingsRepository.findByNameIgnoreCase(name);

        if (toppings.isEmpty()) {
            throw new NotFoundException("No topping named " + name + "found");
        }

        log.info("Found " + toppings.size() + name);


        return toppings;
    }

    public List<Topping> findToppingsByNames(List<String> names) {
        List<Topping> toppings = toppingsRepository.findByNameInIgnoreCase(names);
        if (toppings.isEmpty()) {
            throw new NotFoundException("No toppings found for names: " + names);
        }
        return toppings;
    }

}