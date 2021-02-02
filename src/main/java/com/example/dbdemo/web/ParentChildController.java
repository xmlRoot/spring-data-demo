package com.example.dbdemo.web;

import com.example.dbdemo.entities.Parent;
import com.example.dbdemo.repo.ChildRepository;
import com.example.dbdemo.repo.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ParentChildController {

    private final ParentRepository parents;
    private final ChildRepository children;

    @PostMapping("/parent/new")
    public Parent emptyParent(){
        return parents.save(new Parent());
    }

    @PostMapping("/parent")
    public Parent newParent(@RequestBody Parent parent){
        // obviously not save, but it's fine as a demo.
        parent.getChildren().forEach(child -> {
            child.setParent(parent);
        });
        children.saveAll(parent.getChildren());

        return parents.save(parent);
    }


}
