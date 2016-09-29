package com.projects.yur.carscatalog.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yur on 28.09.2016.
 */

public class Expression_Checker {

    public  boolean nameChecker(String name){
        Pattern p=Pattern.compile("^[a-zA-Z]\\w+\\s\\w+$");
        Matcher m=p.matcher(name);
        return m.matches();

    }

    public boolean EmailChecker(String Email){

        Pattern p=Pattern.compile("^\\w+[@](mail.ru|gmail.com|bk.ru|inbox.ru|yahoo.com)$");
        Matcher m=p.matcher(Email);
        return m.matches();
    }
    public boolean usernameChecker(String username){
        Pattern p=Pattern.compile("^(\\w){10,}(\\s{0})");
        Matcher m=p.matcher(username);
        return m.matches();
    }

    public  boolean passwordChecker(String password){

        Pattern p=Pattern.compile("^(?=(.*\\d){3})(?=.*[a-z])(?=(.*[A-Z]){2}).{7,}\\S$");
        Matcher m=p.matcher(password);
        return m.matches();
    }

}
