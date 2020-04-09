package com.example.demo.command;

/**
 * TODO
 *
 * @author xufj
 * @date 2020/4/6 10:46
 */
public class ClientDemo {

    public static void main(String[] args) {

        TV tv = new TV();
        Command command = new AdjustVolumnCommand(tv);
        Control control = new Control(command);
        control.action();
    }
}
