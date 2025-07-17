package zairastra.u5w1d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "toppings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Topping extends Item {
    private String name;

    public Topping(int calories, double price, String name) {
        super(calories, price);
        this.name = name;
    }
}
