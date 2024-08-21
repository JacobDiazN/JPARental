package cl.praxis.JPARental.model.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "film")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;

    private String title;
    private String description;

    @Column(name = "release_year")
    private int year;

    /*Establecer una relación entre la clase Film y la clase Language*/
    @ManyToOne
    @JoinColumn(name = "language_id", insertable = true, updatable = true)//esta es la columna language_id de la clase Film que hace referencia a la llave primaria de la clase Language
    private Language language;

    /*Establecer una relación entre la clase Film y la clase Category*/
    /*La clase Category tiene muchas categorías por eso pide una List de categoría*/
    @ManyToMany
    @JoinTable(name = "film_category",
        joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name = "film_actor",
        joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    )
    private List<Actor> actors;

}
