package me.danipro2007.betterstreams.Bungee;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.command.CommandExecutor;

public class Reload implements CommandExecutor
{
    final Plugin plugin;
    final FileConfiguration config;
    
    public Reload() {
        this.plugin = Bukkit.getServer().getPluginManager().getPlugin("BungeeAlert");
        this.config = this.plugin.getConfig();
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final String nick = sender.getName();
        if (!command.getName().equalsIgnoreCase("dalert") || args.length != 1 || !args[0].equalsIgnoreCase("reload")) {
            return true;
        }
        if (sender.hasPermission("Permissions.Reload-Command")) {
            this.plugin.reloadConfig();
            sender.sendMessage(ChatColor.RED + "Configuracion recargada pa.");
            return true;
        }
        sender.sendMessage("&cNo tienes permisos");
        return true;
    }
}
