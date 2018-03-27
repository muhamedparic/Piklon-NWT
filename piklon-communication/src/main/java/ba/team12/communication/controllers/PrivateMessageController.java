package ba.team12.communication.controllers;

import ba.team12.communication.models.PrivateMessage;
import ba.team12.communication.services.PrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrivateMessageController {

    @Autowired
    private PrivateMessageService privateMessageService;

    @RequestMapping(value = "/messages/new_message", method = RequestMethod.POST)
    public ResponseEntity newMessage(@RequestParam(name = "senderId", required = true) Long senderId,
                                     @RequestParam(name = "recepientId", required = true) Long recepientid,
                                     @RequestParam(name = "messageText", required = true) String messageText) {

        privateMessageService.createNewMessage(senderId, recepientid, messageText);
        return ResponseEntity.ok("WE DID IT REDDIT");
    }

    @GetMapping("/sent_messages")
    public ResponseEntity getAllSentMessages(@RequestParam(name = "senderId", required = true) Long senderId) {

        List<PrivateMessage> messages = privateMessageService.getAllSentMessages(senderId);
        if (messages.size() > 0)
            return ResponseEntity.ok(messages);
        else
            return ResponseEntity.ok("not found");
    }

    @GetMapping("/received_messages")
    public ResponseEntity getAllReceivedMessages(@RequestParam(name = "recepientId", required = true) Long recepientId) {

        List<PrivateMessage> messages = privateMessageService.getAllReceivedMessages(recepientId);
        return ResponseEntity.ok(messages);
    }
}
