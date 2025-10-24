package dev.lpa;

import java.util.Arrays;

public class Person {

    private String name;
    private String dob;
    private Person[] kids;


    public Person(String name, Person[] kids, String dob) {
        this.name = name;
        this.kids = kids;
        this.dob = dob;
    }

    public Person(String name, String dob) {
        this(name, null, dob);
    }

    public String getName() {
        return name;
    }



    public String getDob() {
        return dob;
    }



    public Person[] getKids() {
        return kids;
    }

    public void setKids(Person[] kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {

        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", dob = " + dob + ", kids = " + kidString;
    }
}
