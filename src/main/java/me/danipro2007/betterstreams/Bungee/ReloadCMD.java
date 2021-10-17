package me.danipro2007.betterstreams.Bungee;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class ReloadCMD extends Command
{
    public ReloadCMD(final String name) {
        super(name);
    }
    
    public void execute(final CommandSender sender, final String[] args) {
        if (sender.hasPermission("directo.reload")) {
            Main.getConfigManager().setupConfig();
            sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().reload));
        }
        else {
            sender.sendMessage((BaseComponent)new TextComponent("§cNo tienes permisos para ver esa informacion!"));
        }
    }
}
