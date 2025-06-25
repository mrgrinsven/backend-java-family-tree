package nl.novi.familytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;
    Person father;
    Person mother;

    // add before each example instead of instancing every method
    @BeforeEach
    public void setup(){
        this.person = new Person("Jan", "Jansen", 18, 'm');
        this.father = new Person("Jip", "Jansen", 45, 'm');
        this.mother = new Person("Janneke", "Jansen", 43, 'f');
    }

    @Test
    @DisplayName("Person mother and Person father should be added to Person person")
    public void testAddParents() {
        // arrange
        Person person = new Person("Jan", "Jansen", 18, 'm');
        Person father = new Person("Jip", "Jansen", 45, 'm');
        Person mother = new Person("Janneke", "Jansen", 43, 'f');

        // act
        person.addParents(father, mother);
        Person personFather = person.getFather();
        Person personMother = person.getMother();

        //assert
        assertEquals(father, personFather);
        assertEquals(mother, personMother);
    }

    @Test
    @DisplayName("Person child1 and child2 should be added to List<Person> children of Person person")
    public void testAddChild() {
        // arrange
        Person person = new Person("Janneke", "Jansen", 43, 'f');
        Person child1 = new Person("Jan", "Jansen", 18, 'm');
        Person child2 = new Person("Piet", "Jansen", 15, 'm');
        List<Person> children = List.of(child1, child2);

        // act
        person.addChild(child1);
        person.addChild(child2);
        List<Person> childrenList = person.getChildren();

        // assert
        assertEquals(children, childrenList);
        // optional way to assert using asserTrue and contains method
        assertTrue(person.getChildren().contains(child1));
        assertTrue(person.getChildren().contains(child2));
        assertEquals(2, person.getChildren().size());
    }

    @Test
    @DisplayName("Pet pet1 and pet2 should be added to List<Pet> pets of Person person")
    public void testAddPet() {
        // arrange
        Person person = new Person("Jan", "Jansen", 18, 'm');
        Pet pet1 = new Pet("Snoopy", 3,"Beagle");
        Pet pet2 = new Pet("Snoepje", 4,"Beagle");
        List<Pet> pets = List.of(pet1, pet2);

        // act
        person.addPet(pet1);
        person.addPet(pet2);
        List<Pet> petsList = person.getPets();

        //assert
        assertEquals(pets, petsList);
    }

    @Test
    @DisplayName("Person sibling1 and sibling 2 should be added to List<Person> siblings of Person person")
    public void testAddSibling() {
        // arrange
        Person person = new Person("Jan", "Jansen", 18, 'm');
        Person sibling1 = new Person("Piet", "Jansen", 15, 'm');
        Person sibling2 = new Person("Inge", "Jansen", 13, 'f');
        List<Person> siblings = List.of(sibling1, sibling2);

        // act
        person.addSibling(sibling1);
        person.addSibling(sibling2);
        List<Person> siblingList = person.getSiblings();

        //assert
        assertEquals(siblings, siblingList);
    }

    @Test
    @DisplayName("Should return List<Person> grandchildren")
    public void testGetGrandchildren() {
        // arrange
        Person person = new Person("Janneke", "Jansen", 43, 'f');
        Person child1 = new Person("Jan", "Jansen", 18, 'm');
        Person child2 = new Person("Piet", "Jansen", 15, 'm');
        Person grandchild1 = new Person("Jip", "Jansen", 2, 'm');
        Person grandchild2= new Person("Max", "Jansen", 5, 'm');
        Person grandchild3 = new Person("Piet", "Jansen", 4, 'm');
        Person grandchild4 = new Person("Inge", "Jansen", 2, 'f');
        List<Person> grandchildren = List.of(grandchild1, grandchild2, grandchild3, grandchild4);
        person.addChild(child1);
        person.addChild(child2);
        child1.addChild(grandchild1);
        child1.addChild(grandchild2);
        child2.addChild(grandchild3);
        child2.addChild(grandchild4);

        // act
        List<Person> grandchildrenList = person.getGrandchildren();

        //assert
        assertEquals(grandchildren, grandchildrenList);
    }

    @Test
    @DisplayName("Should return List<Pet> of all Person.getGrandchildren of a Person")
    public void testGetPetsGrandchildren() {
        // arrange
        Person person = new Person("Janneke", "Jansen", 43, 'f');
        Person child1 = new Person("Jan", "Jansen", 18, 'm');
        Person child2 = new Person("Piet", "Jansen", 15, 'm');
        Person grandchild1 = new Person("Jip", "Jansen", 2, 'm');
        Person grandchild2= new Person("Max", "Jansen", 5, 'm');
        Person grandchild3 = new Person("Anne", "Jansen", 4, 'f');
        Person grandchild4 = new Person("Inge", "Jansen", 2, 'f');
        Pet pet1 = new Pet("Woof", 3, "Herder");
        Pet pet2 = new Pet("Waf", 2, "Herder");
        Pet pet3 = new Pet("Whif", 4, "Herder");
        Pet pet4 = new Pet("Bark", 6, "Herder");
        Pet pet5 = new Pet("Snoopy", 7, "Herder");
        person.addChild(child1);
        person.addChild(child2);
        child1.addChild(grandchild1);
        child1.addChild(grandchild2);
        child2.addChild(grandchild3);
        child2.addChild(grandchild4);
        grandchild1.addPet(pet1);
        grandchild1.addPet(pet2);
        grandchild2.addPet(pet3);
        grandchild3.addPet(pet4);
        grandchild4.addPet(pet5);

        // act
        List<Pet> pets = person.getPetsGrandchildren();

        // assert
        assertTrue(pets.contains(pet1));
        assertTrue(pets.contains(pet2));
        assertTrue(pets.contains(pet3));
        assertTrue(pets.contains(pet4));
        assertTrue(pets.contains(pet5));
        assertEquals(5, pets.size());
    }

    @Test
    @DisplayName("Should return List<Person> of all Person.getSiblings where Person.sex == 'f'")
    public void testGetAllNieces() {
        // arrange
        Person person = new Person("Janneke", "Jansen", 20, 'f');
        Person sibling1 = new Person("Jan", "Jansen", 18, 'm');
        Person sibling2 = new Person("Piet", "Jansen", 15, 'm');
        Person sibling3 = new Person("Jip", "Jansen", 2, 'm');
        Person sibling4 = new Person("Eva", "Jansen", 5, 'f');
        Person sibling5 = new Person("Anne", "Jansen", 4, 'f');
        Person sibling6 = new Person("Inge", "Jansen", 2, 'f');
        person.addSibling(sibling1);
        person.addSibling(sibling2);
        person.addSibling(sibling3);
        person.addSibling(sibling4);
        person.addSibling(sibling5);
        person.addSibling(sibling6);

        // act
        List<Person> nieces = person.getAllNieces();

        // assert
        assertTrue(nieces.contains(sibling4) &&
                nieces.contains(sibling5) &&
                nieces.contains(sibling6));
        assertEquals(3, nieces.size());
    }

    @Test
    @DisplayName("Person partner should be added to Person person")
    public void testAddPartner() {
        // arrange
        Person person = new Person("Jip", "Jansen", 45, 'm');
        Person partner = new Person("Janneke", "Jansen", 43, 'f');

        // act
        person.addPartner(partner);
        Person personPartner = person.getPartner();

        //assert
        assertEquals(partner, personPartner);
    }
}