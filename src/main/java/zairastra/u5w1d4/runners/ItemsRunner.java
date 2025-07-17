package zairastra.u5w1d4.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zairastra.u5w1d4.entities.Drink;
import zairastra.u5w1d4.entities.Pizza;
import zairastra.u5w1d4.entities.Topping;
import zairastra.u5w1d4.services.DrinksService;
import zairastra.u5w1d4.services.ItemsService;
import zairastra.u5w1d4.services.PizzasService;
import zairastra.u5w1d4.services.ToppingsService;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ItemsRunner implements CommandLineRunner {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private DrinksService drinksService;

    @Autowired
    private ToppingsService toppingsService;

    @Autowired
    private PizzasService pizzasService;

    @Override
    public void run(String... args) {
        List<Drink> newDrinks = new ArrayList<>();
        newDrinks.add(new Drink(150, 3, "cola"));
        newDrinks.add(new Drink(120, 2.5, "fanta"));
        newDrinks.add(new Drink(170, 3.5, "beer"));
        newDrinks.add(new Drink(110, 4, "wine"));

//        drinksService.saveManyDrinks(newDrinks);

        List<Topping> newToppings = new ArrayList<>();
        newToppings.add(new Topping(30, 1, "tomato"));
        newToppings.add(new Topping(50, 2, "bufala"));
        newToppings.add(new Topping(70, 2.5, "onions"));
        newToppings.add(new Topping(10, 0.5, "basil"));
        newToppings.add(new Topping(70, 3, "tuna"));
        newToppings.add(new Topping(80, 4, "nduja"));


//        toppingsService.saveManyToppings(newToppings);

//        toppingsService.findToppingByName("tomato");
//        toppingsService.findToppingByName("bufala");
//        toppingsService.findToppingByName("onions");
//        toppingsService.findToppingByName("basil");
//        toppingsService.findToppingByName("tuna");
//        toppingsService.findToppingByName("nduja");


        //se avessi salvato toppings e pizze insieme non sarei dovuta andarmeli a prendere dal db
        //perchè sarebbero esistiti nella fase managed insieme
        //avendoli salvati separatamente devo prima cercare i topping nel db
        //avrei potuto mettere la ricerca dei topping dentro il save della pizza, come nel blog

        List<String> toppingNames = List.of("tomato", "bufala", "onions", "basil", "tuna", "nduja");
        List<Topping> toppings = toppingsService.findToppingsByNames(toppingNames);

        List<Pizza> newPizzas = new ArrayList<>();
        Pizza margherita = new Pizza("Margherita", toppings.subList(0, 2), false);
        Pizza tropeana = new Pizza("Tropeana", toppings.subList(0, 5), false);
        Pizza calabrese = new Pizza("Calabrese", toppings, true);

        newPizzas.add(margherita);
        newPizzas.add(tropeana);
        newPizzas.add(calabrese);

//        pizzasService.saveManyPizzas(newPizzas);

        //testato per pizza esistente, logga correttamente exception
//        pizzasService.savePizzaWithToppings("Margherita", List.of("tomato", "bufala"), false);
    }
}
