package io.ecommerce.repository.dao;
import javax.persistence.*;

@Entity
@Table(name = "review")
public class Rating {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "point")
    private int ratingPoint;

    public Rating() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(int ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", ratingPoint=" + ratingPoint +
                '}';
    }
}

