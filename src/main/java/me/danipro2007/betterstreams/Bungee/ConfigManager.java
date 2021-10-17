package me.danipro2007.betterstreams.Bungee;

import java.io.IOException;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import java.nio.file.Files;
import java.nio.file.CopyOption;
import java.io.File;
import java.util.List;
import net.md_5.bungee.config.Configuration;

public class ConfigManager
{
    public static Configuration cg;
    public String YTline;
    public String YTheader;
    public String YTfooter;
    public String YTlink;
    public String TWline;
    public String TWheader;
    public String TWfooter;
    public String TWlink;
    public String noperm;
    public String justlinks;
    public String permission;
    public String noargs;
    public String reload;
    public String CooldownTime;
    public String CooldownMessage;
    public Long CDT;
    public String Command;
    public String YTH;
    public List YTH2;
    public List yt2;
    
    public void setupConfig() {
        try {
            if (!Main.getInstance().getDataFolder().exists()) {
                Main.getInstance().getDataFolder().mkdir();
            }
            final File f = new File(Main.getInstance().getDataFolder(), "config.yml");
            if (!f.exists()) {
                System.out.println("No tienes una config.yml pero ya te la creo yo :).");
                Files.copy(Main.getInstance().getResourceAsStream("config.yml"), f.toPath(), new CopyOption[0]);
            }
            final Configuration cfg = ConfigurationProvider.getProvider((Class)YamlConfiguration.class).load(new File(Main.getInstance().getDataFolder(), "config.yml"));
            final long CLT = cfg.getLong("Utils.cooldown");
            final List<String> yt3 = (List<String>)cfg.getStringList("Messages.Youtube.prueba");
            final String CLTT = String.valueOf(CLT);
            this.Command = ChatColor.translateAlternateColorCodes('&', cfg.getString("Command"));
            this.TWheader = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Twitch.header"));
            this.TWline = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Twitch.line"));
            this.TWlink = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Twitch.Link"));
            this.TWfooter = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Twitch.footer"));
            this.YTheader = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Youtube.header"));
            this.YTline = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Youtube.line"));
            this.YTlink = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Youtube.Link"));
            this.YTfooter = ChatColor.translateAlternateColorCodes('&', cfg.getString("Messages.Youtube.footer"));
            this.CooldownMessage = ChatColor.translateAlternateColorCodes('&', cfg.getString("Utils.cooldown-msg"));
            this.CooldownTime = ChatColor.translateAlternateColorCodes('&', CLTT);
            this.noperm = ChatColor.translateAlternateColorCodes('&', cfg.getString("Utils.no-permission"));
            this.justlinks = ChatColor.translateAlternateColorCodes('&', cfg.getString("Utils.linksonly"));
            this.permission = ChatColor.translateAlternateColorCodes('&', cfg.getString("Utils.use-permission"));
            this.noargs = ChatColor.translateAlternateColorCodes('&', cfg.getString("Utils.no-args"));
            this.reload = ChatColor.translateAlternateColorCodes('&', cfg.getString("Utils.reload"));
            this.CDT = cfg.getLong("Utils.cooldown");
        }
        catch (IOException var7) {
            var7.printStackTrace();
        }
    }
    
    public static void registerConfig() {
        try {
            final File f = new File(Main.getInstance().getDataFolder(), "config.yml");
            final Configuration configuration = ConfigurationProvider.getProvider((Class)YamlConfiguration.class).load(new File(Main.getInstance().getDataFolder(), "config.yml"));
            if (!f.exists()) {
                Main.getConfigManager().setupConfig();
                System.out.println("No tienes una config.yml pero ya te la creo yo :).");
            }
        }
        catch (IOException var2) {
            var2.printStackTrace();
        }
    }
}
