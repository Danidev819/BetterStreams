package me.danipro2007.betterstreams.Bungee;

import java.io.InputStream;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.CopyOption;
import net.md_5.bungee.config.Configuration;
import java.io.File;

public class ConfigFileManager
{
    private File file;
    private Configuration conf;
    public static ConfigFileManager INSTANCE;
    
    public ConfigFileManager() {
        this.file = new File(Main.getInstance().getDataFolder().getAbsolutePath(), "config.yml");
    }
    
    public void loadFile() {
        if (!this.file.exists()) {
            this.file.getParentFile().mkdirs();
            try {
                final InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.yml");
                try {
                    Files.copy(in, this.file.toPath(), new CopyOption[0]);
                    if (in != null) {
                        in.close();
                    }
                }
                catch (Throwable var6) {
                    if (in != null) {
                        try {
                            in.close();
                        }
                        catch (Throwable var7) {
                            var6.addSuppressed(var7);
                        }
                    }
                    throw var6;
                }
            }
            catch (IOException var8) {
                var8.printStackTrace();
            }
        }
        try {
            this.conf = ConfigurationProvider.getProvider((Class)YamlConfiguration.class).load(this.file);
        }
        catch (IOException var9) {
            var9.printStackTrace();
        }
        this.saveFile();
    }
    
    public void saveFile() {
        try {
            ConfigurationProvider.getProvider((Class)YamlConfiguration.class).save(this.conf, this.file);
        }
        catch (IOException var2) {
            var2.printStackTrace();
        }
    }
    
    public String getString(final String path) {
        return this.conf.getString(path);
    }
    
    static {
        ConfigFileManager.INSTANCE = new ConfigFileManager();
    }
}
