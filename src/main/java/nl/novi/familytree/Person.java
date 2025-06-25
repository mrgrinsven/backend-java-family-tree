package nl.novi.familytree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private char sex;
    private int age;
    private Person mother;
    private Person father;
    private Person partner;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, String lastName, int age, char sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName,String lastName, int age, char sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public void addParents(Person father, Person mother) {
        this.father = father;
        this.mother = mother;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public void addSibling(Person sibling) {
        this.siblings.add(sibling);
    }

    public void addPartner(Person partner) {
        this.partner = partner;
    }

    public List<Person> getGrandchildren() {
        List<Person> grandChildren = new ArrayList<>();

        for (Person child: this.children) {
            grandChildren.addAll(child.children);
        }
        return grandChildren;
    }

    public List<Pet> getPetsGrandchildren() {
        List<Pet> pets = new ArrayList<>();
        List<Person> grandchildren = this.getGrandchildren();
        for (Person p : grandchildren) {
            pets.addAll(p.getPets());
        }
        return pets;
    }

    public List<Person> getAllNieces() {
        List<Person> nieces = new ArrayList<>();
        List<Person> siblings = this.getSiblings();
        for (Person p : siblings) {
            if (p.getSex() == 'f') {
                nieces.add(p);
            }
        }
        return nieces;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return this.mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return this.father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return this.siblings;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public Person getPartner() {
        return this.partner;
    }

}
