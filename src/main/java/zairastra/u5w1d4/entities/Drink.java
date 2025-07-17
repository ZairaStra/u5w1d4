package zairastra.u5w1d4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "drinks")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Drink extends Item {
    private String name;

    public Drink(int calories, double price, String name) {
        super(calories, price);
        this.name = name;
    }
}
