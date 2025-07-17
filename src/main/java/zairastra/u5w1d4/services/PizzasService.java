package zairastra.u5w1d4.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zairastra.u5w1d4.entities.Pizza;
import zairastra.u5w1d4.exceptions.DuplicatedException;
import zairastra.u5w1d4.exceptions.NotFoundException;
import zairastra.u5w1d4.exceptions.ValidationException;
import zairastra.u5w1d4.repositories.PizzasRepository;

import java.util.List;

//qui scrivo i metodi personalizzati e le query non standard
@Service
@Slf4j
public class PizzasService {
    @Autowired
    private PizzasRepository pizzaRepository;

    public Pizza savePizza(Pizza newPizza) {
        List<Pizza> saved = pizzaRepository.findByNameIgnoreCase(newPizza.getName());

        if (!saved.isEmpty()) {
            throw new DuplicatedException("The pizza " + newPizza.getName() + " is already on the menu");
        }

        return pizzaRepository.save(newPizza);
    }

    public void saveManyPizzas(List<Pizza> newPizzas) {
        for (Pizza pizza : newPizzas) {
            try {
                this.savePizza(pizza);
            } catch (ValidationException exception) {
                log.error(exception.getMessage());
            }
        }
    }

    public List<Pizza> findPizzaByName(String name) {
        List<Pizza> pizzas = pizzaRepository.findByNameIgnoreCase(name);

        if (pizzas.isEmpty()) {
            throw new NotFoundException("No pizza named " + name + "found");
        }

        log.info("Found " + pizzas.size() + name);


        return pizzas;
    }
}