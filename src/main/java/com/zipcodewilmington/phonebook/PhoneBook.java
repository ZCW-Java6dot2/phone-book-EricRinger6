package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<String, List<String>>(0);
    }

    public void add(String name, String phoneNumber) {
        List<String> list = new ArrayList<>();
        list.add(phoneNumber);
        this.phonebook.put(name, list);
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String, List<String>> entry : phonebook.entrySet()){
            for(String phone : entry.getValue()){
                if(phoneNumber.equals(phone)){
                    return entry.getKey();
                }
            }
        }

        return phoneNumber;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(this.phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {

        return phonebook;
    }
}
