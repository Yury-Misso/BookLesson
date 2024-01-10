package by.it_academy.jd2.mk_jd2_103_23.dao.api;

import by.it_academy.jd2.mk_jd2_103_23.dao.entity.DocEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository("IDocDAO")
public interface IDocDAO extends ListCrudRepository<DocEntity, UUID> {

}
