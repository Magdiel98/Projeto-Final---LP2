package entity;

import java.util.ArrayList;
import java.util.List;

public class Pedido extends Entity{
    private List<Item> items;

    public Pedido(List<Item> items)
    {
        this.items = items != null ? items : new ArrayList<>();
    }

    public Pedido()
    {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems()
    {
        return this.items;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }
}
