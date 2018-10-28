package space.cc.com.uilayouttest.domain.bizobject;

import lombok.Data;

@Data
public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
}
