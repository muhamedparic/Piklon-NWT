package ba.team12.communication.services;

import ba.team12.communication.models.PrivateMessage;
import ba.team12.communication.repositories.PrivateMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PrivateMessageService {

    @Autowired
    private PrivateMessageRepository privateMessageRepository;

    public void createNewMessage(Long senderId, Long recepientId, String messageText) {
        privateMessageRepository.save(new PrivateMessage(senderId, recepientId, messageText,
                new GregorianCalendar().getTime()));
    }

    public List<PrivateMessage> getAllSentMessages(Long senderId) {
        return privateMessageRepository.findBySenderId(senderId);
    }

    public List<PrivateMessage> getAllReceivedMessages(Long recepientId) {
        return privateMessageRepository.findByRecepientId(recepientId);
    }
}
