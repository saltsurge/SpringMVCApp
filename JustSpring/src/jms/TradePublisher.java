package jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * Created with IntelliJ IDEA.
 * User: jim.sun
 * Date: 10/20/13
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class TradePublisher {
    private String destinationName = "justspring.core.jms.trades";
    private JmsTemplate jmsTemplate = null;

    // access the template when publishing the message
    public void publishTrade(final Trade t) {
        jmsTemplate.send(destinationName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage msg = session.createObjectMessage();
                msg.setObject(t);
                return msg;
            }
        });
    }


    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
