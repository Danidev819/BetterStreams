package me.danipro2007.betterstreams.Event;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class Stream extends Command
{
    public Stream(final String name) {
        super(name);
    }
    
    public void execute(final CommandSender sender, final String[] args) {
        if (sender.hasPermission("directo.use")) {
            if (args.length == 0) {
                sender.sendMessage((BaseComponent)new TextComponent("§c/directo <mensaje>"));
            }
            if (args.length == 1) {
                if (args[0].contains("youtube.com")) {
                    final StringBuilder bc = new StringBuilder();
                    final String[] var4 = args;
                    for (int var5 = args.length, var6 = 0; var6 < var5; ++var6) {
                        final String port = var4[var6];
                        bc.append(port + " ");
                        final String url = bc.toString();
                        final String nick = sender.getName();
                        ProxyServer.getInstance().broadcast((BaseComponent)new TextComponent("§8§m§l------------------------------"));
                        ProxyServer.getInstance().broadcast((BaseComponent)new TextComponent("     §b" + nick + " §c§lEst\u00e1 en directo!"));
                        ProxyServer.getInstance().broadcast("§dLink: §6" + bc.toString());
                        ProxyServer.getInstance().broadcast((BaseComponent)new TextComponent("§8§m§l------------------------------"));
                    }
                }
                else if (args[0].contains("twitch.tv")) {
                    final StringBuilder bc = new StringBuilder();
                    final String[] var4 = args;
                    for (int var5 = args.length, var6 = 0; var6 < var5; ++var6) {
                        final String port = var4[var6];
                        bc.append(port + " ");
                        final String url = bc.toString();
                        final String nick = sender.getName();
                        ProxyServer.getInstance().broadcast((BaseComponent)new TextComponent("§8§m§l------------------------------"));
                        ProxyServer.getInstance().broadcast((BaseComponent)new TextComponent("     §b" + nick + " §c§lEst\u00e1 en directo!"));
                        ProxyServer.getInstance().broadcast("§dLink: §6" + bc.toString());
                        ProxyServer.getInstance().broadcast((BaseComponent)new TextComponent("§8§m§l------------------------------"));
                    }
                }
                else {
                    sender.sendMessage((BaseComponent)new TextComponent("§4Porfavor solo usa links!"));
                }
            }
            else if (args.length == 2) {
                sender.sendMessage((BaseComponent)new TextComponent("§4Porfavor solo usa links!"));
            }
        }
        else {
            sender.sendMessage((BaseComponent)new TextComponent("§aPlugin original de LyDark Studios. Version 1.0"));
        }
    }
}
