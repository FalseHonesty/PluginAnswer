package dev.fh.pluginanswer;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PluginAnswer extends JavaPlugin{

    public static HashMap<String,Boolean> map = new HashMap<>();

    @Override
    public void onEnable(){
        getLogger().info("Started");
        getServer().getPluginManager().registerEvents(new RightClickListener(),this);
        this.getCommand("togglesignclear").setExecutor(new ToggleCommand());
    }

    @Override
    public void onDisable(){
        getLogger().info("Ended");
    }

    public static String getMetadata(Metadatable obj, String key){
        List<MetadataValue> values = obj.getMetadata(key);
        for(MetadataValue value : values){
            if(value.toString().equals("true")){
                return "false";
            } else {
                return  "true";
            }
        }

        return null;
    }

}
