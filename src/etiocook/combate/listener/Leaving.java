package etiocook.combate.listener;

import etiocook.combate.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leaving implements Listener {

    private final Main main;

    public Leaving(Main pl) {
        this.main = pl;
        pl.getServer().getPluginManager().registerEvents(this, pl);
    }


    @EventHandler
    public void leave(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        if (main.getManager().contains(player.getName())) {

            player.setHealth(0.0);
            main.getManager().remove(player.getName());

            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§4§lCombate: §f" + player.getName() + " §cdeslogou em combate");

            }
        }
    }
}
