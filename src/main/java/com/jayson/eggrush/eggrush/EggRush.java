package com.jayson.eggrush.eggrush;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class EggRush extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Register events and commands
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("eggrush").setExecutor(new EggRushCommand());
        getLogger().info("EggRushPlugin has been enabled!");
    }

    // Event listeners and game logic can be implemented here

    // Custom command for managing the EggRush gamemode
    private class EggRushCommand implements CommandExecutor {

        private CommandSender sender;
        private Command cmd;
        private String label;
        private String[] args;

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            this.sender = sender;
            this.cmd = cmd;
            this.label = label;
            this.args = args;
            if (cmd.getName().equalsIgnoreCase("eggrush")) {
                if (args.length == 1) {
                    String subCommand = args[0].toLowerCase();

                    // Handle sub-commands
                    if (subCommand.equals("start")) {
                        // Start the EggRush game
                        startGame();
                        sender.sendMessage("EggRush game started.");
                    } else if (subCommand.equals("stop")) {
                        // Stop the EggRush game
                        stopGame();
                        sender.sendMessage("EggRush game stopped.");
                    } else {
                        sender.sendMessage("Unknown sub-command. Usage: /eggrush <start|stop>");
                    }
                    return true;
                } else {
                    sender.sendMessage("Usage: /eggrush <start|stop>");
                    return true;
                }
            }
            return false;
        }
    }

    // Game logic methods can be implemented here

    private void startGame() {
        // Start the EggRush game
    }

    private void stopGame() {
        // Stop the EggRush game
    }
}
