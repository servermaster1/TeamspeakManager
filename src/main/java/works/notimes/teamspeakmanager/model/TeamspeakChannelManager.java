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

    private LinkedList<TeamspeakChannel> channels;
    private int maxid;

    public TeamspeakChannelManager() {
        channels = new LinkedList<>();
        maxid = 1;
    }

    public List<TeamspeakChannel> getChannels() {
        return channels;
    }

    public void setChannels(LinkedList<TeamspeakChannel> channels) {
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
            if (cha.getOrder() == ch.getOrder()) {
                if (cha.getParentChannelID() == ch.getParentChannelID()) {
                    if (!(cha.getID() == 0 && cha.getParentChannelID() == 0)) {
                        cha.setOrder(ch.getID());
                    }
                }
            }
        }
        channels.add(ch);
        SortMyList();
    }

    public TeamspeakChannel getChannel(int id) {
        return channels.get(id);
    }

    public int ChildCount(int id) {
        int child = 0;
        for (TeamspeakChannel ch : channels) {
            if (ch.getParentChannelID() == id) {
                child++;
            }
        }

        return child;
    }

    private LinkedList<TeamspeakChannel> getChildSortedList(int id) {
        LinkedList<TeamspeakChannel> ret = new LinkedList<>();
        int search = 0;
        for (int i = 0; i < channels.size(); i++) {
            TeamspeakChannel tt = channels.get(i);
            if (tt.getParentChannelID() == id) {
                if (tt.getOrder() == search) {
                    ret.add(tt);
                    channels.remove(i);
                    if (!(tt.getID() == 0 && tt.getParentChannelID() == 0)) {
                        if (this.ChildCount(tt.getID()) > 0) {
                            LinkedList<TeamspeakChannel> temp = this.getChildSortedList(tt.getID());
                            for (TeamspeakChannel gr : temp) {
                                ret.add(gr);
                            }
                        }
                    }
                    search = tt.getID();
                    i = -1;
                }
            }
        }
        return ret;
    }

    public LinkedList<TeamspeakChannel> getChildList(int parent) {
        LinkedList<TeamspeakChannel> ret = new LinkedList<>();
        for (TeamspeakChannel tt : channels) {
            if (tt.getParentChannelID() == parent) {
                ret.add(tt);
            }
        }

        return ret;
    }

    public void SortMyList() {
        this.channels = this.getChildSortedList(0);
    }

}
