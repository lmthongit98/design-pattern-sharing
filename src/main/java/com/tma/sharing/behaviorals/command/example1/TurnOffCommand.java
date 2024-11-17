package com.tma.sharing.behaviorals.command.example1;

public class TurnOffCommand implements Command {

    private final Fan fan;

    public TurnOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }

    @Override
    public void undo() {
        fan.turnOn();
    }

}
