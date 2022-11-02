package com.company;

interface Liveable {
    boolean Liveable = true;
    String breathe();
    String feed();
}

public abstract class Animal implements Liveable {
    public String className() {
        return "Animal";
    }
    public abstract String move();
}
class Fish extends Animal {
    @Override
    public String className() {
        return "Fish";
    }

    @Override
    public String move() {
        return "Swim";
    }

    @Override
    public String breathe() {
        return "gills";
    }

    @Override
    public String feed() {
        return "bugs";
    }
}
class Bird extends Animal {
    @Override
    public String className() {
        return "Bird";
    }

    @Override
    public String move() {
        return "Fly";
    }

    @Override
    public String breathe() {
        return "lungs";
    }

    @Override
    public String feed() {
        return "bugs";
    }
}
class Pike extends Fish {
    @Override
    public String className() {
        return "Pike";
    }
}
class Carp extends Fish {
    @Override
    public String className() {
        return "Carp";
    }
}
class Sparrow extends Bird {
    @Override
    public String className() {
        return "Sparrow";
    }

    @Override
    public String move() {
        return super.move() + " " + "Jump";
    }
}
class Eagle extends Bird {
    @Override
    public String className() {
        return "Eagle";
    }

    @Override
    public String feed() {
        return "catch";
    }
}
