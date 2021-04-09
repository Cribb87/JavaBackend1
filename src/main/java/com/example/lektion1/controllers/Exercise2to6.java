package com.example.lektion1.controllers;

import com.example.lektion1.dao.Dao;
import com.example.lektion1.model.Friends;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Christoffer Grännby
 * Date: 2021-04-09
 * Time: 11:12
 * Project: Lektion1
 * Copyright: MIT
 */
@RestController
public class Exercise2to6 {

    Dao dao = new Dao();
    List<Friends> friendsList = dao.getFriends();

    @RequestMapping("/friends")
    public List<Friends> getAllFriends() {
        return friendsList;
    }

    @RequestMapping("/friends/{id}")
    public Friends friendsID(@PathVariable int id){
        for (Friends f : friendsList){
            if (f.getId() == id){
                return f;
            }
        }
        return null;
    }

    @RequestMapping("/friends/{id}/delete")
        public String deleteFriend(@PathVariable int id, Friends friend){
        int delete =-1;

        String name = "";
        for (int i = 0; i < friendsList.size(); i++) {
            if (friendsList.get(i).getId() == id){
                name = friendsList.get(i).getName();
                delete = i;
            }
        }
        if (delete != -1) {
            friendsList.remove(delete);
            return "Your friend " + name + " aint your friend no more";
        }
        return "You dont have this friend in your collection";
    }

    @RequestMapping("/friends/add")
        public String addFriend(@RequestBody Friends friend){
        friendsList.add(friend);
        return "You caught a wild " + friend;
    }

    @RequestMapping("/friends/upsert")
    public String upsertFriend(@RequestBody Friends friend){
        int update = -1;

        for (int i = 0; i < friendsList.size(); i++) {
            if (friendsList.get(i).getId() == friend.getId()){
                update = i;
            }
        }
        if (update == -1){
            friendsList.add(friend);
            return "You caught a new friend";
        }
        else{
            friendsList.set(update, friend);
            return "Your friend levled up";
        }
    }
}
