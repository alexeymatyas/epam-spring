package com.epam.springadv.model.entities;

import com.epam.springadv.model.Rating;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Alexey on 18.10.2016.
 */
@Entity
public class Movie {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(name = "rating_id")
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @OneToMany(mappedBy = "movie")
    private List<Event> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }
}
