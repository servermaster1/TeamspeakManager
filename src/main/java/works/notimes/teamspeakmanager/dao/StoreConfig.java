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

/**
 *
 * @author mu
 */
public class StoreConfig {

    final static String basepath = "./config/";

    public final static ServerAuthInfo readServerAuthInfo() {
        if (!isServerAuthInfo()) {
            return null;
        }
        ServerAuthInfo conf = null;
        try {
            File f = new File(basepath + "ServerAuthInfo.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(ServerAuthInfo.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            conf = (ServerAuthInfo) jaxbUnmarshaller.unmarshal(f);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return conf;
    }

    public final static void writeServerAuthInfo(ServerAuthInfo conf) {
        try {
            File f = new File(basepath + "ServerAuthInfo.xml");
            f.getParentFile().mkdirs();

            JAXBContext jaxbContext = JAXBContext.newInstance(ServerAuthInfo.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(conf, f);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public final static boolean isServerAuthInfo() {
        File f = new File(basepath + "ServerAuthInfo.xml");
        return f.exists();
    }
}
