package me.danipro2007.betterstreams.Event;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import me.danipro2007.betterstreams.Bungee.Main;
import net.md_5.bungee.api.CommandSender;
import java.util.HashMap;
import java.util.Map;
import net.md_5.bungee.api.plugin.Command;

public class DBC extends Command
{
    Map<String, Long> cooldowns;
    
    public DBC(final String name) {
        super(name);
        this.cooldowns = new HashMap<String, Long>();
    }
    
    public void execute(final CommandSender sender, final String[] args) {
        final String nick = sender.getName();
        if (!sender.hasPermission("directo.use")) {
            sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().noperm.replaceAll("", "")));
        }
        else {
            if (args.length == 0) {
                sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().noargs.replaceAll("", "")));
            }
            if (args.length != 1) {
                if (args.length == 2) {
                    sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().justlinks.replaceAll("", "")));
                }
            }
            else if (this.cooldowns.containsKey(sender.getName()) && this.cooldowns.get(sender.getName()) > System.currentTimeMillis()) {
                final long CooldownT = (this.cooldowns.get(sender.getName()) - System.currentTimeMillis()) / 1000L;
                final String TL = String.valueOf(CooldownT);
                sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().CooldownMessage.replaceAll("%seconds%", ChatColor.translateAlternateColorCodes('&', TL))));
            }
            else {
                final long CooldownT = Main.getConfigManager().CDT;
                if (args[0].contains("youtube.com")) {
                    this.cooldowns.put(sender.getName(), System.currentTimeMillis() + CooldownT * 1000L);
                    final StringBuilder builder = new StringBuilder();
                    final String[] arrayOfString = args;
                    for (int j = args.length, i = 0; i < j; ++i) {
                        final String s = arrayOfString[i];
                        builder.append(ChatColor.translateAlternateColorCodes('&', s));
                        builder.append(" ");
                    }
                    final String message = builder.substring(0, builder.length() - 1);
                    ProxyServer.getInstance().broadcast(Main.getConfigManager().YTheader.replaceAll("", ""));
                    ProxyServer.getInstance().broadcast(Main.getConfigManager().YTline.replaceAll("%player%", ChatColor.translateAlternateColorCodes('&', nick)));
                    ProxyServer.getInstance().broadcast(Main.getConfigManager().YTlink.replaceAll("%msg%", ChatColor.translateAlternateColorCodes('&', message)));
                    ProxyServer.getInstance().broadcast(Main.getConfigManager().YTfooter.replaceAll("", ""));
                }
                else if (!args[0].contains("twitch.tv")) {
                    sender.sendMessage((BaseComponent)new TextComponent(Main.getConfigManager().justlinks.replaceAll("", "")));
                }
                else {
                    this.cooldowns.put(sender.getName(), System.currentTimeMillis() + CooldownT * 1000L);
                    final StringBuilder builder = new StringBuilder();
                    final String[] arrayOfString = args;
                    for (int j = args.length, i = 0; i < j; ++i) {
                        final String s = arrayOfString[i];
                        builder.append(ChatColor.translateAlternateColorCodes('&', s));
                        builder.append(" ");
                    }
                    final String message = builder.substring(0, builder.length() - 1);
                    final StringBuilder bc = new StringBuilder();
                    final String[] var11 = args;
                    for (int var12 = args.length, var13 = 0; var13 < var12; ++var13) {
                        final String port = var11[var13];
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
    }
}
