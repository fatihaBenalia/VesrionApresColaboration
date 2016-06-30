/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import dao.UserDao;
import java.util.List;

/**
 *
 * @author HASNA
 */
public class UserService {
    
    UserDao userDao = new UserDao();
    
   
     
        public User seConnecter(User user) throws Exception {
        User loadedUser = findById(user.getId());
        if (loadedUser == null) {
            return null;
        }
         if (!loadedUser.getLogin().equals(user.getLogin())) {
            return null;
        }
        if (!loadedUser.getPassword().equals(user.getPassword())) {
            return null;
        }
        return loadedUser;
    }
        
        
         public int authentifier(User user) throws Exception{
        
        String requette = "select * from user where login ='"+user.getLogin()+"'";
        List<User> users = userDao.load(requette);
        if (!users.isEmpty()) {
            User myUser = users.get(0);
            if(myUser.getPassword().equalsIgnoreCase(user.getPassword())){
                return 1;
            }
            else{
                return -1;
            }
        }
        else {
            return -2;
        }
        
    
    }

    private User findById(String id) throws Exception {
        return userDao.findById(id);
    }
    
}
