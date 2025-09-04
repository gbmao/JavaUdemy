package dev.lpa;

 interface NodeList {
     ListItem getRoot();
     boolean addItem(ListItem item);
     boolean removeItem(ListItem item);
     void traverse(ListItem item);
}

