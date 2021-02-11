package dev.lachor.springmvc.order;

import dev.lachor.springmvc.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client_order")
public class Order implements Comparable<Order>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "order_item",
    joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Item> items = new ArrayList<>();
    @NotEmpty(message = "{dev.lachor.springmvc.order.Order.Address}")
    private String address;
    @Size(min = 9, max = 9, message = "{dev.lachor.springmvc.order.Order.Telephone.size}")
    private String telephone;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.status.ordinal(), o.getStatus().ordinal());
    }
}
