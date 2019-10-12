/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.notimes.teamspeakmanager.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mu
 */
@XmlRootElement
public class TeamspeakChannel {

    private String name;
    private int ID;
    private int order;
    private int parentChannelID;

    public TeamspeakChannel(String name, int ID, int order, int parentChannelID) {
        this.name = name;
        this.ID = ID;
        this.order = order;
        this.parentChannelID = parentChannelID;
       // System.out.println(name + "|" + ID + "|" + order + "|" + parentChannelID);
    }

    public TeamspeakChannel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChannelID() {
        return parentChannelID;
    }

    public void setParentChannelID(int parentChannelID) {
        this.parentChannelID = parentChannelID;
    }

    @Override
    public String toString() {
        return name;
    }

}
