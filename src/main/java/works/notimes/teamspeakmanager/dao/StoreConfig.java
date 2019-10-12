/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.notimes.teamspeakmanager.dao;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import works.notimes.teamspeakmanager.model.ServerAuthInfo;
import works.notimes.teamspeakmanager.model.TeamspeakChannelManager;

/**
 *
 * @author mu
 */
public class StoreConfig {

    final static String basepath = "./config/";
    final static String ServerAuthInfo = "ServerAuthInfo.xml";
    final static String TeamSpeakChannelM = "TeamSpeakChannel.xml";

    private static Object readSomething(Class cl, File f) {
        if (!f.exists()) {
            return null;
        }
        Object ret = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(cl);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ret = jaxbUnmarshaller.unmarshal(f);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private static void writeSomething(Object o, Class cl, File f) {
        try {
            f.getParentFile().mkdirs();
            JAXBContext jaxbContext = JAXBContext.newInstance(cl);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(o, f);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public final static void writeServerAuthInfo(ServerAuthInfo conf) {
        File f = new File(basepath + ServerAuthInfo);
        writeSomething(conf, ServerAuthInfo.class, f);
    }

    public final static ServerAuthInfo readServerAuthInfo() {
        File f = new File(basepath + ServerAuthInfo);
        return (ServerAuthInfo) readSomething(ServerAuthInfo.class, f);
    }

    public final static boolean isServerAuthInfo() {
        File f = new File(basepath + ServerAuthInfo);
        return f.exists();
    }

    public final static void writeTeamspeakChannelManager(TeamspeakChannelManager conf) {
        File f = new File(basepath + TeamSpeakChannelM);
        writeSomething(conf, TeamspeakChannelManager.class, f);
    }

    public final static TeamspeakChannelManager readTeamspeakChannelManager() {
        File f = new File(basepath + TeamSpeakChannelM);
        return (TeamspeakChannelManager) readSomething(TeamspeakChannelManager.class, f);
    }

    public final static boolean isTeamspeakChannelManager() {
        File f = new File(basepath + TeamSpeakChannelM);
        return f.exists();
    }

}
