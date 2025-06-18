package nl.novi.familytree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    String middleName;
    String lastName;
    char sex;
    int age;
    Person mother;
    Person father;
    List<Person> siblings;
    List<Person> children;
    List<Pet> pets;

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

    public List<Person> getGrandchildren() {
        List<Person> grandChildren = new ArrayList<>();

        for (Person child: this.children) {
            grandChildren.addAll(child.children);
        }
        return grandChildren;
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

}
