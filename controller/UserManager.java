package product.controller;

import product.model.User;


import java.util.ArrayList;
import java.util.List;

public class UserManager implements General<User> {
    private List<User> users = new ArrayList<>();

    public UserManager(){

    }

    @Override
    public void show() {
        System.out.println(users);
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void update(String id, User user) {
        int index = findById(id);
        if (index != -1) {
            users.set(index, user);
        } else {
            System.out.println("không có user này");
        }
    }

    @Override
    public void delete(String id) {
        int index = findById(id);
        if (index != -1) {
            users.remove(id);
        }else {
            System.out.println("không có user này");
        }
    }

    private int findById(String id) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public User LoginUser(User user){
        for (User user1:users) {
            if (user1.getUsername().equals(user1.getUsername())&&user1.getPassword().equals(user1.getPassword())){
                return user1;
            }
        }
        return null;
    }


}
