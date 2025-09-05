package com.mine;

import java.util.List;

public interface ISaveable {

    //    write(), takes no arguments and returns a List containing objects of type String.
    List<String> write();

    //    -  read(), takes a List of type String and doesn't return anything.
    void read(List<String> list);
}
