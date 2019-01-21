package br.com.bionexo.service.mapper;

import br.com.bionexo.domain.*;
import br.com.bionexo.service.dto.UbsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity TB_UBS and its DTO TB_UBSDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TB_UBSMapper extends EntityMapper<UbsDTO, PersistentUbs> {



    default PersistentUbs fromId(Long id) {
        if (id == null) {
            return null;
        }
        PersistentUbs tB_UBS = new PersistentUbs();
        tB_UBS.setId(id);
        return tB_UBS;
    }
}
