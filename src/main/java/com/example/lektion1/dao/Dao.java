package com.example.lektion1.dao;

import com.example.lektion1.model.Friends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christoffer Grännby
 * Date: 2021-04-09
 * Time: 11:15
 * Project: Lektion1
 * Copyright: MIT
 */
public class Dao {

    public List<Friends> getFriends() {

        Friends f1 = new Friends(1, "Oscar", "Fel sida av stan", "070-1111111");
        Friends f2 = new Friends(2, "Emil", "Berget", "070-2222222");
        Friends f3 = new Friends(3, "Lili", "Också fel sida av stan", "070-3333333");
        Friends f4 = new Friends(4, "Philip", "Finsidan", "070-4444444");
        Friends f5 = new Friends(5, "Robin", "City 1990", "070-5555555");
        Friends f6 = new Friends(6, "Patrik", "Brommas bakdel", "070-6666666");

        List<Friends> friendsList = new ArrayList<>();
        friendsList.add(f1);
        friendsList.add(f2);
        friendsList.add(f3);
        friendsList.add(f4);
        friendsList.add(f5);
        friendsList.add(f6);

        return friendsList;
    }
}
