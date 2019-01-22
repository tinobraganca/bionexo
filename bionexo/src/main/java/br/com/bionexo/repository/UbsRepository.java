package br.com.bionexo.repository;

import br.com.bionexo.domain.PersistentUbs;
import br.com.bionexo.domain.User;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TB_UBS entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UbsRepository extends JpaRepository<PersistentUbs, Long> {
	
	@Query(value = "SELECT * FROM tb_ubs WHERE  ( co_latitude BETWEEN (?1 - 0.44915558749551) AND  (?1 + 0.44915558749551)) AND (co_longitute BETWEEN (?2 - 0.45220222483495) AND (?2 + 0.45220222483495 ))", nativeQuery = true)
	List<PersistentUbs> findAllByLatAndLong(BigDecimal lat, BigDecimal longitude);
	

}
