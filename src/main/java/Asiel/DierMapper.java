package Asiel;

import Asiel.dto.DierDto;
import Asiel.dto.VerblijfDto;

public class DierMapper {

    public DierMapper() {
    }

    public DierDto dierDto(Dier dier) {
        DierDto dierDto = new DierDto();
        dierDto.setId(dier.getId());
        dierDto.setDierNaam(dier.getDierNaam());

        VerblijfDto verblijfDto = new VerblijfDto();
        verblijfDto.setId(dier.getVerblijf().getId());
        verblijfDto.setVerblijfNaam(dier.getVerblijf().getVerblijfNaam());

        dierDto.setVerblijf(verblijfDto);
        return dierDto;
    }
}
