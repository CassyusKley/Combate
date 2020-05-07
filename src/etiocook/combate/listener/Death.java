package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

    private final Main main;

    public Death(Main pl) {
        this.main = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }

    @EventHandler
    public void death (PlayerDeathEvent e){
        Player player = e.getEntity();

        if(main.getManager().contains(player.getName())) {

            main.getManager().remove(player.getName());

        }
    }
}
