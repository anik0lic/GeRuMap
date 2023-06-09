package dsw.gerumap.app.commands.implementation;

import dsw.gerumap.app.commands.AbstractCommand;
import dsw.gerumap.app.workspace.view.MapView;
import dsw.gerumap.app.workspace.elements.Topic;
import dsw.gerumap.app.workspace.elements.painters.ElementPainter;

import java.io.IOException;

public class AddTopicCommand extends AbstractCommand {

    private final MapView map;
    private final ElementPainter painter;

    public AddTopicCommand(MapView map, ElementPainter painter) {
        this.map = map;
        this.painter = painter;
    }

    @Override
    public void doCommand() throws IOException {
        if (map == null || painter == null) {
            return;
        }
        Topic topic = (Topic) painter.getElement();
        map.getMindMap().getPainterList().add(painter);
        map.getMindMap().addChild(topic);
    }

    @Override
    public void undoCommand() throws IOException {
        if (map == null || painter == null) {
            return;
        }
        Topic topic = (Topic) painter.getElement();
        map.getMindMap().getPainterList().remove(painter);
        map.getMindMap().removeChild(topic);
    }
}
