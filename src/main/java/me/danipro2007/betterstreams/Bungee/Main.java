package me.danipro2007.betterstreams.Bungee;

import me.danipro2007.betterstreams.Event.DBC;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin
{
    private static ConfigManager cfgmanager;
    private static Main instance;
    
    public void onEnable() {
        ProxyServer.getInstance().getConsole().sendMessage("§8§m---+---------------------+---");
        ProxyServer.getInstance().getConsole().sendMessage("§aBetterStreams");
        ProxyServer.getInstance().getConsole().sendMessage(" ");
        ProxyServer.getInstance().getConsole().sendMessage("§cHecho por Danipro_2007");
        ProxyServer.getInstance().getConsole().sendMessage("§cCargando plugin....");
        this.getProxy().getPluginManager().registerCommand((Plugin)this, (Command)new ReloadCMD("bs-reload"));
        ProxyServer.getInstance().getConsole().sendMessage("§cCargando config.yml...");
        Main.instance = this;
        Main.cfgmanager = new ConfigManager();
        getConfigManager().setupConfig();
        ProxyServer.getInstance().getConsole().sendMessage("§4Version §61.0");
        ProxyServer.getInstance().getConsole().sendMessage("§8§m---+---------------------+---");
        this.getProxy().getPluginManager().registerCommand((Plugin)this, (Command)new DBC("directo"));
    }
    
    public static ConfigManager getCfgmanager() {
        return Main.cfgmanager;
    }
    
    public static ConfigManager getConfigManager() {
        return Main.cfgmanager;
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
}
