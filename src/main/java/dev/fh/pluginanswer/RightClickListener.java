package dev.fh.pluginanswer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import static dev.fh.pluginanswer.PluginAnswer.map;

public class RightClickListener implements Listener {


    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        if(map.get(event.getPlayer().getUniqueId().toString()) == null){
            return;
        }

        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Material type = event.getClickedBlock().getType();
            if (type == Material.SIGN || type == Material.SIGN_POST || type == Material.WALL_SIGN) {
                if(map.get(event.getPlayer().getUniqueId().toString()) == true) {
                    Sign sign = (Sign) event.getClickedBlock().getState();
                    String[] lines = sign.getLines();
                    for (int i = 0; i < lines.length; i++) {
                        if (lines[i].equals("\"\"") || lines[i].equals("null")) {
                            sign.setLine(i, "");
                        } else if (lines[i].startsWith("\"") && lines[i].endsWith("\"")){
                            String content = lines[i].substring(1,lines[i].length()-1);
                            sign.setLine(i,content);
                        }
                    }
                    sign.update();
                }
            }
        }
    }
}
