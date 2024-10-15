package org.example;

public class Owner extends Person{
    Person ownerId;

    public Owner(int id, String name) {
        super(id, name);
    }

    public Person getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Person ownerId) {
        this.ownerId = ownerId;
    }
}
