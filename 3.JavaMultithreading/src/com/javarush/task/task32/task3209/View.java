package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Новый": controller.createNewDocument();
            case "Открыть": controller.openDocument();
            case "Сохранить": controller.saveDocument();
            case "Сохранить как...": controller.saveDocumentAs();
            case "Выход": controller.exit();
            case "О программе": this.showAbout();
            default:;
        }

    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane pane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", pane);
        JScrollPane jScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", jScrollPane);
        tabbedPane.setPreferredSize(null);
        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(listener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged() {
        if (tabbedPane.getSelectedIndex() == 0) {
            controller.setPlainText(plainTextPane.getText());
        }
        else if (tabbedPane.getSelectedIndex() == 1) {
            plainTextPane.setText(controller.getPlainText());
        }
        this.resetUndo();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public  boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == tabbedPane.indexOfTab("HTML");
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(getContentPane(), "Version 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
    }



}
