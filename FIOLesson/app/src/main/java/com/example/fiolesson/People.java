package com.example.fiolesson;

import java.util.ArrayList;
import java.util.List;

public class People {
    List<String> names2 = new ArrayList<String>();
    public void createNewPerson(String name){
        String nameFIO=name;
        class GenericName {
            List<String> names=new ArrayList<String>();
            public GenericName() {
                for(String str: nameFIO.split(" ")) names.add(str);
            }
            public String getName(){return names.get(1);}
            public String getMiddleName(){return names.get(2);}
            public String getSurname(){return names.get(0);}
        }
        GenericName gname=new GenericName();
        names2.add(gname.getSurname());
        names2.add(gname.getName());
        names2.add(gname.getMiddleName());
    }
}
