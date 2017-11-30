/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sessions;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import Objects.User;
import Utils.Constants;

/**
*
* @author nilsf
*/
public class UserSessionManager implements HttpSessionListener{
private static volatile ArrayList<User> activeUsers = new ArrayList<>();

public static ArrayList<User> getOnlineUsers(){
return activeUsers;
}

public synchronized static boolean addOnlineUser(User user){
for(User u : activeUsers){
if(u.getUserId()==user.getUserId()){
return false;
}
}
return activeUsers.add(user);
}

public synchronized static boolean removeOnlineUser(User user){
try{
for(int i=0;i<activeUsers.size();i++){
if(activeUsers.get(i).getUserId()==user.getUserId()){
activeUsers.remove(i);
return true;
}
}
}catch(Exception e){}
return false;
}

@Override
public void sessionCreated(HttpSessionEvent ses) {
HttpSession session = ses.getSession();
session.setAttribute(Constants.LOGIN, false);
}
/**
* @param arg0
* @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
*/
@Override
public void sessionDestroyed(HttpSessionEvent arg0) {
User u = (User)arg0.getSession().getAttribute(Constants.USER);
if(Constants.DEBUG){
if(removeOnlineUser(u)){
System.out.println("INFO: User Removed form Online List");
}else{
System.err.println("ERROR: User Not Removed form Online List");
}
}
}
}