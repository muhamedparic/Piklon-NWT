package ba.team12.communication.repositories;

import ba.team12.communication.models.PrivateMessage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivateMessageRepository extends PagingAndSortingRepository<PrivateMessage, Long> {

    // save, delete, findById by default
    List<PrivateMessage> findBySenderId(Long id);
    List<PrivateMessage> findByRecepientId(Long id);
}
