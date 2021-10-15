package rrpss;

import java.util.Arrays;

public class Alacarte {
    private int numAlacarteItems;

    // declare array of  objects
    private Drinks[] drinks = new Drinks[10]; 
    private Appetisers[] appetiser = new Appetisers[10];
    private MainCourse[] main = new MainCourse[10];
    private Dessert[] dessert = new Dessert[10];

    public Alacarte () {
        // number of alacarte items
        numAlacarteItems = 10;

        // create alacarte drink, alacarte appetiser, alacarte main and alacarte dessert object
        for (int i = 0; i < numAlacarteItems; i++) {
            drinks[i] = new Drinks(i);
            appetiser[i] = new Appetisers(i);
            main[i] = new MainCourse(i);
            dessert[i] = new Dessert(i);
        }
    }
}
