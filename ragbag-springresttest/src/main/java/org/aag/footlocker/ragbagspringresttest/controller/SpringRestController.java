package org.aag.footlocker.ragbagspringresttest.controller;

import org.aag.footlocker.ragbagspringresttest.beans.CursoBean;
import org.aag.footlocker.ragbagspringresttest.exceptions.CursosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "TestRest")
public class SpringRestController {

    private List<CursoBean> cursos;

    @PostConstruct
    private void initCurso() {
        cursos = new ArrayList<>();
        cursos.add(new CursoBean(1, "Un curso de ejemplo", 3, new Date()));

    }

    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CursoBean> test() {
        return cursos;
    }

    @GetMapping(value = "cursos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CursoBean getCursoById(@PathVariable("id") String id) throws CursosException {
        if ("".equals(id))
            throw new CursosException();

        for (CursoBean curso : cursos)
            if (id.equals(String.valueOf(curso.getId())))
                return curso;

        return null;
    }

    @PostMapping(value = "addCurso", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevoCurso(@RequestBody CursoBean curso) {
        cursos.add(curso);
    }

    @DeleteMapping(value = "deleteCurso/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCursoById(@PathVariable("id") String id) throws CursosException {
        if ("".equals(id))
            throw new CursosException();

        for (CursoBean curso : cursos)
            if (id.equals(String.valueOf(curso.getId()))) {
                cursos.remove(curso);
                return;
            }
        throw new CursosException("curso not finded");
    }

    @PutMapping(value = "updateCurso/{id}/{descripcion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CursoBean updateCurso(@PathVariable("id") String id, @PathVariable("descripcion") String descripcion) throws CursosException {
        if ("".equals(id) || "".equals(descripcion))
            throw new CursosException();

        for (CursoBean existingCurso : cursos)
            if (id.equals(String.valueOf(existingCurso.getId()))) {
                existingCurso.setDescription(descripcion);
                return existingCurso;
            }
        throw new CursosException("curso not finded");
    }

    @ExceptionHandler(CursosException.class)
    protected ResponseEntity<Object> handleCustomAPIException(CursosException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
