package zairastra.u5w1d4.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zairastra.u5w1d4.entities.Drink;
import zairastra.u5w1d4.exceptions.DuplicatedException;
import zairastra.u5w1d4.exceptions.NotFoundException;
import zairastra.u5w1d4.exceptions.ValidationException;
import zairastra.u5w1d4.repositories.DrinksRepository;

import java.util.List;

//qui scrivo i metodi personalizzati e le query non standard
@Service
@Slf4j
public class DrinksService {
    @Autowired
    private DrinksRepository drinksRepository;

    public Drink saveDrink(Drink newDrink) {
        List<Drink> saved = drinksRepository.findByNameIgnoreCase(newDrink.getName());

        if (!saved.isEmpty()) {
            throw new DuplicatedException("The drink " + newDrink.getName() + " is already on the menu");
        }

        return drinksRepository.save(newDrink);
    }

    public void saveManyDrinks(List<Drink> newDrinks) {
        for (Drink drink : newDrinks) {
            try {
                this.saveDrink(drink);
            } catch (ValidationException exception) {
                log.error(exception.getMessage());
            }
        }
    }

    public List<Drink> findDrinkByName(String name) {
        List<Drink> drinks = drinksRepository.findByNameIgnoreCase(name);

        if (drinks.isEmpty()) {
            throw new NotFoundException("No drink named " + name + "found");
        }

        log.info("Found " + drinks.size() + name);


        return drinks;
    }

}