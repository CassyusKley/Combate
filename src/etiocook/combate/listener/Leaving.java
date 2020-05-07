package etiocook.combate.listener;

import etiocook.combate.Main;
import etiocook.combate.manager.CombateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leaving implements Listener {

    public Main pl;
    public Leaving(Main pl) {
        this.pl = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }

    @EventHandler
    public void leave(PlayerQuitEvent e){

        CombateManager manager = Main.getInstance().getManager();
        Player player = e.getPlayer();

        if(manager.contains(player.getName())){

            player.setHealth(0.0);
            manager.remove(player.getName());

            for(Player players : Bukkit.getOnlinePlayers())
            {
                players.sendMessage("§4§lCombate: §f" + player.getName() + " §cdeslogou em combate");
            }
        }

    }
}
