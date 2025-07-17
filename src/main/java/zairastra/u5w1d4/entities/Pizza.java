package zairastra.u5w1d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "pizzas")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pizza extends Item {
    private String name;
    private boolean isXl = false;

    @ManyToMany
    @JoinTable(
            name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppingList;

    public Pizza(String name, List<Topping> toppingList, boolean isXl) {
        super(1012, 4.3);
        this.name = name;
        this.toppingList = toppingList;
        this.isXl = isXl;
        this.calories = setCalories(toppingList, isXl);
        this.price = setPrice(toppingList, isXl);
    }

    //il metodo per contare le calorie le prende direttamente da ciascun elemento della List<Topping>
    //e li somma alle calorie di Pizza come oggetto
    //(valuta pure se è xl)
    public int setCalories(List<Topping> toppingList, boolean isXl) {
        int tot = 1012;
        if (toppingList != null) {
            for (int i = 0; i < toppingList.size(); i++) {
                tot += toppingList.get(i).getCalories();
            }
        }
        if (isXl) return (tot += (tot * 5) / 100);
        else return tot;
    }

    //il metodo per calcolare il prezzo prende il singolo prezzo di ciascun elemento della List<Topping>
    //e li somma al prezzo di Pizza come oggetto
    //(valuta pure se è xl)
    public double setPrice(List<Topping> t, boolean isXl) {
        double tot = 4.30;
        if (t != null) {
            for (int i = 0; i < t.size(); i++) {
                tot += t.get(i).getPrice();
            }
        }

        if (isXl) return tot += (tot * 10) / 100;
        else return tot;
    }
}
