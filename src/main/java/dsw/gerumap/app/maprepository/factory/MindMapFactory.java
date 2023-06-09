package dsw.gerumap.app.maprepository.factory;

import dsw.gerumap.app.maprepository.composite.MapNode;
import dsw.gerumap.app.maprepository.implementation.MindMap;
import dsw.gerumap.app.maprepository.implementation.Project;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MindMapFactory extends NodeFactory {
    private static int num = 0;
    @Override
    public MapNode createNode(MapNode node) {
        return new MindMap("MindMap " + num++, node);
    }
}
