/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.repository;

import com.kelaskoding.model.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jarvis
 */
public class PersonRepo {
    
    private final List<Person> persons = new ArrayList<>();
    
    public PersonRepo(){
        persons.add(new Person(1,"Hendro", "hendro@gmail.com","234234234","Jakarta"));
        persons.add(new Person(2,"Steven", "steve@gmail.com","3456456","Bandung"));
        persons.add(new Person(3,"Budi", "budi@gmail.com","4534364564","Bandung"));
        persons.add(new Person(4,"Hendro Steven", "hendro.steven@gmail.com","678453453","Bogor"));
        persons.add(new Person(5,"Sari", "sari@gmail.com","23454374567","Jakarta"));        
    }
    
    public List<Person> findAll(){
        return this.persons;
    }
    
    public Person findById(int id){
        for(Person person : this.persons){
            if(person.getId()== id){
                return person;
            }
        }
        return null;
    }
    
    public Person createOne(Person person){
        person.setId(this.persons.size()+1);
        this.persons.add(person);
        return person;
    }
    
    public void removeById(int id){
        for(Person person : this.persons){
            if(person.getId()== id){
                this.persons.remove(person);
                break;
            }
        }
    }
    
    public Person update(int id, Person person){
        for(Person p : this.persons){
            if(p.getId()== id){
                p.setName(person.getName());
                p.setEmail(person.getEmail());
                p.setAddress(person.getAddress());
                p.setPhone(person.getPhone());
                return p;
            }
        }
        return null;
    }
    
}
