package com.example.demo.command;

/**
 * 调节音量
 */
public class AdjustVolumnCommand implements Command {

    private TV tv;

    public AdjustVolumnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.ajductVolumn();
    }
}
