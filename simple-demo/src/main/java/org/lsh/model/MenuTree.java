package org.lsh.model;

import lombok.Data;
import org.lsh.entity.Menu;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuTree implements Serializable {
    private Menu menu;
    private List<MenuTree> children;
}
