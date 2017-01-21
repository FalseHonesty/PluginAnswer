package dev.fh.pluginanswer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import static dev.fh.pluginanswer.PluginAnswer.getMetadata;
import static dev.fh.pluginanswer.PluginAnswer.map;

public class ToggleCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player){
            Player playerObj = (Player) sender;

            String uuid = playerObj.getUniqueId().toString();

            if(!(map.containsKey(uuid))) {
                map.put(uuid,true);
                playerObj.sendMessage("Turned on sign fix!");
            } else {
                boolean state = map.get(uuid);
                map.put(uuid,!state);
                String stateString;

                if(state == true) {
                    stateString = "off";
                } else {
                    stateString = "on";
                }

                playerObj.sendMessage("Turned " + stateString + " sign fix!");
            }
        }
        return true;
    }


}
