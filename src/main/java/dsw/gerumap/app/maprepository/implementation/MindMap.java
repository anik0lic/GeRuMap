package dsw.gerumap.app.maprepository.implementation;

import dsw.gerumap.app.maprepository.composite.MapNode;
import dsw.gerumap.app.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.workspace.elements.Topic;
import dsw.gerumap.app.workspace.elements.painters.ElementPainter;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MindMap extends MapNodeComposite {
    private transient List<ElementPainter> painterList;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
        painterList = new ArrayList<>();
    }

    @Override
    public void addChild(MapNode child) throws IOException {
        if (child instanceof Element) {
            Element element = (Element) child;
//            if (!this.getChildren().contains(element)) {
//                this.getChildren().add(element);
//            }
            this.getChildren().add(element);
            child.setParent(this);
            notify(this);
        }
    }

    @Override
    public void removeChild(MapNode child) throws IOException {
        if (child instanceof Element) {
            Element element = (Element) child;
            this.getChildren().remove(element);
            child.setParent(null);
            notify(this);
        }
    }

    @Override
    public void setName(String name) throws IOException {
        super.setName(name);
        notify(this);
    }

    public int numberOfTopics(){
        int num = 0;
        for(MapNode el : getChildren()){
            if(el instanceof Topic){
                num++;
            }
        }
        return num;
    }

    @Override
    public String toString() {
        return getName();
    }
}
