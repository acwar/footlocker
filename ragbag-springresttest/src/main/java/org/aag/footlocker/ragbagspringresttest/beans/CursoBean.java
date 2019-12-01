package org.aag.footlocker.ragbagspringresttest.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoBean {

    private int id;
    private String description;
    private long duration;
    private Date inicio;

}
