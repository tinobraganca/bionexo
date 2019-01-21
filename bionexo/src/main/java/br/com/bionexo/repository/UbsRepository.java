package br.com.bionexo.repository;

import br.com.bionexo.domain.PersistentUbs;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TB_UBS entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UbsRepository extends JpaRepository<PersistentUbs, Long> {

}
