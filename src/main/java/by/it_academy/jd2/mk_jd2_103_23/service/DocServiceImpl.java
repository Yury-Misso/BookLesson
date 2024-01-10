package by.it_academy.jd2.mk_jd2_103_23.service;

import by.it_academy.jd2.mk_jd2_103_23.core.dto.DocCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.core.dto.DocDTO;
import by.it_academy.jd2.mk_jd2_103_23.dao.api.IDocDAO;
import by.it_academy.jd2.mk_jd2_103_23.dao.entity.DocEntity;
import by.it_academy.jd2.mk_jd2_103_23.service.api.IDocService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("docServiceImpl")
public class DocServiceImpl implements IDocService {
    private final IDocDAO DAO;

    public DocServiceImpl(@Qualifier("IDocDAO") IDocDAO dao) {
        this.DAO = dao;
    }


    @Override
    public DocDTO save(DocCreateDTO docDTO) {
        DocEntity docEntity = new DocEntity();

        docEntity.setId(UUID.randomUUID());
        docEntity.setName(docDTO.getName());
        docEntity.setDescription(docDTO.getDescription());
        docEntity.setDtUpdate(LocalDateTime.now());

        this.DAO.save(docEntity);

        return new DocDTO(docEntity.getId(),
                docEntity.getName(),
                docEntity.getDescription(),
                docEntity.getDtUpdate());
    }

    @Override
    public DocDTO update(DocDTO docDTO) {
        Optional<DocEntity> byId = this.DAO.findById(docDTO.getId());

        if (byId.isEmpty()) {
            throw new IllegalArgumentException("Document not found");
        }

        DocEntity docEntity = byId.get();

        if (!docEntity.getDtUpdate().isEqual(docDTO.getDtupdate())) {
            throw new IllegalArgumentException("The document has already been edited ");
        }

        docEntity.setName(docDTO.getName());
        docEntity.setDescription(docDTO.getDescription());

        try {
            this.DAO.save(docEntity);
            return new DocDTO(docEntity.getId(),
                    docEntity.getName(),
                    docEntity.getDescription(),
                    docEntity.getDtUpdate());
        } catch (OptimisticLockingFailureException e) {
            throw new IllegalArgumentException("The document has already been edited ");
        }

    }

    @Override
    public List<DocDTO> getAll() {
        return this.DAO.findAll().stream().map(docEntity -> new DocDTO(
                docEntity.getId(),
                docEntity.getName(),
                docEntity.getDescription(),
                docEntity.getDtUpdate()
        )).toList();
    }

    @Override
    public DocDTO getById(UUID key) {
        return this.DAO.findById(key).map(docEntity -> new DocDTO(
                docEntity.getId(),
                docEntity.getName(),
                docEntity.getDescription(),
                docEntity.getDtUpdate()
        )).orElse(null);
    }

    @Override
    public boolean delete(UUID key) {
        Optional<DocEntity> byId = this.DAO.findById(key);
        if (byId.isPresent()) {
            this.DAO.delete(byId.get());
            return true;
        } else {
            return false;
        }
    }
}
