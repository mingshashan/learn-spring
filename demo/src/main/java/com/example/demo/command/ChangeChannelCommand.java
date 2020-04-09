package com.example.demo.command;

/**
 * 换台
 */
public class ChangeChannelCommand implements Command {

    private TV tv;

    public ChangeChannelCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}
