package ba.team12.piklonusers.repositories;

import ba.team12.piklonusers.models.Token;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TokenRepository extends PagingAndSortingRepository<Token, Long> {

    //Token findByUser_id(Long userID);
    Token findByUserId(Long id);

}
