package com.example.dockerdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>
 *
 * </p>
 *
 * @author k9
 * @since 2019-09-30
 */
@Entity
public class Test {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private  Long  count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
