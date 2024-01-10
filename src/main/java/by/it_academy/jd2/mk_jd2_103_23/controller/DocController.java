package by.it_academy.jd2.mk_jd2_103_23.controller;

import by.it_academy.jd2.mk_jd2_103_23.core.dto.DocCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.core.dto.DocDTO;
import by.it_academy.jd2.mk_jd2_103_23.service.api.IDocService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doc")
public class DocController {

    private final IDocService iDocService;

    public DocController(@Qualifier("docServiceImpl") IDocService iDocService) {
        this.iDocService = iDocService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DocCreateDTO createDTO) {
        if ((createDTO.getName() != null) && (createDTO.getDescription() != null)) {
            DocDTO saved = this.iDocService.save(createDTO);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.badRequest().body("CreateDTO is null");
        }
    }

    @GetMapping
    public ResponseEntity<List<DocDTO>> get() {
        List<DocDTO> all = this.iDocService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocDTO> get(@PathVariable("id") UUID id) {
        DocDTO byId = this.iDocService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody DocDTO docDTO) {
        DocDTO byId = this.iDocService.update(docDTO);
        return ResponseEntity.ok(byId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(Boolean.toString(this.iDocService.delete(id)));
    }


}
