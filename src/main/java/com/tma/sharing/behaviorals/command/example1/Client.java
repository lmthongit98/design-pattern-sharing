package com.tma.sharing.behaviorals.command.example1;

public class Client {

    public static void main(String[] args) {
        Fan fan = new Fan();
        Command turnOnCommand = new TurnOnCommand(fan);
        Command turnOffCommand = new TurnOffCommand(fan);

        Remote remote = new Remote(turnOnCommand, turnOffCommand);
        remote.turnOnButtonClick();
        remote.turnOffButtonClick();

    }

}
