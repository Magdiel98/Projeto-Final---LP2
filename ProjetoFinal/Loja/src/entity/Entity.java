package entity;

public class Entity {
    private int id;

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id; 
    }

    //Implementação do equals

    @Override
    public boolean equals(Object idEntity)
    {
        return idEntity instanceof Entity && Integer.valueOf(this.id).equals(((Entity)idEntity).getId());
    }
}
