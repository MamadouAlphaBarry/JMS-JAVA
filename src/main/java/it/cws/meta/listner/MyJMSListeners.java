package it.cws.meta.listner;

import it.cws.meta.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.jms.annotation.JmsListener;

@Component
public class MyJMSListeners {

    @JmsListener(destination="sample.queue")
    public void receive(byte[] message) throws Exception {
        String strMessage=new String(message,"UTF-8");
        System.out.println(strMessage);

    }
@JmsListener(destination = "sample.queue")
    public User userEvent(){
        return null;
}
}