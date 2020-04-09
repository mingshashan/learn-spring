package com.example.demo.command;

/**
 * TODO
 *
 * @author xufj
 * @date 2020/4/6 11:26
 */
public class Control {

    private Command command;

    public Control(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
