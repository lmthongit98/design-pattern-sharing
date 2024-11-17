package com.tma.sharing.behaviorals.momento;

import java.util.Scanner;
import java.util.Stack;


/**
 * The {@code Command} interface defines the structure for commands
 * that can be executed and undone in the text editor.
 */
interface Command {
    void execute();

    void undo();
}


/**
 * The {@code TextEditorMemento} class holds the state of a {@code TextEditor}
 * at a specific point in time. It is used to implement undo functionality.
 */
class TextEditorMemento {
    private final String state;

    public TextEditorMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

/**
 * The {@code AddTextCommand} class implements the {@code Command} interface
 * to add text to a {@code TextEditor}. It supports undoing the add operation.
 */
class AddTextCommand implements Command {
    private final TextEditor receiver;
    private final String textToAdd;
    private TextEditorMemento memento;

    /**
     * Constructs a new {@code AddTextCommand} for the specified editor and text.
     *
     * @param receiver the text editor to which text will be added
     * @param textToAdd the text to add
     */
    public AddTextCommand(TextEditor receiver, String textToAdd) {
        this.receiver = receiver;
        this.textToAdd = textToAdd;
    }

    /**
     * Executes the command by adding text to the editor and saving the state
     * for undo functionality.
     */
    @Override
    public void execute() {
        memento = receiver.save(); // save memento for undo
        receiver.addText(textToAdd);
    }

    /**
     * Undoes the command by restoring the editor's state from the memento.
     */
    @Override
    public void undo() {
        receiver.restore(memento); // Restore the saved state
    }
}

/**
 * The {@code TextEditor} class represents a simple text editor.
 * It allows adding text and supports undo functionality through mementos.
 */

class TextEditor {
    private StringBuilder text = new StringBuilder();

    /**
     * Saves the current state of the editor and returns a memento.
     *
     * @return a memento containing the current state of the editor
     */
    public TextEditorMemento save() {
        return new TextEditorMemento(text.toString());
    }

    /**
     * Restores the editor's state from the provided memento.
     *
     * @param memento the memento to restore state from
     */
    public void restore(TextEditorMemento memento) {
        text = new StringBuilder(memento.getState());
    }

    public void addText(String text) {
        this.text.append(text);
    }

    public String getText() {
        return text.toString();
    }
}

/**
 * The {@code CommandManager} class acts as the invoker in the Command pattern.
 * It executes commands and provides undo functionality by keeping a history of executed commands.
 */
class CommandManager {
    private final Stack<Command> history = new Stack<>();

    /**
     * Executes a command and saves it to the history for possible undoing.
     *
     * @param command the command to execute
     */
    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }


    /**
     * Undoes the last command executed, if any.
     */
    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        }
    }
}


public class Client {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(); // receiver
        CommandManager manager = new CommandManager(); // sender
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add new text");
            System.out.println("2. Undo text");
            System.out.print("Choose an option (or any other key to exit): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter text to add: ");
                    String newText = scanner.nextLine();
                    Command addTextCommand = new AddTextCommand(editor, newText);
                    manager.executeCommand(addTextCommand);
                    System.out.println("Current text: " + editor.getText());
                    break;
                case "2":
                    manager.undo();
                    System.out.println("After undo, current text: " + editor.getText());
                    break;
                default:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

}


