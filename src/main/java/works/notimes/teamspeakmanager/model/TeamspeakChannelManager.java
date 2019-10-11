/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.notimes.teamspeakmanager.model;

import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
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

    public void increaseMaxid() {
        maxid++;
    }

    public void addChannel(TeamspeakChannel ch) {
        for (TeamspeakChannel cha : channels) {
            //if (ch.getParentChannelID() != 0) {
                if (cha.getOrder() == ch.getOrder()) {
                    if (cha.getParentChannelID() == ch.getParentChannelID()) {
                        cha.setOrder(ch.getID());
                    }
                }
            //}
        }
        channels.add(ch);
        SortMyList();
    }

    public TeamspeakChannel getChannel(int id) {
        return channels.get(id);
    }

    public void SortMyList() {
        Collections.sort(channels, new Comparator<TeamspeakChannel>() {
            @Override
            public int compare(TeamspeakChannel o1, TeamspeakChannel o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });

    }

}
