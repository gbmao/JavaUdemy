package dev.lpa;

import java.util.Arrays;

public class PersonImmutable {

    private final String name;
    private final String dob;
    protected final PersonImmutable[] kids;


    public PersonImmutable(String name, PersonImmutable[] kids, String dob) {
        this.name = name;
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
        this.dob = dob;
    }

    public PersonImmutable(String name, String dob) {
        this(name, null, dob);
    }

    protected PersonImmutable(PersonImmutable person) {
        this.name = person.name;
        this.dob = person.dob;
        this.kids = person.kids;
    }

    public String getName() {
        return name;
    }


    public String getDob() {
        return dob;
    }


    public PersonImmutable[] getKids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }


    @Override
    public String toString() {

        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", dob = " + getDob() + ", kids = " + kidString;
    }
}
