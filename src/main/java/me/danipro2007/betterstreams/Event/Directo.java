package me.danipro2007.betterstreams.Event;

import java.util.Iterator;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import me.danipro2007.betterstreams.Bungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class Directo extends Command
{
    public Directo() {
        super("directo", "directo.use", new String[0]);
    }
    
    public void execute(final CommandSender sender, final String[] args) {
        if (!sender.hasPermission("directo.use")) {
            sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().noperm.replaceAll("", "")));
        }
        else {
            if (args.length == 0) {
                sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().noargs.replaceAll("", "")));
            }
            if (args.length == 1) {
                final StringBuilder builder = new StringBuilder();
                final String[] arrayOfString = args;
                for (int j = args.length, i = 0; i < j; ++i) {
                    final String nick = arrayOfString[i];
                    builder.append(ChatColor.translateAlternateColorCodes('&', nick));
                    builder.append(" ");
                }
                final String message = builder.substring(0, builder.length() - 1);
                final String nick = sender.getName();
                if (args[0].contains("youtube.com")) {
                    for (final ProxiedPlayer p1 : ProxyServer.getInstance().getPlayers()) {
                        final StringBuilder bc = new StringBuilder();
                        final String[] var9 = args;
                        for (int var10 = args.length, var11 = 0; var11 < var10; ++var11) {
                            final String port = var9[var11];
                            bc.append(port + " ");
                            final String url = bc.toString();
                            new ClickEvent(ClickEvent.Action.OPEN_URL, message);
                            ProxyServer.getInstance().broadcast(Main.getConfigManager().YTheader.replaceAll("", ""));
                            ProxyServer.getInstance().broadcast(Main.getConfigManager().YTline.replaceAll("%player%", ChatColor.translateAlternateColorCodes('&', nick)));
                            ProxyServer.getInstance().broadcast(Main.getConfigManager().YTlink.replaceAll("%msg%", ChatColor.translateAlternateColorCodes('&', message)));
                            ProxyServer.getInstance().broadcast(Main.getConfigManager().YTfooter.replaceAll("", ""));
                        }
                    }
                }
                else if (args[0].contains("twitch.tv")) {
                    for (final ProxiedPlayer p1 : ProxyServer.getInstance().getPlayers()) {
                        final StringBuilder bc = new StringBuilder();
                        final String[] var9 = args;
                        for (int var10 = args.length, var11 = 0; var11 < var10; ++var11) {
                            final String port = var9[var11];
                            bc.append(port + " ");
                            final String url = bc.toString();
                            ProxyServer.getInstance().broadcast(Main.getConfigManager().TWheader.replaceAll("", ""));
                            ProxyServer.getInstance().broadcast(Main.getConfigManager().TWline.replaceAll("%player%", ChatColor.translateAlternateColorCodes('&', nick)));
                            ProxyServer.getInstance().broadcast(Main.getConfigManager().TWlink.replaceAll("%msg%", ChatColor.translateAlternateColorCodes('&', message)));
                            ProxyServer.getInstance().broadcast(Main.getConfigManager().TWfooter.replaceAll("", ""));
                        }
                    }
                }
            }
            else {
                sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().justlinks.replaceAll("", "")));
            }
        }
    }
}
