package org.jhotdraw.draw.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.figure.Figure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SendToBackActionTest {
    @Mock
    private DefaultDrawingEditor editor;
    @Mock
    private DefaultDrawingView view;
    @Mock
    private Drawing drawing;
    private SendToBackAction action;
    @Captor
    private ArgumentCaptor<Figure> figureCaptor;

    @Before
    public void setUp() {
        action = new SendToBackAction(editor);
        when(view.getDrawing()).thenReturn(drawing);
    }

    @Test
    public void testSendToBackAction() {
        Figure figure = Mockito.mock(Figure.class);
        Figure figure2 = Mockito.mock(Figure.class);
        Collection<Figure> figures = new ArrayList<Figure>(){{
            add(figure);
            add(figure2);
        }};

        action.arrange(view, figures);

        verify(drawing, times(2)).sendToBack(figureCaptor.capture());
        List<Figure> capturedFigures = figureCaptor.getAllValues();
        assertEquals(figure, capturedFigures.get(0));
        assertEquals(figure2, capturedFigures.get(1));
    }
}
