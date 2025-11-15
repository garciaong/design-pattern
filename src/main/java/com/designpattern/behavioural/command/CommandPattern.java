package com.designpattern.behavioural.command;

public class CommandPattern {
    public static void main(String[] args) {
        Room room = new LivingRoom();
        room.setCommand(new SwitchLightCommand("On"));
        room.executeCommand();
        room.setCommand(new SwitchLightCommand("Off"));
        room.executeCommand();
    }
}

interface Room {
    void setCommand(Command command);
    void executeCommand();
}

class LivingRoom implements Room {
    private Command command;
    @Override
    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void executeCommand() {
        command.execute();  
    }
}

interface Command {
    public void execute();
}

abstract class SwitchCommand implements Command {
    String action;

    public SwitchCommand(String action) {
        this.action = action;
    }

    public abstract void execute();
}

class SwitchLightCommand extends SwitchCommand {
    public SwitchLightCommand(String action) {
        super(action);
    }

    @Override
    public void execute() {
        System.out.println("Light is switching " + action);
    }

}
