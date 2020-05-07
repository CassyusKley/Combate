package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
    public Main pl;

    public Death(Main pl) {
        this.pl = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }

    @EventHandler
    public void death (PlayerDeathEvent e){
        Player player = e.getEntity();

        if(Main.getInstance().getManager().contains(player.getName())) {

            Main.getInstance().getManager().remove(player.getName());

        }
    }
}
