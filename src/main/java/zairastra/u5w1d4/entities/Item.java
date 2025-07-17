package zairastra.u5w1d4.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {

    protected int calories;
    protected double price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // Toglie il setter per l'id
    private Long id;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }
}
