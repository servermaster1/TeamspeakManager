/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.notimes.teamspeakmanager.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mu
 */
public class TeamspeakChannelManager {
    private List<TeamspeakChannel> channels;
    private int maxid;

    public TeamspeakChannelManager() {
        channels = new LinkedList<>();
        maxid = 1;
    }

    public List<TeamspeakChannel> getChannels() {
        return channels;
    }

    public void setChannels(List<TeamspeakChannel> channels) {
        this.channels = channels;
    }

    public int getMaxid() {
        return maxid;
    }

    public void setMaxid(int maxid) {
        this.maxid = maxid;
    }
    
    public void increaseMaxid(){
        maxid++;
    }
    
    public void addChannel(TeamspeakChannel ch){
        channels.add(ch);
    }
    
    public TeamspeakChannel getChannel(int id){
        return channels.get(id);
    }
    
    
    
}
