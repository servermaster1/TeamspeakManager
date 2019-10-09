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
import works.notimes.teamspeakmanager.model.ServerAuthInfo;

/**
 *
 * @author mu
 */
public class TS3Server {

    private ServerAuthInfo serverconf;
    private TS3Config config;
    private TS3Query query;

    public TS3Server(ServerAuthInfo serverconf) {
        this.serverconf = serverconf;

        config = new TS3Config();

        config.setHost(serverconf.getIP());
        config.setEnableCommunicationsLogging(true);

        query = new TS3Query(config);
        query.connect();

        final TS3Api api = query.getApi();
        api.login(serverconf.getName(), serverconf.getPW());
        //System.out.println(api.getServerInfo());
        api.selectVirtualServerById(1);
        api.setNickname(serverconf.getName());
        api.sendChannelMessage("Bot is online!");

        System.out.println(query.isConnected());

        // We're done, disconnect
        query.exit();
        
        System.out.println(query.isConnected());

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
