package com.example.secondpract.dao;

import com.example.secondpract.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USER_COUNT;
    private List<UserModel> user;
    {
        user = new ArrayList<>();

        user.add(new UserModel(++USER_COUNT,"perchik228", "perchik228@mail.ru", "qwerty123"));
        user.add(new UserModel(++USER_COUNT,"seledka24", "seledka24@mail.ru", "zaxscd123"));
        user.add(new UserModel(++USER_COUNT,"gnom123", "gnom123@mail.ru", "qwe123"));
        user.add(new UserModel(++USER_COUNT,"meet444", "meet444@mail.ru", "asd123"));
    }

    public List<UserModel> index(){

        return user;
    }

    public UserModel show(int id){
        return user.stream().filter(UserModel -> UserModel.getId() == id).findAny().orElse(null);
    }

    public void save(UserModel User){
        User.setId(++USER_COUNT);
        user.add(User);
    }

    public void update(int id, UserModel userModel){
        UserModel updateUser = show(id);
        updateUser.setUsername(userModel.getUsername());
        updateUser.setEmail(userModel.getEmail());
        updateUser.setPassword(userModel.getPassword());
    }


    public void delete(int id){
        user.removeIf(p-> p.getId() == id);
    }
}
