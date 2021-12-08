package com.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("user.xml");
    ApplicationContext acx = new AnnotationConfigApplicationContext(Config.class);

        User user = (User) acx.getBean("user");
        User user1 = (User)acx.getBean("user1");
        DataConnect ref = (DataConnect) acx.getBean("dao");
        ref.insertRow(user);  //executed successfully
//        ref.updateRow(user1);  //executed successfully
//        ref.deleteRow(user);  //executed successfully

        List<User> list = (List<User>) ref.retrieveRecord(user.getUsername());

       for(User u : list){
           System.out.println("Username : "+u.getUsername() + " Password : "+u.getPassword());
       }

    }


}
