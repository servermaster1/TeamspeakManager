/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.notimes.teamspeakmanager.model;

/**
 *
 * @author mu
 */
public class ServerAuthInfo {

    private String IP;
    private String User;
    private String PW;
    private String name;

    public ServerAuthInfo(String IP, String User, String PW, String name) {
        this.IP = IP;
        this.User = User;
        this.PW = PW;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

}
