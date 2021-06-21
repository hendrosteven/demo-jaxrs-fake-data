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
    
    
    public List<Person> findAll(){
        return DataSource.persons;
    }
    
    public Person findById(int id){
        for(Person person : DataSource.persons){
            if(person.getId()== id){
                return person;
            }
        }
        return null;
    }
    
    public Person createOne(Person person){
        person.setId(DataSource.persons.size()+1);
        DataSource.persons.add(person);
        return person;
    }
    
    public void removeById(int id){
        for(Person person : DataSource.persons){
            if(person.getId()== id){
                DataSource.persons.remove(person);
                break;
            }
        }
    }
    
    public Person update(int id, Person person){
        for(Person p : DataSource.persons){
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
