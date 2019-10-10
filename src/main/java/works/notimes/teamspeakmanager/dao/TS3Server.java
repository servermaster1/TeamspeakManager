/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.notimes.teamspeakmanager.dao;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.wrapper.Channel;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import works.notimes.teamspeakmanager.model.ServerAuthInfo;

/**
 *
 * @author mu
 */
public class TS3Server {

    private ServerAuthInfo serverconf;
    private TS3Config config;
    private TS3Query query;
    private TS3Api api;

    public TS3Server(ServerAuthInfo serverconf) {
        this.serverconf = serverconf;

    }

    public void connect() throws com.github.theholywaffle.teamspeak3.api.exception.TS3Exception {
        config = new TS3Config();
        config.setHost(this.serverconf.getIP());
        config.setEnableCommunicationsLogging(true);

        query = new TS3Query(config);
        query.connect();

        api = query.getApi();
        api.login(this.serverconf.getUser(), this.serverconf.getPW());
        api.selectVirtualServerById(1);
        api.setNickname(this.serverconf.getName());

    }

    public void exit() {
        api.setNickname("BotCheck" + Math.random());
        api.logout();
        query.exit();
    }

    public void testCredentials() {
        boolean ok = true;
        try {
            this.connect();
            this.exit();
        } catch (com.github.theholywaffle.teamspeak3.api.exception.TS3Exception ex) {
            ok = false;
            String message = "Fehler!\n" + ex.getMessage();
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (ok) {
            String message = "Verbindung OK!";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*// Get all channels and map their channel IDs to them
        List<Channel> channels = api.getChannels();
        Map<Integer, Channel> channelMap = new HashMap<>(channels.size());
        for (Channel channel : channels) {
            channelMap.put(channel.getId(), channel);
        }

        // List all clients in the console
        for (Client c : api.getClients()) {
            // Get the client's channel
            Channel channel = channelMap.get(c.getChannelId());

            // Write the client and channel name into the console
            System.out.println(c.getNickname() + " in channel " + channel.getName());
        }*/
}
