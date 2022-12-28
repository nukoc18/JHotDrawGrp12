package org.jhotdraw.draw.action;


import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.LinkedList;

public abstract class ArrangeAction extends AbstractSelectedAction {

    public String direction;
    public String ID;
    public ArrangeAction arrangeAction;

    /**
     * Creates an action which acts on the selected figures on the current view
     * of the specified editor.
     *
     * @param editor
     */
    public ArrangeAction(DrawingEditor editor, String direction, String ID) {
        super(editor);
        this.direction = direction;
        this.ID = ID;
        ResourceBundleUtil labels
                = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, this.ID);
        updateEnabledState();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        final DrawingView view = getView();
        final LinkedList<Figure> figures = new LinkedList<>(view.getSelectedFigures());
        arrange(view, figures);
        ArrangeAction arrangeAction = this;
        fireUndoableEditHappened(new AbstractUndoableEdit() {
            private static final long serialVersionUID = 1L;

            @Override
            public String getPresentationName() {
                ResourceBundleUtil labels
                        = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                return labels.getTextProperty(ID);
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                arrangeAction.arrange(view, figures);
            }

            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                arrangeAction.arrange(view, figures);
            }
        });
    }

    public void arrange(DrawingView view, Collection<Figure> figures) {
        Drawing drawing = view.getDrawing();
        if(this.direction == "back"){
            for (Figure figure : figures) { // XXX Shouldn't the figures be sorted here back to front?
                drawing.sendToBack(figure);
            }
        } else {
            for (Figure figure : drawing.sort(figures)) {
                drawing.bringToFront(figure);
            }
        }
    }


}
