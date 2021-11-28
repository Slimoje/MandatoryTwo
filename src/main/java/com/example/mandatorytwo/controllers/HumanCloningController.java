package com.example.mandatorytwo.controllers;
import com.example.mandatorytwo.models.Clone;
import com.example.mandatorytwo.repositories.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kamino/clone")
public class HumanCloningController {

    @Autowired
    private CloneRepository repository;

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public List<Clone> findAll() {
        return repository.findAll();
    }

    @GetMapping("/pages")
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public Page<Clone> findAllPages(@PageableDefault(page = 0, size = 20)
                                    @SortDefault.SortDefaults({
                                            @SortDefault(sort = "id", direction = Sort.Direction.ASC)
                                    }) Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PostMapping()
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public Clone createClone(@RequestBody Clone clone){
        return repository.save(clone);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public Clone findById(@PathVariable("id") Long id) {
        return getOne(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_KAMINOAIN', 'ROLE_EMPEROR')")
    public void delete(@PathVariable("id") Long id) {
        Clone clone = getOne(id);
        repository.delete(clone);
    }


    protected Clone getOne(Long id) {
        Optional<Clone> clone = repository.findById(id);
        return clone.get();
    }

}
