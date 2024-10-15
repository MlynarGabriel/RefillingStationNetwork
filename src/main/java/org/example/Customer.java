package org.example;

public class Customer extends Person{
    Person customerId;
    String name;

    public Person getCustomerId() {
        return customerId;
    }

    public void setPerson_id(Person person_id) {
        this.customerId = person_id;
    }

    public Customer(int id, String name) {
        super(id, name);
    }
}
