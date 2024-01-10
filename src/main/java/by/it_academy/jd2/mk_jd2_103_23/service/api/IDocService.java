package by.it_academy.jd2.mk_jd2_103_23.service.api;

import by.it_academy.jd2.mk_jd2_103_23.core.dto.DocCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.core.dto.DocDTO;

import java.util.List;
import java.util.UUID;

public interface IDocService {
    DocDTO save(DocCreateDTO docDTO);

    DocDTO update(DocDTO docDTO);

    List<DocDTO> getAll();

    DocDTO getById(UUID key);

    boolean delete(UUID key);
}
